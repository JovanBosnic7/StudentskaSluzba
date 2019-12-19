package komponente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ToolBar extends JToolBar implements ActionListener {

	private static final long serialVersionUID = -3632212177343556646L;
	private JButton dodavanjeStudenta;
	private JButton dodavanjeProfesora;
	private JButton izmena;
	private JButton brisanje;
	private JButton brisanjePredmeta;
	private JButton pretraga;
	private JTextField unosPretrage;
	private JButton dodavanjePredmeta;
	private JButton dodavanjeStudentaNaPredemet;
	private JButton dodavanjeProfesoraNaPredmet;
	private DijalogZaDodavanjeProfesora dijalogProfesor;
	private DijalogZaDodavanjePredmeta dijalogPredmet;
	private DijalogZaBrisanjePredmeta dijalogBrisanjePredmet;




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
		dodavanjeStudenta.setIcon(new ImageIcon("slike/dodavanje.png"));
		
		
		dodavanjeProfesora = new JButton();
		dodavanjeProfesora.setToolTipText("Dodavanje profesora");
		dodavanjeProfesora.addActionListener(this);
		dodavanjeProfesora.setIcon(new ImageIcon("slike/dodavanjeprofesora.png"));
		
		
		
		izmena = new JButton();
		izmena.setToolTipText("Izmena studenta/profesora/predmeta");
		izmena.setIcon(new ImageIcon("slike/izmena.png"));

		brisanje = new JButton();
		brisanje.setToolTipText("Brisanje selektovanog entiteta");
		brisanje.setIcon(new ImageIcon("slike/brisanje.png"));

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
		dodavanjePredmeta.addActionListener(this);

		dodavanjeProfesoraNaPredmet = new JButton();
		dodavanjeProfesoraNaPredmet.setToolTipText("Dodajte novog profesora na predmet");
		dodavanjeProfesoraNaPredmet.setIcon(new ImageIcon("slike/dodavanjeprofesora.png"));
		
		brisanjePredmeta= new JButton();
		brisanjePredmeta.setToolTipText("Brisanje predmeta");
		brisanjePredmeta.setIcon(new ImageIcon("slike/brisanje.png"));
		brisanjePredmeta.addActionListener(this);
		
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
			izmena.setToolTipText("Izmena studenta");
			add(izmena);

			addSeparator();
			brisanje.setToolTipText("Brisanje studenta");
			add(brisanje);

			add(Box.createHorizontalStrut(850));

			add(unosPretrage);
			addSeparator();

			pretraga.setToolTipText("Pretrazite studente");
			add(pretraga);

		} else if (t == Tip.PROFESOR) {
			
			add(dodavanjeProfesora);
			
			addSeparator();
			izmena.setToolTipText("Izmena profesora");
			add(izmena);

			addSeparator();
			brisanje.setToolTipText("Brisanje profesora");
			add(brisanje);

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

			izmena.setToolTipText("Izmena predmeta");
			add(izmena);

			addSeparator();
			
			add(brisanjePredmeta);

			add(Box.createHorizontalStrut(690));

			add(unosPretrage);

			addSeparator();

			pretraga.setToolTipText("Pretrazite predmete");
			add(pretraga);

		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if(clicked== dodavanjeProfesora) {
			dijalogProfesor=new DijalogZaDodavanjeProfesora();
			dijalogProfesor.setLocationRelativeTo(MainFrame.getInstance());
			dijalogProfesor.setVisible(true);
		}
		if (clicked == dodavanjePredmeta) {
			dijalogPredmet=new DijalogZaDodavanjePredmeta();
			dijalogPredmet.setLocationRelativeTo(MainFrame.getInstance());
			dijalogPredmet.setVisible(true);
		}
		if(clicked == brisanjePredmeta) {
			dijalogBrisanjePredmet=new DijalogZaBrisanjePredmeta();
			dijalogBrisanjePredmet.setLocationRelativeTo(MainFrame.getInstance());
			dijalogBrisanjePredmet.setVisible(true);
		}
		
	}
}
