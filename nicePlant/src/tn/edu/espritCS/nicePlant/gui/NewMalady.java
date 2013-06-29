package tn.edu.espritCS.nicePlant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.espritCS.nicePlant.dao.FarmerDao;
import tn.edu.espritCS.nicePlant.dao.MaladyDao;
import tn.edu.espritCS.nicePlant.domain.Farmer;
import tn.edu.espritCS.nicePlant.domain.Malady;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class NewMalady extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField tige;
	private JTextField feuille;
	private JTextField fleur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMalady frame = new NewMalady();
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
	public NewMalady() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(110, 26, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNameMalady = new JLabel("Name Malady");
		lblNameMalady.setBounds(10, 29, 90, 14);
		contentPane.add(lblNameMalady);
		
		tige = new JTextField();
		tige.setBounds(110, 51, 86, 20);
		contentPane.add(tige);
		tige.setColumns(10);
		
		JLabel lblColorOfTige = new JLabel("Color Tige");
		lblColorOfTige.setBounds(10, 54, 72, 14);
		contentPane.add(lblColorOfTige);
		
		JLabel lblDescriptionFeuille = new JLabel("Description feuille");
		lblDescriptionFeuille.setBounds(10, 79, 84, 14);
		contentPane.add(lblDescriptionFeuille);
		
		feuille = new JTextField();
		feuille.setBounds(110, 76, 86, 20);
		contentPane.add(feuille);
		feuille.setColumns(10);
		
		JLabel lblDescriptionOfFleur = new JLabel("Description flower");
		lblDescriptionOfFleur.setBounds(10, 105, 90, 14);
		contentPane.add(lblDescriptionOfFleur);
		
		fleur = new JTextField();
		fleur.setBounds(110, 102, 86, 20);
		contentPane.add(fleur);
		fleur.setColumns(10);
		final JTextArea solution = new JTextArea();
		solution.setBounds(10, 152, 248, 42);
		contentPane.add(solution);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Malady malady=new Malady(name.getText(),tige.getText(),feuille.getText(),fleur.getText(),solution.getText());
				MaladyDao maladyDao=new MaladyDao();
				maladyDao.addMalady(malady);
				AdminInterface adminInterface=new AdminInterface();
				adminInterface.setVisible(true);
			}
		});
		btnAdd.setBounds(43, 204, 89, 23);
		contentPane.add(btnAdd);
		
		
		
		JLabel lblSolution = new JLabel("Solution");
		lblSolution.setBounds(10, 127, 46, 14);
		contentPane.add(lblSolution);
	}
}
