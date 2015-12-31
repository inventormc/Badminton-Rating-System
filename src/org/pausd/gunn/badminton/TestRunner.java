package org.pausd.gunn.badminton;

import java.util.Date;

public class TestRunner {

	//MAKE A PLAYGAME METHOD THAT public playGame(int thisScore, int opponentScore, Player opponent)
	//that utilizes the updateRating method once determining who has won and lost-and assigning all
	//the needed values (rating-given, scores-given, winner-calculated)
	//take out opponent and matchUp();
	public static void main(String args[]) {
		Player john = new Player("John");
		Player mike = new Player("Mike");
		john.setRating(1466);
		mike.setRating(1430);
		
		Match match = new Match();
		match.setTime(new Date(System.currentTimeMillis()));
		match.setPlayerA(john);
		match.setPlayerB(mike);
		match.setPlayerAScore(21);
		match.setPlayerBScore(5);
		match.updatePlayerRatings();
		
		System.out.println(john.getRating());
		System.out.println(mike.getRating());
	}
	
}
