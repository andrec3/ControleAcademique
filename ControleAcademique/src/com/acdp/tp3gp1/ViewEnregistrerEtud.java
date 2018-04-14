package com.acdp.tp3gp1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class ViewEnregistrerEtud extends JInternalFrame{
	//Variaveis
	JTextField txtPrenom, txtNom, txtNote1, txtNote2, txtNote3, txtMoyenne, txtStatus;
	JLabel lblPrenom, lblNom, lblNote1, lblNote2, lblNote3, lblMoyenne, lblStatus;
	JButton btnCalculer, btnAjouter, btnExporterTxt, btnImporterTxt;
	JPanel panel;
	JTable table;
	Container pane;
	EtudiantTableModel tableModel;
	JScrollPane scrollPane;
	
	// Contructeur
	public ViewEnregistrerEtud() {
		
		// Criando o JInternalFrame
		setClosable(true);
		setIconifiable(true);
		setTitle("Enregistrer Etudiant");
		setSize(600, 400);
		getContentPane().setLayout(null);
		pane = getContentPane();
		Color myColor = new Color(153, 204, 255);
		pane.setBackground(myColor);
		
		// Tabela
		tableModel = new EtudiantTableModel();
		table = new JTable() {
			public boolean isCellEditable() {
				return false;
			}
		};
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 143, 564, 123);
		pane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		
		// JLabel Prenom
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(11, 6, 61, 16);
		pane.add(lblPrenom);
		
		// JTextField Prenom
		txtPrenom = new JTextField();
		txtPrenom.setBounds(6, 21, 100, 26);
		pane.add(txtPrenom);
		
		// JLabel Nom
		lblNom = new JLabel("Nom");
		lblNom.setBounds(118, 6, 61, 16);
		pane.add(lblNom);
		
		// JTextField Nom
		txtNom = new JTextField();
		txtNom.setBounds(113, 21, 100, 26);
		pane.add(txtNom);
		
		// JLabel Note1
		lblNote1 = new JLabel("Note 1");
		lblNote1.setBounds(225, 6, 61, 16);
		pane.add(lblNote1);
		
		// JTextField Note1
		txtNote1 = new JTextField();
		txtNote1.setBounds(220, 21, 50, 26);
		pane.add(txtNote1);
		
		// JLabel Note2
		lblNote2 = new JLabel("Note 2");
		lblNote2.setBounds(282, 6, 61, 16);
		pane.add(lblNote2);
		
		// JTextField Note2
		txtNote2 = new JTextField();
		txtNote2.setBounds(277, 21, 50, 26);
		pane.add(txtNote2);
		
		// JLabel Note3
		lblNote3 = new JLabel("Note 3");
		lblNote3.setBounds(339, 6, 61, 16);
		pane.add(lblNote3);
		
		// JTextField Note3
		txtNote3 = new JTextField();
		txtNote3.setBounds(334, 21, 50, 26);
		pane.add(txtNote3);
		
		// JLabel Moyenne
		lblMoyenne = new JLabel("Moyenne");
		lblMoyenne.setBounds(11, 55, 61, 16);
		pane.add(lblMoyenne);
		
		// JTextField Moyenne
		txtMoyenne = new JTextField();
		txtMoyenne.setEditable(false);
		txtMoyenne.setBounds(6, 70, 60, 26);
		pane.add(txtMoyenne);
		
		// JLabel Status
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(84, 55, 61, 16);
		pane.add(lblStatus);
		
		// JTextField Status
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setBounds(79, 70, 100, 26);
		pane.add(txtStatus);
		
		// Botão calcular média
		btnCalculer = new JButton("Calculer");
		btnCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n1 = Integer.parseInt(txtNote1.getText());
				int n2 = Integer.parseInt(txtNote2.getText());
				int n3 = Integer.parseInt(txtNote3.getText());
				int m = (n1 + n2 + n3)/3;
				
				txtMoyenne.setText(Integer.toString(m));
				if (m >= 6) {
					txtStatus.setText("Approuvé");
				} else {
					txtStatus.setText("Non Approuvé");
				}
			}
		});
		btnCalculer.setBounds(425, 23, 117, 65);
		pane.add(btnCalculer);
	
		// Botão para adicionar os dados na tabela
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Etudiant etud = new Etudiant();
				etud.setPrenom(txtPrenom.getText());
				etud.setNom(txtNom.getText());
				etud.setNote1(Integer.parseInt(txtNote1.getText()));
				etud.setNote2(Integer.parseInt(txtNote2.getText()));
				etud.setNote3(Integer.parseInt(txtNote3.getText()));
				etud.setMoyenne(Integer.parseInt(txtMoyenne.getText()));
				etud.setStatus(txtStatus.getText());
				
				tableModel.addRow(etud);
				nettoyerChamps();
				
			}
		});
		btnAjouter.setBounds(55, 100, 117, 29);
		getContentPane().add(btnAjouter);
		
		// Botão para exportar os dados da tabela para TXT
		btnExporterTxt = new JButton("Exporter TXT");
		btnExporterTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrintWriter pw;
				try {
					pw = new PrintWriter("Etudiants.txt");
		
					for (int i = 0; i < table.getRowCount(); i++) {
						pw.println(table.getValueAt(i, 0) + "\n" +
									table.getValueAt(i, 1) + "\n" +
									table.getValueAt(i, 2) + "\n" +
									table.getValueAt(i, 3) + "\n" +
									table.getValueAt(i, 4) + "\n" +
									table.getValueAt(i, 5) + "\n" +
									table.getValueAt(i, 6));
					}
					
					pw.close();
					
					JOptionPane.showMessageDialog(null, "Fichier enregistré");
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
				}
			}
		});
		btnExporterTxt.setBounds(6, 319, 117, 29);
		getContentPane().add(btnExporterTxt);
		
		// Botão para importar os dados d TXT para a tabela
		JButton btnImporterTxt = new JButton("Importer TXT");
		btnImporterTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileReader fichier;
					fichier = new FileReader("Etudiants.txt");
					Scanner lireInfo = new Scanner(fichier);
					
					while(lireInfo.hasNextLine()) {
						Etudiant etud = new Etudiant();

						etud.setPrenom(lireInfo.nextLine());
						etud.setNom(lireInfo.nextLine());
						etud.setNote1(Integer.valueOf(lireInfo.nextLine()));
						etud.setNote2(Integer.valueOf(lireInfo.nextLine()));
						etud.setNote3(Integer.valueOf(lireInfo.nextLine()));
						etud.setMoyenne(Integer.valueOf(lireInfo.nextLine()));
						etud.setStatus(lireInfo.nextLine());
						
						tableModel.addRow(etud);		
					}
				} catch (FileNotFoundException e1) {
					e1.getMessage();
				}
				
			}
		});
		btnImporterTxt.setBounds(135, 319, 117, 29);
		getContentPane().add(btnImporterTxt);
		
	}//Fin du constructeur
	
	// Metodo para centralizar o JInternalFrame - Chamado na ViewPrincipal
	public void setPosition() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}
	
	// Metodo para limpar os campos JTextField
	public void nettoyerChamps() {
		txtPrenom.setText("");
		txtNom.setText("");
		txtNote1.setText("");
		txtNote2.setText("");
		txtNote3.setText("");
		txtMoyenne.setText("");
		txtStatus.setText("");
		
		txtPrenom.requestFocus();
	}
}


