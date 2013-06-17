package tn.edu.espritCS.nicePlant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import tn.edu.espritCS.nicePlant.dao.FarmerDao;
import tn.edu.espritCS.nicePlant.domain.Farmer;
import tn.edu.espritCS.nicePlant.domain.Plant;
import tn.edu.espritCS.nicePlant.services.ListFarmerService;
import tn.edu.espritCS.nicePlant.services.ListePlantService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyFarmer extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField last;
	private JTextField login;
	private JPasswordField pwd;
	private JTextField mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFarmer frame = new ModifyFarmer();
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
	public ModifyFarmer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setBounds(25, 46, 69, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setBounds(25, 71, 69, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("login");
		label_2.setBounds(25, 96, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setBounds(25, 121, 69, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Mail");
		label_4.setBounds(25, 146, 69, 14);
		contentPane.add(label_4);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(112, 43, 86, 20);
		contentPane.add(name);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(112, 68, 86, 20);
		contentPane.add(last);
		
		login = new JTextField();
		login.setColumns(10);
		login.setBounds(112, 93, 86, 20);
		contentPane.add(login);
		
		pwd = new JPasswordField();
		pwd.setBounds(112, 118, 86, 20);
		contentPane.add(pwd);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(112, 146, 86, 20);
		contentPane.add(mail);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Farmer farmer=new Farmer(name.getText(),last.getText(),login.getText(),pwd.getText(),mail.getText());
				FarmerDao farmerDao=new FarmerDao();
				farmerDao.updateFarmer(farmer);
			}
		});
		btnModify.setBounds(25, 191, 89, 23);
		contentPane.add(btnModify);
		ListFarmerService listefarmerService=new ListFarmerService();
		Farmer farmer=listefarmerService.getRow(ListFarmer.dah);
	   name.setText(farmer.getFirstName());
	   last.setText(farmer.getLastName());
	   login.setText(farmer.getLogin());
	   mail.setText(farmer.getMail());
	}

}
