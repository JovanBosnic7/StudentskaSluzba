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

public class DijalogZaDodavanjeProfesora extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5230900675304536431L;
	private JLabel labelaIme;
	private JLabel labelaPrezime;
	private JLabel labelaDatumRodjenja;
	private JLabel labelaAdresaStanovanja;
	private JLabel labelaKontaktTelefon;
	private JLabel labelaEmailAdresa;
	private JLabel labelaAdresaKancelarije;
	private JLabel labelaBrojLicneKarte;
	private JLabel labelaTitula;
	private JLabel labelaZvanje;
	
	private JTextField unosIme;
	private JTextField unosPrezime;
	private JTextField unosDatumRodjenja;
	private JTextField unosAdresaStanovanja;
	private JTextField unosKontaktTelefon;
	private JTextField unosEmailAdresa;
	private JTextField unosAdresaKancelarije;
	private JTextField unosBrojLicneKarte;
	private JTextField unosTitula;
	private JTextField unosZvanje;

	private JButton dugmeOdustanak;
	private JButton dugmePotvrda;
	private JPanel panelBottom;
	private JPanel panelUnosPodataka;
	private JPanel panelCenter;

	
	
	public DijalogZaDodavanjeProfesora() {
		GridBagConstraints cLabele;
		GridBagConstraints cTextBox;
		GridBagConstraints cDugmad;
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1 * screenDimension.width / 4, screenDimension.height / 2);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Dodavanje profesora");
		setModal(true);
		
		panelUnosPodataka = new JPanel();
		panelUnosPodataka.setLayout(new GridBagLayout());

		cLabele = new GridBagConstraints();
		cTextBox = new GridBagConstraints();
		cTextBox.fill = GridBagConstraints.HORIZONTAL;
		cTextBox.insets=new Insets(10, 10, 0, 50);
		
		labelaIme = new JLabel("Ime *");
		cLabele.gridx = 0;
		cLabele.gridy = 0;
		cLabele.weightx=100;
		cLabele.fill=GridBagConstraints.HORIZONTAL;
		cLabele.insets=new Insets(10,50,0,0);
		panelUnosPodataka.add(labelaIme, cLabele);

		labelaPrezime = new JLabel("Prezime*");
		cLabele.gridx = 0;
		cLabele.gridy = 1;
		panelUnosPodataka.add(labelaPrezime, cLabele);

		labelaDatumRodjenja = new JLabel("Datum rodjenja*");
		cLabele.gridx = 0;
		cLabele.gridy = 2;
		panelUnosPodataka.add(labelaDatumRodjenja, cLabele);

		labelaAdresaStanovanja = new JLabel("Adresa stanovanja*");
		cLabele.gridx = 0;
		cLabele.gridy = 3;
		panelUnosPodataka.add(labelaAdresaStanovanja, cLabele);
		
		labelaKontaktTelefon = new JLabel("Kontakt telefon*");
		cLabele.gridx = 0;
		cLabele.gridy = 4;
		panelUnosPodataka.add(labelaKontaktTelefon, cLabele);
		
		labelaEmailAdresa = new JLabel("Email*");
		cLabele.gridx = 0;
		cLabele.gridy = 5;
		panelUnosPodataka.add(labelaEmailAdresa, cLabele);
		
		labelaAdresaKancelarije = new JLabel("Adresa kancelarije*");
		cLabele.gridx = 0;
		cLabele.gridy = 6;
		panelUnosPodataka.add(labelaAdresaKancelarije, cLabele);
		
		labelaBrojLicneKarte = new JLabel("Broj licne karte*");
		cLabele.gridx = 0;
		cLabele.gridy = 7;
		panelUnosPodataka.add(labelaBrojLicneKarte, cLabele);
		
		labelaTitula = new JLabel("Titula*");
		cLabele.gridx = 0;
		cLabele.gridy = 8;
		panelUnosPodataka.add(labelaTitula, cLabele);

		labelaZvanje = new JLabel("Zvanje*");
		cLabele.gridx = 0;
		cLabele.gridy = 9;
		panelUnosPodataka.add(labelaZvanje, cLabele);
		
		unosIme = new JTextField();
		unosIme.setToolTipText("<html>" + "Unesite ime profesora." + "<br>" + "Ime mora poceti velikim slovom." + "<br>" + "npr. Pera"+ "</html>");
		unosIme.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 0;
		panelUnosPodataka.add(unosIme, cTextBox);
		
		unosPrezime = new JTextField();
		unosPrezime.setToolTipText("<html>" + "Unesite prezime profesora." + "<br>" + "Prezime mora poceti velikim slovom." + "<br>" + "npr. Peric"+ "</html>");
		unosPrezime.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 1;
		panelUnosPodataka.add(unosPrezime, cTextBox);
		
		unosDatumRodjenja = new JTextField();
		unosDatumRodjenja.setToolTipText("<html>" + "Unesite datum rodjenja profesora." + "<br>" + "Datum se unosi u formatu dd.mm.gggg." + "<br>" + "npr. 01.01.1998."+ "</html>");
		unosDatumRodjenja.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 2;
		panelUnosPodataka.add(unosDatumRodjenja, cTextBox);
		
		unosAdresaStanovanja = new JTextField();
		unosAdresaStanovanja.setToolTipText("Unesite adresu stanovanja profesora.");
		unosAdresaStanovanja.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 3;
		panelUnosPodataka.add(unosAdresaStanovanja, cTextBox);
		
		unosKontaktTelefon = new JTextField();
		unosKontaktTelefon.setToolTipText("<html>" + "Unesite broj telefona profesora." + "<br>" + "Obavezno sa prefiksom drzave." + "<br>" + "npr. +381651234567"+ "</html>");
		unosKontaktTelefon.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 4;
		panelUnosPodataka.add(unosKontaktTelefon, cTextBox);
		
		unosEmailAdresa = new JTextField();
		unosEmailAdresa.setToolTipText("Unesite email adresu profesora.");
		unosEmailAdresa.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 5;
		panelUnosPodataka.add(unosEmailAdresa, cTextBox);
		
		unosAdresaKancelarije = new JTextField();
		unosAdresaKancelarije.setToolTipText("Unesite adresu kancelarije profesora.");
		unosAdresaKancelarije.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 6;
		panelUnosPodataka.add(unosAdresaKancelarije, cTextBox);
		
		unosBrojLicneKarte = new JTextField();
		unosBrojLicneKarte.setToolTipText("Unesite broj licne karte profesora.");
		unosBrojLicneKarte.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 7;
		panelUnosPodataka.add(unosBrojLicneKarte, cTextBox);
		
		unosTitula = new JTextField();
		unosTitula.setToolTipText("<html>Unesite titulu profesora. <br> npr. dr </html>");
		unosTitula.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 8;
		panelUnosPodataka.add(unosTitula, cTextBox);
		
		unosZvanje = new JTextField();
		unosZvanje.setToolTipText("<html>Unesite zvanje profesora. <br> npr. redovni profesor </html>");
		unosZvanje.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 9;
		panelUnosPodataka.add(unosZvanje, cTextBox);
		
		panelUnosPodataka.setBackground(new Color(240, 240, 240));
		this.add(panelUnosPodataka, BorderLayout.NORTH);
		
		dugmePotvrda = new JButton("Potvrda");
		dugmePotvrda.setBackground(Color.WHITE);
		dugmePotvrda.setEnabled(false);
		dugmePotvrda.addActionListener(this);
		dugmePotvrda.setPreferredSize(new Dimension(100, 30));
		
		dugmeOdustanak = new JButton("Odustanak");
		dugmeOdustanak.setBackground(Color.WHITE);
		dugmeOdustanak.addActionListener(this);
		dugmeOdustanak.setPreferredSize(new Dimension(100, 30));
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		
		cDugmad = new GridBagConstraints();
		cDugmad.gridx = 0;
		cDugmad.gridy = 0;
		cDugmad.insets=new Insets(40,40,40,40);
		panelCenter.add(dugmeOdustanak, cDugmad);
		cDugmad.gridx = 1;
		cDugmad.gridy = 0;
		panelCenter.add(dugmePotvrda, cDugmad);
		panelCenter.setBackground(new Color(240, 240, 240));
		this.add(panelCenter, BorderLayout.CENTER);
		panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(screenDimension.width, 30));
		panelBottom.setBackground(new Color(240, 240, 240));
		this.add(panelBottom, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == dugmeOdustanak) {
			setVisible(false);
		}
		 	if (clicked == dugmePotvrda) {
			
			setVisible(false);
		}

	}
}
