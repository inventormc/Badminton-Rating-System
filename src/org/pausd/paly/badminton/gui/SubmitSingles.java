package org.pausd.paly.badminton.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.pausd.paly.badminton.processing.Gender;
import org.pausd.paly.badminton.processing.Match;
import org.pausd.paly.badminton.processing.Player;
import org.pausd.paly.badminton.processing.SinglesMatch;
import org.pausd.paly.badminton.processing.Team;
import org.pausd.paly.badminton.sql.SqlHelper;

/**
 * 
 * @author michaelchau
 * A class that is an actionlistener for the submit button in singlespanel.
 * Pulls data inputted by user from textfields to update player ratings
 */
public class SubmitSingles implements ActionListener{
	
	SinglesPanel sp;//singles panel to take user input from
	
	/**
	 * 
	 * @param sp-singles panel to take user input from
	 * Initialize actionlistener
	 */
	public SubmitSingles(SinglesPanel sp){
		this.sp = sp;
	}
	
	/**
	 * Actions to perform when button to submit is pressed in SingesPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//will need to identify player by id when querying into databases (e.g 007-James Bond, substring to get 007)
		String [][] players = new String[2][2];
		players[0] = sp.getChoosePlayerA().getSelectedItem().toString().split("-");//parse into id and name
		players[1] = sp.getChoosePlayerB().getSelectedItem().toString().split("-");
		
		//get ids 
		String playerAId = players[0][0].trim();//check what the string looks like for errors
		String playerBId = players[1][0].trim();//check what the string looks like for errors
		
		//ArrayList<String []> stringScores = new ArrayList<>();//might want to change code to stackoverflow way
		int[][] scores = new int[3][2];
		for(int i = 0;i < scores.length;i++){
			for(int j = 0;j < scores[i].length;j++){
				try{
					scores[i][j] = Integer.parseInt(sp.getSinglesTextField(i, j).getText());//take all scores from textfield
				}catch(NumberFormatException | NullPointerException ex){
					scores[i][j] = -1;//set to negative to indicate game was not played
				}
			}
		}
		//(007-James Bond, substring to get James Bond), get player names
		String playerAName = players[0][1].trim();//check what the string looks like for errors
		String playerBName = players[1][1].trim();//check what the string looks like for errors
		Gender genderA = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerAId));//get gender from database with id
		Gender genderB = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerBId));
		int initialRatingA = Integer.parseInt(SqlHelper.get("singlesRating", "players", "id = " + playerAId));//get rating before this game
																											//was played from database
		int initialRatingB = Integer.parseInt(SqlHelper.get("singlesRating", "players", "id = " + playerBId));
		
		//"play" the game to update the ratings
		Player playerA = new Player(Integer.parseInt(playerAId), playerAName, genderA);
		Player playerB = new Player(Integer.parseInt(playerBId), playerBName, genderB);
		playerA.setSinglesRating(initialRatingA);
		playerB.setSinglesRating(initialRatingB);
		Team A = new Team(playerA);
		Team B = new Team(playerB);
		
		SinglesMatch match = new SinglesMatch(A,B);
		for(int i = 0;i < scores.length;i++){
			if(Match.areValidScores(scores[i][0], scores[i][1])){
				match.setTeamAScore(scores[i][0]);
				match.setTeamBScore(scores[i][1]);
				match.updatePlayerRatings();//input scores from user, play the game to update player ratings
			}
		}
		
		SqlHelper.set("players", "singlesRating = " + playerA.getSinglesRating(), "id = " + playerAId);
		SqlHelper.set("players", "sinlgesRating = " + playerB.getSinglesRating(), "id = " + playerBId);//put new ratings into database
		sp.clearSinglesEntries();
	}

}
