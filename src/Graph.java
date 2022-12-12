import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town,Road>{
	/**
	 * the attributes of all the sets and hashSets
	 */
	private Set <Town> t = new HashSet<Town>();
	private Set<Road> r = new HashSet<Road>();
	private Set<Town> closed = new HashSet<>();
	private Set<Town> open = new HashSet<>();
	/**
	 * @return the road for the town whether both destination 
	 * and source exist and is not null
	 * @param Town SourceVertex
	 * @param Town destinationVertex
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road temp = null;
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		for(Road road : r) {
			if(road.contains(destinationVertex) && road.contains(sourceVertex)) {
				temp = road;
			}
		}
		return temp;
	}
	/**
	 * adds a new road with a source and destination and weight
	 * @param Town SourceVertex
	 * @param Town destinationVertex
	 * @param int weight
	 * @param String name
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
			if(sourceVertex == null || destinationVertex == null) {
				throw new NullPointerException();
			}
			if(!t.contains(sourceVertex) || !t.contains(destinationVertex)) {
				throw new IllegalArgumentException();
			}
			try {
				r.add(new Road(sourceVertex,destinationVertex,weight,description));
			} catch(Exception e) {
				return null;
			}
			 return new Road(sourceVertex,destinationVertex,weight,description);
	}
	/**
	 * return true it it has a town and adds the paramater town's 
	 * @param the town being checked
	 * @return true or false if it contains a town
	 */
	@Override
	public boolean addVertex(Town v) {
		if(!t.contains(v)) {
			t.add(v);
			return(true);
		}
		if(v== null) {
			throw new NullPointerException();

		}
		return false;
	}

	/**
	 * Checks if it contains a road and if return true or false if it does
	 * @param Town sourceVertex
	 * @param Town destinationVertex
	 * @return true or false whether or not it contained that road
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		boolean temp = false;
		for(Road road : r) {
			if(road.contains(destinationVertex) && road.contains(sourceVertex)) {
				temp = true;
			}
		}
		return temp;
	}
	/**
	 * checks to see if it contain the certain town
	 * @param Town v 
	 * @return true or false if the set has this town
	 */
	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		return t.contains(v);
	}
	/**
	 * @return the roads set
	 */
	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return r;
	}
	/**
	 * adds each road of the town into a set
	 * @param Town vertex
	 * @return a set of roads for the town
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> e = new HashSet<>();
		if(vertex == null) {
			throw new NullPointerException();
		}
		if(!t.contains(vertex)) {
			throw new IllegalArgumentException();
		}
		for(Road road : r) {
			if(road.contains(vertex)) {
				e.add(road);
			}
		}
		return e;
	}
	/**
	 * checks through a set to see if the it has the same destination and source
	 * and if it does it removes it.
	 * @param Town sourceVertex
	 * @param Town destinationVertex
	 * @param int weight
	 * @param String name
	 * @return the removed road
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		for(Road road : r) {
			if(road.contains(destinationVertex) && road.contains(sourceVertex)) {
				 r.remove(road);
				 return road;
			}
		}
		return null;
	}
	/**
	 * checks if the vertex is removed from the set
	 * @param Town Vertex
	 * @return true or false if that vertex is removed
	 */
	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		return t.remove(v);
	}
	/**
	 * @return the set of towns.
	 *
	 */
	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return t;
	}
	/**
	 *  Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> shortArr = new ArrayList<String>();
		boolean temp = false;
		return null;
	}
	/**
	 *  Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		while(!open.isEmpty()) {
			int minWt = Integer.MAX_VALUE;
			Town minAdjT = null;
			for(Town t : closed) {
				if(t.equals(sourceVertex)) {
					Road road = new Road(sourceVertex, minAdjT, minWt);
					int weight = road.getWeight();
					if(weight < minWt) {
					minWt = weight;
					minAdjT = t;
					
				}
				}
				
			}
		}
		
	}

}
