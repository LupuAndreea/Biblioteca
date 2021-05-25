import java.util.List;

public class Film extends Produs {

	private String sectiune;
	private String numeRegizor;
	private int lungime;
	
	public Film() {
		super();
	}
   
	public Film(String titlu, float rating, String numeRegizor, String sectiune, int lungime) {
		super(TipuriDeProduse.Filme, titlu, 0, rating);
		
		this.lungime = lungime;
		this.setSectiune(sectiune);
		this.setNumeRegizor(numeRegizor);
	}
	
	public String getSectiune() {
		return sectiune;
	}

	public void setSectiune(String sectiune) {
		this.sectiune = sectiune;
	}

	public String getNumeRegizor() {
		return numeRegizor;
	}

	public void setNumeRegizor(String numeRegizor) {
		this.numeRegizor = numeRegizor;
	}

	public int getLungime() {
		return lungime;
	}

	public void setLungime(int lungime) {
		this.lungime = lungime;
	}
	
	@Override
    public String toString () {
    	return String.format("%s,%s,%f,%s,%d\n", titlu, numeRegizor, rating, sectiune, lungime);
    }
}
