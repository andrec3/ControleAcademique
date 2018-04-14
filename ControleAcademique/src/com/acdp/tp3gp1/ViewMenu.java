package com.acdp.tp3gp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ViewMenu extends JFrame{

	JMenuBar barre = new JMenuBar();
	JMenu menu1 = new JMenu("Enregistrer");
	JMenu menu2 = new JMenu("Outils");
	JMenu menu3 = new JMenu("Sortir");
	
	JMenuItem element11 = new JMenuItem("Élève");
	JMenuItem element31 = new JMenuItem("Sortir");
	
	public ViewMenu() {
		setJMenuBar(barre);
		barre.add(menu1);
		barre.add(menu2);
		barre.add(menu3);
		
		menu1.add(element11);
		menu3.add(element31);
		
		element11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewEnregistrerEtudiant();
			}
		});
		
		element31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("Menu");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ViewMenu();
	}
}
