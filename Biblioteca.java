import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

//import jdk.internal.jshell.tool.resources.version;
//import jdk.nashorn.api.tree.Tree;

public class Biblioteca extends BaseObject{

	private String nume;

	private ArrayList<Personal> persoane;
	private ArrayList<Autor> autori;
	private ArrayList<Cititor> cititori;
	private ArrayList<Eveniment> evenimente;
	private ArrayList<Imprumut> imprumuturi;
	
	private Dictionary<TipuriDeProduse, List<Produs>> produse; 

	public Biblioteca(String nume) {
		super();
		this.nume = nume;
		this.persoane = new ArrayList<Personal>();
		this.autori = new ArrayList<Autor>();
		this.cititori = new ArrayList<Cititor>();
		this.evenimente = new ArrayList<Eveniment>();
		this.imprumuturi = new ArrayList<Imprumut>();
		this.produse = new Hashtable<TipuriDeProduse, List<Produs>>();
		this.produse.put(TipuriDeProduse.Book, new ArrayList<Produs>());
		this.produse.put(TipuriDeProduse.AudioBook, new ArrayList<Produs>());
		this.produse.put(TipuriDeProduse.Filme, new ArrayList<Produs>());
	}

	public String getNumeBiblioteca() {
		return nume;
	}

	public void setNumeBiblioteca(String nume) {
		this.nume = nume;
	}

	// Metode pentru Imprumut
	public void addImprumut(Imprumut imp) {
		imprumuturi.add(imp);
	}

	public void adaugaProdusNou(Produs newProdus) {
		this.produse.get(newProdus.tipProdus).add(newProdus);
	}
	
	public Produs getProdus (int id, TipuriDeProduse t) {
		if (this.produse.get(t) == null) {
			return null;
		}
		for(Produs produs : this.produse.get(t)){
			if(produs.id == id){
				return produs;
			}
		}
		return null;
	}
	
	public Produs getProdus (String titlu, TipuriDeProduse t) {
		for(Produs produs : this.produse.get(t)){
			if(produs.titlu.equals(titlu)){
				return produs;
			}
		}
		return null;
	}
	
	public void stergeProdus(int id, TipuriDeProduse t) {		
		Produs produs = getProdus(id, t);
		
		produse.get(t).remove(produs);
	}

	public boolean AddPersonal(String nume, String responsabilitati) {
		try {
			List<String> res = Arrays.asList(responsabilitati.split(","));    
			Personal p = new Personal(nume, res);
			persoane.add(p);
			return true;
		}
		catch(Exception ex) {
			//Log Exception if needed 
			return false;
		}
	}
	
	public Autor getAutor(String numeAutor) {
		for(Autor autor : this.autori){
			if(autor.numeAutor.equals(numeAutor)){
				return autor;
			}
		}
		return null;
	}

	public boolean AddAutor(String nume) {
		try {
			Autor a = new Autor(nume);
			autori.add(a);
			return true;
		}
		catch(Exception ex) {
			//Log Exception if needed 
			return false;
		}
	}

	public boolean AddCarte(String titlu, int cantitate, String numeAutor, float rating, String sectiune, String errors) {
		try {
			Autor autor = getAutor(numeAutor);
			if(autor == null) {
				System.out.println("Autorul nu a fost gasit");
				return false;
			}
			Carte carte = new Carte(titlu, cantitate, rating, autor, sectiune);
			this.adaugaProdusNou(carte);
			
			return true;
		}
		catch(Exception ex) {
			//Log Exception if needed
			System.out.println("Exceptie");
			return false;
		}
	}

	public boolean AddAudioBook(String titlu, float rating, String numeAutor, String sectiune, int lungime){
		try{
			Autor autor = this.getAutor(numeAutor);
			if(autor == null){
				System.out.println("Autorul nu a fost gasit");
				return false;
			}
			AudioBook audiobook = new AudioBook(titlu, rating, autor, sectiune, lungime);
			this.adaugaProdusNou(audiobook);
			return true;
		} catch (Exception e) {
			//Log Exception if needed
			return false;
		}
	}

	public boolean AddFilm(String titlu, String numeRegizor, float rating, String sectiune, int lungime, String errors) {
		try {
			Film film = new Film(titlu, rating, numeRegizor, sectiune, lungime);
			this.adaugaProdusNou(film);
			
			return true;
		}
		catch(Exception ex) {
			//Log Exception if needed 
			return false;
		}
	}

	public boolean AddEveniment(String numeEveniment, String data, String errors) {
		try {
			
			Date date = Eveniment.formatter.parse(data);
			
			Eveniment ev = new Eveniment(numeEveniment, date);
			this.evenimente.add(ev);
			
			return true;
		}
		catch(Exception ex) {
			//Log Exception if needed 
			return false;
		}
	}

	public void AddCititor(String nume){
		Cititor cititor = new Cititor(nume);
		this.cititori.add(cititor);
	}

	public List<Produs> getAllProdus (TipuriDeProduse t) {
		return this.produse.get(t);
	}

	public List<Eveniment> getAllEvents() {	
		return evenimente;
	}

	public Eveniment getEveniment(String numeEveniment, String errors) {
		for(Eveniment eveniment : this.evenimente){
			if(eveniment.getNumeEveniment().equals(numeEveniment)){
				return eveniment;
			}
		}
		return null;
	}

	public ArrayList<Personal> getPersoane() {
		return persoane;
	}

	public ArrayList<Autor> getAutori() {
		return autori;
	}

	public ArrayList<Cititor> getCititori() {
		return cititori;
	}

	public ArrayList<Eveniment> getEvenimente() {
		return evenimente;
	}

	public ArrayList<Produs> getCarti(){
		return (ArrayList) produse.get(TipuriDeProduse.Book);
	}

	public ArrayList<Produs> getFilme(){
		return (ArrayList) produse.get(TipuriDeProduse.Filme);
	}

	public ArrayList<Produs> getAudioBooks(){
		return (ArrayList) produse.get(TipuriDeProduse.AudioBook);
	}
}