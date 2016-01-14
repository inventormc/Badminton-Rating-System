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
		if (playerA.getRating() > playerB.getRating()) {
			playerA.setRating((int) Math.round(playerA.getRating() + ((this.getPlayerAScore() - this.getPlayerBScore())
					- (0.1 * (playerA.getRating() - playerB.getRating())))));
			if (winner.equals(playerA)) {
				playerA.setRating(playerA.getRating() + 3);
			}
		} else if (playerA.getRating() < playerB.getRating()){
			playerA.setRating((int) Math.round(playerA.getRating() + ((this.getPlayerAScore() - this.getPlayerBScore())
					+ (0.1 * (playerB.getRating() - playerA.getRating())))));
			if (winner.equals(playerA)) {
				playerA.setRating(playerA.getRating() + 3);
			}
		} else {//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch (choice){
			case 0:
				playerA.setRating((int) Math.round(playerA.getRating() + (this.getPlayerAScore() - this.getPlayerBScore())));
			case 1:
				playerA.setRating((int) Math.round(playerA.getRating() + (this.getPlayerBScore() - this.getPlayerAScore())));
			}
			if (winner.equals(playerA)) {
				playerA.setRating(playerA.getRating() + 3);
			}
		}

		// Next update rating for playerB
		if (playerB.getRating() > playerA.getRating()) {
			playerB.setRating((int) Math.round(playerB.getRating() + ((this.getPlayerBScore() - this.getPlayerAScore())
					- (0.1 * (playerB.getRating() - playerA.getRating())))));
			if (winner.equals(playerB)) {
				playerB.setRating(playerB.getRating() + 3);
			}
		} else if (playerB.getRating() < playerA.getRating()) {
			playerB.setRating((int) Math.round(playerB.getRating() + ((this.getPlayerBScore() - this.getPlayerAScore())
					+ (0.1 * (playerA.getRating() - playerB.getRating())))));
			if (winner.equals(playerB)) {
				playerB.setRating(playerB.getRating() + 3);
			}
		} else {//when the player rankings are equal, we randomly choose an xy assignment to use
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);

			switch (choice){
			case 0:
				playerB.setRating((int) Math.round(playerB.getRating() + (this.getPlayerBScore() - this.getPlayerAScore())));
				break;
			case 1:
				playerB.setRating((int) Math.round(playerB.getRating() + (this.getPlayerAScore() - this.getPlayerBScore())));
				break;
			}
			if (winner.equals(playerB)) {
				playerB.setRating(playerB.getRating() + 3);
			}	
		}
		
		//ensure rankings can't go under 0
		if(playerA.getRating() < 0){
			playerA.setRating(0);
		}
		if(playerB.getRating() < 0){
			playerB.setRating(0);
		}
	}

}
