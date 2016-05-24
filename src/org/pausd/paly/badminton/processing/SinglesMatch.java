package org.pausd.paly.badminton.processing;

import java.util.Random;
/**
 * Extends Match- a singles match. Used to simulate a singles match
 * being played.
 * @author michaelchau
 *
 */
public class SinglesMatch extends Match{
	//POTENTIAL BUG: TEAM A IS UPDATED AND THEN TEAM B, SO TEAM B IS BEING UDPATED WITH TEAM A NEW RATING
	/**
	 * 
	 * @param teamA- team a
	 * @param teamB- team b
	 * create SinglesMatch with team a and team b
	 */
	public SinglesMatch(Team teamA, Team teamB){
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	/**
	 * simulate singles match being played and update the rating after the game
	 */
	public void updatePlayerRatings() {
		Team winner = this.getWinner();

		if (teamA == null || teamB == null) {
			System.out.println("Players have not been set yet");
			return;
		}

		// First update rating for playerA using rating rules (a formula)
		if (teamA.getPlayers().get(0).getSinglesRating() > teamB.getPlayers().get(0).getSinglesRating()) {//teamA rating higher
			teamA.getPlayers().get(0).setSinglesRating((int) Math.round(teamA.getPlayers().get(0).getSinglesRating() + ((this.getTeamAScore() - this.getTeamBScore())
					- (0.1 * (teamA.getPlayers().get(0).getSinglesRating() - teamB.getPlayers().get(0).getSinglesRating())))));
		} else if (teamA.getPlayers().get(0).getSinglesRating() < teamB.getPlayers().get(0).getSinglesRating()){//team b rating higher
			teamA.getPlayers().get(0).setSinglesRating((int) Math.round(teamA.getPlayers().get(0).getSinglesRating() + ((this.getTeamAScore() - this.getTeamBScore())
					+ (0.1 * (teamB.getPlayers().get(0).getSinglesRating() - teamA.getPlayers().get(0).getSinglesRating())))));
		} else {//ratings are the same
			//when the player rankings are equal, we randomly choose an xy assignment to use 
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
		
		//if team a is winner, give rating appropriate rating points(+3)
		if (winner.equals(teamA)) {
			teamA.getPlayers().get(0).setSinglesRating(teamA.getPlayers().get(0).getSinglesRating() + 3);
		}
		

		// Next update rating for playerB using rating rules (a formula)
		if (teamB.getPlayers().get(0).getSinglesRating() > teamA.getPlayers().get(0).getSinglesRating()) {//team b rating higher
			teamB.getPlayers().get(0).setSinglesRating((int) Math.round(teamB.getPlayers().get(0).getSinglesRating() + ((this.getTeamBScore() - this.getTeamAScore())
					- (0.1 * (teamB.getPlayers().get(0).getSinglesRating() - teamA.getPlayers().get(0).getSinglesRating())))));
		} else if (teamB.getPlayers().get(0).getSinglesRating() < teamA.getPlayers().get(0).getSinglesRating()) {//team a rating higher
			teamB.getPlayers().get(0).setSinglesRating((int) Math.round(teamB.getPlayers().get(0).getSinglesRating() + ((this.getTeamBScore() - this.getTeamAScore())
					+ (0.1 * (teamA.getPlayers().get(0).getSinglesRating() - teamB.getPlayers().get(0).getSinglesRating())))));
		} else {//ratings are the same
			//when the player rankings are equal, we randomly choose an xy assignment to use
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
		
		//if team b is winner, award appropriate points (+3)
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
