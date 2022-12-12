import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	/**
	 * Attribute of the graph 
	 */
	private Graph g = new Graph();
	/** 
	 * adds the a road between the two towns using the 
	 * graphs addEdge method
	 * @param String town1
	 * @param String town2
	 * @param int weight
	 * @param String name
	 * @return true or false whether or not if the road was added and 
	 * was not null
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if(g.addEdge(t1, t2, weight, roadName)!=null) {
			return true;
		}
		else return false;
	}
	/**
	 * @returns the road between the two towns
	 */
	@Override
	public String getRoad(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return g.getEdge(t1, t2).getName();
	}
	/**
	 * create a new town and adds it to the town set
	 * in graph 
	 * @param String v 
	 */
	@Override
	public boolean addTown(String v) {
		Town t = new Town(v);
		if(g.addVertex(t)) {
			return true;
		}
		return false;
	}
	/**
	 * searches through and finds the town with the same name
	 * @param String name
	 * @return the town wit the same name
	 */
	@Override
	public Town getTown(String name) {
		Set<Town> t = g.vertexSet();
		for(Town town : t) {
			if(town.getName().equals(name)) {
				return town;
			}
		}
		return null;
	}
	/**
	 * Checks to see if it has a certain town
	 * @param String v
	 * @returns true or false whether it has that town
	 */
	@Override
	public boolean containsTown(String v) {
		Town t = new Town(v);
		if(g.containsVertex(t)) {
			return true;
		}
		return false;
	}
	/**
	 * checks if the towns have a road connecting them
	 * @param String town1
	 * @param String town2
	 * @return true or false if the roads have a connection
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if(g.containsEdge(t1, t2)) {
			return true;
		}
		return false;
	}
	/**
	 * @return a List of all the roads in the town
	 * 
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList <String > rList = new ArrayList<>();
		for(Road r: g.edgeSet()) {
			String rName = r.getName();
			rList.add(rName);
		}
		Collections.sort(rList);
		return rList;
	}
	
	/**
	 * checks for a certain road between two towns that has been cut off.
	 * @param String town1
	 * @param String town2
	 * @param String road
	 * @return true or false whether the road between the towns is cut off
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if(g.removeEdge(t1, t2, 0, road) != null) {
			return true;
		}
		return false;
	}
	/**
	 * checks for the deleted town and whether
	 * @param String v
	 * @returns true or false if the town is deleted
	 */
	@Override
	public boolean deleteTown(String v) {
		Town t = new Town(v);
		if(g.removeVertex(t)) {
			return true;
		}
		return false;
	}
	/**
	 * @returns a list of all the towns 
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList <String > tList = new ArrayList<>();
		for(Town t: g.vertexSet()) {
			String tName = t.getName();
			tList.add(tName);
		}
		Collections.sort(tList);
		return tList;
	}
	/**
	 * /**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return g.shortestPath(t1, t2);
	}

}
