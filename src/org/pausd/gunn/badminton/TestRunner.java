package org.pausd.gunn.badminton;

import java.util.Date;
public class TestRunner {

	//MAKE A PLAYGAME METHOD THAT public playGame(int thisScore, int opponentScore, Player opponent)
	//that utilizes the updateRating method once determining who has won and lost-and assigning all
	//the needed values (rating-given, scores-given, winner-calculated)
	//take out opponent and matchUp();
	public static void main(String args[]) {
		Player john = new Player("John", Gender.MALE);
		Player mike = new Player("Mike", Gender.MALE);
		john.setSinglesRating(1466);
		mike.setSinglesRating(1430);
		
		SinglesMatch singlesMatch = new SinglesMatch();
		singlesMatch.setTime(new Date(System.currentTimeMillis()));
		singlesMatch.setPlayerA(john);
		singlesMatch.setPlayerB(mike);
		singlesMatch.setPlayerAScore(21);
		singlesMatch.setPlayerBScore(5);
		singlesMatch.updatePlayerRatings();
		
		System.out.println(john.getSinglesRating());
		System.out.println(mike.getSinglesRating());
	}
	
}
