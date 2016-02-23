import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class findWords {
	public ArrayList<String> dict = new ArrayList<String>();
	private String[][] maze;
	private CheckrMgr checkr;
	
	// Creates maze using inputs, and runs recursive function to 
	public findWords(CheckrMgr checkr, String[] arry, int n, int m){
		this.checkr = checkr;
		int r = 0;
		int c = 0;
		ArrayList<int[]> old;
		int count = 0;
		maze = new String[n][n];
		
		// creates the maze using the given string and n
		for(int a = 0; a < n; a++){
			for(int b = 0; b < n; b++){
				maze[a][b] = arry[count];
				//System.out.print(maze[a][b]);
						count++;
			}
		}
		// recurse is run for every root coordinate pair in the maze
		for(int a = 0; a < n; a++){
			for(int b = 0; b < n; b++){
				dict.addAll(recurse(m, a, b, new boolean[m*n][m*n])); // initialized to oversize to prevent error
				 // primitive boolean arrays are automatically initialized to false
			}
		}
	}
	// Finds all word paths from given coords in maze
	public ArrayList<String> recurse(int m, int r, int c, boolean[][] old){
		ArrayList<String> words = new ArrayList<String>();
		
		//case to invalidate current stack - invalid moves, or no more moves
		if(m <= 0 || r >= maze.length || c >= maze.length || c < 0 || r < 0 || old[r][c])
			return new ArrayList<String>();
		
		// Gets handle on current letter, adds to used coords
		String letter = maze[r][c];
		old[r][c] = true;
		
		// Base case for recursion
		if(m == 1){
			words.add(letter);
			return words;
		}
		
		// calls recurse for all 8 possible directions
		for(int a = r-1; a <= r+1; a++) {
			for(int b = c-1; b <= c+1; b++) {
				ArrayList<String> subwords = recurse(m-1, a, b, copyOf(old)); // gets all recursively generated words
				
				for(String s : subwords) { // for each in subwords, add the current letter
					words.add(letter + s);
				}
			}
		}
		
		return words;
	}
	
	//takes all found word combinations and outputs the real words
	public ArrayList<String> realWords(){
		ArrayList<String> output = new ArrayList<String>();
		for(int a = 0; a < dict.size(); a++){
			if(checkr.check(dict.get(a)) && !output.contains(dict.get(a))){
				output.add(dict.get(a));
			}
		}
		return output;
	}
	
	// creates copy of boolean array so we don't run into stacks editing the same array
	public boolean[][] copyOf(boolean[][] old){
		boolean[][] newbool = new boolean[old.length][];
		for(int a = 0; a < newbool.length; a++){
			newbool[a] = Arrays.copyOf(old[a], old[a].length);
		}
		return newbool;
	}
	
	// Main for testing
	public static void main(String[] args) throws IOException {
		CheckrMgr boop = new CheckrMgr();
		
		String[] test = "nhcaeefse".split("");
	
		findWords find = new findWords(boop, test, 3, 6);
		System.out.println(find.realWords());
	}

}
