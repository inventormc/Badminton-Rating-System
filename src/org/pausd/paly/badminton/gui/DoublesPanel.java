package org.pausd.paly.badminton.gui;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author michaelchau
 * A JPanel that will be called upon in MainMenu when user needs to enter scores
 * for a doubles match
 */
public class DoublesPanel extends JPanel{
	private JComboBox<String> a1, a2, b1, b2;//combobox to choose player
	private JTextField doublesScores[][];//store scores textfields

	/**
	 * Build DoublesPanel (JPanel), GUI for entering scores in doubles match
	 */
	public DoublesPanel(){
		doublesScores = new JTextField[3][2];//initialize
		
		//label which side is for team a scores, and team b scores
		JPanel doublesTop = new JPanel();
		doublesTop.setLayout(new GridLayout(0,2));
		JLabel teamA = new JLabel("Team A");
		JLabel teamB = new JLabel("Team B");
		doublesTop.add(teamA);
		doublesTop.add(teamB);
		
		//combobox to choose which players are in the game
		JPanel doublesMiddle = new JPanel();
		doublesMiddle.setLayout(new GridLayout(0,4));
		a1 = new JComboBox<>();
		a2 = new JComboBox<>();
		b1 = new JComboBox<>();
		b2 = new JComboBox<>();
		a1.setEditable(true);
		a2.setEditable(true);
		b1.setEditable(true);
		b2.setEditable(true);
		doublesMiddle.add(a1);
		doublesMiddle.add(a2);
		doublesMiddle.add(b1);
		doublesMiddle.add(b2);
		
		//initialize textfields to take game scores
		JPanel doublesBottom = new JPanel();
		doublesBottom.setLayout(new GridLayout(0,2));
		doublesScores[0][0] = new JTextField();//teamAGame1
		doublesScores[1][0] = new JTextField();//teamAGame2
		doublesScores[2][0] = new JTextField();//teamAGame3
		doublesScores[0][1] = new JTextField();//teamBGame1
		doublesScores[1][1] = new JTextField();//teamBGame2
		doublesScores[2][1] = new JTextField();//teamBGame3
		JButton enterDoubles = new JButton("Enter");//may want to put into separate panel so its centered
		enterDoubles.addActionListener(new SubmitDoubles(this));
		
		doublesBottom.add(doublesScores[0][0]);
		doublesBottom.add(doublesScores[0][1]);
		doublesBottom.add(doublesScores[1][0]);
		doublesBottom.add(doublesScores[1][1]);
		doublesBottom.add(doublesScores[2][0]);
		doublesBottom.add(doublesScores[2][1]);
		doublesBottom.add(enterDoubles);
		
		//add to this jpanel
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(doublesTop);
		this.add(doublesMiddle);
		this.add(doublesBottom);
	}
	
	/**
	 * 
	 * @return JComboBox a1 (Player 1 of team a)
	 */
	public JComboBox<String> getA1() {
		return a1;
	}
	
	/**
	 * 
	 * @return JComboBox a2 (Player 2 of team a)
	 */
	public JComboBox<String> getA2() {
		return a2;
	}
	
	/**
	 * 
	 * @return JComboBox b1 (Player 1 of team b)
	 */
	public JComboBox<String> getB1() {
		return b1;
	}
	
	/**
	 * 
	 * @return JComboBox b2 (Player 2 of team b)
	 */
	public JComboBox<String> getB2() {
		return b2;
	}
	
	/**
	 * 
	 * @return array storing scores for the game
	 */
	public JTextField[][] getDoublesScores() {
		return doublesScores;
	}
	
	/**
	 * 
	 * @param row - which row textfield is in
	 * @param column - which column textfield is in
	 * @return a specific textfield that takes a sccore in the gui 
	 */
	public JTextField getDoublesTextField(int row, int column) {
		return doublesScores[row][column];
	}
	
	/**
	 * clear textfields
	 */
	public void clearDoublesEntries(){
		for(int i = 0;i < doublesScores.length;i++){
			for(int j = 0;j < doublesScores[i].length;j++){
				doublesScores[i][j].setText("");
			}
		}
		
		a1.setSelectedItem(null);
		a2.setSelectedItem(null);
		b1.setSelectedItem(null);
		b2.setSelectedItem(null);
	}
}
