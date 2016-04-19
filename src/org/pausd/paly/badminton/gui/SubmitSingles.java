package org.pausd.paly.badminton.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.pausd.paly.badminton.processing.Gender;
import org.pausd.paly.badminton.processing.Player;
import org.pausd.paly.badminton.processing.SinglesMatch;
import org.pausd.paly.badminton.processing.Team;
import org.pausd.paly.badminton.sql.SqlHelper;

public class SubmitSingles implements ActionListener{
	MainMenu mm;
	public SubmitSingles(MainMenu mm){
		this.mm = mm;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//will need to identify player by id when querying into databases (e.g 007-James Bond, substring to get 007)
		String playerAId = mm.getChoosePlayerA().getSelectedItem().toString();//check what the string looks like for errors
		String playerBId = mm.getChoosePlayerB().getSelectedItem().toString();//check what the string looks like for errors
		int[][] scores = new int[3][2];
		for(int i = 0;i < scores.length;i++){
			for(int j = 0;j < scores[i].length;j++){
				try{
					scores[i][j] = Integer.parseInt(mm.getSinglesTextField(i, j).getText());
				}catch(NumberFormatException ex){
					scores[i][j] = -1;//set to negative to indicate game was not played
				}
			}
		}
		//(007-James Bond, substring to get James Bond)
		String playerAName = mm.getChoosePlayerA().getSelectedItem().toString();//check what the string looks like for errors
		String playerBName = mm.getChoosePlayerB().getSelectedItem().toString();//check what the string looks like for errors
		Gender genderA = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerAId));
		Gender genderB = Gender.fromString(SqlHelper.get("gender", "players", "id = " + playerBId));
		int initialRatingA = Integer.parseInt(SqlHelper.get("singlesRating", "players", "id = " + playerAId));
		int initialRatingB = Integer.parseInt(SqlHelper.get("singlesRating", "players", "id = " + playerBId));
		
		Player playerA = new Player(playerAName, genderA);
		Player playerB = new Player(playerBName, genderB);
		playerA.setSinglesRating(initialRatingA);
		playerB.setSinglesRating(initialRatingB);
		Team A = new Team(playerA);
		Team B = new Team(playerB);
		
		SinglesMatch match = new SinglesMatch(A,B);
		for(int i = 0;i < scores.length;i++){
			if(scores[i][0] >= 0 && scores[i][1] >= 0){
				match.setTeamAScore(scores[i][0]);
				match.setTeamBScore(scores[i][1]);
				match.updatePlayerRatings();
			}
		}
		
		SqlHelper.set("players", "singlesRating = " + playerA.getSinglesRating(), "id = " + playerAId);
		SqlHelper.set("players", "sinlgesRating = " + playerB.getSinglesRating(), "id = " + playerBId);
		mm.clearSinglesEntries();
	}

}
