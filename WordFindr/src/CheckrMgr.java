import java.awt.EventQueue;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class CheckrMgr {
   private static boolean needCompile = false;
   public static ConcurrentSkipListSet skippy;
   
   public CheckrMgr() throws IOException {
	   Scanner scn = new Scanner(System.in);
	   
	   Files.walk(Paths.get("src/dict")).forEach(filePath -> {
		   	needCompile = false;
		   	File filey = new File("src/dict/thecache.txt");
		   
		   	if( !filey.exists() || new File(filePath.toString()).lastModified() > filey.lastModified()){
				needCompile = true;
			}
		});
	   
	   if(needCompile){                         
		   File file = new File("src/dict/thecache.txt");
		   //delete the file if it exists
		   if(file.exists()){
			   file.delete();
		   }
			
		   //makes the file 
		   file.createNewFile();
			
		   // writer for the file
		   PrintWriter writer = new PrintWriter(file, "UTF-8");
		   
			
		   Compilr comp = new Compilr();
		   skippy = comp.compile(); //get the words
		   writer.println(skippy.size());
	
		   Iterator it = skippy.iterator();	//using an iterator, because forloops take CENTURIES
		   while(it.hasNext()){
			   writer.println(it.next());
		   }
		  
		   writer.close(); // being a memory smart person
		   System.out.println("Imported " + skippy.size() + " words.");
	   }
	   else{
		   Compilr comp = new Compilr();
		   skippy = comp.read(); // if the cache isn't stale, we can just read it.
		   System.out.println("Imported " + skippy.size() + " words.");
	   }
   }
    public boolean check(String word){
    	if(skippy.contains(word.toLowerCase()))
    		return true;
    	else
    		return false;
    }
   
   /**
    * Launch the application.
    */
   public static void main(String[] args)  throws IOException{
	   CheckrMgr boop = new CheckrMgr();
	   findWords wordFine = new findWords(args, 0, 0);
	   
//	   Scanner scn = new Scanner(System.in);
//	   //old command line way
//	   System.out.println("Type a word!");
//	   while(true){
//		   if(skippy.contains(scn.nextLine().toLowerCase())){
//			   System.out.println("true");
//		   }
//		   else{
//			   System.out.println("false");
//		   }
//	   }
   
	   FrameMane frame = new FrameMane(boop);
    
   }
   
}
    