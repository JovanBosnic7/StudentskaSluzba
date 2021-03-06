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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import kontroler.ProfesoriKontroler;
import model.BazaProfesora;
import model.Profesor;

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

	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	
	private JButton dugmeOdustanak;
	private JButton dugmePotvrda;
	private JPanel panelUnosPodataka;
	private JPanel panelCenter;
	
	private Boolean izmena;
	private int vrsta;
	private Boolean[] uslovi;
	
	public DijalogZaDodavanjeProfesora(int row) {
		this();
		if(row < 0) {
			JOptionPane.showMessageDialog(null, "Niste ozna\u010dili profesora kog \u017eelite da izmenite!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
			return;
		}
		izmena = true;
		vrsta = TabelaProfesora.getInstance().convertRowIndexToModel(row);
		setTitle("Izmena profesora");
		Profesor p = BazaProfesora.getInstance().getProfesori().get(row);
		unosIme.setText(p.getIme());
		unosPrezime.setText(p.getPrezime());
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
		unosDatumRodjenja.setText(df.format(p.getDatumRodjenja()));
		unosAdresaStanovanja.setText(p.getAdresaStanovanja());
		unosKontaktTelefon.setText(p.getKontaktTelefon());
		unosEmailAdresa.setText(p.getEmailAdresa());
		unosAdresaKancelarije.setText(p.getAdresaKancelarije());
		unosBrojLicneKarte.setText(p.getBrojLicneKarte());
		unosTitula.setText(p.getTitula());
		unosZvanje.setText(p.getZvanje());
	}
	
	public DijalogZaDodavanjeProfesora() {
		izmena = false;
		GridBagConstraints cLabele;
		GridBagConstraints cTextBox;
		GridBagConstraints cDugmad;
		uslovi = new Boolean[10];
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(screenDimension.width / 4, screenDimension.height / 2));
		setSize(screenDimension.width / 4, screenDimension.height / 2);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Dodavanje profesora");
		setModal(true);
		
		panelUnosPodataka = new JPanel();
		panelUnosPodataka.setLayout(new GridBagLayout());
		panelUnosPodataka.setPreferredSize(new Dimension(480, 400));
		
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

		labelaDatumRodjenja = new JLabel("Datum ro\u0111enja*");
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
		
		labelaBrojLicneKarte = new JLabel("Broj li\u010dne karte*");
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
		unosIme.setToolTipText("<html>" + "Unesite ime profesora." + "<br>" + "Ime mora po\u010deti velikim slovom." + "<br>" + "npr. Pera"+ "</html>");
		unosIme.setMinimumSize(new Dimension(200, 20));
		unosIme.setPreferredSize(new Dimension(200, 25));
		unosIme.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[0])
					unosIme.setBackground(Color.WHITE);
				else
					unosIme.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 0;
		panelUnosPodataka.add(unosIme, cTextBox);
		
		unosPrezime = new JTextField();
		unosPrezime.setToolTipText("<html>" + "Unesite prezime profesora." + "<br>" + "Prezime mora po\u010deti velikim slovom." + "<br>" + "npr. Peric"+ "</html>");
		unosPrezime.setMinimumSize(new Dimension(200, 20));
		unosPrezime.setPreferredSize(new Dimension(200, 25));
		unosPrezime.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[1])
					unosPrezime.setBackground(Color.WHITE);
				else
					unosPrezime.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cTextBox.gridx = 1;
		cTextBox.gridy = 1;
		panelUnosPodataka.add(unosPrezime, cTextBox);
		
		unosDatumRodjenja = new JTextField();
		unosDatumRodjenja.setToolTipText("<html>" + "Unesite datum ro\u0111enja profesora." + "<br>" + "Datum se unosi u formatu dd.mm.gggg." + "<br>" + "npr. 01.01.1998."+ "</html>");
		unosDatumRodjenja.setMinimumSize(new Dimension(200, 20));
		unosDatumRodjenja.setPreferredSize(new Dimension(200, 25));
		unosDatumRodjenja.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[2])
					unosDatumRodjenja.setBackground(Color.WHITE);
				else
					unosDatumRodjenja.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 2;
		panelUnosPodataka.add(unosDatumRodjenja, cTextBox);
		
		unosAdresaStanovanja = new JTextField();
		unosAdresaStanovanja.setToolTipText("Unesite adresu stanovanja profesora.");
		unosAdresaStanovanja.setMinimumSize(new Dimension(200, 20));
		unosAdresaStanovanja.setPreferredSize(new Dimension(200, 25));
		unosAdresaStanovanja.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[3])
					unosAdresaStanovanja.setBackground(Color.WHITE);
				else
					unosAdresaStanovanja.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 3;
		panelUnosPodataka.add(unosAdresaStanovanja, cTextBox);
		
		unosKontaktTelefon = new JTextField();
		unosKontaktTelefon.setToolTipText("<html>" + "Unesite broj telefona profesora." + "<br>" + "Dozvoljene su cifre, kao i karakteri / +(ako se unosi prefiks dr\u017eave) i -." + "<br>" + "npr. +38165/1234567"+ "</html>");
		unosKontaktTelefon.setMinimumSize(new Dimension(200, 20));
		unosKontaktTelefon.setPreferredSize(new Dimension(200, 25));
		unosKontaktTelefon.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[4])
					unosKontaktTelefon.setBackground(Color.WHITE);
				else
					unosKontaktTelefon.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cTextBox.gridx = 1;
		cTextBox.gridy = 4;
		panelUnosPodataka.add(unosKontaktTelefon, cTextBox);
		
		unosEmailAdresa = new JTextField();
		unosEmailAdresa.setToolTipText("Unesite email adresu profesora.");
		unosEmailAdresa.setMinimumSize(new Dimension(200, 20));
		unosEmailAdresa.setPreferredSize(new Dimension(200, 25));
		unosEmailAdresa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[5])
					unosEmailAdresa.setBackground(Color.WHITE);
				else
					unosEmailAdresa.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 5;
		panelUnosPodataka.add(unosEmailAdresa, cTextBox);
		
		unosAdresaKancelarije = new JTextField();
		unosAdresaKancelarije.setToolTipText("Unesite adresu kancelarije profesora.");
		unosAdresaKancelarije.setMinimumSize(new Dimension(200, 20));
		unosAdresaKancelarije.setPreferredSize(new Dimension(200, 25));
		unosAdresaKancelarije.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[6])
					unosAdresaKancelarije.setBackground(Color.WHITE);
				else
					unosAdresaKancelarije.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 6;
		panelUnosPodataka.add(unosAdresaKancelarije, cTextBox);
		
		unosBrojLicneKarte = new JTextField();
		unosBrojLicneKarte.setToolTipText("Unesite broj li\u010dne karte profesora.");
		unosBrojLicneKarte.setMinimumSize(new Dimension(200, 20));
		unosBrojLicneKarte.setPreferredSize(new Dimension(200, 25));
		unosBrojLicneKarte.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[7])
					unosBrojLicneKarte.setBackground(Color.WHITE);
				else
					unosBrojLicneKarte.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cTextBox.gridx = 1;
		cTextBox.gridy = 7;
		panelUnosPodataka.add(unosBrojLicneKarte, cTextBox);
		
		unosTitula = new JTextField();
		unosTitula.setToolTipText("<html>Unesite titulu profesora. <br> npr. dr </html>");
		unosTitula.setMinimumSize(new Dimension(200, 20));
		unosTitula.setPreferredSize(new Dimension(200, 25));
		unosTitula.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[8])
					unosTitula.setBackground(Color.WHITE);
				else
					unosTitula.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cTextBox.gridx = 1;
		cTextBox.gridy = 8;
		panelUnosPodataka.add(unosTitula, cTextBox);
		
		unosZvanje = new JTextField();
		unosZvanje.setToolTipText("<html>Unesite zvanje profesora. <br> npr. redovni profesor </html>");
		unosZvanje.setMinimumSize(new Dimension(200, 20));
		unosZvanje.setPreferredSize(new Dimension(200, 25));
		unosZvanje.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[9])
					unosZvanje.setBackground(Color.WHITE);
				else
					unosZvanje.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 9;
		panelUnosPodataka.add(unosZvanje, cTextBox);
		
		panelUnosPodataka.setBackground(new Color(240, 240, 240));
		
		dugmePotvrda = new JButton("Potvrda");
		dugmePotvrda.setBackground(Color.WHITE);
		dugmePotvrda.setEnabled(false);
		dugmePotvrda.addActionListener(this);
		dugmePotvrda.setMinimumSize(new Dimension(100,20));
		dugmePotvrda.setPreferredSize(new Dimension(100, 30));
		
		dugmeOdustanak = new JButton("Odustanak");
		dugmeOdustanak.setBackground(Color.WHITE);
		dugmeOdustanak.addActionListener(this);
		dugmeOdustanak.setMinimumSize(new Dimension(100,20));
		dugmeOdustanak.setPreferredSize(new Dimension(100, 30));
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setMinimumSize(new Dimension(screenDimension.width/4, 70));
		panelCenter.setPreferredSize(new Dimension(screenDimension.width/4, 80));
		
		
		
		cDugmad = new GridBagConstraints();
		cDugmad.gridx = 0;
		cDugmad.gridy = 0;
		cDugmad.insets=new Insets(20,40,20,40);
		panelCenter.add(dugmeOdustanak, cDugmad);
		cDugmad.gridx = 1;
		cDugmad.gridy = 0;
		panelCenter.add(dugmePotvrda, cDugmad);
		panelCenter.setBackground(new Color(240, 240, 240));
		

		JPanel prikaz = new JPanel();
		prikaz.setPreferredSize(new Dimension(460,480));
		prikaz.setBackground(new Color(240, 240, 240));
		prikaz.add(panelUnosPodataka, BorderLayout.NORTH);
		prikaz.add(panelCenter, BorderLayout.SOUTH);
		
		JScrollPane scroll = new JScrollPane(prikaz);
		
		this.add(scroll);
		
	}

	private Boolean proveriUnos() {
		ime = unosIme.getText();
	 	prezime = unosPrezime.getText();
	 	datumRodjenja = unosDatumRodjenja.getText();
		adresaStanovanja = unosAdresaStanovanja.getText();
		kontaktTelefon = unosKontaktTelefon.getText();
		emailAdresa = unosEmailAdresa.getText();
		adresaKancelarije = unosAdresaKancelarije.getText();
		brojLicneKarte = unosBrojLicneKarte.getText();
		titula = unosTitula.getText();
		zvanje = unosZvanje.getText();
		
		if(ime.matches("[\\p{L} ]+")) 
			uslovi[0] = true;
		else
			uslovi[0] = false;
		if(prezime.matches("[\\p{L} ]+"))
			uslovi[1] = true;
		else
			uslovi[1] = false;
		if(datumRodjenja.matches("0?([1-9]|[12][0-9]|3[01])\\.0?([1-9]|1[012])\\.(19|20)[0-9][0-9]\\."))
			uslovi[2] = true;
		else
			uslovi[2] = false;
		if(adresaStanovanja.matches("[\\p{L} , 0-9]+"))
			uslovi[3] = true;
		else
			uslovi[3] = false;
		if(kontaktTelefon.matches("[0-9 /+-]+"))
			uslovi[4] = true;
		else
			uslovi[4] = false;
		if(emailAdresa.matches("[A-Za-z0-9][a-zA-Z_.0-9]+@[a-zA-Z_.0-9]+"))
			uslovi[5] = true;		
		else
			uslovi[5] = false;
		if(adresaKancelarije.matches("[\\p{L} , 0-9]+"))
			uslovi[6] = true;
		else
			uslovi[6] = false;
		if(brojLicneKarte.matches("[0-9]{9}"))
			uslovi[7] = true;
		else
			uslovi[7] = false;
		if(titula.matches("[\\p{L} .-/]+"))
			uslovi[8] = true;
		else
			uslovi[8] = false;
		if(zvanje.matches("[\\p{L} .-/]+"))
			uslovi[9] = true;
		else
			uslovi[9] = false;
		return (uslovi[0] && uslovi[1] && uslovi[2] && uslovi[3] && uslovi[4] && uslovi[5] && uslovi[6] && uslovi[7] && uslovi[8] && uslovi[9]);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == dugmeOdustanak) {
			setVisible(false);
		}
		 	if (clicked == dugmePotvrda) {
			
		 		Profesor p = new Profesor();
		 		p.setIme(ime);
		 		p.setPrezime(prezime);
		 		
		 		DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
				df.setLenient(false);
				Date datum = null;
				try {
					datum = df.parse(datumRodjenja);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		 		
		 		p.setDatumRodjenja(datum);
				p.setAdresaStanovanja(adresaStanovanja);
				p.setKontaktTelefon(kontaktTelefon);
				p.setEmailAdresa(emailAdresa);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setBrojLicneKarte(brojLicneKarte);
				p.setTitula(titula);
				p.setZvanje(zvanje);
		 		if(izmena) {
		 			if(!ProfesoriKontroler.getInstance().izmeniProfesora(vrsta,p))
		 				JOptionPane.showMessageDialog(null, "Doslo je do greske pri izmeni profesora!", "Greska", JOptionPane.ERROR_MESSAGE);
		 		}
		 		else {
		 			if(!ProfesoriKontroler.getInstance().dodajProfesora(p))
		 				JOptionPane.showMessageDialog(null, "Uneti broj licne karte vec postoji u bazi podataka!", "Greska", JOptionPane.ERROR_MESSAGE);
		 		}
			setVisible(false);
		}

	}
}
