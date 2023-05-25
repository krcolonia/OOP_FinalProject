package finalProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class GUI extends JFrame {
	
	//  Strings used for GUI Titles/JLabels
	String defTitle = "Please choose an option from the menu to the left.",
		   view = "View Reservations",
		   make = "Make Reservation",
		   del = "Delete Reservation",
		   gen = "Generate Report";
	
	// Colors used for Program
	Color japaneseIndigo = new Color(0x27374D),
		  darkElectricBlue = new Color(0x526D82),
		  cadetBlue = new Color(0x9DB2BF),
		  azureWhite = new Color(0xDDE6ED);
	
	// Panels for every option
	JPanel menuPanel = new JPanel(),
		   defaultPanel = new JPanel(),
		   viewPanel = new JPanel(),
		   makePanel = new JPanel(),
		   delPanel = new JPanel(),
		   genPanel = new JPanel();
	
	// Output Area Components Declarations
	Border outputPadding = BorderFactory.createEmptyBorder(8,8,8,8); // Output Padding
	
	// View Output
	JTextPane viewOutput = new JTextPane();
	JScrollPane viewScroll = new JScrollPane(viewOutput);
	
	// Delete Output
	JTextPane delOutput = new JTextPane();
	JScrollPane delScroll = new JScrollPane(delOutput);
	
	// Generate Output
	JTextPane genOutput = new JTextPane();
	JScrollPane genScroll = new JScrollPane(genOutput);
	
	// JLabels used throughout the program
	JLabel appName = new JLabel("Restaurant Reservation System  | Colonia, Kurt Robin P. | 2BSIT-2"),
		   menuTitle = new JLabel("System Menu"),
		   defLabel = new JLabel(defTitle),
		   viewTitle = new JLabel(view),
		   makeTitle = new JLabel(make),
		   delTitle = new JLabel(del),
		   genTitle = new JLabel(gen);
	
	// Font styles used
	Font titleFont = new Font("Century Gothic", Font.BOLD, 20),
		 buttonFont = new Font("Century Gothic", Font.BOLD, 15),
		 outputFont = new Font("Consolas", Font.BOLD, 12),
		 generateFont = new Font("Consolas", Font.BOLD, 10);
	
	// Buttons used in GUI
	JButton viewRes = new JButton(view),
			makeRes = new JButton(make),
			delRes = new JButton(del),
			genRep = new JButton(gen),
			exit = new JButton("Exit"),
			delBtn = new JButton("Delete Reservation"),
			makeBtn = new JButton("Make Reservation");
	
	JLabel dateLabel = new JLabel("Reservation Date"),
		   timeLabel = new JLabel("Reservation Time"),
		   nameLabel = new JLabel("Name of Reservee"),
		   adultLabel = new JLabel("Number of Adults"),
		   childLabel = new JLabel("Number of Children");
	
	// Inputs used in GUI
	JTextField delInput = new JTextField(),
			   dateInput = new JTextField(),
			   timeInput  = new JTextField(),
			   nameInput = new JTextField(),
			   adultInput = new JTextField(),
			   childInput = new JTextField();
	
	public GUI() {
		// Main GUI Panel
		setSize(900, 435);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(japaneseIndigo);
		
		// App Name. Above Menu Panel and Input/Output Panel
		appName.setFont(titleFont);
		appName.setForeground(azureWhite);
		appName.setBounds(10, 5, 800, 25);
		add(appName);
		
		// Menu Panel
		menuPanel.setBounds(10, 35, 220, 350);
		menuPanel.setBackground(cadetBlue);
		menuPanel.setLayout(null);
		add(menuPanel);
		
		// Menu Panel Title
		menuTitle.setFont(titleFont);
		menuTitle.setForeground(japaneseIndigo);
		menuTitle.setBounds(45, 10, 200, 25);
		menuPanel.add(menuTitle);
		
		addPanels();
		addMenuButtons();
	}
	
	// Method used for setting the design and attributes of the Menu Buttons
	void setMenuButtons(JButton btn, int xPos, int yPos) {
		btn.setBounds(xPos,yPos,200,50);
		btn.setBackground(darkElectricBlue);
		btn.setForeground(azureWhite);
		btn.setFocusPainted(false);
		menuPanel.add(btn);
	}
	
	// Method used to set the design of the default panel used upon launch
	void setDefaultPanel(JPanel pnl, JLabel ttl) {
		pnl.setBounds(240, 35, 635, 350);
		pnl.setLayout(null);
		pnl.setBackground(cadetBlue);
		add(pnl);
		
		ttl.setBounds(65, 150, 600, 25);
		ttl.setFont(titleFont);
		ttl.setForeground(japaneseIndigo);
		pnl.add(ttl);
	}
	
	// Method used to set the design of each option panel
	void setOptionPanels(JPanel pnl, JLabel ttl) {
		pnl.setBounds(240, 35, 635, 350);
		pnl.setLayout(null);
		pnl.setBackground(cadetBlue);
		add(pnl);
		
		ttl.setBounds(10, 5, 300, 25);
		ttl.setFont(titleFont);
		ttl.setForeground(japaneseIndigo);
		pnl.add(ttl);
		
		pnl.setVisible(false);
	}
	
	// Used to set the Area where output table gets printed out
	void setOutputArea(JTextPane output) {
		output.setBackground(azureWhite);
		output.setBorder(outputPadding);
		output.setEditable(false);
	}
	
	// Used to set the TextField for the "Make Reservation" option
	void setTextField(JTextField textField, int yPos) {
		textField.setBounds(10, yPos, 180, 35);
		textField.setBackground(azureWhite);
		textField.setForeground(japaneseIndigo);
		textField.setFont(buttonFont);
		
		makePanel.add(textField);
	}
	
	// Used to set the TextLabel for the "Make Reservation" option
	void setTextLabel(JLabel label, int yPos) {
		label.setBounds(200, yPos, 150, 35);
		label.setBackground(azureWhite);
		label.setForeground(japaneseIndigo);
		label.setFont(buttonFont);
		
		makePanel.add(label);
	}
	
	// Used to switch the option panels based on what is clicked in the Menu Buttons
	void panelSwitch(String panel) {
		defaultPanel.setVisible(false);
		switch(panel) {
			case "view":
				viewPanel.setVisible(true);
				makePanel.setVisible(false);
				delPanel.setVisible(false);
				genPanel.setVisible(false);
				break;
			case "make":
				viewPanel.setVisible(false);
				makePanel.setVisible(true);
				delPanel.setVisible(false);
				genPanel.setVisible(false);
				break;
			case "del":
				viewPanel.setVisible(false);
				makePanel.setVisible(false);
				delPanel.setVisible(true);
				genPanel.setVisible(false);
				break;
			case "gen":
				viewPanel.setVisible(false);
				makePanel.setVisible(false);
				delPanel.setVisible(false);
				genPanel.setVisible(true);
				break;
		}
	}
	
	// Used to add the Menu Buttons to the main GUI Frame
	void addMenuButtons() {
		// View Reservation Button
		viewRes.setFont(buttonFont);
		viewRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSwitch("view");
				viewOutput.setFont(outputFont);
				viewOutput.setText(Menu.viewRes());
			}
		});
		setMenuButtons(viewRes, 10, 50);
		
		// Make Reservation Button
		makeRes.setFont(buttonFont);
		makeRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSwitch("make");
			}
		});
		setMenuButtons(makeRes, 10, 110);
		
		makeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = InputFormat.inputDate(dateInput.getText());
				String time = InputFormat.inputTime(timeInput.getText());
				String name = InputFormat.inputString(nameInput.getText());
				Integer numAdult = InputFormat.inputInt(adultInput.getText(), "Adult");
				Integer numChild = InputFormat.inputInt(childInput.getText(), "Child");
				
				if(date != null && 
				   time != null &&
				   name != null &&
				   numAdult != null &&
				   numChild != null) {
					Menu.makeRes(date, time, name, numAdult, numChild);
					clearResInputs();
					JOptionPane.showMessageDialog(null, "Reservation added Succesfully", "TASK: Make Reservation", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		// Delete Reservation Button
		delRes.setFont(buttonFont);
		delRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSwitch("del");
				delOutput.setFont(outputFont);
				delOutput.setText(Menu.delResView());
				
				if(Menu.delEmpty()) {
					delInput.setEnabled(false);
					delBtn.setEnabled(false);
				}
				else {
					delInput.setEnabled(true);
					delBtn.setEnabled(true);
				}
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer resToDel = (InputFormat.inputInt(delInput.getText(), "Delete"))-1;
				if(resToDel != null && resToDel < Menu.getResSize()) {
					Menu.delRes(resToDel);
					delOutput.setText(Menu.delResView());
					delInput.setText(null);
					JOptionPane.showMessageDialog(null, "Reservation removed Succesfully", "TASK: Delete Reservation", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please only enter from numbers 1 - " + Menu.getResSize(), "ERROR: Invalid Delete Input", JOptionPane.ERROR_MESSAGE);
				}
				
				if(Menu.delEmpty()) {
					delInput.setEnabled(false);
					delBtn.setEnabled(false);
				}
			}
		});
		
		setMenuButtons(delRes, 10, 170);
		
		// Generate Report Button
		genRep.setFont(buttonFont);
		genRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				panelSwitch("gen");
				genOutput.setFont(generateFont);
				genOutput.setText(Menu.genRep());
			}
		});
		setMenuButtons(genRep, 10, 230);
		
		// Exit Button
		exit.setFont(buttonFont);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				exitFrame();
			}
		});
		setMenuButtons(exit, 10, 290);
	}

	// Used to clear inputs after adding a new reservation
	void clearResInputs() {
		dateInput.setText(null);
		timeInput.setText(null);
		nameInput.setText(null);
		adultInput.setText(null);
		childInput.setText(null);
	}
	
	// Used to add the Options Panels to the main GUI Frame
	void addPanels() {
		// Default Panel when program is launched
		setDefaultPanel(defaultPanel, defLabel);
		
		// View Reservation Panel
		setOptionPanels(viewPanel, viewTitle);
		viewScroll.setBounds(10, 35, 615, 305);
		setOutputArea(viewOutput);
		viewPanel.add(viewScroll);
		
		// Make Reservation Panel
		setOptionPanels(makePanel, makeTitle);
		setTextField(dateInput, 60);
		setTextLabel(dateLabel, 60);
		setTextField(timeInput, 110);
		setTextLabel(timeLabel, 110);
		setTextField(nameInput, 160);
		setTextLabel(nameLabel, 160);
		setTextField(adultInput, 210);
		setTextLabel(adultLabel, 210);
		setTextField(childInput, 260);
		setTextLabel(childLabel, 260);
		
		makeBtn.setBounds(400, 160, 200, 35);
		makeBtn.setBackground(darkElectricBlue);
		makeBtn.setForeground(azureWhite);
		makeBtn.setFont(buttonFont);
		makeBtn.setFocusPainted(false);
		makePanel.add(makeBtn);
		
		// Delete Reservation Panel
		setOptionPanels(delPanel, delTitle);
		setOutputArea(delOutput);
		delPanel.add(delScroll);
				
		delScroll.setBounds(10, 35, 615, 265);
		delInput.setBounds(10, 310, 45, 30);
		delInput.setFont(buttonFont);
		delInput.setBorder(outputPadding);
				
		delBtn.setBounds(65, 310, 560, 30);
		delBtn.setFont(buttonFont);
		delBtn.setBackground(darkElectricBlue);
		delBtn.setForeground(azureWhite);
		delBtn.setFocusPainted(false);
				
		delPanel.add(delInput);
		delPanel.add(delBtn);
				
		// Generate Report Panel
		setOptionPanels(genPanel, genTitle);
		genScroll.setBounds(10, 35, 615, 305);
		setOutputArea(genOutput);
		genPanel.add(genScroll);
	}

	// Method used when exiting software
	void exitFrame() {
		
		JFrame exitWindow = new JFrame();
		
		exitWindow.setTitle("Exiting Program...");
		exitWindow.setSize(500,240);
		exitWindow.setResizable(false);
		exitWindow.setUndecorated(true);
		exitWindow.setLocationRelativeTo(null); // Sets frame position to center of screen upon launch
		exitWindow.getContentPane().setBackground(darkElectricBlue);
		exitWindow.setLayout(null);
		exitWindow.setVisible(true);
		
		JPanel exitPanel = new JPanel();
		
		exitPanel.setBounds(10,10,480,220);
		exitPanel.setBackground(japaneseIndigo);
		exitPanel.setLayout(null);
		exitWindow.add(exitPanel);
		
		JLabel exitTitle = new JLabel();
		
		exitTitle.setText("Thank You!");
		exitTitle.setFont(new Font("Century Gothic", Font.BOLD, 30));
		exitTitle.setForeground(azureWhite);
		exitTitle.setBounds(160, 40, 500, 35);
		exitPanel.add(exitTitle);
		
		JLabel exitCredits = new JLabel();
		
		exitCredits.setText("Exiting Program. Developed by Kurt Robin Colonia");
		exitCredits.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		exitCredits.setForeground(azureWhite);
		exitCredits.setBounds(20, 110, 500, 25);
		exitPanel.add(exitCredits);
		
		JLabel exitSection = new JLabel();
		
		exitSection.setText("2BSIT-2, A.Y. 2022-2023");
		exitSection.setFont(new Font("Century Gothic", Font.ITALIC, 12));
		exitSection.setForeground(azureWhite);
		exitSection.setBounds(170, 160, 500, 20);
		exitPanel.add(exitSection);
		
		Timer t = new Timer(4000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		
		t.start();
	}
	
}
