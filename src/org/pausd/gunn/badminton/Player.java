package org.pausd.gunn.badminton;

public class Player {
	private final String name;
	private int rating;

	public Player(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
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
