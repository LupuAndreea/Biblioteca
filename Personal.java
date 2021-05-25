import java.util.List;

public class Personal extends BaseObject{

    private String nume;

    private List<String> responsabilitati;

    public Personal(String nume, List<String> responsabilitati){
        super();

        this.nume = nume;
        this.responsabilitati = responsabilitati;
    }

    @Override
    public String toString () {
    	StringBuilder sb = new StringBuilder();
    	sb.append(nume);
    	for(String c : responsabilitati) {
    		sb.append(String.format(",%s", c));
    	}
    	sb.append("\n");
    	return sb.toString();  
    }
}
