package komponente;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import kontroler.BrisanjePredmetaListener;
import kontroler.DodavanjePredmetaListener;
import kontroler.DodavanjeProfesoraListener;
import kontroler.DodavanjeStudentaListener;
import kontroler.IzmenaStudentaListener;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = -3632212177343556646L;
	private JButton dodavanjeStudenta;
	private JButton dodavanjeProfesora;
	private JButton izmenaStudenta;
	private JButton izmenaPredmeta;
	private JButton izmenaProfesora;
	private JButton brisanjeStudenta;
	private JButton brisanjePredmeta;
	private JButton brisanjeProfesora;
	private JButton pretraga;
	private JTextField unosPretrage;
	private JButton dodavanjePredmeta;
	private JButton dodavanjeStudentaNaPredemet;
	private JButton dodavanjeProfesoraNaPredmet;

	private static ToolBar instance = null; // singlton klasa
	// obrazac za singlton po defaultu treba da se pali student

	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar();
		}
		return instance;
	}

	private ToolBar() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setFloatable(false);
		dodavanjeStudenta = new JButton();
		dodavanjeStudenta.setToolTipText("Dodavanje studenta/profesora/predmeta");
		dodavanjeStudenta.addActionListener(new DodavanjeStudentaListener());
		dodavanjeStudenta.setIcon(new ImageIcon("slike/dodavanje.png"));
		
		
		dodavanjeProfesora = new JButton();
		dodavanjeProfesora.setToolTipText("Dodavanje profesora");
		dodavanjeProfesora.addActionListener(new DodavanjeProfesoraListener());
		dodavanjeProfesora.setIcon(new ImageIcon("slike/dodavanjeprofesora.png"));
		
		
		
		izmenaStudenta = new JButton();
		izmenaStudenta.setToolTipText("Izmena studenta");
		izmenaStudenta.setIcon(new ImageIcon("slike/izmena.png"));
		izmenaStudenta.addActionListener(new IzmenaStudentaListener());
		
		izmenaPredmeta = new JButton();
		izmenaPredmeta.setToolTipText("Izmena predmeta");
		izmenaPredmeta.setIcon(new ImageIcon("slike/izmena.png"));
		
		izmenaProfesora = new JButton();
		izmenaProfesora.setToolTipText("Izmena profesora");
		izmenaProfesora.setIcon(new ImageIcon("slike/izmena.png"));
		
		brisanjeStudenta = new JButton();
		brisanjeStudenta.setToolTipText("Brisanje studenta");
		brisanjeStudenta.setIcon(new ImageIcon("slike/brisanje.png"));

		brisanjeProfesora = new JButton();
		brisanjeProfesora.setToolTipText("Brisanje profesora");
		brisanjeProfesora.setIcon(new ImageIcon("slike/brisanje.png"));
		
		unosPretrage = new JTextField();
		unosPretrage.setPreferredSize(new Dimension(250, 30));

		pretraga = new JButton();
		pretraga.setToolTipText("Pretrazite studente/profesore/predmete");
		pretraga.setIcon(new ImageIcon("slike/pretraga.png"));

		dodavanjeStudentaNaPredemet = new JButton();
		dodavanjeStudentaNaPredemet.setToolTipText("Dodajte novog studenta na predmet");
		dodavanjeStudentaNaPredemet.setIcon(new ImageIcon("slike/dodavanje.png"));

		dodavanjePredmeta = new JButton();
		dodavanjePredmeta.setToolTipText("Dodavanje predmeta");
		dodavanjePredmeta.setIcon(new ImageIcon("slike/dodajpredmet.png"));
		dodavanjePredmeta.addActionListener(new DodavanjePredmetaListener());

		dodavanjeProfesoraNaPredmet = new JButton();
		dodavanjeProfesoraNaPredmet.setToolTipText("Dodajte novog profesora na predmet");
		dodavanjeProfesoraNaPredmet.setIcon(new ImageIcon("slike/dodavanjeprofesora.png"));
		
		brisanjePredmeta= new JButton();
		brisanjePredmeta.setToolTipText("Brisanje predmeta");
		brisanjePredmeta.setIcon(new ImageIcon("slike/brisanje.png"));
		brisanjePredmeta.addActionListener(new BrisanjePredmetaListener());
		
		iscrtajNaEkran(Tip.STUDENT);
	}

	// iscrtavam komponente na osnovu kartice na kojoj se nalazim - menja se toolbar
	// uvek ovu metodu pozivam u listeneru
	public void iscrtajNaEkran(Tip t) {
		removeAll();

		if (t == Tip.STUDENT) {
			dodavanjeStudenta.setToolTipText("Dodavanje studenta");
			add(dodavanjeStudenta);

			addSeparator();
			add(izmenaStudenta);

			addSeparator();
			add(brisanjeStudenta);

			add(Box.createHorizontalStrut(850));

			add(unosPretrage);
			addSeparator();

			pretraga.setToolTipText("Pretrazite studente");
			add(pretraga);

		} else if (t == Tip.PROFESOR) {
			
			add(dodavanjeProfesora);
			
			addSeparator();
			add(izmenaProfesora);

			addSeparator();
			add(brisanjeProfesora);

			add(Box.createHorizontalStrut(850));

			add(unosPretrage);

			addSeparator();

			pretraga.setToolTipText("Pretrazite profesora");
			add(pretraga);

		} else if (t == Tip.PREDMET) {
			//dodavanjePredmeta.addActionListener(this);
			add(dodavanjePredmeta);

			addSeparator();

			add(dodavanjeStudentaNaPredemet);
			addSeparator();

			add(dodavanjeProfesoraNaPredmet);
			addSeparator();

			add(izmenaPredmeta);

			addSeparator();
			
			add(brisanjePredmeta);

			add(Box.createHorizontalStrut(690));

			add(unosPretrage);

			addSeparator();

			pretraga.setToolTipText("Pretrazite predmete");
			add(pretraga);

		}

	}
}
