package tn.edu.espritCS.nicePlant.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tn.edu.espritCS.nicePlant.dao.PlantDao;
import tn.edu.espritCS.nicePlant.domain.Plant;

public class AddPlant extends JFrame {

	private JPanel contentPane;
	private JTextField nom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlant frame = new AddPlant();
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
	public AddPlant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPlantName = new JLabel("Plant Name");
		lblPlantName.setBounds(10, 30, 89, 14);
		contentPane.add(lblPlantName);

		JLabel lblSaison = new JLabel("Saison");
		lblSaison.setBounds(10, 55, 46, 14);
		contentPane.add(lblSaison);

		nom = new JTextField();
		nom.setBounds(88, 27, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);

		final JComboBox sai = new JComboBox();
		sai.setModel(new DefaultComboBoxModel(
				new String[] { "winter", "summer" }));
		sai.setBounds(88, 52, 86, 20);
		contentPane.add(sai);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) sai.getSelectedItem();
				Plant plant = new Plant(nom.getText(), s);
				PlantDao plantDao = new PlantDao();
				plantDao.addPlant(plant);
			}
		});
		btnAdd.setBounds(57, 116, 89, 23);
		contentPane.add(btnAdd);

	}
}
