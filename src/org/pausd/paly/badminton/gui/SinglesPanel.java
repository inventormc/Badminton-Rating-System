package org.pausd.paly.badminton.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SinglesPanel extends JPanel{

	private JTextField singlesScores[][];
	private JComboBox<String> choosePlayerA, choosePlayerB;
	
	public SinglesPanel(){
			singlesScores = new JTextField[3][2];
			JPanel singles = new JPanel();
			JLabel playerA = new JLabel("Player A");
			choosePlayerA = new JComboBox<>();
			choosePlayerA.setEditable(true);
			singlesScores[0][0] = new JTextField();//playerAGame1
			singlesScores[1][0] = new JTextField();//playerAGame2
			singlesScores[2][0] = new JTextField();//playerAGame3
			JLabel playerB = new JLabel("Player B");
			choosePlayerB = new JComboBox<>();
			choosePlayerB.setEditable(true);
			singlesScores[0][1] = new JTextField();//playerBGame1
			singlesScores[1][1] = new JTextField();//playerBGame2
			singlesScores[2][1] = new JTextField();//playerBGame3
			JButton enterSingles = new JButton("Enter");//may want to put into separate panel so its centered
			enterSingles.addActionListener(new SubmitSingles(this));
			
			singles.setLayout(new GridLayout(0,2));
			singles.add(playerA);
			singles.add(playerB);
			singles.add(choosePlayerA);
			singles.add(choosePlayerB);
			singles.add(singlesScores[0][0]);
			singles.add(singlesScores[0][1]);
			singles.add(singlesScores[1][0]);
			singles.add(singlesScores[1][1]);
			singles.add(singlesScores[2][0]);
			singles.add(singlesScores[2][1]);
			singles.add(enterSingles);
	}

	public JTextField[][] getSinglesScores() {
		return singlesScores;
	}

	public JComboBox<String> getChoosePlayerA() {
		return choosePlayerA;
	}

	public JComboBox<String> getChoosePlayerB() {
		return choosePlayerB;
	}
	
	public JTextField getSinglesTextField(int row, int column) {
		return singlesScores[row][column];
	}
	
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
