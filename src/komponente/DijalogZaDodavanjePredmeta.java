package komponente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

import kontroler.PredmetiKontroler;
import model.BazaPredmeta;
import model.GodinaStudija;
import model.Predmet;

public class DijalogZaDodavanjePredmeta extends JDialog implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7545776025882740463L;
	private JLabel labelSifraPredmeta;
	private JLabel labelNazivPredmeta;
	private JLabel labelSemestar;
	private JLabel labelGodinaUKojojeSePredmetIzvodi;
	private JLabel labelProfesor;

	private JTextField unosSifre;
	private JTextField unosNaziva;
	private JTextField unosSemestra;
	private JTextField unosGodine;
	private JTextField unosProfesora;

	private String sifra;
	private String naziv;
	private String semestar;
	private String godina;
	private String profesor;
	private GodinaStudija godinaStudija;

	private JButton odustanak;
	private JButton potvrda;
	private JPanel panelBottom;
	private JPanel panelCenter;
	private JComboBox<GodinaStudija> godStudijaComboBox;
	private JComboBox<String> semestarComboBox;

	Boolean[] uslovi = { false, false };
	private Boolean izmena;
	private int vrsta;
	private int formaDijaloga;

	private GridBagConstraints c;
	private GridBagConstraints b;

	public DijalogZaDodavanjePredmeta() {
		izmena = false;
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(2 * screenDimension.width / 7, screenDimension.height / 2);
		setLocation(screenDimension.width / 2 - getWidth() / 2, screenDimension.height / 2 - getHeight() / 2);
		setTitle("Dodavanje predmeta");
		setModal(true);
		setLocationRelativeTo(null);
//		setLayout(new GridBagLayout());
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		b = new GridBagConstraints();
		b.fill = GridBagConstraints.VERTICAL;
		b.insets = new Insets(10, 10, 10, 100);

		labelNazivPredmeta = new JLabel("Naziv predmeta:");
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 100;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 20, 20, 20);
		panelCenter.add(labelNazivPredmeta, c);

		labelSifraPredmeta = new JLabel("Sifra predmeta:");
		c.gridx = 0;
		c.gridy = 0;
		panelCenter.add(labelSifraPredmeta, c);

		labelSemestar = new JLabel("Semestar:");
		c.gridx = 0;
		c.gridy = 2;
		panelCenter.add(labelSemestar, c);

		labelGodinaUKojojeSePredmetIzvodi = new JLabel("Godina u kojoj se izvodi:");
		c.gridx = 0;
		c.gridy = 3;
		panelCenter.add(labelGodinaUKojojeSePredmetIzvodi, c);

		this.add(panelCenter, BorderLayout.CENTER);

		unosSifre = new JTextField();
		unosSifre.setPreferredSize(new Dimension(200, 20));
		unosSifre.setToolTipText("<html>" + "Unesite sifru predmeta." + "<br>" + "Sifra mora poceti velikim slovom."
				+ "<br>" + "npr. EE123" + "</html>");
		unosSifre.addKeyListener(this);

		b.gridx = 1;
		b.gridy = 0;
		panelCenter.add(unosSifre, b);

		unosNaziva = new JTextField();
		unosNaziva.setPreferredSize(new Dimension(200, 20));
		unosNaziva.setToolTipText("<html>" + "Unesite naziv predmeta." + "<br>" + "Predmet mora poceti velikim slovom."
				+ "<br>" + "npr. Matematika" + "</html>");
		unosNaziva.addKeyListener(this);
		b.gridx = 1;
		b.gridy = 1;
		panelCenter.add(unosNaziva, b);

		semestarComboBox = new JComboBox<String>();
		semestarComboBox.setBackground(Color.WHITE);
		semestarComboBox.setPreferredSize(new Dimension(200, 30));
		semestarComboBox.addItem("1");
		semestarComboBox.addItem("2");
		semestarComboBox.addItem("3");
		semestarComboBox.addItem("4");
		semestarComboBox.addItem("5");
		semestarComboBox.addItem("6");
		semestarComboBox.addItem("7");
		semestarComboBox.addItem("8");
		semestarComboBox.addItem("9");
		semestarComboBox.addItem("10");

		b.gridx = 1;
		b.gridy = 2;
		panelCenter.add(semestarComboBox, b);

		godStudijaComboBox = new JComboBox<GodinaStudija>();
		godStudijaComboBox.setBackground(Color.WHITE);

		godStudijaComboBox.addItem(GodinaStudija.I);
		godStudijaComboBox.addItem(GodinaStudija.II);
		godStudijaComboBox.addItem(GodinaStudija.III);
		godStudijaComboBox.addItem(GodinaStudija.IV);
		godStudijaComboBox.addItem(GodinaStudija.V);
		godStudijaComboBox.setPreferredSize(new Dimension(200, 30));

		b.gridx = 1;
		b.gridy = 3;
		panelCenter.add(godStudijaComboBox, b);

		odustanak = new JButton("Odustanak");
		odustanak.addActionListener(this);

		potvrda = new JButton("Potrvda");
		//potvrda.setBackground(new Color(131, 237, 253));
		potvrda.setEnabled(false);
		potvrda.addActionListener(this);

		GridBagConstraints a = new GridBagConstraints();
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridBagLayout());
		a.gridx = 0;
		a.gridy = 0;
		a.insets = new Insets(40, 40, 40, 40);
		panelBottom.add(odustanak, a);
		a.gridx = 1;
		a.gridy = 0;
		panelBottom.add(potvrda, a);
		this.add(panelBottom, BorderLayout.SOUTH);

	}

	public DijalogZaDodavanjePredmeta(int row) {
		this();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Niste oznacili predmet koji zelite da izmenite");
			return;
		}
		izmena = true;
		vrsta = TabelaPredmeta.getInstance().convertRowIndexToModel(row);
		setTitle("Izmena predmeta");
		Predmet p = BazaPredmeta.getInstance().getPredmeti().get(vrsta);
		unosSifre.setText(p.getSifraPredmeta());
		unosNaziva.setText(p.getNazivPredmeta());
		semestarComboBox.setSelectedItem(p.getSemestar());

		godStudijaComboBox.setSelectedItem(p.getGodinaUKojojSePredmetIzvodi());

	}

	private Boolean proveriUnos() {
		sifra = unosSifre.getText();
		naziv = unosNaziva.getText();
		
		if (sifra.matches("[a-zA-Z0-9]*")) {
			uslovi[0] = true;
			unosSifre.setBackground(new Color(240, 240, 240));

		} else {
			uslovi[0] = false;
			unosSifre.setBackground(new Color(255, 166, 166));
		}
		if (naziv.matches("[\\p{L} 0-9]*")) {
			uslovi[1] = true;
			unosNaziva.setBackground(new Color(240, 240, 240));

		} else {
			uslovi[1] = false;
			unosNaziva.setBackground(new Color(255, 166, 166));
		}

		return (uslovi[0] && uslovi[1]);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		if (clicked == odustanak) {
			setVisible(false);

		}
		if (clicked == potvrda) {
			sifra = unosSifre.getText();
			naziv = unosNaziva.getText();
			semestar = (String) semestarComboBox.getSelectedItem();
			godinaStudija = (GodinaStudija) godStudijaComboBox.getSelectedItem();
			Predmet p = new Predmet();

			p.setSifraPredmeta(sifra);
			p.setNazivPredmeta(naziv);
			p.setSemestar(semestar);
			p.setGodinaUKojojSePredmetIzvodi(godinaStudija);
			if (izmena) {
				if (!PredmetiKontroler.getInstance().izmeniPredmet(vrsta, p)) {
					JOptionPane.showConfirmDialog(null, "Doslo je do greske pri izmeni predmeta");
				}

			} else {

				if (!PredmetiKontroler.getInstance().dodajPredmet(p)) {
					JOptionPane.showMessageDialog(null, "Uneli ste sifru predmeta koja vec postoji!");
				}
			}
			setVisible(false);
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (proveriUnos()) {
			potvrda.setEnabled(true);
		} else {
			potvrda.setEnabled(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
