package org.pausd.paly.badminton.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.pausd.paly.badminton.sql.SqlHelper;

public class MainMenu extends JPanel implements ItemListener{

	final static String SINGLES = "Singles";
	final static String DOUBLES = "Doubles";
	private SinglesPanel singles;
	private DoublesPanel doubles;
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
		
		//Overall with all parts of GUI
		singles = new SinglesPanel();
		doubles = new DoublesPanel();
		this.add(singles,SINGLES);
		this.add(doubles,DOUBLES);
	
        mainMenu.add(comboPane, BorderLayout.PAGE_START);
        mainMenu.add(this, BorderLayout.CENTER);
	}
//	public JButton getEnterSingles() {
//		return enterSingles;
//	}
//
//
//	public JButton getEnterDoubles() {
//		return enterDoubles;
//	}
	
	//NEED TO PUT THIS METHOD BEFORE SET VISIBLE
	public void populatePlayerLists(){
		ArrayList<String> ids = SqlHelper.getAllIds();
		for(int i = 0;i < ids.size();i++){
			String name = SqlHelper.get("firstName", "players", "id = " + ids.get(i)).trim() + " "
							+ SqlHelper.get("lastname", "players" , "id = " + ids.get(i)).trim();
			String element = ids.get(i).trim() + "-" + name;
			singles.getChoosePlayerA().addItem(element);
			singles.getChoosePlayerB().addItem(element);
			doubles.getA1().addItem(element);
			doubles.getA2().addItem(element);
			doubles.getB1().addItem(element);
			doubles.getB2().addItem(element);
		}
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
