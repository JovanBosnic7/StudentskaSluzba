package komponente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import kontroler.BrisanjePredmetaListener;
import kontroler.BrisanjeProfesoraListener;
import kontroler.BrisanjeStudentaListener;
import kontroler.DodavanjePredmetaListener;
import kontroler.DodavanjeProfesoraListener;
import kontroler.DodavanjeProfesoraNaPredmetListener;
import kontroler.DodavanjeStudentaListener;
import kontroler.DodavanjeStudentaNaPredmetListener;
import kontroler.IzmenaPredmetaListener;
import kontroler.IzmenaProfesoraListener;
import kontroler.IzmenaStudentaListener;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = -3632212177343556646L;
	private JPanel leviPanel;
	private JPanel desniPanel;
	private JButton dodavanjeStudenta;
	private JButton dodavanjeProfesora;
	private JButton izmenaStudenta;
	private JButton izmenaPredmeta;
	private JButton izmenaProfesora;
	private JButton brisanjeStudenta;
	private JButton brisanjePredmeta;
	private JButton brisanjeProfesora;

	private JButton pretragaStudenta;
	private JButton pretragaProfesora;
	private JButton pretragaPredmeta;
	private JTextField unosPretrageStudenta;
	private JTextField unosPretrageProfesora;
	private JTextField unosPretragePredmeta;

	private String stringPretrageStudenta;
	private String stringPretragePredmeta;
	private String stringPretrageProfesora;

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

		setLayout(new BorderLayout());
		setFloatable(false);
		leviPanel = new JPanel();
		leviPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		desniPanel = new JPanel();
		desniPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		dodavanjeStudenta = new JButton();
		dodavanjeStudenta.addActionListener(new DodavanjeStudentaListener());
		dodavanjeStudenta.setIcon(new ImageIcon("slike/dodavanje.png"));
		dodavanjeStudenta.setMnemonic(KeyEvent.VK_D);

		dodavanjeProfesora = new JButton();
		dodavanjeProfesora.setToolTipText("Dodavanje profesora Alt+D");
		dodavanjeProfesora.addActionListener(new DodavanjeProfesoraListener());
		dodavanjeProfesora.setIcon(new ImageIcon("slike/dodavanjeprofesora.png"));
		dodavanjeProfesora.setMnemonic(KeyEvent.VK_D);

		izmenaStudenta = new JButton();
		izmenaStudenta.setToolTipText("Izmena studenta Alt+I");
		izmenaStudenta.setIcon(new ImageIcon("slike/izmena.png"));
		izmenaStudenta.addActionListener(new IzmenaStudentaListener());
		izmenaStudenta.setMnemonic(KeyEvent.VK_I);

		izmenaPredmeta = new JButton();
		izmenaPredmeta.setToolTipText("Izmena predmeta Alt+I");
		izmenaPredmeta.setIcon(new ImageIcon("slike/izmena.png"));
		izmenaPredmeta.addActionListener(new IzmenaPredmetaListener());
		izmenaPredmeta.setMnemonic(KeyEvent.VK_I);

		izmenaProfesora = new JButton();
		izmenaProfesora.setToolTipText("Izmena profesora Alt+I");
		izmenaProfesora.setIcon(new ImageIcon("slike/izmena.png"));
		izmenaProfesora.addActionListener(new IzmenaProfesoraListener());
		izmenaProfesora.setMnemonic(KeyEvent.VK_I);

		brisanjeStudenta = new JButton();
		brisanjeStudenta.setToolTipText("Brisanje studenta Alt+B");
		brisanjeStudenta.setIcon(new ImageIcon("slike/brisanje.png"));
		brisanjeStudenta.addActionListener(new BrisanjeStudentaListener());
		brisanjeStudenta.setMnemonic(KeyEvent.VK_B);

		brisanjeProfesora = new JButton();
		brisanjeProfesora.setToolTipText("Brisanje profesora Alt+B");
		brisanjeProfesora.setIcon(new ImageIcon("slike/brisanje.png"));
		brisanjeProfesora.addActionListener(new BrisanjeProfesoraListener());
		brisanjeProfesora.setMnemonic(KeyEvent.VK_B);

		unosPretrageStudenta = new JTextField();
		unosPretrageStudenta.setMinimumSize(new Dimension(200,25));
		unosPretrageStudenta.setPreferredSize(new Dimension(250, 30));
		unosPretrageStudenta.setToolTipText("<html>" + "Pretragu unesite u slede\u0107em formatu ime:_____; prezime:_____;indeks:____;" + "</html>");

		unosPretrageStudenta.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (unosPretrageStudenta.getText().equals("")) {
					stringPretrageStudenta = unosPretrageStudenta.getText();
					ScrollPaneStudenti.getInstance().pretrazi(stringPretrageStudenta);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		pretragaStudenta = new JButton();
		pretragaStudenta.setToolTipText("Pretra\u017Eite studente Alt+P");
		pretragaStudenta.setIcon(new ImageIcon("slike/pretraga.png"));
		pretragaStudenta.setMnemonic(KeyEvent.VK_P);
		pretragaStudenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stringPretrageStudenta = unosPretrageStudenta.getText();
				ScrollPaneStudenti.getInstance().pretrazi(stringPretrageStudenta);
			}
		});

		unosPretrageProfesora = new JTextField();
		unosPretrageProfesora.setMinimumSize(new Dimension(200,25));
		unosPretrageProfesora.setPreferredSize(new Dimension(250, 30));
		unosPretrageProfesora.setToolTipText("<html>" + "Pretragu unesite u slede\u0107em formatu ime:_____; prezime:_____;brLicneKarte:_____;" + "</html>");

		unosPretrageProfesora.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (unosPretrageProfesora.getText().equals("")) {
					stringPretrageProfesora = unosPretrageProfesora.getText();
					ScrollPaneProfesori.getInstance().pretrazi(stringPretrageProfesora);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		pretragaProfesora = new JButton();
		pretragaProfesora.setToolTipText("Pretra\u017Eite profesore Alt+P");
		pretragaProfesora.setIcon(new ImageIcon("slike/pretraga.png"));
		pretragaProfesora.setMnemonic(KeyEvent.VK_P);
		pretragaProfesora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stringPretrageProfesora = unosPretrageProfesora.getText();
				ScrollPaneProfesori.getInstance().pretrazi(stringPretrageProfesora);
			}
		});

		unosPretragePredmeta = new JTextField();
		unosPretragePredmeta.setToolTipText("<html>" + "Pretragu unesite u slede\u0107em formatu sifraPredmeta:_____; nazivPredmeta:_____;" + "</html>");
		unosPretragePredmeta.setMinimumSize(new Dimension(200,25));
		unosPretragePredmeta.setPreferredSize(new Dimension(250, 30));
		unosPretragePredmeta.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (unosPretragePredmeta.getText().equals("")) {
					stringPretragePredmeta = unosPretragePredmeta.getText();
					ScrollPanePredmeti.getInstance().pretrazi(stringPretragePredmeta);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		pretragaPredmeta = new JButton();
		pretragaPredmeta.setToolTipText("Pretra\u017Eite predmete Alt+P");
		pretragaPredmeta.setMnemonic(KeyEvent.VK_P);
		pretragaPredmeta.setIcon(new ImageIcon("slike/pretraga.png"));
		pretragaPredmeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stringPretragePredmeta = unosPretragePredmeta.getText();
				ScrollPanePredmeti.getInstance().pretrazi(stringPretragePredmeta);
			}
		});

		dodavanjeStudentaNaPredemet = new JButton();
		dodavanjeStudentaNaPredemet.setToolTipText("Dodajte novog studenta na predmet Alt+S");
		dodavanjeStudentaNaPredemet.setIcon(new ImageIcon("slike/dodavanje.png"));
		dodavanjeStudentaNaPredemet.setMnemonic(KeyEvent.VK_S);
		dodavanjeStudentaNaPredemet.addActionListener(new DodavanjeStudentaNaPredmetListener());

		dodavanjePredmeta = new JButton();
		dodavanjePredmeta.setToolTipText("Dodavanje predmeta Alt+D");
		dodavanjePredmeta.setMnemonic(KeyEvent.VK_D);
		dodavanjePredmeta.setIcon(new ImageIcon("slike/dodajpredmet.png"));
		dodavanjePredmeta.addActionListener(new DodavanjePredmetaListener());

		dodavanjeProfesoraNaPredmet = new JButton();
		dodavanjeProfesoraNaPredmet.setToolTipText("Dodajte novog profesora na predmet Alt+N");
		dodavanjeProfesoraNaPredmet.setIcon(new ImageIcon("slike/dodavanjeprofesora.png"));
		dodavanjeProfesoraNaPredmet.setMnemonic(KeyEvent.VK_N);
		dodavanjeProfesoraNaPredmet.addActionListener(new DodavanjeProfesoraNaPredmetListener());

		brisanjePredmeta = new JButton();
		brisanjePredmeta.setToolTipText("Brisanje predmeta Alt+B");
		brisanjePredmeta.setIcon(new ImageIcon("slike/brisanje.png"));
		brisanjePredmeta.setMnemonic(KeyEvent.VK_B);
		brisanjePredmeta.addActionListener(new BrisanjePredmetaListener());

		iscrtajNaEkran(Tip.STUDENT);
	}

	// iscrtavam komponente na osnovu kartice na kojoj se nalazim - menja se toolbar
	// uvek ovu metodu pozivam u listeneru
	public void iscrtajNaEkran(Tip t) {
		removeAll();
		if (t == Tip.STUDENT) {
			leviPanel.removeAll();
			desniPanel.removeAll();
			dodavanjeStudenta.setToolTipText("Dodavanje studenta Alt+D");
			leviPanel.add(dodavanjeStudenta);

			leviPanel.add(izmenaStudenta);

			leviPanel.add(brisanjeStudenta);

			add(leviPanel, BorderLayout.WEST);

			desniPanel.add(unosPretrageStudenta);

			desniPanel.add(pretragaStudenta);

			add(desniPanel, BorderLayout.EAST);

		} else if (t == Tip.PROFESOR) {
			leviPanel.removeAll();
			desniPanel.removeAll();
			leviPanel.add(dodavanjeProfesora);

			leviPanel.add(izmenaProfesora);

			leviPanel.add(brisanjeProfesora);

			add(leviPanel, BorderLayout.WEST);

			desniPanel.add(unosPretrageProfesora);

			desniPanel.add(pretragaProfesora);
			add(desniPanel, BorderLayout.EAST);

		} else if (t == Tip.PREDMET) {
			// dodavanjePredmeta.addActionListener(this);
			leviPanel.removeAll();
			desniPanel.removeAll();

			leviPanel.add(dodavanjePredmeta);

			leviPanel.add(dodavanjeStudentaNaPredemet);

			leviPanel.add(dodavanjeProfesoraNaPredmet);

			leviPanel.add(izmenaPredmeta);

			leviPanel.add(brisanjePredmeta);

			add(leviPanel, BorderLayout.WEST);

			desniPanel.add(unosPretragePredmeta);

			desniPanel.add(pretragaPredmeta);

			add(desniPanel, BorderLayout.EAST);

		}

	}
}
