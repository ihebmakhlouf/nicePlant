package tn.edu.espritCS.nicePlant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.espritCS.nicePlant.dao.MaladyDao;
import tn.edu.espritCS.nicePlant.domain.Farmer;
import tn.edu.espritCS.nicePlant.domain.Malady;
import tn.edu.espritCS.nicePlant.services.ListFarmerService;
import tn.edu.espritCS.nicePlant.services.ListMaladyService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyMalady extends JFrame {

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
					ModifyMalady frame = new ModifyMalady();
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
	public ModifyMalady() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaladyName = new JLabel("Malady Name");
		lblMaladyName.setBounds(10, 28, 86, 14);
		contentPane.add(lblMaladyName);
		
		name = new JTextField();
		name.setBounds(135, 25, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblColorTige = new JLabel("Color tige");
		lblColorTige.setBounds(10, 53, 46, 14);
		contentPane.add(lblColorTige);
		
		JLabel lblDescriptionFeuille = new JLabel("Description feuille");
		lblDescriptionFeuille.setBounds(10, 78, 97, 14);
		contentPane.add(lblDescriptionFeuille);
		
		JLabel lblDescriptionFlower = new JLabel("Description flower");
		lblDescriptionFlower.setBounds(10, 106, 97, 14);
		contentPane.add(lblDescriptionFlower);
		
		tige = new JTextField();
		tige.setBounds(135, 50, 86, 20);
		contentPane.add(tige);
		tige.setColumns(10);
		
		feuille = new JTextField();
		feuille.setBounds(135, 75, 86, 20);
		contentPane.add(feuille);
		feuille.setColumns(10);
		
		fleur = new JTextField();
		fleur.setBounds(135, 103, 86, 20);
		contentPane.add(fleur);
		fleur.setColumns(10);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListMaladyService listMaladyService=new ListMaladyService();
				Malady malady=listMaladyService.getRow(ListMalady.dah);
				malady.setName_mal(name.getText());
				  malady.setTige( tige.getText());
				  malady.setFeuille( feuille.getText());
				   malady.setFleur(fleur.getText());
				   MaladyDao maladyDao=new MaladyDao();
				   maladyDao.updateMalady(malady);
				   AdminInterface adminInterface=new AdminInterface();
					adminInterface.setVisible(true);
			}
		});
		btnModify.setBounds(10, 228, 89, 23);
		contentPane.add(btnModify);
		ListMaladyService listMaladyService=new ListMaladyService();
		Malady malady=listMaladyService.getRow(ListMalady.dah);
	   name.setText(malady.getName_mal());
	   tige.setText(malady.getTige());
	   feuille.setText(malady.getFeuille());
	   fleur.setText(malady.getFleur());
	   
	}

}
