package org.pausd.gunn.badminton;

import java.util.Date;

public abstract class Match {
	protected Date time;
	protected Team teamA;
	protected Team teamB;
	protected Integer teamAScore;
	protected Integer teamBScore;
	
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
	public Integer getTeamAScore() {
		return teamAScore;
	}
	public void setTeamAScore(Integer teamAScore) {
		this.teamAScore = teamAScore;
	}
	public Integer getTeamBScore() {
		return teamBScore;
	}
	public void setTeamBScore(Integer teamBScore) {
		this.teamBScore = teamBScore;
	}
	
	public Team getWinner(){
		if(teamAScore > teamBScore){
			return teamA;
		}else{
			return teamB;
		}
	}
	
	public abstract void updatePlayerRatings();
}
