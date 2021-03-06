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
		
		String text = "<html><body style=\"background-color:#F0F0F0\"> <h1 align =\"center\"> Help </h1>"
				+ "<h2> Aplikacija </h2>"
				+ "<p style = \"font-size:12px\">"
				+ "-<u><b>Aplikacija</u></b> <i>Studentska slu\u017eba </i> namenjena je za vo\u0111enje evidencije o studentima, "
				+ "profesorima i predmetima u okviru fakulteta.<br>" + 
				"-<u><b>Glavni prozor</u></b> aplikacije sa\u010dinjen je od <i>trake menija, alatne trake i "
				+ "prikaza podataka</i> koji se menjaju u zavisnosti od toga na kojoj se trenutno kartici nalazimo."
				+ "<h2> Funkcionalnosti </h2>" 
				+ "</p><p style = \"font-size:12px\">"
				+"-<u><b>Funkcionalnosti aplikacije</u></b> sastoje se u manipulisanju podacima prikazanim u <i>tabelama.</i> <br>"
				+ "<u><b>Dodavanje novog entiteta</u></b> - Dodajemo novi entitet u sistem. Ovoj funkcionalnosti se pristupa iz <i>alatne trake</i> ili <i>trake menija</i>.(detaljnije u nastavku)<br>"
				+ "Dodavanje entiteta se vr\u0161i popunjavanjem odgovaraju\u0107eg dijaloga. Nakon \u010dega mo�emo potvrditi dodavanje ili ga prekinuti.<br>"
				+ "<u><b>Izmena postoje\u0107eg entiteta</u></b> - Menjamo vrednosti postoje\u0107eg entiteta. Ovoj funkcionalnosti se tako\u0111e pristupa iz <i>alatne trake</i> ili <i>trake menija</i>.<br>"
				+ "Izmena entiteta se vr\u0161i pre svega selektovanjem entiteta iz odgovaraju\u0107e tabele, zatim popunjavanjem odgovaraju\u0107eg dijaloga (identi\u010dnog dijalogu za dodavanje). Nakon \u010dega mo�emo potvrditi izmenu ili je odbaciti.<br>"
				+ "<u><b>Brisanje postoje\u0107eg entiteta</u></b> - Bri\u0161emo postoje\u0107i entitet. Ovoj funkcionalnosti se tako\u0111e pristupa iz <i>alatne trake</i> ili <i>trake menija</i>.<br>"
				+ "Brisanje entiteta se vr\u0161i pre svega selektovanjem entiteta iz odgovaraju\u0107e tabele. Nakon \u010dega mo�emo potvrditi brisanje ili odustati.<br>"
				+ "<u><b>Dodavanje studenta na predmet</u></b> - Dodajemo studenta na predmet. Ovoj funkcionalnosti se pristupa iz <i>alatne trake</i> pritiskom dugmeta \"Dodaj studenta na predmet\" (samo na kartici \"Predmeti\")<br>"
				+ "Dodavanje studenta na predmet se vr\u0161i popunjavanjem odgovaraju\u0107eg dijaloga. Nakon \u010dega mo�emo potvrditi dodavanje ili ga prekinuti.<br>"
				+ "<u><b>Dodavanje profesora na predmet</u></b> - Dodajemo profesora na predmet. Ovoj funkcionalnosti se pristupa iz <i>alatne trake</i> pritiskom dugmeta \"Dodaj profesora na predmet\" (samo na kartici \"Predmeti\")<br>"
				+ "Dodavanje profesora na predmet se vr\u0161i popunjavanjem odgovaraju\u0107eg dijaloga. Nakon \u010dega mo�emo potvrditi dodavanje ili ga prekinuti.<br>"
				+ "<h2> Traka menija</h2>" 
				+ "</p><p style = \"font-size:12px\">"
				+"-<u><b>Traka menija</u></b> ima tri menija: <i> File, Edit i Help </i><br>"
				+ "Svi meniji uvek imaju isti izgled, a entitet na koji se konkretna radnja odnosi zavisi od kartice na kojoj se trenutno nalazimo.<br>"
				+ "<u><b>-File</u></b> meni slu\u017ei za dodavanje novog entiteta ili zatvaranje aplikacije. "
				+ "Pre\u010Dica kojom direktno pristupamo ovom meniju je <b>\"Alt+F\"</b> <br>"
				+ "<u>Dodavanje entiteta</u> iz menija se vr\u0161i odabirom stavke menija \"New\". Drugi na\u010din za dodavanje je upotrebom pre\u010dice <b>\"Ctrl+N\"</b>"
				+ "bilo gde u aplikaciji odnosno samo <b>\"N\"</b> ako je meni ve\u0107 otvoren <br>"
				+ "<u>Zatvaranje aplikacije</u> iz menija se vr\u0161i odabirom stavke \"Close\". Pre\u010dica za zatvaranje aplikacije je <b>\"Ctrl+C\"</b> ili samo <b>\"C\"</b> "
				+ "ako je meni ve\u0107 otvoren<br>"
				+ "<u><b>-Edit</u></b> meni slu\u017ei za izmenu ili brisanje postoje\u0107eg entiteta. "
				+ "Pre\u010Dica kojom direktno pristupamo ovom meniju je <b>\"Alt+E\"</b> <br>"
				+ "<u>Izmena entiteta</u> vr\u0161i se odabirom stavke menija \"Edit\". Drugi na\u010din za izmenu je upotrebom pre\u010dice <b>\"Ctrl+E\"</b> "
				+ "bilo gde u aplikaciji odnosno samo <b>\"E\"</b> ako je meni ve\u0107 otvoren. <br>"
				+ "<u>Brisanje entiteta</u> vr\u0161i odabirom stavke menija \"Delete\". Drugi na\u010din za brisanje je upotrebom pre\u010dice <b>\"Ctrl+D\"</b> "
				+ "bilo gde u aplikaciji odnosno samo <b>\"D\"</b> ako je meni ve\u0107 otvoren. <br>"
				+ "<u><b>-Help</u></b> meni slu\u017ei za pomo\u0107 pri kori\u0161\u0107enju aplikacije i prikaz informacija o aplikaciji "
				+ "Pre\u010Dica kojom direktno pristupamo ovom meniju je <b>\"Alt+H\"</b> <br>"
				+ "<u>Pomo\u0107 pri kori\u0161\u0107enju</u> dobija se odabirom stavke menija \"Help\". Drugi na\u010din za pomo\u0107 je upotrebom pre\u010dice <b>\"Ctrl+H\"</b> "
				+ "bilo gde u aplikaciji odnosno samo <b>\"H\"</b> ako je meni ve\u0107 otvoren. <br>"
				+ "<u>Prikaz informacija o aplikaciji</u> dobija se odabirom stavke menija \"About\". Drugi na\u010din za prikaz informacija je upotrebom pre\u010dice <b>\"Ctrl+A\"</b> "
				+ "bilo gde u aplikaciji odnosno samo <b>\"A\"</b> ako je meni ve\u0107 otvoren."
				+ "<h2> Alatna traka</h2>"
				+ "</p><p style = \"font-size:12px\">"
				+ "<u><b>-Alatna traka</u></b> je promenljivog sadr\u017Eaja i menja se u zavisnosti od kartice na kojoj se nalazimo.<br>"
				+ "Upotrebom njenih alata posti\u017Eu se funkcionalnosti aplikacije. <br>"
				+ "-Kada smo na kartici <i>\"Student\" ili na kartici \"Profesor\"</i> alati koji su nam dostupni zavisno od kartice su:<br> "
				+ "Dugme za <b>unos</b> novog studenta/profesora - pre\u010Dica <b>\"Alt+D\"</b> <br> "
				+ "Dugme za <b>izmenu</b> postoje\u0107eg studenta/profesora - pre\u010Dica <b>\"Alt+I\"</b> <br> "
				+ "Dugme za <b>brisanje</b> postoje\u0107eg studenta/profesora - pre\u010Dica <b>\"Alt+B\"</b><br>"
				+ "-Kada smo na kartici <i>\"Predmet\"</i> pored alata za manipulisanje predmetima, imamo i alate za dodavanje drugih entiteta na predmet, alati redom su :<br> "
				+ "Dugme za <b>unos</b> novog predmeta - pre\u010Dica <b>\"Alt+D\"</b> <br> "
				+ "Dugme za <b>izmenu</b> postoje\u0107eg predmeta - pre\u010Dica <b>\"Alt+I\"</b> <br> "
				+ "Dugme za <b>brisanje</b> postoje\u0107eg predmeta - pre\u010Dica <b>\"Alt+B\"</b><br>"
				+ "Dugme za <b>dodavanje</b> studenta na predmet - pre\u010Dica <b>\"Alt+S\"</b><br>"
				+ "Dugme za <b>dodavanje</b> profesora na predmet - pre\u010Dica <b>\"Alt+N\"</b><br>"
				+ "Dugme za <b>brisanje</b> postoje\u0107eg predmeta - pre\u010Dica <b>\"Alt+B\"</b><br>"
				+ "Pored navedenih alata zajedni\u010Dki alat za sve kartice je alat za pretragu entiteta(zavisi od trenutne kartice).<br>"
				+ "Svi navedeni alati sem pretrage pozivaju dijalog pomo\u0107u kog se data funkcionalnost sprovodi u delo.<br>"
				+ "Pretraga se vr\u0161i pritiskom dugmeta \"Pretra\u017ei\"<br>"
				+ "Unos pretrage za studenta je u formatu \"ime:xxx; prezime:xxx; indeks:xxx\". Pretraga je kombinovana. Mo\u017e se vr\u0161iti pretraga po pojedina\u010dnim parametrima, kao i po svim.<br>"
				+ "Unos pretrage za profesora je u formatu \"ime:xxx; prezime:xxx; brLicneKarte:xxx\". Pretraga je kombinovana. Mo\u017e se vr\u0161iti pretraga po pojedina\u010dnim parametrima, kao i po svim.<br>"
				+ "Unos pretrage za predmet je u formatu \"nazivPredmeta:xxx; sifraPredmeta:xxx\". Pretraga je kombinovana. Mo\u017e se vr\u0161iti pretraga po pojedina\u010dnim parametrima, kao i po svim.<br>"
				+ "<h2> Dijalozi</h2>"
				+ "<h2>Student</h2>" 
				+ "</p><p style = \"font-size:12px\">"
				+ "<u><b>-Dijalog za dodavanje studenta </u></b><br>"
				+ "Ovaj dijalog sastoji se iz 8 polja za unos teksta u razli\u010ditim formatima i to: <br>"
				+ "<u>Polje za unos imena </u>- Dozvoljen unos latini\u010dnih slova i razmaka<br>"
				+ "<u>Polje za unos prezimena </u>- Dozvoljen unos latini\u010dnih slova i razmaka<br>"
				+ "<u>Polje za unos datuma ro\u0111enja </u>- Unos je dozvoljen isklju\u010Divo u formatu dd.MM.gggg.<br>"
				+ "<u>Polje za unos adrese stanovanja </u>- Dozvoljen unos latini\u010dnih slova, razmaka, brojeva i zareza<br>"
				+ "<u>Polje za unos broja telefona </u>- Dozvoljen je unos cifara, kao i karaktera \"/\", \"+\"(ako se unosi prefiks dr\u017eave) i \"-\", npr. +38165/1234-567<br>"
				+"<u>Polje za unos email adrese </u>- Dozvoljen unos karaktera iz alfabeta, brojeva, i znakova . i _ uz obavezan @ karakter kao poveznik username-a i domena. "
				+ "Prvi karakter mora biti alfa-numeri\u010dki<br>"
				+ "<u>Polje za unos broja indeksa </u>- Unos je dozvoljen isklju\u010Divo u formatu xx-yyy-zzzz<br>"
				+ "Pritom xx predstavlja oznaku studijskog programa, yyy broj indeksa 1-999 i zzzz godinu upisa <br>"
				+ "<u>Polje za unos datuma upisa </u>- Unos je dozvoljen isklju\u010Divo u formatu dd.MM.gggg.<br>"
				+ "<u>Combobox-a</u> za odabir trenutne godine studija<br>"
				+ "<u>Dva isklju\u010duju\u0107a dugmeta</u> za odabir statusa (bud\u017eet/samofinansiranje)<br>"
				+ "<u>Dugmeta za potvrdu unosa</u><br>"
				+ "<u>Dugmeta za odustanak od unosa</u><br>"
				+ "Sva polja moraju biti validno popunjena i ni jedno ne sme biti prazno ina\u010de je onemogu\u0107ena potvrda unosa.<br>"
				+ "<u><b>-Dijalog za brisanje studenta </u></b><br>"
				+ "Ovaj dijalog sastoji se iz dva dugmeta: <br>"
				+ "<u>Dugmeta za potvrdu brisanja</u><br>"
				+ "<u>Dugmeta za odustanak od brisanja</u><br>"
				+ "<u><b>-Dijalog za izmenu studenta</b></u> ekvivalentan je dijalogu za dodavanje studenta <br>"
				+ "<h2> Profesor</h2>"
				+ "</p><p style = \"font-size:12px\">"
				+ "<u><b>-Dijalog za dodavanje profesora </u></b><br>"
				+ "Ovaj dijalog sastoji se iz 10 polja za unos teksta u razli\u010ditim formatima i to: <br>"
				+ "<u>Polje za unos imena </u>- Dozvoljen unos latini\u010dnih slova i razmaka<br>"
				+ "<u>Polje za unos prezimena </u>- Dozvoljen unos latini\u010dnih slova i razmaka<br>"
				+ "<u>Polje za unos datuma ro\u0111enja </u>- Unos je dozvoljen isklju\u010Divo u formatu dd.MM.gggg.<br>"
				+ "<u>Polje za unos adrese stanovanja </u>- Dozvoljen unos latini\u010dnih slova, razmaka, brojeva i zareza<br>"
				+ "<u>Polje za unos broja telefona </u>- Dozvoljen je unos cifara, kao i karaktera \"/\", \"+\"(ako se unosi prefiks dr\u017eave) i \"-\", npr. +38165/1234-567<br>"
				+"<u>Polje za unos email adrese </u>- Dozvoljen unos karaktera iz alfabeta, brojeva, i znakova . i _ uz obavezan @ karakter kao poveznik username-a i domena. "
				+ "Prvi karakter mora biti alfa-numeri\u010dki<br>"
				+ "<u>Polje za unos adrese kancelarije </u>- Dozvoljen unos latini\u010dnih slova, razmaka, brojeva i zareza<br>"
				+ "<u>Polje za unos broja li\u010dne karte </u>- Dozvoljen isklju\u010divo unos ta\u010dno 9 cifara<br>"
				+ "<u>Polje za unos titule </u>- Dozvoljen unos latini\u010dnih slova i razmaka<br>"
				+ "<u>Polje za unos zvanja </u>- Dozvoljen unos latini\u010dnih slova i razmaka<br>"
				+ "<u>Dugmeta za potvrdu unosa</u><br>"
				+ "<u>Dugmeta za odustanak od unosa</u><br>"
				+ "Sva polja moraju biti validno popunjena i ni jedno ne sme biti prazno ina\u010de je onemogu\u0107ena potvrda unosa.<br>"
				+ "<u><b>-Dijalog za brisanje profesora </u></b><br>"
				+ "Ovaj dijalog sastoji se iz dva dugmeta: <br>"
				+ "<u>Dugmeta za potvrdu brisanja</u><br>"
				+ "<u>Dugmeta za odustanak od brisanja</u><br>"
				+ "<u><b>-Dijalog za izmenu profesora</u></b> ekvivalentan je dijalogu za dodavanje profesora <br>"
				+ "<h2> Predmet</h2>"
				+ "</p><p style = \"font-size:12px\">"
				+ "<u><b>-Dijalog za dodavanje predmeta </u></b><br>"
				+ "Ovaj dijalog sastoji se iz 2 polja za unos teksta u razli\u010ditim formatima i to: <br>"
				+ "<u>Polje za unos \u0161ifre predmeta </u>- Dozvoljen unos alfa-numeri\u010dkih karaktera<br>"
				+ "<u>Combobox-a</u> za odabir semestra u kom se predmet izvodi<br>"
				+ "<u>Combobox-a</u> za odabir godise studija u kojoj se predmet izvodi<br>"
				+ "<u>Dugmeta za potvrdu unosa</u><br>"
				+ "<u>Dugmeta za odustanak od unosa</u><br>"
				+ "<u><b>-Dijalog za brisanje predmeta </u></b><br>"
				+ "Ovaj dijalog sastoji se iz dva dugmeta: <br>"
				+ "<u>Dugmeta za potvrdu brisanja</u><br>"
				+ "<u>Dugmeta za odustanak od brisanja</u><br>"
				+ "Sva polja moraju biti validno popunjena i ni jedno ne sme biti prazno ina\u010de je onemogu\u0107ena potvrda unosa.<br>"
				+ "<u><b>-Dijalog za izmenu predmeta</u></b> ekvivalentan je dijalogu za dodavanje predmeta <br>"
				+ "<u><b>-Dijalog za dodavanje studenta na predmet</u></b><br>"
				+ "Ovaj dijalog sastoji se od polja za unos broja indeksa studenta koga dodajemo <br>"
				+ "<u>Dugmeta za potvrdu dodavanja</u><br>"
				+ "<u>Dugmeta za odustanak od dodavanja</u><br>"
				+ "Ako polje nije validno popunjeno ili ne postoji student sa zadatim brojem indeksa, onemogu\u0107eno je dugme za potvrdu dodavanja.<br>"
				+ "<u><b>-Dijalog za dodavanje profesora na predmet</u></b><br>"
				+ "Ovaj dijalog sastoji se od polja za unos broja li\u010dne karte profesora koga dodajemo <br>"
				+ "<u>Dugmeta za potvrdu dodavanja</u><br>"
				+ "<u>Dugmeta za odustanak od dodavanja</u><br>"
				+ "Ako polje nije validno popunjeno ili ne postoji profesor sa zadatim brojem li\u010dne karte, onemogu\u0107eno je dugme za potvrdu dodavanja.<br>"
				+ "<h2> Prikaz podataka </h2>" 
				+ "</p><p style = \"font-size:12px\">"
				+ "Prikaz podataka se vr\u0161i tabelarno uz pomo\u0107 3 tabele u zavisnosti od odabrane kartice. Tabele su: <br>"
				+ "<u> Tabela studenata </u>- Prikazuje podatke o studentima. Svi podaci osim liste predmeta koje student slu\u0161a prikazani su leksikografski."
				+ "<br> Lista predmeta koje student slu\u0161a dobija se odabirom dugmeta koje se nalazi u poslednjoj koloni tabele studenata.<br>"
				+ "<u> Tabela profesora </u>- Prikazuje podatke o profesorima. Svi podaci osim liste predmeta koje profesor predaje prikazani su leksikografski."
				+ "<br> Lista predmeta koje profesor predaje dobija se odabirom dugmeta koje se nalazi u poslednjoj koloni tabele profesora.<br>"
				+ "<u> Tabela predmeta </u>- Prikazuje podatke o predmetima. Svi podaci osim predmetnog profesora i liste studenata na predmetu prikazani su leksikografski."
				+ "<br> Lista studenata koji poha\u0111aju predmet dobija se odabirom dugmeta koje se nalazi u poslednjoj koloni tabele predmeta."
				+ "<br> Predmetni profesor dobija se odabirom dugmeta koje se nalazi u pretposlednjoj koloni tabele predmeta.<br>"
				+ "<h2> Statusna traka</h2>"
				+ "</p><p style = \"font-size:12px\">"
				+ "<u><b>-Statusna traka</u></b> je fiksnog sadr\u017Eaja i ne menja se u zavisnosti od kartice na kojoj se nalazimo.<br>"
				+ "Na njoj je prikazano ime aplikacije, trenutno vreme i datum. Nalazi se na dnu prozora aplikacije."
				+ "</p></body></html>";
		JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setText(text);
		textPane.setEditable(false);
		textPane.setCaretPosition(0);
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
		this.setVisible(true);

	}
}
