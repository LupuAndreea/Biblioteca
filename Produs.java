public class Produs extends BaseObject{

	protected String titlu;
	protected int cantitate;
	protected float rating;
	protected TipuriDeProduse tipProdus;
	
	public Produs() {
		super();
	}
	
	public Produs(TipuriDeProduse tipProdus, String titlu, int cantitate, float rating) {
		super();
		this.titlu = titlu;
		this.tipProdus = tipProdus;
		this.cantitate = cantitate;
		this.rating = rating;
	}
	
	public void setTitlu (String titlu) {
		this.titlu = titlu;
	}
	public void setCantitate (int cantitate) {
		this.cantitate = cantitate;
	}
	public void setRating (float rating) {
		this.rating = rating;
	}
	
	public float getRating () {
		return this.rating;
	}
	public int getCantitate () {
		return this.cantitate;
	}
	public String getTitlu () {
		return this.titlu;
	}
}
