package com.acdp.tp3gp1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class EtudiantTableModel extends AbstractTableModel{
	

	private List<Etudiant> data = new ArrayList<>();
	private String[] cols = {"Prenom", "Nom", "Note 1", "Note 2", "Note 3", "Moyenne", "Status"};
	
	@Override
	public String getColumnName(int column) {
		return cols[column];
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return data.get(rowIndex).getPrenom();
			case 1:
				return data.get(rowIndex).getNom();
			case 2:
				return data.get(rowIndex).getNote1();
			case 3:
				return data.get(rowIndex).getNote2();
			case 4:
				return data.get(rowIndex).getNote3();
			case 5:
				return data.get(rowIndex).getMoyenne();
			case 6:
				return data.get(rowIndex).getStatus();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				data.get(rowIndex).setPrenom((String) aValue);
				break;
			case 1:
				data.get(rowIndex).setNom((String) aValue);
				break;
			case 2:
				data.get(rowIndex).setNote1(Integer.parseInt((String) aValue));
				break;
			case 3:
				data.get(rowIndex).setNote2(Integer.parseInt((String) aValue));
				break;
			case 4:
				data.get(rowIndex).setNote3(Integer.parseInt((String) aValue));
				break;
			case 5:
				data.get(rowIndex).setMoyenne(Integer.parseInt((String) aValue));
				break;
			case 6:
				data.get(rowIndex).setStatus((String) aValue);
				break;
		}
		this.fireTableRowsUpdated(rowIndex, rowIndex);
	}
	
	public void addRow(Etudiant etud) {
		this.data.add(etud);
		this.fireTableDataChanged();
	}
	
	public void removeRow(int row) {
		this.data.remove(row);
		this.fireTableRowsDeleted(row, row);
	}
	
}
