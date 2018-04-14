package com.acdp.tp3gp1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewPrincipal extends JFrame{
 
    /**
	 * ViewPrincipal: Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPane;
    private JMenuItem menu1Item1, menu2Item1, menu3Item1;
    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3;
    private ViewEnregistrerEtud enregistrerEtudiant;
    //private InternalFrameDois frameDois;
 
    // Constructeur
    public ViewPrincipal(){
 
        super("Exemplo de JDesktopPane");
 
        int inset = 75;
 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                   screenSize.width  - inset*2,
                  screenSize.height - inset*2);
 
        desktopPane = new JDesktopPane();
        menu1Item1 = new JMenuItem("Etudiant");
        menu1Item1.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent evt){
 
                if(enregistrerEtudiant == null){
                    enregistrerEtudiant = new ViewEnregistrerEtud();
                    enregistrerEtudiant.setVisible(true);
                    desktopPane.add(enregistrerEtudiant);
                    enregistrerEtudiant.setPosition();
                }
                else if(!enregistrerEtudiant.isVisible()){
                    enregistrerEtudiant.setVisible(true);
                    desktopPane.add(enregistrerEtudiant);
                }
            }
        });
 
//        menuItem2 = new JMenuItem("InternalFrameDois");
//        menuItem2.addActionListener(new ActionListener(){
// 
//            public void actionPerformed(ActionEvent evt){
// 
//                if(frameDois == null){
//                    frameDois = new InternalFrameDois();
//                    frameDois.setVisible(true);
//                    desktopPane.add(frameDois);
//                }
//                else if(!frameDois.isVisible()){
//                    frameDois.setVisible(true);
//                    desktopPane.add(frameDois);
//                }
//            }
//        });
        
        menu3Item1 = new JMenuItem("Sortir");
        menu3Item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
 
        menuBar = new JMenuBar();
        menu1 = new JMenu("Enregistrer");
        menu2 = new JMenu("Outils");
        menu3 = new JMenu("Sortir");
 
        setContentPane(desktopPane);
 
        menu1.add(menu1Item1);
        //menu.add(menuItem2);
        menu3.add(menu3Item1);
 
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
 
        setJMenuBar(menuBar);
 
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public static void main(String args[]){
 
    	ViewPrincipal vp = new ViewPrincipal();
    }
 
}
