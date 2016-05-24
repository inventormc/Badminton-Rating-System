package org.pausd.paly.badminton.processing;

import java.util.ArrayList;
/**
 * 
 * @author michaelchau
 * A class used in each match (two teams in each match). Team has its own rating
 * and players.
 */
public class Team {
	//ensure that ordering in arraylist will work alright
	private ArrayList<Player> players;//players on this team
	private int teamRating;//the teams rating (average of players)
	
//	public Team(Player playerA, Player playerB){
//		players = new ArrayList<>();
//		players.add(playerA);
//		players.add(playerB);
//	}
//	
//	public Team(Player playerA){
//		players = new ArrayList<>();
//		players.add(playerA);
//	}
	
	//may want to change to either 1 or 2 players
	/**
	 * 
	 * @param players- the players on this time
	 * Create a Team object with variable number of players
	 */
	public Team(Player ...players){
		this.players = new ArrayList<>();
		for(Player player: players){
			this.players.add(player);
		}
	}
	
	/**
	 * 
	 * @return player array containing players on this team
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * 
	 * @param players players on this team
	 * set which players are on this team
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	/**
	 * 
	 * @return team rating
	 * calculate team rating by averaging player ratings
	 */
	public int getTeamRating() {
		switch (players.size()){
		case 1:
			teamRating = players.get(0).getSinglesRating();//if its just one person, take the singles rating as team rating
		case 2://if multiple people, take either mixed doubles or doubles rating (appropriate one) and average
			if(players.get(0).getGender() != players.get(1).getGender()){
				teamRating = (int)Math.round((players.get(0).getMixedDoublesRating() + players.get(1).getMixedDoublesRating())/2.0);
			}else{
				teamRating = (int)Math.round((players.get(0).getDoublesRating() + players.get(1).getDoublesRating())/2.0);
			}
		}
		
		return teamRating;
	}
	
	/**
	 * Check whether two Team objects are the same Team
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof Team){
			if(players.size() == 1){//if one person on team, return true if two players are the same player
				return players.get(0).equals(((Team)o).players.get(0));
			}
			if(players.size() == 2){//if two people, return true if each two players are the same player
				return players.get(0).equals(((Team) o).players.get(0))
						&& players.get(1).equals(((Team) o).players.get(1));
			}
		}
		return false;
	}
}
