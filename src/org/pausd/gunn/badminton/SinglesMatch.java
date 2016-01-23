package org.pausd.gunn.badminton;

import java.util.Random;

public class SinglesMatch extends Match{

	public SinglesMatch(Team teamA, Team teamB){
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	public void updatePlayerRatings() {
		Team winner = this.getWinner();

		if (teamA == null || teamB == null) {
			System.out.println("Players have not been set yet");
			return;
		}

		// First update rating for playerA
		if (teamA.getPlayers().get(0).getSinglesRating() > teamB.getPlayers().get(0).getSinglesRating()) {
			teamA.getPlayers().get(0).setSinglesRating((int) Math.round(teamA.getPlayers().get(0).getSinglesRating() + ((this.getTeamAScore() - this.getTeamBScore())
					- (0.1 * (teamA.getPlayers().get(0).getSinglesRating() - teamB.getPlayers().get(0).getSinglesRating())))));
		} else if (teamA.getPlayers().get(0).getSinglesRating() < teamB.getPlayers().get(0).getSinglesRating()){
			teamA.getPlayers().get(0).setSinglesRating((int) Math.round(teamA.getPlayers().get(0).getSinglesRating() + ((this.getTeamAScore() - this.getTeamBScore())
					+ (0.1 * (teamB.getPlayers().get(0).getSinglesRating() - teamA.getPlayers().get(0).getSinglesRating())))));
		} else {//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch (choice){
			case 0:
				teamA.getPlayers().get(0).setSinglesRating((int) Math.round(teamA.getPlayers().get(0).getSinglesRating() + (this.getTeamAScore() - this.getTeamBScore())));
			case 1:
				teamA.getPlayers().get(0).setSinglesRating((int) Math.round(teamA.getPlayers().get(0).getSinglesRating() + (this.getTeamBScore() - this.getTeamAScore())));
			}
		}
		
		if (winner.equals(teamA)) {
			teamA.getPlayers().get(0).setSinglesRating(teamA.getPlayers().get(0).getSinglesRating() + 3);
		}
		

		// Next update rating for playerB
		if (teamB.getPlayers().get(0).getSinglesRating() > teamA.getPlayers().get(0).getSinglesRating()) {
			teamB.getPlayers().get(0).setSinglesRating((int) Math.round(teamB.getPlayers().get(0).getSinglesRating() + ((this.getTeamBScore() - this.getTeamAScore())
					- (0.1 * (teamB.getPlayers().get(0).getSinglesRating() - teamA.getPlayers().get(0).getSinglesRating())))));
		} else if (teamB.getPlayers().get(0).getSinglesRating() < teamA.getPlayers().get(0).getSinglesRating()) {
			teamB.getPlayers().get(0).setSinglesRating((int) Math.round(teamB.getPlayers().get(0).getSinglesRating() + ((this.getTeamBScore() - this.getTeamAScore())
					+ (0.1 * (teamA.getPlayers().get(0).getSinglesRating() - teamB.getPlayers().get(0).getSinglesRating())))));
		} else {//when the player rankings are equal, we randomly choose an xy assignment to use
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);

			switch (choice){
			case 0:
				teamB.getPlayers().get(0).setSinglesRating((int) Math.round(teamB.getPlayers().get(0).getSinglesRating() + (this.getTeamBScore() - this.getTeamAScore())));
				break;
			case 1:
				teamB.getPlayers().get(0).setSinglesRating((int) Math.round(teamB.getPlayers().get(0).getSinglesRating() + (this.getTeamAScore() - this.getTeamBScore())));
				break;
			}
		}
		
		if (winner.equals(teamB)) {
			teamB.getPlayers().get(0).setSinglesRating(teamB.getPlayers().get(0).getSinglesRating() + 3);
		}
		
		
		//ensure rankings can't go under 0
		if(teamA.getPlayers().get(0).getSinglesRating() < 0){
			teamA.getPlayers().get(0).setSinglesRating(0);
		}
		if(teamB.getPlayers().get(0).getSinglesRating() < 0){
			teamB.getPlayers().get(0).setSinglesRating(0);
		}
	}

}
