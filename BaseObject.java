
public abstract class BaseObject {
	private static int id_counter;
	public int id;
	
	public BaseObject() {
		this.id = BaseObject.id_counter++;
	}
	
}
