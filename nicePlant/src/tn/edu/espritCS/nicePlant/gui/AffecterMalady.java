package tn.edu.espritCS.nicePlant.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.edu.espritCS.nicePlant.domain.Malady;
import tn.edu.espritCS.nicePlant.services.AffectMaladyService;
import tn.edu.espritCS.nicePlant.services.ListMaladyService;
import tn.edu.espritCS.nicePlant.services.RechercheNameService;

public class AffecterMalady extends JFrame {

	private JPanel contentPane;
	private ArrayList<Malady> arraylist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AffecterMalady frame = new AffecterMalady();
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
	public AffecterMalady() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel pname = new JLabel("");
		pname.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		pname.setForeground(new Color(0, 0, 255));
		pname.setBounds(67, 11, 115, 14);

		contentPane.add(pname);

		final JComboBox mala = new JComboBox();
		mala.setBounds(79, 53, 132, 20);
		contentPane.add(mala);

		JLabel lblMalady = new JLabel("malady");
		lblMalady.setBounds(10, 56, 46, 14);
		contentPane.add(lblMalady);
		pname.setText(ListPlant.pname);

		JButton btnAffect = new JButton("Affect");
		btnAffect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechercheNameService rechercheNameService = new RechercheNameService();
				String d = (String) mala.getSelectedItem();
				int id_malady = rechercheNameService.findMaladyByName(d);
				AffectMaladyService affectMaladyService = new AffectMaladyService();
				affectMaladyService.affectMalady(id_malady, ListPlant.dah);
				AdminInterface adminInterface=new AdminInterface();
				adminInterface.setVisible(true);
			}
		});
		btnAffect.setBounds(33, 135, 89, 23);
		contentPane.add(btnAffect);

		ListMaladyService listeMaladyService = new ListMaladyService();
		try {
			arraylist = listeMaladyService.liste();

			for (Malady malady : arraylist) {

				mala.addItem(malady.getName_mal());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
