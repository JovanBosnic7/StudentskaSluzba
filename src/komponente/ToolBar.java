package komponente;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class ToolBar extends JToolBar {
	private JButton dodavanje;
	private JButton izmena;
	private JButton brisanje;
	private JButton pretraga;
	private JTextField unos_pretrage;
	
	public ToolBar() {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setFloatable(false);
		dodavanje = new JButton();
		dodavanje.setToolTipText("Dodavanje studenta/profesora/predmeta");
		dodavanje.setIcon(new ImageIcon("slike/dodavanje.png"));

		add(dodavanje);

		addSeparator();

		izmena = new JButton();
		izmena.setToolTipText("Izmena studenta/profesora/predmeta");
		izmena.setIcon(new ImageIcon("slike/izmena.png"));
		add(izmena);

		addSeparator();

		brisanje = new JButton();
		brisanje.setToolTipText("Brisanje selektovanog entiteta");
		brisanje.setIcon(new ImageIcon("slike/brisanje.png"));
		add(brisanje);

		add(Box.createHorizontalStrut(350));
		
		unos_pretrage = new JTextField();
		unos_pretrage.setPreferredSize(new Dimension(250, 30));
		add(unos_pretrage);
		
		addSeparator();

		pretraga = new JButton();
		pretraga.setToolTipText("Pretrazite studente/profesore/predmete");
		pretraga.setIcon(new ImageIcon("slike/pretraga.png"));
		add(pretraga);
	}
}
