package utility;
/*
 * FileHandle provides functions related to csv file operation
 * getherFile() reorganize gathers separative csv files
 * clean csv extract comments and star from original csv files
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandler {
	
	BufferedWriter posReviews;
	BufferedWriter negReviews;
	BufferedWriter allReviews;
	int posCount=0;
	int negCount=0;
	int allCount=0;
	
	
	public FileHandler() throws IOException{
	    posReviews = new BufferedWriter(new FileWriter(new File("./src/corpus/posReviews.csv")));
	    negReviews = new BufferedWriter(new FileWriter(new File("./src/corpus/negReviews.csv")));
	    allReviews = new BufferedWriter(new FileWriter(new File("./src/corpus/allReviews.csv")));	
	}
	
	/*
	 * extract targeted comments and start rates from raw csv
	 */
	private void cleanCSV(File file) throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream(file)); 
	    BufferedReader br= new BufferedReader(new InputStreamReader(in,"GBK"));
	    
		String line;
		String sentence;
		String star;
		
		/*
		 * save pos review and neg reviews respectively in posReviews and negReviews
		 * also saved together in allReviews
		 */
		while ( (line = br.readLine()) != null ) {
			System.out.println(line);
			String[] info = line.split("\\|");
			sentence = info[6].trim()+info[7].trim();
			star = info[4].trim().split("sa")[1].trim();
		   
			//System.out.println(sentence+"|"+star);

			allCount++;
			allReviews.write(sentence+"|"+star);
			allReviews.newLine();
			allReviews.flush();
		   
			if(Integer.valueOf(star).intValue()>3){
			   posReviews.write(sentence+"|"+star);
			   posReviews.newLine();
			   posReviews.flush();
			   posCount++;
		   }
		   else if(Integer.valueOf(star).intValue()<3){
			   negReviews.write(sentence+"|"+star);
			   negReviews.newLine();
			   negReviews.flush();
			   negCount++;
		   }
		}
		br.close();
	}
	/*
	 * reorganize gathers separative csv files,saved in posReviews.csv,negReviews.csv and allReviews.csv
	 */
	public void getherFiles() throws IOException{
		//File file = new File("./src/corpus/reviews");
		File file = new File("./src/corpus/subCorpus");
		File[] files = file.listFiles();

		for(File f:files){
			cleanCSV(f);
		}
		System.out.println("File number:"+files.length);
		negReviews.close();
		posReviews.close();
		allReviews.close();
		System.out.println("posReviews:"+posCount+"\t"+"negReviews:"+negCount+"\t"+"allReviews:"+allCount);
	}

}
