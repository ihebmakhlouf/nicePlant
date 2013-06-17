package tn.edu.espritCS.nicePlant.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class AdminInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");

					AdminInterface frame = new AdminInterface();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 21);
		contentPane.add(menuBar);

		JMenu mnPlant = new JMenu("Plant");
		menuBar.add(mnPlant);

		JMenuItem mntmNewPlant = new JMenuItem("New Plant");
		mntmNewPlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPlant addPlant = new AddPlant();
				addPlant.setVisible(true);
			}
		});
		mnPlant.add(mntmNewPlant);

		JMenuItem mntmListPlant = new JMenuItem("List Plant");
		mntmListPlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlant listPlant = new ListPlant();
				listPlant.setVisible(true);
			
			}
		});
		mnPlant.add(mntmListPlant);

		JList list = new JList();
		mnPlant.add(list);

		JMenu mnFarmer = new JMenu("Farmer");
		menuBar.add(mnFarmer);
		
		JMenuItem mntmNewFarmer = new JMenuItem("New Farmer");
		mntmNewFarmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPlant addPlant=new AddPlant();
				addPlant.setVisible(true);
			}
		});
		mnFarmer.add(mntmNewFarmer);
		
		JMenuItem mntmListFarmer = new JMenuItem("List Farmer");
		mnFarmer.add(mntmListFarmer);

		JMenu mnMalday = new JMenu("Malday");
		menuBar.add(mnMalday);

		JMenu mnEvent = new JMenu("Event");
		menuBar.add(mnEvent);
	}
}
