package org.pausd.gunn.badminton;

public enum Gender {
	MALE("male"),
	FEMALE("female");
	
	private String text;
	
	Gender(String text){
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}

	public static Gender fromString(String text) {
		if (text != null) {
			for (Gender gender : Gender.values()) {
				if (text.equalsIgnoreCase(gender.text)) {
					return gender;
				}
			}
		}
		return null;
	}
}
