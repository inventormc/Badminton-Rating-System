package org.pausd.paly.badminton.processing;

public class Player {
	private final String name;
	private Gender gender;
	private int singlesRating;
	private int doublesRating;
	private int mixedDoublesRating;
	
	public Player(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getSinglesRating() {
		return singlesRating;
	}

	public void setSinglesRating(int singlesRating) {
		this.singlesRating = singlesRating;
	}

	public String getName() {
		return name;
	}

	public int getDoublesRating() {
		return doublesRating;
	}

	public void setDoublesRating(int doublesRating) {
		this.doublesRating = doublesRating;
	}

	public int getMixedDoublesRating() {
		return mixedDoublesRating;
	}

	public void setMixedDoublesRating(int mixedDoublesRating) {
		this.mixedDoublesRating = mixedDoublesRating;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Player) {
			// Compare our name to the name of the given player
			return this.getName().equals(((Player)o).getName());
		}
		return false;
	}
	
}
