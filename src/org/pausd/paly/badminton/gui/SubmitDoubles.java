package org.pausd.paly.badminton.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.pausd.paly.badminton.processing.DoublesMatch;
import org.pausd.paly.badminton.processing.Gender;
import org.pausd.paly.badminton.processing.Match;
import org.pausd.paly.badminton.processing.MixedDoublesMatch;
import org.pausd.paly.badminton.processing.Player;
import org.pausd.paly.badminton.processing.Team;
import org.pausd.paly.badminton.sql.SqlHelper;

/**
 * 
 * @author michaelchau
 * A class that is an actionlistener for the submit button in doublespanel.
 * Pulls data inputed by user from textfields to update player ratings
 */
public class SubmitDoubles implements ActionListener{
	DoublesPanel dp;//doubles panel to pull user input from
	
	/**
	 * 
	 * @param dp-doubles panel to pull user input from
	 */
	public SubmitDoubles(DoublesPanel dp){
		this.dp = dp;
	}
	
	/**
	 * actions to perform when submit button is clicked in DoublesPanel 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//(e.g 007-James Bond, substring to get 007)
		String [][] players = new String[4][2];
		players[0] = dp.getA1().getSelectedItem().toString().split("-");
		players[1] = dp.getA2().getSelectedItem().toString().split("-");
		players[2] = dp.getB1().getSelectedItem().toString().split("-");
		players[3] = dp.getB2().getSelectedItem().toString().split("-");//split to get ids and name for each player from combobox
		
		//get ids (1st part of the string)
		String playerA1Id = players[0][0].trim();
		String playerA2Id = players[1][0].trim();
		String playerB1Id = players[2][0].trim();
		String playerB2Id = players[3][0].trim();
		
		//ArrayList<String []> stringScores = new ArrayList<>();//might want to change code to stackoverflow way
		int[][] scores = new int[3][2];
		
		for(int i = 0;i < scores.length;i++){
			for(int j = 0;j < scores[i].length;j++){
				try{
					scores[i][j] = Integer.parseInt(dp.getDoublesTextField(i, j).getText());//store the scores entered by user
				}catch(NumberFormatException | NullPointerException ex){
					scores[i][j] = -1; //set to negative if a game was not played
				}
			}
		}
		
		//(e.g 007-James Bond, substring to get James Bond)
		//get player names
		String playerA1Name = players[0][1].trim();
		String playerA2Name = players[1][1].trim();
		String playerB1Name = players[2][1].trim();
		String playerB2Name = players[3][1].trim();
		Gender genderA1 = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerA1Id));
		Gender genderA2 = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerA2Id));
		Gender genderB1 = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerB1Id));
		Gender genderB2 = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerB2Id));//get player genders from database using id
		int initialRatingA1;
		int initialRatingA2;
		int initialRatingB1;
		int initialRatingB2;
		if(genderA1 == genderA2){//doubles (genders of the two players are the same)
			initialRatingA1 = Integer.parseInt(SqlHelper.get("doublesRating", "player", "id = " + playerA1Id));
			initialRatingA2 = Integer.parseInt(SqlHelper.get("doublesRating", "player", "id = " + playerA2Id));
			initialRatingB1 = Integer.parseInt(SqlHelper.get("doublesRating", "player", "id = " + playerB1Id));
			initialRatingB2 = Integer.parseInt(SqlHelper.get("doublesRating", "player", "id = " + playerB2Id));//get doubles rating from database
		}else{//mixed doubles (genders of the two players are different)
			initialRatingA1 = Integer.parseInt(SqlHelper.get("mixedDoublesRating", "player", "id = " + playerA1Id));
			initialRatingA2 = Integer.parseInt(SqlHelper.get("mixedDoublesRating", "player", "id = " + playerA2Id));
			initialRatingB1 = Integer.parseInt(SqlHelper.get("mixedDoublesRating", "player", "id = " + playerB1Id));
			initialRatingB2 = Integer.parseInt(SqlHelper.get("mixedDoublesRating", "player", "id = " + playerB2Id));//get mixed doubles rating
																													//from database
		}
		
		Player playerA1 = new Player(Integer.parseInt(playerA1Id), playerA1Name,genderA1);
		Player playerA2 = new Player(Integer.parseInt(playerA2Id), playerA2Name,genderA2);
		Player playerB1 = new Player(Integer.parseInt(playerB1Id), playerB1Name,genderB1);
		Player playerB2 = new Player(Integer.parseInt(playerB2Id), playerB2Name,genderB2);
		if(genderA1 == genderA2){//doubles (genders of the two players are the same)
			playerA1.setDoublesRating(initialRatingA1);
			playerA2.setDoublesRating(initialRatingA2);
			playerB1.setDoublesRating(initialRatingB1);
			playerB2.setDoublesRating(initialRatingB2);//set initial doubles rating
		}else{//mixed doubles (genders of the two players are different)
			playerA1.setMixedDoublesRating(initialRatingA1);
			playerA2.setMixedDoublesRating(initialRatingA2);
			playerB1.setMixedDoublesRating(initialRatingB1);
			playerB2.setMixedDoublesRating(initialRatingB2);//set initial mixed doubles rating
		}
		
		Team A = new Team(playerA1,playerA2);
		Team B = new Team(playerB1,playerB2);
		
		if(genderA1 == genderA2){//doubles 
			//simulate match being played
			DoublesMatch match = new DoublesMatch(A,B);
			for(int i = 0;i < scores.length;i++){
				if(Match.areValidScores(scores[i][0], scores[i][1])){
					match.setTeamAScore(scores[i][0]);
					match.setTeamBScore(scores[i][1]);
					match.updatePlayerRatings();//after scores for match have been set, "play" game to update ratings
				}else{
					JOptionPane.showMessageDialog(null, "Please enter valid scores");
				}
			}
			SqlHelper.set("players", "doublesRating = " + playerA1.getDoublesRating(), "id = " + playerA1Id);
			SqlHelper.set("players", "doublesRating = " + playerA2.getDoublesRating(), "id = " + playerA2Id);
			SqlHelper.set("players", "doublesRating = " + playerB1.getDoublesRating(), "id = " + playerB1Id);
			SqlHelper.set("players", "doublesRating = " + playerB2.getDoublesRating(), "id = " + playerB2Id);//put new rating into database
		}else{//mixed doubles
			//simulate match being played
			MixedDoublesMatch match = new MixedDoublesMatch(A,B);
			for(int i = 0;i < scores.length;i++){
				if(Match.areValidScores(scores[i][0], scores[i][1])){
					match.setTeamAScore(scores[i][0]);
					match.setTeamBScore(scores[i][1]);
					match.updatePlayerRatings();//after scores for match have been set, "play" game to update ratings
				}else{
					JOptionPane.showMessageDialog(null, "Please enter valid scores");
				}
			}
			SqlHelper.set("players", "mixedDoublesRating = " + playerA1.getMixedDoublesRating(), "id = " + playerA1Id);
			SqlHelper.set("players", "mixedDoublesRating = " + playerA2.getMixedDoublesRating(), "id = " + playerA2Id);
			SqlHelper.set("players", "mixedDoublesRating = " + playerB1.getMixedDoublesRating(), "id = " + playerB1Id);
			SqlHelper.set("players", "mixedDoublesRating = " + playerB2.getMixedDoublesRating(), "id = " + playerB2Id);//put new rating into database
		}
		dp.clearDoublesEntries();
	}

}
