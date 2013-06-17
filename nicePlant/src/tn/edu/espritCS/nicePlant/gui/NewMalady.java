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
		name.setBounds(110, 48, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNameMalady = new JLabel("Name Malady");
		lblNameMalady.setBounds(10, 51, 90, 14);
		contentPane.add(lblNameMalady);
		
		tige = new JTextField();
		tige.setBounds(110, 86, 86, 20);
		contentPane.add(tige);
		tige.setColumns(10);
		
		JLabel lblColorOfTige = new JLabel("Color Tige");
		lblColorOfTige.setBounds(10, 89, 72, 14);
		contentPane.add(lblColorOfTige);
		
		JLabel lblDescriptionFeuille = new JLabel("Description feuille");
		lblDescriptionFeuille.setBounds(10, 124, 84, 14);
		contentPane.add(lblDescriptionFeuille);
		
		feuille = new JTextField();
		feuille.setBounds(110, 121, 86, 20);
		contentPane.add(feuille);
		feuille.setColumns(10);
		
		JLabel lblDescriptionOfFleur = new JLabel("Description flower");
		lblDescriptionOfFleur.setBounds(10, 158, 90, 14);
		contentPane.add(lblDescriptionOfFleur);
		
		fleur = new JTextField();
		fleur.setBounds(110, 152, 86, 20);
		contentPane.add(fleur);
		fleur.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Malady malady=new Malady(name.getText(),tige.getText(),feuille.getText(),fleur.getText());
				MaladyDao maladyDao=new MaladyDao();
				maladyDao.addMalady(malady);
			}
		});
		btnAdd.setBounds(43, 204, 89, 23);
		contentPane.add(btnAdd);
	}
}
