
public class Town implements Comparable<Town>{
	/**
	 * attribute for name
	 */
	private String name;
	/**
	 * Paramatize constructor 
	 * @param name
	 */
	public Town(String name) {
		this.name = name;
	}
	/**
	 * Paratize constructor that sets name to temp's name
	 * @param temp
	 */
	public Town(Town temp) {
		name = temp.name;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Compares if the two towns names are equal
	 * @param o - a Town object 
	 */
	@Override
	public int compareTo(Town o) {
		if(this.name.equals(o.name)) {
			return 0;
		}
		else return 1;
	}
	/**
	 * @return name
	 */
	public String toString() {
		return name;
	}
	/**
	 * @return the hashCode
	 */
	public int hashCode() {
		return name.hashCode();
	}
	/**
	 * equals method that comares the two towns names
	 */
	@Override
	public boolean equals(Object o) {
		if(this.name.compareTo(((Town)o).name) ==0) {
			return true;
		}
		else return false;
	}
}
