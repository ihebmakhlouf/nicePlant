package tn.edu.espritCS.nicePlant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import tn.edu.espritCS.nicePlant.domain.Plant;
import tn.edu.espritCS.nicePlant.services.ListePlantService;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ModifyPlant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPlant frame = new ModifyPlant();
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
	public ModifyPlant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Plant Name");
		lblNewLabel.setBounds(10, 31, 104, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(106, 33, 104, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSaison = new JLabel("Saison");
		lblSaison.setBounds(10, 81, 46, 14);
		contentPane.add(lblSaison);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		comboBox.setBounds(106, 68, 104, 27);
		contentPane.add(comboBox);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(83, 153, 89, 23);
		contentPane.add(btnModify);
		ListePlantService listePlantService=new ListePlantService();
		Plant plant=listePlantService.getRow(ListPlant.dah);
		textField.setText(plant.getName());
	
	}
}
