package tsp;

import java.io.File;
import java.util.Scanner;

public class TSPDriver {	
	
	int [][]adj;
	int size;	
	
	public void showMatrix(){
		for( int i = 0; i< size; ++i){
			for( int j = 0; j < size; ++j ){
				System.out.print(adj[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public int[][] getAdj(){
		return adj;
	}
	public int size(){
		return size;
	}
	
	public void setAdj(int [][]adj){
		this.adj = adj;
	}
	public void setSize(int size){
		this.size = size;
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		GraphReader graphReader = new MatrixReaderPair();
		if( args.length > 0 ){
			if(args[0] != null && "1".equals(args[0])){
				graphReader = new MatrixReader();
			}
			if(args.length > 1 && args[1] != null){
				try{
					sc = new Scanner(new File(args[1]));
				}
				catch(Exception e){
					sc = new Scanner(System.in);
				}
			}
		}
		
		TSPDriver tspDriver = new TSPDriver();
		tspDriver.setAdj(graphReader.createAdjMatrix(sc));
		tspDriver.setSize(graphReader.getSize());		
		
		
		TSP tsp = new TSP(tspDriver.getAdj(), tspDriver.size());
		
		int opt = tsp.evaluate();
		System.out.println(" Optimat path cost is : "+opt);
		//tsp.showResult();
	}

}
