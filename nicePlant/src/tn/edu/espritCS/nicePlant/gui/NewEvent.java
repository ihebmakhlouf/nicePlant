package tn.edu.espritCS.nicePlant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.espritCS.nicePlant.dao.EventDao;
import tn.edu.espritCS.nicePlant.domain.Event;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewEvent extends JFrame {

	private JPanel contentPane;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEvent frame = new NewEvent();
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
	public NewEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(21, 46, 88, 14);
		contentPane.add(lblEventName);
		
		name = new JTextField();
		name.setBounds(119, 43, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event=new Event(name.getText());
				EventDao eventDao=new EventDao();
				eventDao.addEvent(event);
			}
		});
		btnAdd.setBounds(68, 104, 89, 23);
		contentPane.add(btnAdd);
	}

}
