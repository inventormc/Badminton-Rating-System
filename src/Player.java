
public class Player {
	private int rating;
	private boolean winner;
	private Player opponent;
	private int score;
	
	public Player(int rating){
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	public Player getOpponent() {
		return opponent;
	}
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void matchUp(Player opponent){
		this.opponent = opponent;
		opponent.opponent = this;
	}
	public void updateRating(boolean winner, int thisScore, int opponentScore){
		this.winner = winner;
		this.score = thisScore;
		this.opponent.score = opponentScore;
		
		if(this.opponent == null){
			System.out.println("Opponent has not been set yet");
			return;
		}
		if(this.getRating() > opponent.getRating()){
			rating = (int) Math.round(rating + ((this.getScore() - opponent.getScore()) - (0.1 * (this.getRating() - opponent.getRating()))));
			if(winner){
				rating = rating + 3;
			}
		}else{
			rating = (int) Math.round(rating + ((this.getScore() - opponent.getScore()) + (0.1 * (opponent.getRating() - this.getRating()))));
			if(winner){
				rating = rating + 3;
			}
		}
	}
	
	//MAKE A PLAYGAME METHOD THAT public playGame(int thisScore, int opponentScore, Player opponent)
	//that utilizes the updateRating method once determining who has won and lost-and assigning all
	//the needed values (rating-given, scores-given, winner-calculated)
	//take out opponent and matchUp();
	public static void main(String args[]){
		Player John = new Player(1466);
		Player Mike = new Player(1430);
		John.matchUp(Mike);
		John.updateRating(true,21,5);
		Mike.updateRating(false,5,21);
		System.out.println(John.getRating());
		System.out.println(Mike.getRating());
	}
}
