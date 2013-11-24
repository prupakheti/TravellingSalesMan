package tsp;

import java.util.Scanner;

/**
 * This class reads the entire adjacency matrix from the given scanner
 * @author prupakheti
 *
 */
public class MatrixReader implements GraphReader{
	int size;
	int [][]adj;
	@Override
	public int[][] createAdjMatrix(Scanner sc) throws Exception{
		int n;
		System.out.println(" The first line should have an integer value n and  n x n adjacency matrix to follow " +
				"\n For eg for 3 x 3 adj matrix " +
				"\n 3"+
				"\n 0 2 2"+"\n 1 0 3"+"\n 2 3 0");
		try{
			n = Integer.parseInt(sc.nextLine());
			this.size = n;
			this.adj = new int[n][n];
			for( int i = 0; i < n; ++i){
				for( int j = 0; j < n; ++j){
					adj[i][j] = Integer.parseInt(sc.next());
				}
			}
		}
		catch(Exception e ){
			throw new Exception(e.toString());
		}
		return adj;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	

}
