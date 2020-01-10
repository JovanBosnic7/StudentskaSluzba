package komponente;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
public class HelpDijalog extends JDialog{

	private static final long serialVersionUID = 1308038538348628940L;

	public HelpDijalog() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(screenDimension.width / 4, screenDimension.height / 2);
		this.setTitle("Help");
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
		
		String text = "-Aplikacija Studentska slu\u017eba namenjena je za vo\u0111enje evidencije o studentima, "
				+ "profesorima i predmetima u okviru fakulteta.\r\n" + 
				"-Glavni prozor aplikacije sa\u010dinjen je od menija, alatne trake i prikaza"
				+ " podataka koji se menjaju u zavisnosti od toga na kojoj se trenutno kartici nalazimo.\n";
		
		JTextPane textPane = new JTextPane();
		textPane.setText(text);
		textPane.setEditable(false);
	
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
		this.setVisible(true);

	}
}
