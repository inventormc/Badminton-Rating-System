package org.pausd.gunn.badminton;

import java.util.Date;
import java.util.Random;

public class MixedDoublesMatch {
	private Date time;
	private Team teamA;
	private Team teamB;
	private int teamAScore;
	private int teamBScore;
	
	public MixedDoublesMatch(Team teamA, Team teamB){
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	public int getTeamAScore() {
		return teamAScore;
	}
	public void setTeamAScore(int teamAScore) {
		this.teamAScore = teamAScore;
	}
	public int getTeamBScore() {
		return teamBScore;
	}
	public void setTeamBScore(int teamBScore) {
		this.teamBScore = teamBScore;
	}
	
	public Team getWinner(){
		if(teamAScore > teamBScore){
			return teamA;
		}else{
			return teamB;
		}
	}
	
	//change update to mix doubles rating
	public void updatePlayerRatings(){
		Team winner = this.getWinner();
		
		if (this.getTeamA() == null || this.getTeamB() == null) {
			System.out.println("Players have not been set yet");
			return;
		}
		
		//First update rating for team a
		if(teamA.getTeamRating() > teamB.getTeamRating()){
			teamA.getPlayerA().setMixedDoublesRating((int) Math.round(teamA.getPlayerA().getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamA.getPlayerB().setMixedDoublesRating((int) Math.round(teamA.getPlayerB().getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));

		} else if(teamA.getTeamRating() < teamB.getTeamRating()){
			teamA.getPlayerA().setMixedDoublesRating((int) Math.round(teamA.getPlayerA().getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamA.getPlayerB().setMixedDoublesRating((int) Math.round(teamA.getPlayerB().getMixedDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else {
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamA.getPlayerA().setMixedDoublesRating((int) Math.round(teamA.getPlayerA().getMixedDoublesRating() + 
						(getTeamAScore() - getTeamBScore())));
				teamA.getPlayerB().setMixedDoublesRating((int) Math.round(teamA.getPlayerB().getMixedDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
			case 1:
				teamA.getPlayerA().setMixedDoublesRating((int) Math.round(teamA.getPlayerA().getMixedDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
				teamA.getPlayerB().setMixedDoublesRating((int) Math.round(teamA.getPlayerB().getMixedDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
			}
		}
		
		if(winner.equals(teamA)){
			teamA.getPlayerA().setMixedDoublesRating(teamA.getPlayerA().getMixedDoublesRating() + 3);
			teamA.getPlayerB().setMixedDoublesRating(teamA.getPlayerB().getMixedDoublesRating() + 3);
		}
		
		
		//Update rating for team b
		if(teamB.getTeamRating() > teamA.getTeamRating()){
			teamB.getPlayerA().setMixedDoublesRating((int) Math.round(teamB.getPlayerA().getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamB.getPlayerB().setMixedDoublesRating((int) Math.round(teamB.getPlayerB().getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else if (teamB.getTeamRating() < teamA.getTeamRating()){
			teamB.getPlayerA().setMixedDoublesRating((int) Math.round(teamB.getPlayerA().getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamB.getPlayerB().setMixedDoublesRating((int) Math.round(teamB.getPlayerB().getMixedDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
		} else {
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamB.getPlayerA().setMixedDoublesRating((int) Math.round(teamB.getPlayerA().getMixedDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
				teamB.getPlayerB().setMixedDoublesRating((int) Math.round(teamB.getPlayerB().getMixedDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
			case 1:
				teamB.getPlayerA().setMixedDoublesRating((int) Math.round(teamB.getPlayerA().getMixedDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				teamB.getPlayerB().setMixedDoublesRating((int) Math.round(teamB.getPlayerB().getMixedDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				
			}
		}
		
		if(winner.equals(teamB)){
			teamB.getPlayerA().setMixedDoublesRating(teamB.getPlayerA().getMixedDoublesRating() + 3);
			teamB.getPlayerB().setMixedDoublesRating(teamB.getPlayerB().getMixedDoublesRating() + 3);
		}
		
		//ensure rankings can't go under 0
		if(teamA.getPlayerA().getMixedDoublesRating() < 0){
			teamA.getPlayerA().setMixedDoublesRating(0);
		}
		if(teamA.getPlayerB().getMixedDoublesRating() < 0){
			teamA.getPlayerB().setMixedDoublesRating(0);
		}
		if(teamB.getPlayerA().getMixedDoublesRating() < 0){
			teamB.getPlayerA().setMixedDoublesRating(0);
		}
		if(teamB.getPlayerB().getMixedDoublesRating() < 0){
			teamB.getPlayerB().setMixedDoublesRating(0);
		}
	}
}
