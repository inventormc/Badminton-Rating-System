package org.pausd.gunn.badminton;

import java.util.ArrayList;

public class Team {
	//ensure that ordering in arraylist will work alright
	private ArrayList<Player> players;
	private int teamRating;
	
	public Team(Player playerA, Player playerB){
		players = new ArrayList<>();
		players.add(playerA);
		players.add(playerB);
	}
	
	public Team(Player playerA){
		players = new ArrayList<>();
		players.add(playerA);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getTeamRating() {
		switch (players.size()){
		case 1:
			teamRating = players.get(0).getSinglesRating();
		case 2:
			if(players.get(0).getGender() != players.get(1).getGender()){
				teamRating = (players.get(0).getMixedDoublesRating() + players.get(1).getMixedDoublesRating())/2;
			}else{
				teamRating = (players.get(0).getDoublesRating() + players.get(1).getDoublesRating())/2;
			}
		}
		
		return teamRating;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Team){
			return players.get(0).getName().equals(((Team) o).players.get(0).getName())
					&& players.get(1).getName().equals(((Team) o).players.get(1).getName());
		}
		return false;
	}
}
