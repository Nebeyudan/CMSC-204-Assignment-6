
public class Road {
	/**
	 * attributes for the
	 * Weight, Name, Source, Destination for the roads
	 */
	private int weight;
	private String name;
	private Town source;
	private Town dest;
	/**
	 * Paramatize constructor  
	 * @param source the source of the road
	 * @param dest - the final destination of the road
	 * @param weight - the weight of the edge
	 * @param name - name of the edge
	 */
	public Road(Town source, Town dest, int weight, String name) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
		this.name = name;
	}
	/**
	 * same constructor but weight is set to 1
	 * @param source
	 * @param dest
	 * @param name
	 */
	public Road(Town source, Town dest, String name) {
		this.source = source;
		this.dest = dest;
		this.name = name;
		weight = 1;
	}
	public Road(Town source, Town dest, int weigth) {
		this.source = source;
		this.dest = dest;
		this.weight = weigth;
	}
	/**
	 * equals method that compares the destination and source
	 * @param Object r
	 * @return a true or false of whether the two elements are equaled  
	 */
	@Override
	public boolean equals(Object r) {
		return(((Road) r).dest.equals(dest) && ((Road) r).source.equals(source)
				|| ((Road)r).dest.equals(source) && ((Road)r).source.equals(dest));
	}
	/**
	 * checks to see if the towns contains the same name
	 * @param town 
	 * @return return true or false if they have the same name content 
	 */
	public boolean contains(Town town) {
		if(source.getName().equals(town.getName()) || dest.getName().equals(town.getName())) {
			return true;
		}
		else return false;
	}
	/**
	 * @returns a string of the name, weight, source, and destination
	 */
	public String toString() {
		return name + "," + weight + "," + source + "," + dest;
	}
	/**
	 * 
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * 
	 * @return source
	 */
	public Town getSource() {
		return source;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
