package tn.edu.espritCS.nicePlant.gui;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tn.edu.espritCS.nicePlant.dao.FarmerDao;
import tn.edu.espritCS.nicePlant.dao.MaladyDao;
import tn.edu.espritCS.nicePlant.domain.Farmer;
import tn.edu.espritCS.nicePlant.domain.Malady;
import tn.edu.espritCS.nicePlant.services.ListFarmerService;
import tn.edu.espritCS.nicePlant.services.ListMaladyService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListMalady extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Malady> arraylist;
	public static int dah;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListMalady frame = new ListMalady();
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
	public ListMalady() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 330, 81);
		contentPane.add(scrollPane);
		
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null},
					},
					new String[] {
						"id", "Malady Name", "Tige", "feuille", "flower"
					}
				));
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
		liste_malady();
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int message = JOptionPane.showConfirmDialog(null,
						"You are Sure ?", "Remove",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (message == JOptionPane.YES_OPTION) {
					Malady malady = (Malady) table.getValueAt(
							table.getSelectedRow(), 0);
					MaladyDao MaladyDao = new MaladyDao();
					MaladyDao.deleteMalady(malady.getId_malady());

					liste_malady();
			}
				}
		});
		btnRemove.setBounds(210, 198, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnModfiy = new JButton("Modfiy");
		btnModfiy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Malady malady = (Malady) table.getValueAt(table.getSelectedRow(),
						0);
				dah=malady.getId_malady();
		   ModifyMalady modifyMalady=new ModifyMalady();
		   modifyMalady.setVisible(true);
			}
		});
		btnModfiy.setBounds(44, 198, 89, 23);
		contentPane.add(btnModfiy);
		
		
	}

	void liste_malady() {
		ListMaladyService listeMaladyService = new ListMaladyService();
		try {
			arraylist = listeMaladyService.liste();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while (model.getRowCount() > 0)
				model.removeRow(0);
			int numcols = model.getColumnCount();
			for (Malady malady : arraylist) {
				Object[] file = new Object[numcols];

				file[0] = malady;
				file[1] = malady.getName_mal();
				file[2] = malady.getTige();
				file[3] = malady.getFeuille();
				file[4] = malady.getFleur();

				model.addRow(file);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
