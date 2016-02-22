import java.util.ArrayList;
import java.util.Arrays;

public class findWords {
	public ArrayList<String> words = new ArrayList<String>();
	public findWords(String[] arry, int n, int m){
		int r = 0;
		int c = 0;
		ArrayList<int[]> old;
		int count = 0;
		String[][] maze = new String[n][n];
		for(int a = 0; a < n; a++){
			for(int b = 0; b < n; b++){
				maze[a][b] = arry[count];
				System.out.print(maze[a][b]);
						count++;
			}
		}
		//return recurse(maze, m, r, c, old);
//		for(int a = 0; a < n; a++){
//			for(int b = 0; b < n; b++){
//				
//			}
//		}
		
	}
	
	public ArrayList<String> recurse(String[][] puzzle, int m, int r, int c, ArrayList<int[]> old){
		if(m <= 0 || r > puzzle.length || c > puzzle.length || c < 0 || r < 0)
			return new ArrayList<String>();
		String letter = puzzle[r][c];
		int[] temp = {r,c};
		old.add(temp);
		
		if(m == 1){
			
		}
		
		return new ArrayList<String>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = "nhcaeefse".split("");
		//String[] test = {"n","h","c","a", "e", "e", };
		findWords find = new findWords(test,3,3);
	}

}
