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

import kontroler.StudentiKontroler;
import model.GodinaStudija;
import model.Status;

public class DodavanjeStudentaDijalog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -2433379998096556754L;

	private JLabel labelaIme;
	private JLabel labelaPrezime;
	private JLabel labelaDatumRodjenja;
	private JLabel labelaAdresaStanovanja;
	private JLabel labelaBrojTelefona;
	private JLabel labelaBrojIndeksa;
	private JLabel labelaGodinaStudija;
	
	private JTextField unosIme;
	private JTextField unosPrezime;
	private JTextField unosDatumRodjenja;
	private JTextField unosAdresaStanovanja;
	private JTextField unosBrojTelefona;
	private JTextField unosBrojIndeksa;

	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String brojTelefona;
	private String brojIndeksa;
	private GodinaStudija godinaStudija;
	private String status;
	
	private JButton dugmePotvrda;
	private JButton dugmeOdustanak;
	private JPanel panelBottom;
	private JPanel panelUnosPodataka;
	private JPanel panelCenter;
	private JRadioButton buttonBudzet;
	private JRadioButton buttonSamofinansiranje;
	private ButtonGroup buttonGroupStatus;
	private JComboBox<GodinaStudija> godStudijaComboBox;

	
	public DodavanjeStudentaDijalog() {
		GridBagConstraints cLabele;
		GridBagConstraints cTextBox;
		GridBagConstraints cDugmad;
		
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
		cTextBox.fill = GridBagConstraints.VERTICAL;
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
		
		labelaBrojIndeksa = new JLabel("Broj indeksa*");
		cLabele.gridx = 0;
		cLabele.gridy = 5;
		panelUnosPodataka.add(labelaBrojIndeksa, cLabele);
		
		labelaGodinaStudija = new JLabel("Trenutna godina studija*");
		cLabele.gridx = 0;
		cLabele.gridy = 6;
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
		cLabele.gridy = 7;
		panelUnosPodataka.add(buttonBudzet, cLabele);
		cLabele.gridx = 0;
		cLabele.gridy = 8;
		panelUnosPodataka.add(buttonSamofinansiranje, cLabele);
		
		unosIme = new JTextField();
		unosIme.setPreferredSize(new Dimension(200, 30));
		
		cTextBox.gridx = 1;
		cTextBox.gridy = 0;
		panelUnosPodataka.add(unosIme, cTextBox);
		
		unosPrezime = new JTextField();
		unosPrezime.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 1;
		panelUnosPodataka.add(unosPrezime, cTextBox);
		
		unosDatumRodjenja = new JTextField();
		unosDatumRodjenja.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 2;
		panelUnosPodataka.add(unosDatumRodjenja, cTextBox);
		
		unosAdresaStanovanja = new JTextField();
		unosAdresaStanovanja.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 3;
		panelUnosPodataka.add(unosAdresaStanovanja, cTextBox);
		
		unosBrojTelefona = new JTextField();
		unosBrojTelefona.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 4;
		panelUnosPodataka.add(unosBrojTelefona, cTextBox);
		
		unosBrojIndeksa = new JTextField();
		unosBrojIndeksa.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 5;
		panelUnosPodataka.add(unosBrojIndeksa, cTextBox);
		
		godStudijaComboBox = new JComboBox<GodinaStudija>();
		godStudijaComboBox.setBackground(Color.WHITE);
		
		godStudijaComboBox.addItem(GodinaStudija.I);
		godStudijaComboBox.addItem(GodinaStudija.II);
		godStudijaComboBox.addItem(GodinaStudija.III);
		godStudijaComboBox.addItem(GodinaStudija.IV);
		godStudijaComboBox.addItem(GodinaStudija.V);
		godStudijaComboBox.setPreferredSize(new Dimension(200, 30));
		cTextBox.gridx = 1;
		cTextBox.gridy = 6;
		panelUnosPodataka.add(godStudijaComboBox, cTextBox);
		panelUnosPodataka.setBackground(new Color(240, 240, 240));
		this.add(panelUnosPodataka, BorderLayout.NORTH);
		
		dugmePotvrda = new JButton("Potvrda");
		dugmePotvrda.setBackground(Color.WHITE);
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
			 	ime = unosIme.getText();
			 	prezime = unosPrezime.getText();
			 	datumRodjenja = unosDatumRodjenja.getText();
				adresaStanovanja = unosAdresaStanovanja.getText();
				brojTelefona = unosBrojTelefona.getText();
				brojIndeksa = unosBrojIndeksa.getText();
				godinaStudija = (GodinaStudija)godStudijaComboBox.getSelectedItem();
				if(buttonGroupStatus.isSelected(buttonBudzet.getModel()))
					status = "B";
				else
					status = "S";
				
				StudentiKontroler.getInstance().dodajStudenta(ime, prezime, datumRodjenja, adresaStanovanja, brojTelefona, brojIndeksa , godinaStudija, Status.valueOf(status));
				
			setVisible(false);
		}

	}
	
	
}
