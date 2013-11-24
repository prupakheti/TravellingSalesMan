package tsp;

import java.util.Scanner;

/**
 * 
 * @author prupakheti
 * An interface that reads adjacency matrix for a graph.
 *
 */
public interface GraphReader {
	int [][] createAdjMatrix(Scanner sc) throws Exception;
	int getSize();
}
