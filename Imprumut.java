import java.text.SimpleDateFormat;
import java.util.Date;

public class Imprumut {

    private Cititor cititor;
    private Carte carte;
    private boolean isReturned;
    private Date createdDate;
    private Date returnedDate;

	private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    public Imprumut(Cititor cititor, Carte carte){
    	this.cititor = cititor;
    	this.carte = carte;
    	this.cititor.setCarteImprumutata(carte);
    	this.isReturned = false;
    	
    	
    	this.createdDate = new Date(System.currentTimeMillis());
    }
    
    public void returneazaCarte (Cititor cititor, Carte carte) {
    	this.isReturned = true;
    	this.returnedDate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString () {
    	if(this.isReturned ) {
    		return String.format("%s, %s, %s, %s, %s\n", 
    				carte.getTitlu(),
    				carte.getAutor().toString(),
    				cititor.getNume(), 
    				formatter.format(this.createdDate), 
    				formatter.format(this.returnedDate));	
    	}
    	
    	return String.format("%s, %s, %s, %s, \n", 
    			carte.getTitlu(), 
    			carte.getAutor().toString(), 
    			cititor.getNume(), 
    			formatter.format(this.createdDate));
    }

}
