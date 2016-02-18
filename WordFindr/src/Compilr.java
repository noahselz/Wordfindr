import java.awt.Dimension;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Compilr {
	
	public Compilr() { 
	}
		public ConcurrentSkipListSet compile() throws IOException{
			
			ConcurrentSkipListSet skippy = new ConcurrentSkipListSet();
			
			// file walker goes over all files in the directory
			Files.walk(Paths.get("src/dict")).forEach(filePath -> {
			
				try {
					if (Files.isRegularFile(filePath) && !Files.isHidden(filePath) && !filePath.endsWith("thecache.txt")) {
						// doesn't grab weird files, or the cache itself
						Scanner scn = new Scanner(new File(filePath.toString()));
						while(scn.hasNext()){
							String word = scn.next(); // grabs the next word
							if(!( word.matches(".*\\d+.*"))){ // fancy regex to sanitize for numbers
								skippy.add(word.toLowerCase()); // adds to the skip list, which alphabetizes.
							}
								
						}
					    System.out.println(filePath);
					    
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			return skippy;

	}
	
	public ConcurrentSkipListSet read() throws IOException{
		//just reads the cache file right into the set.
		
		ConcurrentSkipListSet skippy = new ConcurrentSkipListSet();
		Scanner scn = new Scanner(new File("src/dict/thecache.txt"));
		while(scn.hasNext()){
			//String word  = 
			skippy.add(scn.next());
			//System.out.println(word);
		}
		return skippy;
	}

	public static void main(String[] args) throws IOException { // main class for testing to see if it breaks
		Compilr comp = new Compilr();
		ConcurrentSkipListSet skippy = comp.compile();
	}

}
