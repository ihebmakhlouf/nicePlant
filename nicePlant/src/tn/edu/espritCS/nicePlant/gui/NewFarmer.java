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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewFarmer extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField login;
	private JTextField last;
	private JPasswordField pwd;
	private JTextField mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFarmer frame = new NewFarmer();
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
	public NewFarmer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(10, 50, 69, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(122, 47, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("login");
		lblNewLabel.setBounds(10, 112, 46, 14);
		contentPane.add(lblNewLabel);
		
		login = new JTextField();
		login.setBounds(122, 109, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 82, 69, 14);
		contentPane.add(lblLastName);
		
		last = new JTextField();
		last.setBounds(122, 78, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 143, 69, 14);
		contentPane.add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setBounds(122, 140, 86, 20);
		contentPane.add(pwd);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 175, 69, 14);
		contentPane.add(lblMail);
		
		mail = new JTextField();
		mail.setBounds(122, 172, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Farmer farmer=new Farmer(name.getText(),last.getText(),login.getText(),pwd.getText(),mail.getText());
				FarmerDao farmerDao=new FarmerDao();
				farmerDao.addFarmer(farmer);
				AdminInterface adminInterface=new AdminInterface();
				adminInterface.setVisible(true);
				
			}
		});
		btnAdd.setBounds(80, 214, 89, 23);
		contentPane.add(btnAdd);
	}
}
