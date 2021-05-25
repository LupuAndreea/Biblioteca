import java.util.ArrayList;
import java.util.List;

public class Cititor extends BaseObject {
    
    private String nume;
    private List<Carte> cartiImprumutate;

    public Cititor(String nume){
        super();
        this.setNume(nume);
        this.cartiImprumutate = new ArrayList<Carte>();
    }

    public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void setCarteImprumutata (Carte carte){
        cartiImprumutate.add(carte);
    }

    
    public List<Carte> getCartiImprumutate(){
        return cartiImprumutate;
    }
    
    public void removeCarteImprumutate (int id_carte) {
    	if (cartiImprumutate == null) {
			return;
		}
		
    	Carte carte = cartiImprumutate.stream().filter((el) -> el.id == id_carte).findFirst().orElse(null);
    	
    	if(carte == null) {
    		return;
    	}
    	cartiImprumutate.remove(carte);
    }

    @Override
    public String toString () {
    	StringBuilder sb = new StringBuilder();
    	sb.append(nume);
    	for(Carte c : cartiImprumutate) {
    		sb.append(String.format(",%s", c.getTitlu()));
    	}
    	sb.append("\n");
    	return sb.toString();  
    }
}
