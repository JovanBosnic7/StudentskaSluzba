package komponente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 6498475041649714732L;
	
	private JLabel labela;
	private JLabel datumLab;
	//private JLabel vremeLab;
	
	public StatusBar() {
		this.setLayout(new BorderLayout());
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijeEkrana = toolkit.getScreenSize();
		int sirina = 3*dimenzijeEkrana.width/4;
		this.setPreferredSize(new Dimension(sirina, 30));
		
		this.labela = new JLabel("Studentska služba");
		this.datumLab = new JLabel();
		
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azurirajVreme();
            }
        });
        timer.setInitialDelay(0);
        timer.start();
		
		JPanel levi = new JPanel();
		levi.setPreferredSize(new Dimension(sirina/2, 30));
		JPanel desni = new JPanel();
		desni.setPreferredSize(new Dimension(sirina/2, 30));
		levi.setLayout(new FlowLayout(FlowLayout.LEFT));
		desni.setLayout(new FlowLayout(FlowLayout.RIGHT));
		levi.add(labela);
		this.add(levi, BorderLayout.WEST);
		//desni.add(vremeLab);
		desni.add(datumLab);
		this.add(desni, BorderLayout.EAST);
		
		
	}

	public void azurirajVreme() {
		SimpleDateFormat formatDatuma = new SimpleDateFormat("HH:mm dd.MM.YYYY.");
        datumLab.setText(formatDatuma.format(new Date()));
    }
	
}
