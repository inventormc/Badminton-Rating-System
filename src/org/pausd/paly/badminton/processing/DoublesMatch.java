package org.pausd.paly.badminton.processing;

import java.util.Random;
/**
 * Extends Match- a doubles match. Used to simulate a doubles match
 * being played.
 * @author michaelchau
 *
 */
public class DoublesMatch extends Match{
	//POTENTIAL BUG: TEAM A IS UPDATED AND THEN TEAM B, SO TEAM B IS BEING UDPATED WITH TEAM A NEW RATING
	/**
	 * 
	 * @param teamA- team a of match
	 * @param teamB- team b of match
	 * set the teams of the match
	 */
	public DoublesMatch(Team teamA, Team teamB){
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	/**
	 * simulate doubles match being played and update the rating after the game
	 */
	public void updatePlayerRatings(){
		Team winner = this.getWinner();//figure out who winner is
		
		if (this.getTeamA() == null || this.getTeamB() == null) {
			System.out.println("Players have not been set yet");
			return;
		}
		
		//First update rating for team a according to rating rules (a formula)
		if(teamA.getTeamRating() > teamB.getTeamRating()){//if team a's rating is higher
			teamA.getPlayers().get(0).setDoublesRating((int) Math.round(teamA.getPlayers().get(0).getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamA.getPlayers().get(1).setDoublesRating((int) Math.round(teamA.getPlayers().get(1).getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));

		} else if(teamA.getTeamRating() < teamB.getTeamRating()){//if team b's rating is higher
			teamA.getPlayers().get(0).setDoublesRating((int) Math.round(teamA.getPlayers().get(0).getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamA.getPlayers().get(1).setDoublesRating((int) Math.round(teamA.getPlayers().get(1).getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else {//if ratings are the same
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamA.getPlayers().get(0).setDoublesRating((int) Math.round(teamA.getPlayers().get(0).getDoublesRating() + 
						(getTeamAScore() - getTeamBScore())));
				teamA.getPlayers().get(1).setDoublesRating((int) Math.round(teamA.getPlayers().get(1).getDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
			case 1:
				teamA.getPlayers().get(0).setDoublesRating((int) Math.round(teamA.getPlayers().get(0).getDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
				teamA.getPlayers().get(1).setDoublesRating((int) Math.round(teamA.getPlayers().get(1).getDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
			}
		}
		
		if(winner.equals(teamA)){//if team a is the winner, add appropriate rating points(+3)
			teamA.getPlayers().get(0).setDoublesRating(teamA.getPlayers().get(0).getDoublesRating() + 3);
			teamA.getPlayers().get(1).setDoublesRating(teamA.getPlayers().get(1).getDoublesRating() + 3);
		}
		
		
		//Update rating for team b according to rating rules (a formula)
		if(teamB.getTeamRating() > teamA.getTeamRating()){//if team b rating is higher
			teamB.getPlayers().get(0).setDoublesRating((int) Math.round(teamB.getPlayers().get(0).getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamB.getPlayers().get(1).setDoublesRating((int) Math.round(teamB.getPlayers().get(1).getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else if (teamB.getTeamRating() < teamA.getTeamRating()){//if team a rating is higher
			teamB.getPlayers().get(0).setDoublesRating((int) Math.round(teamB.getPlayers().get(0).getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamB.getPlayers().get(1).setDoublesRating((int) Math.round(teamB.getPlayers().get(1).getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
		} else {//if ratings are the same
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamB.getPlayers().get(0).setDoublesRating((int) Math.round(teamB.getPlayers().get(0).getDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
				teamB.getPlayers().get(1).setDoublesRating((int) Math.round(teamB.getPlayers().get(1).getDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
			case 1:
				teamB.getPlayers().get(0).setDoublesRating((int) Math.round(teamB.getPlayers().get(0).getDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				teamB.getPlayers().get(1).setDoublesRating((int) Math.round(teamB.getPlayers().get(1).getDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				
			}
		}
		
		if(winner.equals(teamB)){//if team b is winner, add approriate rating points(+3)
			teamB.getPlayers().get(0).setDoublesRating(teamB.getPlayers().get(0).getDoublesRating() + 3);
			teamB.getPlayers().get(1).setDoublesRating(teamB.getPlayers().get(1).getDoublesRating() + 3);
		}
		
		//ensure rankings can't go under 0
		if(teamA.getPlayers().get(0).getDoublesRating() < 0){
			teamA.getPlayers().get(0).setDoublesRating(0);
		}
		if(teamA.getPlayers().get(1).getDoublesRating() < 0){
			teamA.getPlayers().get(1).setDoublesRating(0);
		}
		if(teamB.getPlayers().get(0).getDoublesRating() < 0){
			teamB.getPlayers().get(0).setDoublesRating(0);
		}
		if(teamB.getPlayers().get(1).getDoublesRating() < 0){
			teamB.getPlayers().get(1).setDoublesRating(0);
		}
	}
}
