import java.text.SimpleDateFormat;
import java.util.Date;

public class Eveniment extends BaseObject 
{
    private String numeEveniment;
    private Date data;
	public static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

    public Eveniment(String numeEveniment, Date data){
    	super();
        this.numeEveniment = numeEveniment;
        this.data = data;
    }

    public String getNumeEveniment() {
    	return numeEveniment;
    }
    public Date getDataEveniment() {
    	return data;
    }
    
    public void setNumeEveniment(String numeEvent) {
    	this.numeEveniment = numeEvent;
    }
    public void setDataEveniment(Date data) {
    	this.data = data;
    }
    
    @Override
    public String toString () {
    	return String.format("%s,%s\n", numeEveniment, formatter.format(this.data));
    }
}
