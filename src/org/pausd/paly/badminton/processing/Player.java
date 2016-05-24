package org.pausd.paly.badminton.processing;
/**
 * A class that holds informations about individual athletes/players.
 * Has id, name, gender, and various ratings.
 * @author michaelchau
 *
 */
public class Player {
	private final int id;//unique player id
	private final String name;//player name
	private Gender gender;//player gender (Enum)
	private int singlesRating;//singles rating of player
	private int doublesRating;//doubles rating of player
	private int mixedDoublesRating;//mixed doubels rating of player
	
	/**
	 * 
	 * @param id- player id
	 * @param name- player's full name
	 * @param gender- player's gender
	 */
	public Player(int id, String name, Gender gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	/**
	 * 
	 * @return id of player
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return gender of player
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * 
	 * @return player's singles rating
	 */
	public int getSinglesRating() {
		return singlesRating;
	}
	
	/**
	 * 
	 * @param singlesRating- new singles rating
	 * set player's singles rating to new singles rating
	 */
	public void setSinglesRating(int singlesRating) {
		this.singlesRating = singlesRating;
	}
	
	/**
	 * 
	 * @return player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return player's doubles rating
	 */
	public int getDoublesRating() {
		return doublesRating;
	}
	
	/**
	 * 
	 * @param doublesRating- new doubles rating
	 * set player's doubles rating to new doubles rating
	 */
	public void setDoublesRating(int doublesRating) {
		this.doublesRating = doublesRating;
	}
	
	/**
	 * 
	 * @return player's mixed doubles rating
	 */
	public int getMixedDoublesRating() {
		return mixedDoublesRating;
	}
	
	/**
	 * 
	 * @param mixedDoublesRating- new mixed doubles rating
	 * set player's mixed doubles rating to new mixed doubles rating
	 */
	public void setMixedDoublesRating(int mixedDoublesRating) {
		this.mixedDoublesRating = mixedDoublesRating;
	}
	
	/**
	 * check if two objects are the same player object
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Player) {
			// Compare our id to the id of the given player
			return this.getId() == ((Player)o).getId();//if two players have same id, then return true
		}
		return false;
	}
	
}
