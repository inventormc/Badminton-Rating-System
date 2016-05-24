package org.pausd.paly.badminton.processing;
/**
 * 
 * @author michaelchau
 * An Enum of type gender to store the gender of players. Used to distinguish gender for
 * singles, doubles, and mixed doubles matches.
 */
public enum Gender {
	MALE("male"),//male
	FEMALE("female");//female
	
	private String text;//text that represents enum of type gender
	
	/**
	 * 
	 * @param text - text that represents gender
	 * Constructor for enum of type gender
	 */
	Gender(String text){
		this.text = text;
	}
	
	/**
	 * 
	 * @return the text of the enum of type gender
	 */
	public String getText() {
		return this.text;
	}
	
	
	/**
	 * 
	 * @param text- text to get enum of type gender
	 * @return enum of type gender corresponding to text
	 */
	public static Gender fromString(String text) {
		if (text != null) {
			for (Gender gender : Gender.values()) {//look through all enums of type gender
				if (text.equalsIgnoreCase(gender.text)) {//if the text matches, return the enum of type gender
					return gender;
				}
			}
		}
		return null;//return null if match is not found
	}
}
