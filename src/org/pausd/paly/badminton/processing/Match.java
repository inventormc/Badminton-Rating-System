package org.pausd.paly.badminton.processing;

import java.util.Date;

public abstract class Match {
	protected Date time;
	protected Team teamA;
	protected Team teamB;
	protected int teamAScore;
	protected int teamBScore;
	
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
	
	//NEED TO MAKE SURE THIS METHOD WORKS
	public static boolean areValidScores(int teamAScore, int teamBScore){
		if(teamAScore < 0 || teamBScore < 0){
			return false;
		}else if(teamAScore > 30 || teamBScore > 30){
			return false;
		}else if(teamAScore < 21 && teamBScore < 21){
			return false;
		}else if(teamAScore == 30 && teamBScore != 29){
			return false;
		}else if(teamBScore == 30 && teamAScore != 29){
			return false;
		}else if(teamAScore > 21 && teamBScore < teamAScore && teamAScore - teamBScore != 2){
			return false;
		}else if(teamBScore > 21 && teamAScore < teamBScore && teamBScore - teamAScore != 2){
			return false;
		}else if(((int)Math.abs(teamAScore - teamBScore)) < 2){
			return false;
		}else{
			return true;
		}
	}
	
	public abstract void updatePlayerRatings();
}
