package org.pausd.paly.badminton.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author michaelchau
 * A JPanel that will be called upon in MainMenu when user needs to enter scores
 * for a singles match
 */
public class SinglesPanel extends JPanel{

	private JTextField singlesScores[][];//textfields for inputting scores
	private JComboBox<String> choosePlayerA, choosePlayerB;//comboboxes for choosing players in the match
	
	/**
	 * Build singlespanel, JPanel for entering scores
	 * of a singles match
	 */
	public SinglesPanel(){
			singlesScores = new JTextField[3][2];
			JLabel playerA = new JLabel("Player A");//label side for player a
			choosePlayerA = new JComboBox<>();//combobox to choose which player is player a
			choosePlayerA.setEditable(true);
			singlesScores[0][0] = new JTextField();//playerAGame1
			singlesScores[1][0] = new JTextField();//playerAGame2
			singlesScores[2][0] = new JTextField();//playerAGame3
			JLabel playerB = new JLabel("Player B");//label side for player b
			choosePlayerB = new JComboBox<>();//combobox to choose which player is player b
			choosePlayerB.setEditable(true);
			singlesScores[0][1] = new JTextField();//playerBGame1
			singlesScores[1][1] = new JTextField();//playerBGame2
			singlesScores[2][1] = new JTextField();//playerBGame3
			JButton enterSingles = new JButton("Enter");//may want to put into separate panel so its centered
			enterSingles.addActionListener(new SubmitSingles(this));
			
			this.setLayout(new GridLayout(0,2));
			this.add(playerA);
			this.add(playerB);
			this.add(choosePlayerA);
			this.add(choosePlayerB);
			this.add(singlesScores[0][0]);
			this.add(singlesScores[0][1]);
			this.add(singlesScores[1][0]);
			this.add(singlesScores[1][1]);
			this.add(singlesScores[2][0]);
			this.add(singlesScores[2][1]);
			this.add(enterSingles);
	}
	
	/**
	 * 
	 * @return textfields for inputting scores
	 */
	public JTextField[][] getSinglesScores() {
		return singlesScores;
	}
	
	/**
	 * 
	 * @return combobox for choosing which player is player a
	 */
	public JComboBox<String> getChoosePlayerA() {
		return choosePlayerA;
	}
	
	/**
	 * 
	 * @return combobox for choosing which player is player b
	 */
	public JComboBox<String> getChoosePlayerB() {
		return choosePlayerB;
	}
	
	/**
	 * 
	 * @param row-which row is the textfield in
	 * @param column-which column is the textfield in
	 * @return-specific textfield based on row and column
	 */
	public JTextField getSinglesTextField(int row, int column) {
		return singlesScores[row][column];
	}
	
	/**
	 * clear all textfields 
	 */
	public void clearSinglesEntries(){
		for(int i = 0;i < singlesScores.length;i++){
			for(int j = 0;j < singlesScores[i].length;j++){
				singlesScores[i][j].setText("");
			}
		}
		
		choosePlayerA.setSelectedItem(null);
		choosePlayerB.setSelectedItem(null);
	}
}
