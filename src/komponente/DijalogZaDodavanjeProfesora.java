package komponente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.BazaProfesora;

public class DijalogZaDodavanjeProfesora extends JDialog implements ActionListener {

	private JLabel labelIme;
	private JLabel labelPrezime;
	private JLabel labelDatumRodjenja;
	private JLabel labelAdresaStanovanja;
	private JLabel labelKontaktTelefon;
	private JLabel labelEmailAdresa;
	private JLabel labelAdresaKancelarije;
	private JLabel labelBrojLicneKarte;
	private JLabel labelTitula;
	private JLabel labelZvanje;
	private JLabel labelPredmeti;
	
	private JTextField unos;
	private JTextField unos1;
	private JTextField unos2;
	private JTextField unos3;
	private JTextField unos4;
	private JTextField unos5;
	private JTextField unos6;
	private JTextField unos7;
	private JTextField unos8;
	private JTextField unos9;
	private JTextField unos10;

	private JButton odustanak;
	private JButton potvrda;
	private JPanel panelBottom;
	private JPanel panelCenter;
	private GridBagConstraints c;
	private GridBagConstraints b;

	public DijalogZaDodavanjeProfesora() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(2 * screenDimension.width / 7, screenDimension.height / 2);
		setLocation(screenDimension.width / 2 - getWidth() / 2, screenDimension.height / 2 - getHeight() / 2);
		setTitle("Dodavanje profesora");
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
//		setLayout(new GridBagLayout());
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		b=new GridBagConstraints();
		b.fill=GridBagConstraints.VERTICAL;
		b.insets=new Insets(10,10 ,0, 170);
		labelIme = new JLabel("Ime:");

		c.gridx = 0;
		c.gridy = 0;
		c.weightx=100;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets=new Insets(10,20,0,0);
		panelCenter.add(labelIme, c);

		labelPrezime = new JLabel("Prezime:");
		c.gridx = 0;
		c.gridy = 1;
		panelCenter.add(labelPrezime, c);

		labelDatumRodjenja = new JLabel("Datum rodjenja:");
		c.gridx = 0;
		c.gridy = 2;
		panelCenter.add(labelDatumRodjenja, c);

		labelAdresaStanovanja = new JLabel("Adresa stanovanja:");
		c.gridx = 0;
		c.gridy = 3;
		panelCenter.add(labelAdresaStanovanja, c);

		labelKontaktTelefon = new JLabel("Kontakt telefon:");
		c.gridx = 0;
		c.gridy = 4;
		panelCenter.add(labelKontaktTelefon, c);

		labelEmailAdresa = new JLabel("Email adresa:");
		c.gridx = 0;
		c.gridy = 5;
		panelCenter.add(labelEmailAdresa, c);

		labelAdresaKancelarije = new JLabel("Adresa kancelarije:");
		c.gridx = 0;
		c.gridy = 6;
		panelCenter.add(labelAdresaKancelarije, c);

		labelBrojLicneKarte = new JLabel("Broj licne karte:");
		c.gridx = 0;
		c.gridy = 7;
		panelCenter.add(labelBrojLicneKarte, c);

		labelTitula = new JLabel("Titula:");
		c.gridx = 0;
		c.gridy = 8;
		panelCenter.add(labelTitula, c);

		labelZvanje = new JLabel("Zvanje:");
		c.gridx = 0;
		c.gridy = 9;
		panelCenter.add(labelZvanje, c);
		
		labelPredmeti=new JLabel("Predmeti:");
		c.gridx=0;
		c.gridy=10;
		panelCenter.add(labelPredmeti,c);

		unos = new JTextField();
		unos.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 0;
		panelCenter.add(unos, b);

		unos1 = new JTextField();
		unos1.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 1;
		panelCenter.add(unos1, b);

		unos2 = new JTextField();
		unos2.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 2;
		panelCenter.add(unos2, b);

		unos3 = new JTextField();
		unos3.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 3;
		panelCenter.add(unos3, b);

		unos4 = new JTextField();
		unos4.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 4;
		panelCenter.add(unos4, b);

		unos5 = new JTextField();
		unos5.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 5;
		panelCenter.add(unos5, b);

		unos6 = new JTextField();
		unos6.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 6;
		panelCenter.add(unos6, b);

		unos7 = new JTextField();
		unos7.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 7;
		panelCenter.add(unos7, b);

		unos8 = new JTextField();
		unos8.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 8;
		panelCenter.add(unos8, b);

		unos9 = new JTextField();
		unos9.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 9;
		panelCenter.add(unos9, b);
		
		unos10= new JTextField();
		unos10.setPreferredSize(new Dimension(200,20));
		b.gridx=1;
		b.gridy=10;
		panelCenter.add(unos10,b);

		this.add(panelCenter, BorderLayout.CENTER);

		odustanak = new JButton("Odustanak");
		odustanak.addActionListener(this);
	

		potvrda = new JButton("Potrvda");
		potvrda.setBackground(new Color(131,237,253));
		potvrda.addActionListener(this);
		
		GridBagConstraints a=new GridBagConstraints();
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridBagLayout());
		a.gridx=0;
		a.gridy=0;
		a.insets=new Insets(40,40,40,40);
		panelBottom.add(odustanak,a);
		a.gridx=1;
		a.gridy=0;
		panelBottom.add(potvrda,a);
		this.add(panelBottom, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == odustanak) {
			setVisible(false);
		}
		 	if (clicked == potvrda) {
			
			setVisible(false);
		}

	}
}
