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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kontroler.StudentiKontroler;
import model.BazaStudenata;
import model.GodinaStudija;
import model.Status;
import model.Student;

public class DodavanjeStudentaDijalog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -2433379998096556754L;

	private JLabel labelaIme;
	private JLabel labelaPrezime;
	private JLabel labelaDatumRodjenja;
	private JLabel labelaAdresaStanovanja;
	private JLabel labelaBrojTelefona;
	private JLabel labelaBrojIndeksa;
	private JLabel labelaGodinaStudija;
	private JLabel labelaEmailAdresa;
	private JLabel labelaDatumUpisa;
	
	private JTextField unosIme;
	private JTextField unosPrezime;
	private JTextField unosDatumRodjenja;
	private JTextField unosAdresaStanovanja;
	private JTextField unosBrojTelefona;
	private JTextField unosBrojIndeksa;
	private JTextField unosEmailAdresa;
	private JTextField unosDatumUpisa;
	
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String brojTelefona;
	private String brojIndeksa;
	private GodinaStudija godinaStudija;
	private Status status;
	private String emailAdresa;
	private String datumUpisa;
	
	private JButton dugmePotvrda;
	private JButton dugmeOdustanak;
	private JPanel panelBottom;
	private JPanel panelUnosPodataka;
	private JPanel panelCenter;
	private JRadioButton buttonBudzet;
	private JRadioButton buttonSamofinansiranje;
	private ButtonGroup buttonGroupStatus;
	private JComboBox<GodinaStudija> godStudijaComboBox;
	private Boolean[] uslovi;
	private Boolean izmena;
	private int vrsta;
	
	
	public DodavanjeStudentaDijalog(int row){
		this();
		if(row < 0) {
			JOptionPane.showMessageDialog(null, "Niste oznacili profesora kojeg zelite da izmenite!", "Greska", JOptionPane.ERROR_MESSAGE);
			return;
		}
		izmena = true;
		vrsta = TabelaStudenata.getInstance().convertRowIndexToModel(row);
		Student s = BazaStudenata.getInstance().getStudenti().get(vrsta);
		unosIme.setText(s.getIme());
		unosPrezime.setText(s.getPrezime());
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
		unosDatumRodjenja.setText(df.format(s.getDatumRodjenja()));
		unosAdresaStanovanja.setText(s.getAdresaStanovanja());
		unosBrojTelefona.setText(s.getKontaktTelefon());
		unosBrojIndeksa.setText(s.getBrojIndeksa());
		unosEmailAdresa.setText(s.getEmailAdresa());
		unosDatumUpisa.setText(df.format(s.getDatumUpisa()));
		
		if(s.getStatusStudenta() == Status.B)
			buttonGroupStatus.setSelected(buttonBudzet.getModel(), true);
		else
			buttonGroupStatus.setSelected(buttonSamofinansiranje.getModel(), true);
		
		godStudijaComboBox.setSelectedItem(s.getTrenutnaGodinaStudija());
	}
	
	public DodavanjeStudentaDijalog() {
		izmena = false;
		GridBagConstraints cLabele;
		GridBagConstraints cTextBox;
		GridBagConstraints cDugmad;
		uslovi = new Boolean[8];
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1 * screenDimension.width / 4, screenDimension.height / 2);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Dodavanje studenta");
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
		
		labelaBrojTelefona = new JLabel("Broj telefona*");
		cLabele.gridx = 0;
		cLabele.gridy = 4;
		panelUnosPodataka.add(labelaBrojTelefona, cLabele);
		
		labelaEmailAdresa = new JLabel("Email*");
		cLabele.gridx = 0;
		cLabele.gridy = 5;
		panelUnosPodataka.add(labelaEmailAdresa, cLabele);
		
		labelaBrojIndeksa = new JLabel("Broj indeksa*");
		cLabele.gridx = 0;
		cLabele.gridy = 6;
		panelUnosPodataka.add(labelaBrojIndeksa, cLabele);
		
		labelaDatumUpisa = new JLabel("Datum upisa*");
		cLabele.gridx = 0;
		cLabele.gridy = 7;
		panelUnosPodataka.add(labelaDatumUpisa, cLabele);
		
		labelaGodinaStudija = new JLabel("Trenutna godina studija*");
		cLabele.gridx = 0;
		cLabele.gridy = 8;
		panelUnosPodataka.add(labelaGodinaStudija, cLabele);
		
		buttonBudzet = new JRadioButton("Budzet");
		buttonSamofinansiranje = new JRadioButton("Samofinansiranje");
		
		buttonBudzet.setBackground(new Color(240, 240, 240));
		buttonSamofinansiranje.setBackground(new Color(240, 240, 240));
		
		buttonGroupStatus = new ButtonGroup();
		buttonGroupStatus.add(buttonBudzet);
		buttonGroupStatus.add(buttonSamofinansiranje);
		
		buttonGroupStatus.setSelected(buttonBudzet.getModel(), true);
		
		cLabele.gridx = 0;
		cLabele.gridy = 9;
		panelUnosPodataka.add(buttonBudzet, cLabele);
		cLabele.gridx = 0;
		cLabele.gridy = 10;
		panelUnosPodataka.add(buttonSamofinansiranje, cLabele);
		
		unosIme = new JTextField();
		unosIme.setToolTipText("<html>" + "Unesite ime studenta." + "<br>" + "Ime mora poceti velikim slovom." + "<br>" + "npr. Pera"+ "</html>");
		unosIme.setPreferredSize(new Dimension(200, 30));
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
		unosPrezime.setToolTipText("<html>" + "Unesite prezime studenta." + "<br>" + "Prezime mora poceti velikim slovom." + "<br>" + "npr. Peric"+ "</html>");
		unosPrezime.setPreferredSize(new Dimension(200, 30));
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
		unosDatumRodjenja.setToolTipText("<html>" + "Unesite datum rodjenja studenta." + "<br>" + "Datum se unosi u formatu dd.MM.GGGG." + "<br>" + "npr. 01.01.1998."+ "</html>");
		unosDatumRodjenja.setPreferredSize(new Dimension(200, 30));
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
		unosAdresaStanovanja.setToolTipText("Unesite adresu stanovanja studenta.");
		unosAdresaStanovanja.setPreferredSize(new Dimension(200, 30));
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
		
		unosBrojTelefona = new JTextField();
		unosBrojTelefona.setToolTipText("<html>" + "Unesite broj telefona studenta." + "<br>" + "Obavezno sa prefiksom drzave." + "<br>" + "npr. +381651234567"+ "</html>");
		unosBrojTelefona.setPreferredSize(new Dimension(200, 30));
		unosBrojTelefona.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[4])
					unosBrojTelefona.setBackground(Color.WHITE);
				else
					unosBrojTelefona.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cTextBox.gridx = 1;
		cTextBox.gridy = 4;
		panelUnosPodataka.add(unosBrojTelefona, cTextBox);
		
		unosEmailAdresa = new JTextField();
		unosEmailAdresa.setToolTipText("Unesite email adresu studenta.");
		unosEmailAdresa.setPreferredSize(new Dimension(200, 30));
		unosEmailAdresa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[6])
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
		
		unosBrojIndeksa = new JTextField();
		unosBrojIndeksa.setToolTipText("<html>" + "Unesite broj indeksa studenta." + "<br>" + "xx-yyy-zzzz" + 
		"<br>" + "xx - oznaka studijskog programa" + "<br>" + "yyy - broj indeksa"+
		"<br>" + "zzzz - godina upisa "+ "<br>" + "npr. ra-1-2020"+ "</html>");
		unosBrojIndeksa.setPreferredSize(new Dimension(200, 30));
		unosBrojIndeksa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[5])
					unosBrojIndeksa.setBackground(Color.WHITE);
				else 
					unosBrojIndeksa.setBackground(new Color(255, 166, 166));
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 6;
		panelUnosPodataka.add(unosBrojIndeksa, cTextBox);
		
		unosDatumUpisa = new JTextField();
		unosDatumUpisa.setToolTipText("<html>" + "Unesite datum upisa studenta." + "<br>" + "Datum se unosi u formatu dd.MM.GGGG." + "<br>" + "npr. 01.01.1998."+ "</html>");
		unosDatumUpisa.setPreferredSize(new Dimension(200, 30));
		unosDatumUpisa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				if(uslovi[7])
					unosDatumUpisa.setBackground(Color.WHITE);
				else
					unosDatumUpisa.setBackground(new Color(255, 166, 166));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cTextBox.gridx = 1;
		cTextBox.gridy = 7;
		panelUnosPodataka.add(unosDatumUpisa, cTextBox);
				
	
		godStudijaComboBox = new JComboBox<GodinaStudija>();
		godStudijaComboBox.setBackground(Color.WHITE);
		godStudijaComboBox.addItem(GodinaStudija.I);
		godStudijaComboBox.addItem(GodinaStudija.II);
		godStudijaComboBox.addItem(GodinaStudija.III);
		godStudijaComboBox.addItem(GodinaStudija.IV);
		godStudijaComboBox.addItem(GodinaStudija.V);
		godStudijaComboBox.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 8;
		panelUnosPodataka.add(godStudijaComboBox, cTextBox);
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
		
		buttonBudzet.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
			}
		});
		
		buttonSamofinansiranje.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
			}
		});
		
		godStudijaComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				dugmePotvrda.setEnabled(proveriUnos());
				
			}
		});
		
		}

	private Boolean proveriUnos() {
		ime = unosIme.getText();
	 	prezime = unosPrezime.getText();
	 	datumRodjenja = unosDatumRodjenja.getText();
		adresaStanovanja = unosAdresaStanovanja.getText();
		brojTelefona = unosBrojTelefona.getText();
		brojIndeksa = unosBrojIndeksa.getText();
		emailAdresa = unosEmailAdresa.getText();
		datumUpisa = unosDatumUpisa.getText();
		
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
		if(adresaStanovanja.matches("[\\p{L} ]+"))
			uslovi[3] = true;
		else
			uslovi[3] = false;
		if(brojTelefona.matches("\\+[0-9]{3}[1-9][1-9][0-9]{6,7}")) 
			uslovi[4] = true;
		else
			uslovi[4] = false;
		if(brojIndeksa.matches("(([a-z][a-z])|([A-Z][A-Z]))\\-([00]?[1-9]|0?[1-9][0-9]|[1-9][0-9][0-9])\\-20[0-9][0-9]"))
			uslovi[5] = true;		
		else
			uslovi[5] = false;
		if(emailAdresa.matches("[A-Za-z0-9][a-zA-Z_.0-9]+@[a-zA-Z_.0-9]+"))
			uslovi[6] = true;		
		else
			uslovi[6] = false;
		if(datumUpisa.matches("0?([1-9]|[12][0-9]|3[01])\\.0?([1-9]|1[012])\\.(19|20)[0-9][0-9]\\."))
			uslovi[7] = true;
		else
			uslovi[7] = false;
		return (uslovi[0] && uslovi[1] && uslovi[2] && uslovi[3] && uslovi[4] && uslovi[5] && uslovi[6] && uslovi[7]);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton) e.getSource();
		
		if (clicked == dugmeOdustanak) {
			setVisible(false);
		}
		 	if (clicked == dugmePotvrda) {
		 		godinaStudija = (GodinaStudija)godStudijaComboBox.getSelectedItem();
				if(buttonGroupStatus.isSelected(buttonBudzet.getModel()))
					status = Status.B;
				else
					status = Status.S;
				
				Student s = new Student();
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setBrojIndeksa(brojIndeksa);
				s.setAdresaStanovanja(adresaStanovanja);
				s.setKontaktTelefon(brojTelefona);
				s.setStatusStudenta(status);
				s.setTrenutnaGodinaStudija(godinaStudija);
				s.setEmailAdresa(emailAdresa);
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
				df.setLenient(false);
				Date datum = null;
				Date datumUpis = null;
				try {
					datum = df.parse(datumRodjenja);
					datumUpis = df.parse(datumUpisa);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				s.setDatumRodjenja(datum);
				s.setDatumUpisa(datumUpis);
				if(izmena == false) {
					if(!StudentiKontroler.getInstance().dodajStudenta(s))
						JOptionPane.showMessageDialog(null, "Uneti broj indeksa vec postoji u bazi podataka!", "Greska", JOptionPane.ERROR_MESSAGE);}
				else {
					if(!StudentiKontroler.getInstance().izmeniStudenta(vrsta, s))
						JOptionPane.showMessageDialog(null, "Doslo je do greske pri izmeni studenta!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				setVisible(false);
		}

	}
	
	
}
