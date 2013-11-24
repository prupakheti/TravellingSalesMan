package tsp;
/**
 * 
 * @author prupakheti
 * This class evaluates the optimal cost for the tour of n cities 0 to n-1 which strts at 0 visits all the city once and finally returns to city 0. Our computation is based
 * on the approach that n can not be more than 31.
 */

public class TSP {
	private int [][]adj;// adjacency matrix for the city graph 
	
	private int N; // size of the adj square matrix
	int R; // total row in cost matrix
	int C; // total column in cost matrix;
	
	private static final int INF = ( 1 << 30); // we are assuming this is the infinity value for the computation	
	
	/**
	 * cost is the cost matrix for the dynamic programming approach. The meaning of cost[i][j] is as follow :
	 * i represents the set of cities. The subset of cities that i represents are those cities indices where the bits in i are set to 1. So if s is the set represented by
	 * integer i, than cost[i][j] means the optimal cost of the tour that begins at 0 and visits all the cities in s ending at j where j is an element of s.
	 */	
 	int cost[][]; 
	
	public TSP(int [][]adj, int n){
		this.adj = adj;
		this.N = n;		
		R = 1 << N; // maximum number of subset is pow(2,n)
		C = N;
		cost = new int[R][C];		
		cost[1][0] = 0; // this is one of the base case. starting from city 0 and not touring any cities has the cost 0.
	}
	
	
	/**
	 * 
	 * @param s : set of integers of indices in s whose bits are set to 1
	 * @param indx : the item to put in set s
	 * @return : a new set that indx added in s
	 */
	private int setPut(int s, int indx){
		s = s | ( 1 << indx);
		return s;
	}
	
	
	/**
	 * 
	 * @param s : set of integers of indices in s whose bits are set to 1
	 * @param indx : the item to delete in set s
	 * @return : a new set that has indx removed from s
	 */
	private int setDel(int s , int indx){		
		int u = -1;
		u = u ^ ( 1 << indx);
		s = s & u ;
		return s;
	}
	
	/**
	 * We are  generating all subset of size ranging from 2 to N.
	 */
	private void generateAllSubset(){
		int set = 1;
		for( int r = 2; r <= N; ++r){
			generateSubset(set, N, r, 1, 1);
		}
	}
	
    /**
     * 
     * @param set : output set
     * @param n : size of the universal set
     * @param r : we want r subset of universal set
     * @param level : we want to decide whether we want to put level item in our r subset n
     * @param size : the total items we have put so far
     */
	private void generateSubset(int set, int n, int r, int level, int size){
		if( size == r ){			
			costCompute(set);
			return;
		}
		if( ( r - size  ) < ( n  - level) ) {
			generateSubset(set, n, r, level + 1, size);
		}
		generateSubset(setPut(set,level), n, r,level+1, size+1);
	}	
	
	/**
	 * 
	 * @param set : set of integers of indices where bits in set are set to 1
	 * 
	 * This method computes the cost for all the tour that starts from 0 visits all the cities in set and saves different path cost for the tour that ends at j 
	 * where j is an item in set and is not 0
	 */
	private void costCompute(int set){
		cost[set][0] = INF;
		for( int j = 0; j < N; ++j ){
			if( j != 0 && ((set >> j) & 0x01)  == 1 ){
				int min = INF;				
				int setMinusJ = setDel(set, j);
				for( int i = 0; i < N; ++i){
					if(  ((setMinusJ >> i ) & 0x01) == 1 ){
						if( min > ( cost[setMinusJ][i]) + adj[i][j] ){
							min = cost[setMinusJ][i] + adj[i][j];							
						}
					}
				}
				cost[set][j] = min;				
			}
		}
	}
	
	/**
	 * 
	 * @return : the optimal tsp tour
	 */
	public int evaluate(){
		generateAllSubset();
		int min = INF;
		
		for( int j = 0; j< N; ++j){
			int t = cost[R-1][j] + adj[j][0];
			if( min > t ){
				min = t;				
			}
		}	
		return min;
	}

}
