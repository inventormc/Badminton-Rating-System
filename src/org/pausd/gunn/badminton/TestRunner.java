package org.pausd.gunn.badminton;

public class TestRunner {

	//MAKE A PLAYGAME METHOD THAT public playGame(int thisScore, int opponentScore, Player opponent)
	//that utilizes the updateRating method once determining who has won and lost-and assigning all
	//the needed values (rating-given, scores-given, winner-calculated)
	//take out opponent and matchUp();
	public static void main(String args[]) {
		Player john = new Player("John", Gender.MALE);
		Player julia = new Player("Julia", Gender.FEMALE);
		
		Player mike = new Player("Mike", Gender.MALE);
		Player mary = new Player("Mary",Gender.FEMALE);
		
		john.setMixedDoublesRating(1500);
		julia.setMixedDoublesRating(1500);
		
		mike.setMixedDoublesRating(1200);
		mary.setMixedDoublesRating(1200);
		
		Team a = new Team(john,julia);
		Team b = new Team(mike,mary);
		MixedDoublesMatch match = new MixedDoublesMatch(a,b);
		match.setTeamAScore(11);
		match.setTeamBScore(21);
		match.updatePlayerRatings();
		
	}
	
}
