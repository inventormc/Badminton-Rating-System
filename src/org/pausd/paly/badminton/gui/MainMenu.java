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

/**
 * 
 * @author michaelchau
 * The MainMenu panel that user interacts with. Switches in correct JPanel
 * when user needs to enter a score (either doubles or singles match)
 */
public class MainMenu extends JPanel implements ItemListener{

	final static String SINGLES = "Singles";//used to identify singles gui
	final static String DOUBLES = "Doubles";//used to identify doubles gui
	private SinglesPanel singles;//gui jpanel for singles scores input
	private DoublesPanel doubles;//gui jpanel for doubles scores input
	//private JButton enterSingles, enterDoubles;
	
	/**
	 * 
	 * @param mainMenu- JFrame to add this panel to
	 * Add all necessary panels to this MainMenu panel.
	 */
	public MainMenu(JFrame mainMenu){
		//to select type of match input
		this.setLayout(new CardLayout());
		JPanel comboPane = new JPanel();
		String [] comboBoxItems = {SINGLES, DOUBLES};
		JComboBox<String> typeOfMatch = new JComboBox<>(comboBoxItems);//switch panels (SinglesPanel, DoublesPanel) based on this value
		typeOfMatch.setEditable(false);
		typeOfMatch.addItemListener(this);
		comboPane.add(typeOfMatch);
		
		//initialize
		singles = new SinglesPanel();
		doubles = new DoublesPanel();
		this.add(singles,SINGLES);//identify singles panel by name
		this.add(doubles,DOUBLES);//identify doubles panel by name
	
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
	/**
	 * Get player names from database and add these to
	 * comboboxes so they can be selected when inputting
	 * match scores
	 */
	public void populatePlayerLists(){
		ArrayList<String> ids = SqlHelper.getAllIds();
		for(int i = 0;i < ids.size();i++){//loop through all ids
			String name = SqlHelper.get("firstName", "players", "id = " + ids.get(i)).trim() + " "
							+ SqlHelper.get("lastname", "players" , "id = " + ids.get(i)).trim();
			String element = ids.get(i).trim() + "-" + name;//combine name and id
			singles.getChoosePlayerA().addItem(element);//add to all comboboxes
			singles.getChoosePlayerB().addItem(element);
			doubles.getA1().addItem(element);
			doubles.getA2().addItem(element);
			doubles.getB1().addItem(element);
			doubles.getB2().addItem(element);
		}
	}
	
	/**
	 * switch panels when combobox value is changed
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		CardLayout cl = (CardLayout)(this.getLayout());
		cl.show(this, (String)e.getItem());
	}

	public static void main(String args[]){
		JFrame mainMenu = new JFrame();//jframe to add mainmenu panel to
		new MainMenu(mainMenu);
		mainMenu.pack();
		mainMenu.setLocationRelativeTo(null);//center panel
		mainMenu.setVisible(true);
	}
}
