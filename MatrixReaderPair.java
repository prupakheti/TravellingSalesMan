package tsp;

import java.util.Scanner;

/**
 * 
 * @author prupakheti
 * This class creates the adjacency matrix from the given scanner based on city pairing and the path cost given for each city pair.
 */
public class MatrixReaderPair implements GraphReader{
	private int size;
	private int [][]adj;
	@Override
	public int[][] createAdjMatrix(Scanner sc) throws Exception {
		if( sc == null ) throw new Exception("Invalid data scanner");
		System.out.println(" TSP data console reader. The first line should be entered as the value for the total number of cities. The subsequent line should contain " +
				"triplet< i j w > where w is the distance cost between city i and j");
		String line;
		if(sc.hasNext()){
			try{
				line = sc.nextLine();
				int n = Integer.parseInt(line);
				if( n > 31 || n < 3) throw new Exception("Cities count out of range exception : must be between 3 and 31");
				size = n;
				adj = new int[n][n];
				
				while( true ){
					line = sc.nextLine();
					if("end".equals(line)) break;
					if(line == null || line.trim().equals("") || !validate(line)) continue;	
					
				}
			}			
			catch (Exception e){
				throw new Exception(e.toString());
			}			
			
		}
		return adj;
	}

	@Override
	public int getSize() {		
		return size;
	}
	
	private boolean validate(String line){
		String []tokens = line.split("\\s+");
		
		if(tokens.length != 3) {
			System.out.println(" Invaid entry. Moving on to read next line of data ");
			return false;
		}
		try{
			int i = Integer.parseInt(tokens[0]);
			int j = Integer.parseInt(tokens[1]);
			int w = Integer.parseInt(tokens[2]);
			
			if( i < 0 || i >= size ) {
				System.out.println(" Invalid start index for city. Moving on to read next line of data ");
				return false;
			}
			if( j < 0 || j >= size ) {
				System.out.println(" Invalid end index for city. Moving on to read next line of data ");
				return false;
			}
			if( adj[i][j] > 0 || adj[j][i] > 0){
				System.out.println(" Cost between city "+ i +" and "+ j +" has already been defined.  Moving on to read next line of data ");
				return false;
			}
			if( i == j ){
				System.out.println(" Self cost should be 0 and should not be assigned");
			}
			if( w < 1 || w >= 100 ) {
				System.out.println(" Invalid distance cost between  "+ i + " and  " + j+" Moving on to read next line of data ");
				return false;
			}
			adj[i][j] = w;
			adj[j][i] = w;
		}
		catch(Exception e){
			System.out.println(" Not an integer. Moving on to read next line of data ");
			return false;
		}
		
		
			
		return true;
	}

}
