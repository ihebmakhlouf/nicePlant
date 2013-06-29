package tn.edu.espritCS.nicePlant.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tn.edu.espritCS.nicePlant.dao.FarmerDao;
import tn.edu.espritCS.nicePlant.domain.Farmer;
import tn.edu.espritCS.nicePlant.domain.Plant;
import tn.edu.espritCS.nicePlant.services.ListFarmerService;
import javax.swing.JScrollPane;

public class ListFarmer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Farmer> arraylist;
	public static int dah;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFarmer frame = new ListFarmer();
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
	public ListFarmer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 22, 316, 112);
		contentPane.add(scrollPane);
		
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(new DefaultTableModel(new Object[][] { { null, null,
						null, null, null }, }, new String[] { "id_farmer",
						"first name", "last name", "login", "mail" }));
				table.getColumnModel().getColumn(0).setMinWidth(0);
				table.getColumnModel().getColumn(0).setMaxWidth(0);
				table.getColumnModel().getColumn(0).setWidth(0);
		liste_farmer();
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Farmer farmer = (Farmer) table.getValueAt(table.getSelectedRow(),
						0);
				dah=farmer.getId_farmer();
		   ModifyFarmer modifyfarmer=new ModifyFarmer();
		   modifyfarmer.setVisible(true);
			}
		});
		btnModify.setBounds(35, 184, 89, 23);
		contentPane.add(btnModify);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int message = JOptionPane.showConfirmDialog(null,
						"You are Sure ?", "Remove",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (message == JOptionPane.YES_OPTION) {
					Farmer farmer = (Farmer) table.getValueAt(
							table.getSelectedRow(), 0);
					FarmerDao farmerDao = new FarmerDao();
					farmerDao.deleteFarmer(farmer.getId_farmer());

					liste_farmer();
				}
			}
		});
		btnRemove.setBounds(183, 184, 89, 23);
		contentPane.add(btnRemove);
		
	
	}

	void liste_farmer() {
		ListFarmerService listeFarmerService = new ListFarmerService();
		try {
			arraylist = listeFarmerService.liste();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while (model.getRowCount() > 0)
				model.removeRow(0);
			int numcols = model.getColumnCount();
			for (Farmer farmer : arraylist) {
				Object[] file = new Object[numcols];

				file[0] = farmer;
				file[1] = farmer.getFirstName();
				file[2] = farmer.getLastName();
				file[3] = farmer.getLogin();
				file[4] = farmer.getMail();
                
				model.addRow(file);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
