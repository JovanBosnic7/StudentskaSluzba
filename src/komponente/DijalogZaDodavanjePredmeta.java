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
	private JPanel prikaz;
	private JScrollPane scroll;
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
		setMinimumSize(new Dimension(400, 500));
		setSize(screenDimension.width / 4, screenDimension.height / 2);
		setLocation(screenDimension.width / 2 - getWidth() / 2, screenDimension.height / 2 - getHeight() / 2);
		setTitle("Dodavanje predmeta");
		setModal(true);
		setLocationRelativeTo(null);
		prikaz=new JPanel();
		prikaz.setPreferredSize(new Dimension(480,500));
		panelCenter = new JPanel();
		panelCenter.setMinimumSize(new Dimension(480, 400));
		panelCenter.setPreferredSize(new Dimension(480, 400));
		panelCenter.setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		b = new GridBagConstraints();
		b.fill = GridBagConstraints.VERTICAL;
		b.insets = new Insets(10, 10, 10, 100);

		labelNazivPredmeta = new JLabel("Naziv predmeta:");
		labelNazivPredmeta.setMinimumSize(new Dimension(200,20));
		labelNazivPredmeta.setPreferredSize(new Dimension(200,25));
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 100;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 20, 20, 20);
		panelCenter.add(labelNazivPredmeta, c);

		labelSifraPredmeta = new JLabel("\u0160ifra predmeta:");
		labelSifraPredmeta.setMinimumSize(new Dimension(200,20));
		labelSifraPredmeta.setPreferredSize(new Dimension(200,25));
		c.gridx = 0;
		c.gridy = 0;
		panelCenter.add(labelSifraPredmeta, c);

		labelSemestar = new JLabel("Semestar:");
		labelSemestar.setMinimumSize(new Dimension(200,20));
		labelSemestar.setPreferredSize(new Dimension(200,25));
		c.gridx = 0;
		c.gridy = 2;
		panelCenter.add(labelSemestar, c);

		labelGodinaUKojojeSePredmetIzvodi = new JLabel("Godina izvo\u0111enja:");
		labelGodinaUKojojeSePredmetIzvodi.setMinimumSize(new Dimension(300,20));
		labelGodinaUKojojeSePredmetIzvodi.setPreferredSize(new Dimension(250,25));
		c.gridx = 0;
		c.gridy = 3;
		panelCenter.add(labelGodinaUKojojeSePredmetIzvodi, c);

		//this.add(panelCenter, BorderLayout.CENTER);

		unosSifre = new JTextField();
		unosSifre.setMinimumSize(new Dimension(200, 20));
		unosSifre.setPreferredSize(new Dimension(200, 25));
		unosSifre.setToolTipText("<html>" + "Unesite \u0161ifru predmeta." + "<br>" + "Sifra mora poceti velikim slovom."
				+ "<br>" + "npr. EE123" + "</html>");
		unosSifre.addKeyListener(this);

		b.gridx = 1;
		b.gridy = 0;
		panelCenter.add(unosSifre, b);

		unosNaziva = new JTextField();
		unosNaziva.setMinimumSize(new Dimension(200, 20));
		unosNaziva.setPreferredSize(new Dimension(200, 25));
		unosNaziva.setToolTipText("<html>" + "Unesite naziv predmeta." + "<br>" + "Predmet mora poceti velikim slovom."
				+ "<br>" + "npr. Matematika" + "</html>");
		unosNaziva.addKeyListener(this);
		b.gridx = 1;
		b.gridy = 1;
		panelCenter.add(unosNaziva, b);

		semestarComboBox = new JComboBox<String>();
		semestarComboBox.setBackground(Color.WHITE);
		semestarComboBox.setMinimumSize(new Dimension(200, 20));
		semestarComboBox.setPreferredSize(new Dimension(200, 25));
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
		godStudijaComboBox.setMinimumSize(new Dimension(200, 20));

		godStudijaComboBox.setPreferredSize(new Dimension(200, 25));

		b.gridx = 1;
		b.gridy = 3;
		panelCenter.add(godStudijaComboBox, b);

		odustanak = new JButton("Odustanak");
		odustanak.setMinimumSize(new Dimension(100,20));
		odustanak.setPreferredSize(new Dimension(100,30));
		odustanak.addActionListener(this);

		potvrda = new JButton("Potrvda");
		potvrda.setMinimumSize(new Dimension(100,20));
		potvrda.setPreferredSize(new Dimension(100,30));
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
		panelBottom.setMinimumSize(new Dimension(screenDimension.width/4,100));
		panelBottom.setPreferredSize(new Dimension(screenDimension.width/4,120));
		prikaz.add(panelCenter, BorderLayout.NORTH);
		prikaz.add(panelBottom,BorderLayout.SOUTH);
		scroll= new  JScrollPane(prikaz);
		this.add(scroll);

	}

	public DijalogZaDodavanjePredmeta(int row) {
		this();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Niste ozna\u010Dili predmet koji \u017Eelite da izmenite");
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
					JOptionPane.showConfirmDialog(null, "Doslo je do gre\u0161ke pri izmeni predmeta");
				}

			} else {

				if (!PredmetiKontroler.getInstance().dodajPredmet(p)) {
					JOptionPane.showMessageDialog(null, "Uneli ste \u0161ifru predmeta koja vec postoji!");
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
