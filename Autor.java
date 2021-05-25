public class Autor extends BaseObject{
	
	public String numeAutor;
	
	public Autor(String nume) {
		super();
		numeAutor = nume;
	}
		
	@Override
    public String toString () {
    	return numeAutor + "\n";
    }
}
