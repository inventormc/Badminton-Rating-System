package org.pausd.gunn.badminton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JPanel implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final static String SINGLES = "Singles";
	final static String DOUBLES = "Doubles";
	private JTextField singlesScores[][], doublesScores[][];
	private JComboBox<String> choosePlayerA, choosePlayerB, a1, a2, b1, b2;
	//private JButton enterSingles, enterDoubles;
	
	public MainMenu(JFrame mainMenu){
		//to select type of match input
		this.setLayout(new CardLayout());
		JPanel comboPane = new JPanel();
		String [] comboBoxItems = {SINGLES, DOUBLES};
		JComboBox<String> typeOfMatch = new JComboBox<>(comboBoxItems);
		typeOfMatch.setEditable(false);
		typeOfMatch.addItemListener(this);
		comboPane.add(typeOfMatch);
		
		//GUI for singles
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
		
		//GUI for doubles
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
		
		//Overall with all parts of GUI
		this.add(singles,SINGLES);
		this.add(doubles,DOUBLES);
	
        mainMenu.add(comboPane, BorderLayout.PAGE_START);
        mainMenu.add(this, BorderLayout.CENTER);
	}
	

	public JTextField getSinglesTextField(int row, int column) {
		return singlesScores[row][column];
	}


	public JTextField getDoublesTextField(int row, int column) {
		return doublesScores[row][column];
	}


	public JComboBox<String> getChoosePlayerA() {
		return choosePlayerA;
	}


	public JComboBox<String> getChoosePlayerB() {
		return choosePlayerB;
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


//	public JButton getEnterSingles() {
//		return enterSingles;
//	}
//
//
//	public JButton getEnterDoubles() {
//		return enterDoubles;
//	}

	public void clearSinglesEntries(){
		for(int i = 0;i < singlesScores.length;i++){
			for(int j = 0;j < singlesScores[i].length;j++){
				singlesScores[i][j].setText("");
			}
		}
		
		choosePlayerA.setSelectedItem(null);
		choosePlayerB.setSelectedItem(null);
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
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		CardLayout cl = (CardLayout)(this.getLayout());
		cl.show(this, (String)e.getItem());
	}
	
	public static void main(String args[]){
		JFrame mainMenu = new JFrame();
		new MainMenu(mainMenu);
		mainMenu.pack();
		mainMenu.setLocationRelativeTo(null);
		mainMenu.setVisible(true);
	}
}
