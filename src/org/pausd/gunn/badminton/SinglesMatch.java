package org.pausd.gunn.badminton;

import java.util.Date;
import java.util.Random;

public class SinglesMatch {

	private Date time;
	private Player playerA;
	private Player playerB;
	private Integer playerAScore;
	private Integer playerBScore;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Player getPlayerA() {
		return playerA;
	}

	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	public Player getPlayerB() {
		return playerB;
	}

	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

	public Integer getPlayerAScore() {
		return playerAScore;
	}

	public void setPlayerAScore(Integer playerAScore) {
		this.playerAScore = playerAScore;
	}

	public Integer getPlayerBScore() {
		return playerBScore;
	}

	public void setPlayerBScore(Integer playerBScore) {
		this.playerBScore = playerBScore;
	}

	public Player getWinner() {
		if (this.getPlayerAScore() > this.getPlayerBScore()) {
			return playerA;
		} else {
			return playerB;
		}
	}

	public void updatePlayerRatings() {
		Player winner = this.getWinner();

		if (this.getPlayerA() == null || this.getPlayerB() == null) {
			System.out.println("Players have not been set yet");
			return;
		}

		// First update rating for playerA
		if (playerA.getSinglesRating() > playerB.getSinglesRating()) {
			playerA.setSinglesRating((int) Math.round(playerA.getSinglesRating() + ((this.getPlayerAScore() - this.getPlayerBScore())
					- (0.1 * (playerA.getSinglesRating() - playerB.getSinglesRating())))));
		} else if (playerA.getSinglesRating() < playerB.getSinglesRating()){
			playerA.setSinglesRating((int) Math.round(playerA.getSinglesRating() + ((this.getPlayerAScore() - this.getPlayerBScore())
					+ (0.1 * (playerB.getSinglesRating() - playerA.getSinglesRating())))));
		} else {//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch (choice){
			case 0:
				playerA.setSinglesRating((int) Math.round(playerA.getSinglesRating() + (this.getPlayerAScore() - this.getPlayerBScore())));
			case 1:
				playerA.setSinglesRating((int) Math.round(playerA.getSinglesRating() + (this.getPlayerBScore() - this.getPlayerAScore())));
			}
		}
		
		if (winner.equals(playerA)) {
			playerA.setSinglesRating(playerA.getSinglesRating() + 3);
		}
		

		// Next update rating for playerB
		if (playerB.getSinglesRating() > playerA.getSinglesRating()) {
			playerB.setSinglesRating((int) Math.round(playerB.getSinglesRating() + ((this.getPlayerBScore() - this.getPlayerAScore())
					- (0.1 * (playerB.getSinglesRating() - playerA.getSinglesRating())))));
		} else if (playerB.getSinglesRating() < playerA.getSinglesRating()) {
			playerB.setSinglesRating((int) Math.round(playerB.getSinglesRating() + ((this.getPlayerBScore() - this.getPlayerAScore())
					+ (0.1 * (playerA.getSinglesRating() - playerB.getSinglesRating())))));
		} else {//when the player rankings are equal, we randomly choose an xy assignment to use
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);

			switch (choice){
			case 0:
				playerB.setSinglesRating((int) Math.round(playerB.getSinglesRating() + (this.getPlayerBScore() - this.getPlayerAScore())));
				break;
			case 1:
				playerB.setSinglesRating((int) Math.round(playerB.getSinglesRating() + (this.getPlayerAScore() - this.getPlayerBScore())));
				break;
			}
		}
		
		if (winner.equals(playerB)) {
			playerB.setSinglesRating(playerB.getSinglesRating() + 3);
		}
		
		
		//ensure rankings can't go under 0
		if(playerA.getSinglesRating() < 0){
			playerA.setSinglesRating(0);
		}
		if(playerB.getSinglesRating() < 0){
			playerB.setSinglesRating(0);
		}
	}

}
