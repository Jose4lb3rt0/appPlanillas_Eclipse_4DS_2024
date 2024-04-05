package ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class pnlCargo extends JPanel {

	private static final long serialVersionUID = 1L;
	JTable tblRegistros;
	
	public pnlCargo() {
		
		
		setBounds(1, 1, 771, 666);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTION CARGOS");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(20, 10, 200, 30);
		lblTitulo.setForeground(Color.RED);
		this.add(lblTitulo);
		
		JPanel pnlPanel = new JPanel();
		pnlPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPanel.setBounds(1 ,50, 769, 614);
		pnlPanel.setLayout(null);
		this.add(pnlPanel);
		
		
		JPanel pnlRegistros = new JPanel();
		pnlRegistros.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlRegistros.setBounds(1, 1, 250, 612);
		pnlRegistros.setLayout(null);
		pnlPanel.add(pnlRegistros);
		
		tblRegistros = new JTable();
		tblRegistros.setBounds(2, 80, 246, 530);
		pnlRegistros.add(tblRegistros);
	}
}