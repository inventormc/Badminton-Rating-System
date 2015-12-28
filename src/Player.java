
public class Player {
	private int rating;
	private boolean winner;
	private Player opponent;
	private int score;
	
	public Player(int rating, boolean winner, int score){
		this.rating = rating;
		this.winner = winner;
		this.score = score;
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
	public void updateRating(){
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
	
	public static void main(String args[]){
		Player John = new Player(1466, true, 21);
		Player Mike = new Player(1430, false, 5);
		John.matchUp(Mike);
		John.updateRating();
		Mike.updateRating();
		System.out.println(John.getRating());
		System.out.println(Mike.getRating());
	}
}
