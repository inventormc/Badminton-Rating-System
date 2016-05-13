package org.pausd.paly.badminton.gui;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DoublesPanel extends JPanel{
	private JComboBox<String> a1, a2, b1, b2;
	private JTextField doublesScores[][];

	public DoublesPanel(){
		doublesScores = new JTextField[3][2];
		JPanel doubles = new JPanel();
		
		JPanel doublesTop = new JPanel();
		doublesTop.setLayout(new GridLayout(0,2));
		JLabel teamA = new JLabel("Team A");
		JLabel teamB = new JLabel("Team B");
		doublesTop.add(teamA);
		doublesTop.add(teamB);
		
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
		
		doubles.setLayout(new BoxLayout(doubles,BoxLayout.Y_AXIS));
		doubles.add(doublesTop);
		doubles.add(doublesMiddle);
		doubles.add(doublesBottom);
	}
	
	public JComboBox<String> getA1() {
		return a1;
	}

	public JComboBox<String> getA2() {
		return a2;
	}

	public JComboBox<String> getB1() {
		return b1;
	}

	public JComboBox<String> getB2() {
		return b2;
	}

	public JTextField[][] getDoublesScores() {
		return doublesScores;
	}
	
	public JTextField getDoublesTextField(int row, int column) {
		return doublesScores[row][column];
	}
	
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
