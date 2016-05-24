package org.pausd.paly.badminton.processing;

import java.util.Date;
/**
 * Abstract class that other kinds of matches (sinlges, doubles) will extend.
 * Stores information about match, and updates player ratings by simulating
 * a match being played.
 * @author michaelchau
 *
 */
public abstract class Match {
	protected Date time;//when match was played
	protected Team teamA;//team a of match
	protected Team teamB;//team b of match
	protected int teamAScore;//score of team a
	protected int teamBScore;//score of team b
	
	/**
	 * 
	 * @return time when match was played
	 */
	public Date getTime() {
		return time;
	}
	
	/**
	 * 
	 * @param time- time when match was played
	 * set time for when the match was played
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	/**
	 * 
	 * @return team a
	 */
	public Team getTeamA() {
		return teamA;
	}
	
	/**
	 * 
	 * @param teamA- team a
	 * set which team is team a
	 */
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	
	/**
	 * 
	 * @return team b
	 */
	public Team getTeamB() {
		return teamB;
	}
	
	/**
	 * 
	 * @param teamB- team b
	 * set which team is team b
	 */
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	
	/**
	 * 
	 * @return score for team a
	 */
	public int getTeamAScore() {
		return teamAScore;
	}
	
	/**
	 * 
	 * @param teamAScore- team a score
	 * set score for team a
	 */
	public void setTeamAScore(int teamAScore) {
		this.teamAScore = teamAScore;
	}
	
	/**
	 * 
	 * @return score for team b
	 */
	public int getTeamBScore() {
		return teamBScore;
	}
	
	/**
	 * 
	 * @param teamBScore- team b score
	 * set score for team b
	 */
	public void setTeamBScore(int teamBScore) {
		this.teamBScore = teamBScore;
	}
	
	/**
	 * 
	 * @return team that is winner of the match
	 */
	public Team getWinner(){
		if(teamAScore > teamBScore){//if score is bigger team a is winner
			return teamA;
		}else{
			return teamB;//else, team b wins
		}
	}
	
	//NEED TO MAKE SURE THIS METHOD WORKS
	/**
	 * check if the inputted scores from the textfields in gui are valid
	 * @param teamAScore- team a score
	 * @param teamBScore- team b score
	 * @return- true if valid scores, false if otherwise
	 */
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
	
	/**
	 * update player ratings based on the scores of the match just played
	 */
	public abstract void updatePlayerRatings();
}
