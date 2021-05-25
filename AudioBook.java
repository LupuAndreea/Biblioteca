public class AudioBook extends Produs{

    private Autor autor;
    private String sectiune;
    public int lungime;
    
	public AudioBook(String titlu, float rating,
			Autor autor, String sectiune, int lungime) {
		super(TipuriDeProduse.AudioBook, titlu, 0, rating);
		
		this.lungime = lungime;
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
    	return String.format("%s,%s,%f,%s,%d\n", titlu, autor,rating, sectiune, lungime);
    }
}