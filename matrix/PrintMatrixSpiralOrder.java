package programming.matrix;

public class PrintMatrixSpiralOrder {

	/**
	 * Suppose the matrix is,
	 * int[][] myArray = { 
	 * {0, 1, 2, 3}, 
	 * {4, 5, 6, 7}, 
	 * {8, 9, 10,11}, 
	 * {12,13,14,15}};  
	 * 
	 * We need to print in spiral form
	 * 
	 * https://www.youtube.com/watch?v=siKFOI8PNKM
	 */
	
	enum Direction {
		LEFT,RIGHT,UP,DOWN;
	}
	
	public static void printMatrix_clockwiseSpiral_direction(int[][] arr) {
		
		//get the dimensions
		int rows = arr.length;
		int cols = arr[0].length;
		
		//I need 4 pointers here, to point 4 indexes
		//L(eft), R(ight), T(op), B(ottom)
		int L=0,R=cols-1,T=0,B=rows-1;
		//another is Dir(ection)
		Direction dir=Direction.RIGHT; // initially we will start moving towards right
		
		//writing condition here is easy,
		// loop will go as long as L<=R and T<=B
		while (L<=R && T<=B) {
			/*
			 *         L         R
			 * 		T=>{0, 1, 2, 3}, 
					   {4, 5, 6, 7}, 
					   {8, 9, 10,11}, 
					B=>{12,13,14,15}};
					
					output is, 0 1 2 3 7 11 15 14 13 12 8 4 5 6 10 9
			 */
			
			if (dir == Direction.RIGHT) {
				for (int i=L;i<=R;i++) {
					System.out.print(arr[T][i] +"->");
				}
				T++;
				dir = Direction.DOWN;
			}
			
			else if (dir == Direction.DOWN) {
				for (int i=T;i<=B;i++) {
					System.out.print(arr[i][R] +"->");
				}
				R--;
				dir = Direction.LEFT;
			}
			
			else if (dir == Direction.LEFT) {
				for (int i=R;i>=L;i--) {
					System.out.print(arr[B][i] +"->");
				}
				B--;
				dir = Direction.UP;
			}
			
			else if (dir == Direction.UP) {
				for (int i=B;i>=T;i--) {
					System.out.print(arr[i][L] +"->");
				}
				L++;
				dir = Direction.RIGHT;
			}
		}
	}
	
	public static void printMatrix_anticlosewiseSpiral_directon(int[][] arr) {
		//get 4 pointers
		/*
		 *         L         R
		 * 		T=>{0, 1, 2, 3}, 
				   {4, 5, 6, 7}, 
				   {8, 9, 10,11}, 
				B=>{12,13,14,15}};
				
			output is, 3 2 1 0 4 8 12 13 14 15 11 7 6 5 9 10
		 */
		int L=0,R=arr[0].length-1;
		int T=0,B=arr.length-1;
		Direction dir = Direction.LEFT;
		
		while (L<=R && T<=B) {
			if (dir == Direction.LEFT) {
				for (int i=R;i>=L;i--) {
					System.out.print(arr[T][i] + "<-");
				}
				T++;
				dir = Direction.DOWN;
			}
			if (dir == Direction.DOWN) {
				for (int i=T;i<=B;i++) {
					System.out.print(arr[i][L] + "<-");
				}
				L++;
				dir = Direction.RIGHT;
			}
			if (dir == Direction.RIGHT) {
				for (int i=L;i<=R;i++) {
					System.out.print(arr[B][i]+"<-");
				}
				B--;
				dir = Direction.UP;
			}
			if (dir == Direction.UP) {
				for (int i=B;i>=T;i--) {
					System.out.print(arr[i][R]+"<-");
				}
				R--;
				dir = Direction.LEFT;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		 int[][] myArray = { 
				 {0, 1, 2, 3}, 
				 {4, 5, 6, 7}, 
				 {8, 9, 10,11}, 
				 {12,13,14,15}};
		 
		 System.out.println("clockwise printing");
		 printMatrix_clockwiseSpiral_direction(myArray);
		 System.out.println();
		 System.out.println("anti-clockwise printing");
		 printMatrix_anticlosewiseSpiral_directon(myArray);
	}
}
