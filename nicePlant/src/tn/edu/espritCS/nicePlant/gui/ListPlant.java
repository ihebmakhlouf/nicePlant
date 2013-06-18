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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tn.edu.espritCS.nicePlant.dao.PlantDao;
import tn.edu.espritCS.nicePlant.domain.Plant;
import tn.edu.espritCS.nicePlant.services.ListePlantService;

public class ListPlant extends JFrame {

	private JPanel contentPane;
	private ArrayList<Plant> arraylist;
	private JTable table_1;
	public static int dah;
	public static String pname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPlant frame = new ListPlant();
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
	public ListPlant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 180, 402, -149);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null }, }, new String[] { "objet", "id Plant",
				"Plant Name", "Saison" }));
		table_1.getColumnModel().getColumn(2).setPreferredWidth(90);

		table_1.setBounds(10, 42, 381, 128);
		contentPane.add(table_1);
		table_1.getColumnModel().getColumn(3).setMinWidth(0);
		table_1.getColumnModel().getColumn(3).setMaxWidth(0);
		table_1.getColumnModel().getColumn(3).setWidth(0);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deletePlant();

			}
		});
		btnDelete.setBounds(335, 180, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plant plant = (Plant) table_1.getValueAt(table_1.getSelectedRow(),
						3);
				
				dah=plant.getId_plant();
		   ModifyPlant modifyplant=new ModifyPlant();
		   modifyplant.setVisible(true);
				
			}
		});
		btnModify.setBounds(244, 180, 89, 23);
		contentPane.add(btnModify);
		
		JButton btnAffectMalady = new JButton("affect Malady");
		btnAffectMalady.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Plant plant = (Plant) table_1.getValueAt(table_1.getSelectedRow(),
						3);
				pname=plant.getName();
				dah=plant.getId_plant();
				AffecterMalady affecterMalady=new AffecterMalady();
				affecterMalady.setVisible(true);
				
			}
		});
		btnAffectMalady.setBounds(0, 180, 120, 23);
		contentPane.add(btnAffectMalady);
		
		JButton btnAffectEvent = new JButton("Affect Event");
		btnAffectEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plant plant = (Plant) table_1.getValueAt(table_1.getSelectedRow(),
						3);
				pname=plant.getName();
				dah=plant.getId_plant();
				AffectEvent affectEvent=new AffectEvent();
				affectEvent.setVisible(true);
			}
		});
		btnAffectEvent.setBounds(130, 180, 104, 23);
		contentPane.add(btnAffectEvent);
		liste_Plant();
	}

	void liste_Plant() {
		ListePlantService listePlantService = new ListePlantService();
		try {
			arraylist = listePlantService.liste();
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			while (model.getRowCount() > 0)
				model.removeRow(0);
			int numcols = model.getColumnCount();
			for (Plant plant : arraylist) {
				Object[] file = new Object[numcols];

				file[3] = plant;
				file[1] = plant.getName();
				file[2] = plant.getSaison();
				file[0] = plant.getId_plant();
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
			Plant plant = (Plant) table_1.getValueAt(table_1.getSelectedRow(),
					3);
			PlantDao plantDao = new PlantDao();
			plantDao.deletePlant(plant.getId_plant());
			liste_Plant();
			
		}

	}
}
