import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

import java.util.*;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		Dictionary<Integer,String> commands = new Hashtable<Integer,String>();
		commands.put(1, "Adauga Personal");
		commands.put(2, "Adauga Autori");
		commands.put(3, "Adauga Carti");
		commands.put(4, "Adauga Eveniment");
		commands.put(5, "Adauga Filme");
		commands.put(6, "Adauga AudioBook");
		commands.put(7, "Adauga cititor");
		commands.put(8, "Vizualizeaza Carti");
		commands.put(9, "Vizualizeaza Evenimente");
		commands.put(10, "Cauta eveniment");
		commands.put(11, "Cauta carte");
		commands.put(12, "Sterge carte");
		commands.put(13, "Import biblioteca");
		commands.put(14, "Export biblioteca");
		commands.put(-1, "Inchide sistem");

	

		Biblioteca biblioteca = new Biblioteca("Lupu Library");
		//cititor
		//AudioBook
		StringBuilder sb = new StringBuilder();
		sb.append("1. Adauga Personal\n");
		sb.append("2. Adauga Autori \n");
		sb.append("3. Adauga Carti\n");
		sb.append("4. Adauga Eveniment\n");
		sb.append("5. Adauga Filme\n");
		sb.append("6. Adauga AudioBook\n");
		sb.append("7. Adauga cititor\n");
		sb.append("8. Vizualizeaza Carti\n");
		sb.append("9. Vizualizeaza Evenimente\n");
		sb.append("10. Cauta eveniment\n");
		sb.append("11. Cauta carte \n");
		sb.append("12. Sterge carte \n");
		sb.append("13. Import biblioteca \n");
		sb.append("14. Export biblioteca \n");
		sb.append("-1. Inchide sistem \n");

		String meniu = sb.toString();

		try{
			FileWriter fw = new FileWriter("Audit.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

		

			while(true) {
				System.out.println(meniu);
				
				Scanner input = new Scanner(System.in);
				
				if(!input.hasNextInt()) {
					continue;
				}
				
				String value = input.nextLine();
				int val = Integer.parseInt(value);
				
				switch(val) {  
					case -1: {
						System.out.println("Have a nice day!\n");
						input.close();
						out.close();
						return;
					}
					case 1: {
						System.out.println("Nume personal:\n");
						String nume = input.nextLine();
						
						System.out.println("Responsabilitati separate prin virgula:\n");
						String res = input.nextLine();
						
						boolean success = biblioteca.AddPersonal(nume, res);
						if(!success) {
							System.out.println(String.format("%s a fost pierdut pe drum :(\n", nume));
						}
						else {
							System.out.println(String.format("%s a fost inserat cu succes!\n", nume));
						}
						break;
					}
					case 2: {
						System.out.println("Nume Autor:\n");
						String nume = input.nextLine();
						
						boolean success = biblioteca.AddAutor(nume);
						if(!success) {
							System.out.println(String.format("%s a fost pierdut pe drum :(\n", nume));
						}
						else {
							System.out.println(String.format("%s a fost inserat cu succes!\n", nume));
						}
						break;
					}
					case 3: {
						System.out.println("Titlu Carte:\n");
						String titlu = input.nextLine();
						
						System.out.println("Autor Carte:\n");
						String numeAutor = input.nextLine();
						
						System.out.println("Cantitate:\n");
						int cantitate = input.nextInt();
						
						System.out.println("Rating:\n");
						float rating = input.nextFloat();
						input.nextLine();
						System.out.println("Sectiune:\n");
						String sectiune= input.nextLine();
						
						String erori = "";
						boolean success = biblioteca.AddCarte(titlu, cantitate, numeAutor, rating, sectiune, erori);
						
						if(!success) {
							if(erori.isEmpty())
								System.out.println(String.format("%s a fost pierdut pe drum :(\n", titlu));
							System.out.println(erori);
						}
						else {
							System.out.println(String.format("%s a fost inserat cu succes!\n", titlu));
						}
						break;
					}
					case 4: {
						System.out.println("Nume Eveniment:\n");
						String numeEveniment = input.nextLine();
						
						System.out.println("Data yyyy-MM-dd:\n");
						String data = input.nextLine();
										
						String erori = "";
						boolean success = biblioteca.AddEveniment(numeEveniment, data, erori);
						
						if(!success) {
							if(erori.isEmpty())
								System.out.println(String.format("%s a fost pierdut pe drum :(\n", numeEveniment));
							System.out.println(erori);
						}
						else {
							System.out.println(String.format("%s a fost inserat cu succes!\n", numeEveniment));
						}
						break;
					}
					case 5: {
						System.out.println("Titlu Film:\n");
						String titlu = input.nextLine();
						
						System.out.println("Regizor film:\n");
						String numeRegizor = input.nextLine();
						
						System.out.println("Rating:\n");
						float rating = input.nextFloat();
						
						System.out.println("Lungime:\n");
						int lungime = input.nextInt();

						input.nextLine();
						System.out.println("Sectiune:\n");
						String sectiune= input.nextLine();
						
						String erori = "";
						boolean success = biblioteca.AddFilm(titlu, numeRegizor, rating, sectiune, lungime,erori);
						
						if(!success) {
							if(erori.isEmpty())
								System.out.println(String.format("%s a fost pierdut pe drum :(\n", titlu));
							System.out.println(erori);
						}
						else {
							System.out.println(String.format("%s a fost inserat cu succes!\n", titlu));
						}
						break;
					}
					case 6: {
						System.out.println("Titlu:\n");
						String titlu = input.nextLine();

						System.out.println("Rating:\n");
						float rating = input.nextFloat();

						input.nextLine();
						System.out.println("Nume autor:\n");
						String numeAutor = input.nextLine();

						System.out.println("Sectiune:\n");
						String sectiune = input.nextLine();

						System.out.println("Lungime:\n");
						int lungime = input.nextInt();

						boolean success = biblioteca.AddAudioBook(titlu, rating, numeAutor, sectiune, lungime);
						if(!success){
							System.out.println(String.format("%s a fost pierdut pe drum :(\n", titlu));
						}
						else{
							System.out.println(String.format("%s a fost inserat cu succes!\n", titlu));
						}
						break;
					}
					case 7: {
						System.out.println("Nume cititor:\n");
						String nume = input.nextLine();

						biblioteca.AddCititor(nume);
						System.out.println(String.format("%s a fost inserat cu succes!\n", nume));
						break;
					}
					case 8: {
						List<Produs> produse = biblioteca.getAllProdus(TipuriDeProduse.Book);
						if(produse.isEmpty()){
							System.out.println("Nu exista carti in biblioteca");
						}
						for(Produs p : produse) {
							Carte c = (Carte)p;
							System.out.println(String.format("Titlu: %s, Autor: %s!\n", c.titlu, c.getAutor()));
						}
						break;
					}
					case 9: {
						List<Eveniment> events = biblioteca.getAllEvents();
						for(Eveniment ev : events) {
							System.out.println(String.format("Nume Eveniment: %s, Data: %s!\n", 
									ev.getNumeEveniment(), Eveniment.formatter.format(ev.getDataEveniment())));
						}
						break;
					}
					case 10: {
						System.out.println("Nume Eveniment:\n");
						String numeEveniment = input.nextLine();
										
						String erori = "";
						Eveniment ev = biblioteca.getEveniment(numeEveniment, erori);
						
						if(ev == null) {
							if(erori.isEmpty())
								System.out.println(String.format("%s a fost pierdut pe drum :(\n", numeEveniment));
							System.out.println(erori);
						}
						else {
							System.out.println(String.format("Evenimentul %s din data %s a fost gasit!\n", 
									ev.getNumeEveniment(), Eveniment.formatter.format(ev.getDataEveniment())));
						}
						break;
					}
					case 11: {
						System.out.println("Nume Carte:\n");
						String numeCarte = input.nextLine();
										
						String erori = "";
						Carte carte = (Carte) biblioteca.getProdus(numeCarte, TipuriDeProduse.Book);
						
						if(carte == null) {
							if(erori.isEmpty())
								System.out.println(String.format("%s a fost pierdut pe drum :(\n", numeCarte));
							System.out.println(erori);
						}
						else {
							System.out.println(String.format("Cartea %s de %s a fost gasita!\n", 
									carte.getTitlu(), carte.getAutor()));
						}
						break;
					}
					case 12: {
						System.out.println("Nume Carte:\n");
						String numeCarte = input.nextLine();
										
						String erori = "";
						Carte carte = (Carte) biblioteca.getProdus(numeCarte, TipuriDeProduse.Book);
						
						if(carte == null) {
							if(erori.isEmpty())
								System.out.println(String.format("%s a fost pierdut pe drum :(\n", numeCarte));
							System.out.println(erori);
						}
						else {
							System.out.println(String.format("Cartea %s de %s a fost gasita!\n", 
									carte.getTitlu(), carte.getAutor()));
							System.out.println("Sunteti sigur/a ca doriti stergerea? (y/n)\n");
							String confirm = input.next();
							if(confirm.equals("y")) {
								biblioteca.stergeProdus(carte.id, TipuriDeProduse.Book);
							}
						}
						break;
					}
					case 13: {
						IOOperations operator = IOOperations.getInstance();
						biblioteca = operator.importCSV();
						if(biblioteca == null){
							System.out.println(":(");
						}
						break;
					}
					case 14: {
						IOOperations operator = IOOperations.getInstance();
						operator.exportCSV(biblioteca);
						break;
					}

					default: 
						break;
				}
				out.println(String.format("%s,%s",commands.get(val),  new Timestamp(System.currentTimeMillis())));
			}
		}
		catch (Exception e){
			System.out.println("OOO....NOOOOO");
		}
			
	}
}
