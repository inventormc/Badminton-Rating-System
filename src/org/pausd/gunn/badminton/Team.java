package org.pausd.gunn.badminton;

public class Team {
	private Player playerA;
	private Player playerB;
	private int teamRating;
	
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
	public int getTeamRating() {
		if(playerA.getGender() != playerB.getGender()){
			teamRating = (playerA.getMixedDoublesRating() + playerB.getMixedDoublesRating())/2;
		}else{
			teamRating = (playerA.getDoublesRating() + playerB.getDoublesRating())/2;
		}
		
		return teamRating;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Team){
			return playerA.getName().equals(((Team) o).getPlayerA().getName())
					&& playerB.getName().equals(((Team) o).getPlayerB().getName());
		}
		return false;
	}
}
