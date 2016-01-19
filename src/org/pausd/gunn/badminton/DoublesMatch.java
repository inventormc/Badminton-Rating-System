package org.pausd.gunn.badminton;

import java.util.Date;
import java.util.Random;

public class DoublesMatch {
	private Date time;
	private Team teamA;
	private Team teamB;
	private int teamAScore;
	private int teamBScore;
	
	public DoublesMatch(Team teamA, Team teamB){
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
	
	public void updatePlayerRatings(){
		Team winner = this.getWinner();
		
		if (this.getTeamA() == null || this.getTeamB() == null) {
			System.out.println("Players have not been set yet");
			return;
		}
		
		//First update rating for team a
		if(teamA.getTeamRating() > teamB.getTeamRating()){
			teamA.getPlayerA().setDoublesRating((int) Math.round(teamA.getPlayerA().getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamA.getPlayerB().setDoublesRating((int) Math.round(teamA.getPlayerB().getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					- (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));

		} else if(teamA.getTeamRating() < teamB.getTeamRating()){
			teamA.getPlayerA().setDoublesRating((int) Math.round(teamA.getPlayerA().getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamA.getPlayerB().setDoublesRating((int) Math.round(teamA.getPlayerB().getDoublesRating() + ((getTeamAScore() - getTeamBScore())
					+ (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else {
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamA.getPlayerA().setDoublesRating((int) Math.round(teamA.getPlayerA().getDoublesRating() + 
						(getTeamAScore() - getTeamBScore())));
				teamA.getPlayerB().setDoublesRating((int) Math.round(teamA.getPlayerB().getDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
			case 1:
				teamA.getPlayerA().setDoublesRating((int) Math.round(teamA.getPlayerA().getDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
				teamA.getPlayerB().setDoublesRating((int) Math.round(teamA.getPlayerB().getDoublesRating() +
						(getTeamBScore()- getTeamAScore())));
			}
		}
		
		if(winner.equals(teamA)){
			teamA.getPlayerA().setDoublesRating(teamA.getPlayerA().getDoublesRating() + 3);
			teamA.getPlayerB().setDoublesRating(teamA.getPlayerB().getDoublesRating() + 3);
		}
		
		
		//Update rating for team b
		if(teamB.getTeamRating() > teamA.getTeamRating()){
			teamB.getPlayerA().setDoublesRating((int) Math.round(teamB.getPlayerA().getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
			teamB.getPlayerB().setDoublesRating((int) Math.round(teamB.getPlayerB().getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					- (0.1 * (teamB.getTeamRating() - teamA.getTeamRating())))));
		} else if (teamB.getTeamRating() < teamA.getTeamRating()){
			teamB.getPlayerA().setDoublesRating((int) Math.round(teamB.getPlayerA().getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
			teamB.getPlayerB().setDoublesRating((int) Math.round(teamB.getPlayerB().getDoublesRating() + ((getTeamBScore() - getTeamAScore())
					+ (0.1 * (teamA.getTeamRating() - teamB.getTeamRating())))));
		} else {
			//when the player rankings are equal, we randomly choose an xy assignment to use 
			//note: end of formula with .1(E-D) where e is high ranking and d is low ranking results in zero
			//since the rankings are the same in this case. .1(E-D) part have been deleted for this reason
			
			Random r = new Random();
			int choice = r.nextInt(2);
			
			switch(choice){
			case 0:
				teamB.getPlayerA().setDoublesRating((int) Math.round(teamB.getPlayerA().getDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
				teamB.getPlayerB().setDoublesRating((int) Math.round(teamB.getPlayerB().getDoublesRating() +
						(getTeamBScore() - getTeamAScore())));
			case 1:
				teamB.getPlayerA().setDoublesRating((int) Math.round(teamB.getPlayerA().getDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				teamB.getPlayerB().setDoublesRating((int) Math.round(teamB.getPlayerB().getDoublesRating() +
						(getTeamAScore() - getTeamBScore())));
				
			}
		}
		
		if(winner.equals(teamB)){
			teamB.getPlayerA().setDoublesRating(teamB.getPlayerA().getDoublesRating() + 3);
			teamB.getPlayerB().setDoublesRating(teamB.getPlayerB().getDoublesRating() + 3);
		}
		
		//ensure rankings can't go under 0
		if(teamA.getPlayerA().getDoublesRating() < 0){
			teamA.getPlayerA().setDoublesRating(0);
		}
		if(teamA.getPlayerB().getDoublesRating() < 0){
			teamA.getPlayerB().setDoublesRating(0);
		}
		if(teamB.getPlayerA().getDoublesRating() < 0){
			teamB.getPlayerA().setDoublesRating(0);
		}
		if(teamB.getPlayerB().getDoublesRating() < 0){
			teamB.getPlayerB().setDoublesRating(0);
		}
	}
}
