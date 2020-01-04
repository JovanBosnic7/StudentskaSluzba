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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kontroler.PredmetiKontroler;
import kontroler.ProfesoriKontroler;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;

public class DijalogZaDodavanjeProfesoraNaPredmet extends JDialog {

	private static final long serialVersionUID = -1193199089270407504L;
	private JLabel labelaLicnaKarta;
	private JButton odustanak;
	private JButton potvrda;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JTextField unosLicneKarte;
	private String brojLicneKarte;
	private int vrsta;
	private Boolean uslov;
	private Profesor profesor;
	
	public DijalogZaDodavanjeProfesoraNaPredmet(int row) {
		
		if(row < 0) {
			JOptionPane.showMessageDialog(null, "Prvo odaberite predmet na kog zelite da dodate profesora!", "Greska", JOptionPane.ERROR_MESSAGE);
			return;
		}
		uslov = false;
		vrsta = TabelaPredmeta.getInstance().convertRowIndexToModel(row);
		Predmet predmet = BazaPredmeta.getInstance().getPredmeti().get(vrsta);
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1 * screenDimension.width / 4, screenDimension.height / 5);
		this.setTitle("Predmet - dodavanje profesora");
		this.setModal(true);
		this.setLocationRelativeTo(MainFrame.getInstance());
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(screenDimension.width/5, 30));
		bottomPanel.setBackground(new Color(240,240,240));
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.WHITE);

		labelaLicnaKarta = new JLabel("Broj licne karte profesora*");
		
		GridBagConstraints gbcUnos = new GridBagConstraints();
		gbcUnos.gridx = 0;
		gbcUnos.gridy = 0;
		gbcUnos.fill = GridBagConstraints.BOTH;
		gbcUnos.insets = new Insets(10,30,30,10);
		centerPanel.add(labelaLicnaKarta, gbcUnos);
		
		unosLicneKarte = new JTextField();
		unosLicneKarte.setPreferredSize(new Dimension(250, 30));
		unosLicneKarte.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				potvrda.setEnabled(proveriUnos());
				if(uslov) {
					unosLicneKarte.setBackground(Color.WHITE);
				}
				else
					unosLicneKarte.setBackground(new Color(255, 166, 166));
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		gbcUnos.gridx = 1;
		gbcUnos.gridy = 0;
		gbcUnos.gridwidth = 2;
		gbcUnos.insets = new Insets(10,30,30,30);
		centerPanel.add(unosLicneKarte, gbcUnos);
		
		odustanak = new JButton("Odustanak");
		odustanak.setPreferredSize(new Dimension(100, 25));
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		GridBagConstraints gbcOdustanak = new GridBagConstraints();
		gbcOdustanak.gridx = 1;
		gbcOdustanak.gridy = 1;
		gbcOdustanak.weightx = 1;
		gbcOdustanak.anchor = GridBagConstraints.EAST;
		gbcOdustanak.insets = new Insets(30, 10, 10, 10);
		centerPanel.add(odustanak, gbcOdustanak);
		
		potvrda = new JButton("Potvrda");
		potvrda.setPreferredSize(new Dimension(100, 25));
		potvrda.setEnabled(false);
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiKontroler.getInstance().dodajProfesora(vrsta, profesor);
				ProfesoriKontroler.getInstance().dodajPredmet(profesor, predmet);
				setVisible(false);
			}
		});
		
		GridBagConstraints gbcPotvrda = new GridBagConstraints();
		gbcPotvrda.gridx = 2;
		gbcPotvrda.gridy = 1;
		gbcPotvrda.weightx = 1;
		gbcPotvrda.insets = new Insets(30, 10, 10, 30);
		gbcPotvrda.anchor = GridBagConstraints.EAST;
		centerPanel.add(potvrda, gbcPotvrda);
		this.add(centerPanel, BorderLayout.CENTER);

	}
	
	private Boolean proveriUnos() {
		brojLicneKarte = unosLicneKarte.getText();
		Boolean povratnaVrednost = false;
		if(brojLicneKarte.matches("[0-9]{9}")) {
			uslov = true;
			profesor = ProfesoriKontroler.getInstance().pronadjiPoBrLicneKarte(brojLicneKarte);
			if(profesor != null)
				povratnaVrednost = true;
		}
		else
			uslov = false;
		
		return povratnaVrednost;
	}
	
}


