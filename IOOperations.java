import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class IOOperations {

	private static IOOperations instance;
	
	private IOOperations () { }
	
	public static IOOperations getInstance () {
		if(instance == null) {
			instance = new IOOperations();
		}
	
		return instance;
	}
	
	//TODO: Change with overload
	public Biblioteca importCSV() {
		try {
			File file = new File("Biblioteca/biblioteca.csv");
			Scanner scanner = new Scanner(file);
			String numebiblioteca = scanner.nextLine().strip();
			Biblioteca biblioteca = new Biblioteca(numebiblioteca);
			scanner.close();

			file = new File("Biblioteca/Personal.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				// se face split dupa prima virgula deoarece vreau toate resposabilotatile intr-o singura varabila   
				String[] properties = scanner.nextLine().strip().split(",", 2);
				String nume = properties[0];
				String responsabilitati = properties[1];
				biblioteca.AddPersonal(nume, responsabilitati);
			}
			scanner.close();

			file = new File("Biblioteca/Autori.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String nume = scanner.nextLine().strip();
				biblioteca.AddAutor(nume);
			}
			scanner.close();

			file = new File("Biblioteca/Carti.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String[] properties = scanner.nextLine().strip().split(",");
				String titlu = properties[0];
				String autor = properties[1];
				float rating = Float.parseFloat(properties[2]);
				String sectiune = properties[3];
				int cantitate = Integer.parseInt(properties[4]);
				biblioteca.AddCarte(titlu, cantitate, autor, rating, sectiune, "");
			}
			scanner.close();

			file = new File("Biblioteca/AudioBooks.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String[] properties = scanner.nextLine().strip().split(",");
				String titlu = properties[0];
				String autor = properties[1];
				float rating = Float.parseFloat(properties[2]);
				String sectiune = properties[3];
				int lungime = Integer.parseInt(properties[4]);
				biblioteca.AddAudioBook(titlu, rating, autor, sectiune, lungime);
			}
			scanner.close();

			file = new File("Biblioteca/Filme.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String[] properties = scanner.nextLine().strip().split(",");
				String titlu = properties[0];
				String regizor = properties[1];
				float rating = Float.parseFloat(properties[2]);
				String sectiune = properties[3];
				int lungime = Integer.parseInt(properties[4]);
				biblioteca.AddFilm(titlu, regizor, rating, sectiune, lungime, "");
			}
			scanner.close();

			file = new File("Biblioteca/Cititori.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String nume = scanner.nextLine().strip();
				biblioteca.AddCititor(nume);
			}
			scanner.close();

			file = new File("Biblioteca/Evenimente.csv");
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String[] properties = scanner.nextLine().strip().split(",");
				String nume = properties[0];
				String data = properties[1];
				biblioteca.AddEveniment(nume, data, "");
			}
			scanner.close();

			return biblioteca;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
    
	
	//TODO: Change with overload
    public void exportCSV(Biblioteca biblioteca) {
		try {
			// se creaza folderul pentru biblioteca
			File folder = new File("Biblioteca");
			folder.mkdirs();

			// imi creaza fisierul pentru biblioteca
			File file = new File("Biblioteca/biblioteca.csv");

			// se creaza scriitorul 
			PrintWriter writer = new PrintWriter(file);

			// se scrie in fisier numele biblioteci 
			writer.println(biblioteca.getNumeBiblioteca());
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// se face overload pentru exportCSV
		exportCSV("Biblioteca/Personal.csv",  biblioteca.getPersoane());
		exportCSV("Biblioteca/Autori.csv", (List) biblioteca.getAutori());
		exportCSV("Biblioteca/Carti.csv", (List) biblioteca.getCarti());
		exportCSV("Biblioteca/AudioBooks.csv", (List) biblioteca.getAudioBooks());
		exportCSV("Biblioteca/Filme.csv", (List) biblioteca.getFilme());
		exportCSV("Biblioteca/Cititori.csv", (List) biblioteca.getCititori());
		exportCSV("Biblioteca/Evenimente.csv", (List) biblioteca.getEvenimente());
	}

	public void exportCSV(String filename, List<BaseObject> objects){
		try {
			File file =	new File(filename);
			PrintWriter writer = new PrintWriter(file);
			for(BaseObject object : objects){
				writer.print(object.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
