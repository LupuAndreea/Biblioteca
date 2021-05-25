public class Carte extends Produs{
    private Autor autor;
    private String sectiune;

	public Carte(String titlu, int cantitate, float rating, Autor autor, String sectiune) {
		super(TipuriDeProduse.Book, titlu, cantitate, rating);
		
		this.setAutor(autor);
		this.setSectiune(sectiune);
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getSectiune() {
		return sectiune;
	}

	public void setSectiune(String sectiune) {
		this.sectiune = sectiune;
	}    
    
	@Override
    public String toString () {
    	return String.format("%s,%s,%f,%s,%d\n", titlu, autor, rating, sectiune, cantitate);
    }
}
