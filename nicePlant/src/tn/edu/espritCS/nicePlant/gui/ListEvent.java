package tn.edu.espritCS.nicePlant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tn.edu.espritCS.nicePlant.dao.EventDao;
import tn.edu.espritCS.nicePlant.dao.PlantDao;
import tn.edu.espritCS.nicePlant.domain.Event;
import tn.edu.espritCS.nicePlant.domain.Plant;
import tn.edu.espritCS.nicePlant.services.ListEventService;
import tn.edu.espritCS.nicePlant.services.ListePlantService;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListEvent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Event> arraylist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEvent frame = new ListEvent();
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
	public ListEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePlant();
			}
		});
		btnRemove.setBounds(213, 113, 89, 23);
		contentPane.add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 30, 325, 59);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"id", "Event Name"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		liste_event() ;
	}
	void liste_event() {
		ListEventService listEventService = new ListEventService();
		try {
			arraylist = listEventService.liste();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while (model.getRowCount() > 0)
				model.removeRow(0);
			int numcols = model.getColumnCount();
			for (Event event : arraylist) {
				Object[] file = new Object[numcols];

				file[0] = event;
				file[1] = event.getName_evt();
				
			
				model.addRow(file);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		void deletePlant() {
			int message = JOptionPane.showConfirmDialog(null, "You are Sure ?",
					"Remove", JOptionPane.YES_NO_CANCEL_OPTION);
			if (message == JOptionPane.YES_OPTION) {
				Event event = (Event) table.getValueAt(table.getSelectedRow(),
						0);
				EventDao eventDao = new EventDao();
				eventDao.deleteEvent(event.getId_evt());
				liste_event();
				
			}

	}
}
