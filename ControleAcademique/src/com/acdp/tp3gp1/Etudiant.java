package com.acdp.tp3gp1;

import java.util.ArrayList;

public class Etudiant {
	private int id;
	private String prenom;
	private String nom;
	private int note1;
	private int note2;
	private int note3;
	private int moyenne;
	private String status;
	private static ArrayList<Etudiant> arrEtudiant = new ArrayList<>();
	
	// Constructeur
	public Etudiant(){
			
	}
	
	// Constructeur
	public Etudiant(String prenom, String nom, int note1, int note2, int note3, int moyenne, String status){
		setPrenom(prenom);
		setNom(nom);
		setNote1(note1);
		setNote2(note2);
		setNote3(note3);
		setMoyenne(moyenne);
		setStatus(status);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNote1() {
		return note1;
	}

	public void setNote1(int note1) {
		this.note1 = note1;
	}

	public int getNote2() {
		return note2;
	}

	public void setNote2(int note2) {
		this.note2 = note2;
	}

	public int getNote3() {
		return note3;
	}

	public void setNote3(int note3) {
		this.note3 = note3;
	}

	public int getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(int moyenne) {
		this.moyenne = moyenne;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static void ajouterEtudiant(Etudiant etudiant) {
		arrEtudiant.add(etudiant);
	}
	
	public static void supprimerEtudiant(Etudiant etudiant) {
		arrEtudiant.remove(etudiant);
	}
	
	public static String listerEtudiant() {
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
					+ " - " + etudiant.getStatus();
		}
		return listEtud;
	}
	
//	public static void main(String[] args) {
//		Etudiant etud1 = new Etudiant();
//		etud1.setId(1);
//		etud1.setPrenom("Andre");
//		etud1.setNom("Cruz");
//		
//		ajouterEtudiant(etud1);
//		
//		System.out.println(listerEtudiant());
//	}
}
