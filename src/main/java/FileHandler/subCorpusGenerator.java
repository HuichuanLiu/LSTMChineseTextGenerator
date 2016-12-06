package FileHandler;

import java.io.*;

/**
 * Created by lj-18 on 2016/12/5.
 */
public class subCorpusGenerator {
    private BufferedReader bfr = new BufferedReader(new FileReader(new File( System.getProperty("user.dir") +"\\qqtest.txt")));
    private BufferedWriter bfw = new BufferedWriter(new FileWriter(new File( System.getProperty("user.dir") +"\\qqtest.txt")));

    public subCorpusGenerator(int lineNum) throws IOException {
        String line;
        int count=0;
        while(!(line=bfr.readLine()).isEmpty()&&count++<lineNum){

        }
    }
}
