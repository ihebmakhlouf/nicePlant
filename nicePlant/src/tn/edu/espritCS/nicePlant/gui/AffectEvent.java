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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tn.edu.espritCS.nicePlant.domain.Event;
import tn.edu.espritCS.nicePlant.services.AffectEventService;
import tn.edu.espritCS.nicePlant.services.FindEventByName;
import tn.edu.espritCS.nicePlant.services.ListEventService;

public class AffectEvent extends JFrame {

	private JPanel contentPane;
	private JTextField period;
	private ArrayList<Event> arraylist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffectEvent frame = new AffectEvent();
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
	public AffectEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel name = new JLabel((String) null);
		name.setForeground(Color.BLUE);
		name.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		name.setBounds(80, 11, 115, 14);
		contentPane.add(name);
		name.setText(ListPlant.pname);
		final JComboBox evt = new JComboBox();
		evt.setBounds(80, 64, 123, 20);
		contentPane.add(evt);

		period = new JTextField();
		period.setBounds(80, 109, 123, 20);
		contentPane.add(period);
		period.setColumns(10);

		JButton btnAffect = new JButton("Affect");
		btnAffect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindEventByName findNameService = new FindEventByName();
				String d = (String) evt.getSelectedItem();
				int id_event = findNameService.findEventByName(d);
				AffectEventService affectEventService = new AffectEventService();
				affectEventService.affectEvent(id_event, ListPlant.dah,
						period.getText());
				AdminInterface adminInterface=new AdminInterface();
				adminInterface.setVisible(true);
			}
		});
		btnAffect.setBounds(10, 181, 89, 23);
		contentPane.add(btnAffect);

		JLabel lblPeriod = new JLabel("period");
		lblPeriod.setBounds(10, 112, 46, 14);
		contentPane.add(lblPeriod);
		ListEventService listeEventService = new ListEventService();
		try {
			arraylist = listeEventService.liste();

			for (Event event : arraylist) {

				evt.addItem(event.getName_evt());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
