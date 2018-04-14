package com.acdp.tp3gp1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;


public class ViewEnregistrerEtudiant extends JInternalFrame {  
 
    /**
	 * ViewEnregistrerEtudiant: Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Etudiant> arrEtudiant = new ArrayList<Etudiant>();
	JLabel lblPrenom, lblNom, lblNote1, lblNote2, lblNote3, lblMoyenne, lblStatus;
	JTextField txtPrenom, txtNom, txtNote1, txtNote2, txtNote3, txtMoyenne, txtStatus;
	JButton btnSauver, btnEffacer;
	JTable table;
	DefaultTableModel dtm;
	
	EtudiantTableModel tableModel = new EtudiantTableModel();
	
	// Constructeur
	public ViewEnregistrerEtudiant() {
        super("Enregistrer: Etudiant",
              true, //resizable
               true, //closable
              true, //maximizable
               true);//iconifiable  
        
		//setSize(largura,altura);
		setSize(600,400);    
 
//        JPanel panel = new JPanel();
//         panel.setBackground(Color.GRAY);  
// 
//         Container container = getContentPane();
//         container.add(panel);
         
		lblPrenom = new JLabel("Prenom");
		lblNom = new JLabel("Nom");
		lblNote1 = new JLabel("Note 1");
		lblNote2 = new JLabel("Note 2");
		lblNote3 = new JLabel("Note 3");
		lblMoyenne = new JLabel("Moyenne");
		lblStatus = new JLabel("Status");
		txtPrenom = new JTextField();
		txtNom = new JTextField();
		txtNote1 = new JTextField();
		txtNote2 = new JTextField();
		txtNote3 = new JTextField();
		txtMoyenne = new JTextField();
		txtStatus = new JTextField();
		//table = new JTable();

		//setTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 143, 564, 123);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		
		btnSauver = new JButton("Sauver");
		btnSauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String prenom = txtPrenom.getText();
				String nom = txtNom.getText();
				DefaultTableModel dt = (DefaultTableModel) table.getModel();
				
				Etudiant etud = new Etudiant();
				etud.setId(1);
				etud.setPrenom(prenom);
				etud.setNom(nom);
				ajouterEtudiant(etud);
				//ajouterEtudiant(new Etudiant());
				
				dt.addRow(new String[] {prenom, nom});
				txtPrenom.setText("");
				txtNom.setText("");
				txtPrenom.requestFocus();
				try {
					PrintWriter fichier = new PrintWriter("teste.txt");
					fichier.println(listerEtudiant());
					fichier.close();
					JOptionPane.showMessageDialog(null, "Arquivo salvo");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "O arquivo não foi salvo" + e.getMessage());
					//e.printStackTrace();
				}
			}
		});
		btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == btnEffacer) {
					txtPrenom.setText("");
					txtNom.setText("");
					txtNote1.setText("");
					txtNote2.setText("");
					txtNote3.setText("");
					txtMoyenne.setText("");
					txtStatus.setText("");
				}
			}
		});
		
		setLayout(null);
		// setBounds(x,y,largura,altura);
		// lbl = txt + 5 em x
		lblPrenom.setBounds(15, 10, 60, 20);
		lblNom.setBounds(125, 10, 50, 20);
		lblNote1.setBounds(235, 10, 50, 20);
		lblNote2.setBounds(295, 10, 50, 20);
		lblNote3.setBounds(355, 10, 50, 20);
		lblMoyenne.setBounds(415, 10, 50, 20);
		lblStatus.setBounds(475, 10, 50, 20);
		
		txtPrenom.setBounds(10, 30, 100, 20);
		txtNom.setBounds(120, 30, 100, 20);
		txtNote1.setBounds(230, 30, 50, 20);
		txtNote2.setBounds(290, 30, 50, 20);
		txtNote3.setBounds(350, 30, 50, 20);
		txtMoyenne.setBounds(410, 30, 50, 20);
		txtStatus.setBounds(470, 30, 100, 20);
		
		btnSauver.setBounds(425, 70, 60, 20);
		btnEffacer.setBounds(505, 70, 60, 20);
		
		table.setBounds(15, 110, 550, 200);
		
		add(lblPrenom);
		add(lblNom);
		add(lblNote1);
		add(lblNote2);
		add(lblNote3);
		add(lblMoyenne);
		add(lblStatus);
		
		add(txtPrenom);
		add(txtNom);
		add(txtNote1);
		add(txtNote2);
		add(txtNote3);
		add(txtMoyenne);
		add(txtStatus);
		
		add(btnSauver);
		add(	btnEffacer);
		
		add(table);
     }
	

	public String lireFichier() {
		File fichier = new File("teste.txt");
		String contenu = "";
		try {
			FileReader lire = new FileReader(fichier);
			BufferedReader br = new BufferedReader(lire);
			String ligne = br.readLine();
			
			while (ligne != null) {
				contenu += ligne + "\n";
				ligne = br.readLine();
			}
			lire.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenu;
	}
	
	public void setTable() {
		String[] rows = {"ID", "Prenom", "Nom", "Note 1", "Note 2", "Note 3", "Moyenne", "Status"};
		//String[][] cols= {{}};
		String input = lireFichier();
		String[] str1 = input.split("\n");
		String[][] cols = new String[str1.length][];
		for (int i = 0; i < cols.length; i++) {
		    String[] str2 = str1[i].split(",");
		    cols[i] = new String[str2.length];
		    for (int j = 0; j < cols[i].length; j++) {
		    	cols[i][j] = (str2[j]);
		    }
		}
		
		
		System.out.println(cols.toString());
		
		table = new JTable();
		dtm = new DefaultTableModel(cols, rows);
		table.setModel(dtm);
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(table);
		add(jsp);
		setVisible(true);
		setLayout(new FlowLayout());
	}
	
	public void setPosition() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}
	
	public void ajouterEtudiant(Etudiant etudiant) {
		this.arrEtudiant.add(etudiant);
	}
	
	public void supprimerEtudiant(Etudiant etudiant) {
		this.arrEtudiant.remove(etudiant);
	}
	
	public String listerEtudiant() {
		String listEtud = "";
		for (int i = 0; i < arrEtudiant.size(); i++) {
			Etudiant etudiant = arrEtudiant.get(i);
			listEtud += etudiant.getId() 
					+ " - " + etudiant.getPrenom() 
					+ " - " + etudiant.getNom()
					+ " - " + etudiant.getNote1()
					+ " - " + etudiant.getNote2()
					+ " - " + etudiant.getNote3()
					+ " - " + etudiant.getMoyenne()
					+ " - " + etudiant.getStatus()
					+ "\n";
		}
		return listEtud;
	}
	
 }
