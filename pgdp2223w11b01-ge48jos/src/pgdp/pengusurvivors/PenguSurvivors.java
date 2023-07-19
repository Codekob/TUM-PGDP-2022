package pgdp.pengusurvivors;


import java.util.ArrayList;

public class PenguSurvivors {

	protected PenguSurvivors() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a model for the matching of workaholics to procrastinators.
	 * 
	 * @param workaholics     array of names/ids of workaholic penguins
	 * @param procrastinators array of names/ids of procrastinating penguins.
	 * @param friendships     relationship between the two groups (each array
	 *                        contains the index of the corresponding workaholic
	 *                        penguin (friendships[i][0]) and the index of the
	 *                        corresponding procrastinating penguin
	 *                        (friendships[i][1]))
	 * @return model for the matching of workaholics to procrastinators
	 */
	public static FlowGraph generateModel(int[] workaholics, int[] procrastinators, int[][] friendships) {
		FlowGraph Matching = new FlowGraph();
		FlowGraph.Vertex s = Matching.addVertex();
		FlowGraph.Vertex t = Matching.addVertex();
		Matching.setSource(s);
		Matching.setSink(t);
		ArrayList<FlowGraph.Vertex> workaholicsVertex = new ArrayList<>();
		ArrayList<FlowGraph.Vertex> procrastinatorVertex = new ArrayList<>();
		for (int w :
				workaholics) {
			FlowGraph.Vertex workaholic = Matching.addVertex("workaholic" + w);
			s.addEdge(workaholic, 1);
			workaholicsVertex.add(workaholic);
		}
		for (int p : procrastinators) {
			FlowGraph.Vertex procrastinator = Matching.addVertex("procastinator" + p);
			procrastinator.addEdge(t, 1);
			procrastinatorVertex.add(procrastinator);
		}
		for (int[] match : friendships
		) {
			FlowGraph.Vertex work = workaholicsVertex.get(match[0]);
			FlowGraph.Vertex pro = procrastinatorVertex.get(match[1]);
			work.addEdge(pro, 1);


		}
		return Matching;
	}

}
