package tn.edu.espritCS.nicePlant.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import tn.edu.espritCS.nicePlant.services.LoginService;

public class First extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField password;

	LoginService loginService = new LoginService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					First frame = new First();
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
	public First() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(35, 40, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(35, 75, 46, 14);
		contentPane.add(lblNewLabel_1);

		login = new JTextField();
		login.setBounds(120, 37, 86, 20);
		contentPane.add(login);
		login.setColumns(10);

		password = new JTextField();
		password.setBounds(120, 69, 86, 20);
		contentPane.add(password);
		password.setColumns(10);

		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = loginService.login(login.getText(),
						password.getText());
				if (res == 1) {
					System.out.println("hana de5lna bel compte fele7 ..");
					

				}
				if (res == 2) {
					AdminInterface adminInterface = new AdminInterface();
					adminInterface.setVisible(true);
				
				}
			}
		});
		btnNewButton.setBounds(80, 138, 89, 23);
		contentPane.add(btnNewButton);
	}
}
