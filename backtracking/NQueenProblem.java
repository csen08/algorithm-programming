package programming.backtracking;

import java.util.Arrays;

public class NQueenProblem {

	//https://www.geeksforgeeks.org/backtracking-introduction/
	/**
	 * Recursive backtracking solution
	 * void findSolutions(n, other params) :
		    if (found a solution) :
		        solutionsFound = solutionsFound + 1;
		        displaySolution();
		        if (solutionsFound >= solutionTarget) : 
		            System.exit(0);
		        return
		
		    for (val = first to last) :
		        if (isValid(val, n)) :
		            applyValue(val, n);
		            findSolutions(n+1, other params);
		            removeValue(val, n);
	 */
	
	/**
	 * Finding whether a solution exists or not
	 * boolean findSolutions(n, other params) :
		    if (found a solution) :
		        displaySolution();
		        return true;
		
		    for (val = first to last) :
		        if (isValid(val, n)) :
		            applyValue(val, n);
		            if (findSolutions(n+1, other params))
		                return true;
		            removeValue(val, n);
		        return false;
	 */
	
	
	//we will place the queen and check if it is under attack
	//under attack for 3 cases only,
	//1.same row
	//2.same column
	//3.diagonal
	//we will start with empty chess board and set it 1
	
	static boolean is_safe(int[][] board, int x, int y) {//isvalid
		
		for (int i=0; i<board.length; i++) {
			if(board[i][y]==1)
				return false;
		}
		for (int j=0; j<board[x].length; j++) {
			if(board[x][j]==1)
				return false;
		}
		//for each (i,j) if p+q=x+y
//		for (int i=0;i<board.length;i++) {
//			for (int j=0;j<board[i].length;j++) {
//				if ((i+j)==(x+y) && board[i][j]==1) {
//					return false;
//				}
//				if ((i-j)==(x-y) && board[i][j]==1) {
//					return false;
//				}
//			}
//		}
		//above condition can be written as,
		//look at left side only, top and bottom, because we are placing columns from left to right, so we need to check left columns only 
		for (int i=x,j=y; i>=0 && j>=0; i--,j--) {
			if (board[i][j]==1)
			{
				return false;
			}
		}
		for (int i=x,j=y; i<N && j>=0; i++,j--) {
			if (board[i][j]==1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	static final int N=8;
	static int count=0;
	
	public static void main(String[] args) {

		int[][] board = new int[N][N];
		NQueen(board, 0);
		
		System.out.println(count);
	}
	
	
	static boolean NQueen(int[][] board, int q){
		
		if (q == N) {
			count++;
			print(board);
			System.out.println();
			return true;
		}
		boolean res=false;
		for (int i=0;i<N;i++) { //loop over each row, and do recursive call on each column
			
			if (is_safe(board, i, q)) {//[is valid]
				board[i][q]=1;//[apply value]
				
//				if (NQueen(board, q+1))
//					return true;
				res=NQueen(board, q+1)||res;
				
				board[i][q]=0;//[remove value]
			}
		}
		
		return res;
	}
	
	
	private static void print(int[][] board) {
		
		for (int i=0;i<board.length;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
}
