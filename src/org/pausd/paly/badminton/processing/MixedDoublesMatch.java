package org.pausd.paly.badminton.processing;

import java.util.Random;

public class MixedDoublesMatch extends Match{
	
	public MixedDoublesMatch(Team teamA, Team teamB){
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	public void updatePlayerRatings(){
		Team winner = this.getWinner();
		
		if (getTeamA() == null || getTeamB() == null) {
			System.out.println("Players have not been set yet");
			return;
		}
		
		//First update rating for team a
		if(teamA.getTeamRating() > teamB.getTeamRating()){
			teamA.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(0).getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamA.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(1).getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));

		} else if(teamA.getTeamRating() < teamB.getTeamRating()){
			teamA.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(0).getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamA.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(1).getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else {
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamA.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(0).getMixedDoublesRating() + 
						(getTeamAScore() - getTeamBScore())));
				teamA.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(1).getMixedDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
			case 1:
				teamA.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(0).getMixedDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
				teamA.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamA.getPlayers().get(1).getMixedDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
			}
		}
		
		if(winner.equals(teamA)){
			teamA.getPlayers().get(0).setMixedDoublesRating(teamA.getPlayers().get(0).getMixedDoublesRating() + 3);
			teamA.getPlayers().get(1).setMixedDoublesRating(teamA.getPlayers().get(1).getMixedDoublesRating() + 3);
		}
		
		
		//Update rating for team b
		if(teamB.getTeamRating() > teamA.getTeamRating()){
			teamB.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(0).getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamB.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(1).getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else if (teamB.getTeamRating() < teamA.getTeamRating()){
			teamB.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(0).getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamB.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(1).getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
		} else {
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamB.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(0).getMixedDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
				teamB.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(1).getMixedDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
			case 1:
				teamB.getPlayers().get(0).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(0).getMixedDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				teamB.getPlayers().get(1).setMixedDoublesRating((int) Math.round(teamB.getPlayers().get(1).getMixedDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				
			}
		}
		
		if(winner.equals(teamB)){
			teamB.getPlayers().get(0).setMixedDoublesRating(teamB.getPlayers().get(0).getMixedDoublesRating() + 3);
			teamB.getPlayers().get(1).setMixedDoublesRating(teamB.getPlayers().get(1).getMixedDoublesRating() + 3);
		}
		
		//ensure rankings can't go under 0
		if(teamA.getPlayers().get(0).getMixedDoublesRating() < 0){
			teamA.getPlayers().get(0).setMixedDoublesRating(0);
		}
		if(teamA.getPlayers().get(1).getMixedDoublesRating() < 0){
			teamA.getPlayers().get(1).setMixedDoublesRating(0);
		}
		if(teamB.getPlayers().get(0).getMixedDoublesRating() < 0){
			teamB.getPlayers().get(0).setMixedDoublesRating(0);
		}
		if(teamB.getPlayers().get(1).getMixedDoublesRating() < 0){
			teamB.getPlayers().get(1).setMixedDoublesRating(0);
		}
	}
}
