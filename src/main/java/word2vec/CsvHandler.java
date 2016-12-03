package word2vec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lj-18 on 2016/12/2.
 */
public class CsvHandler {

    public CsvHandler() throws IOException {
        File file = new File("D:/Workspaces/Data/csv4qq1000.csv");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String str = null;

        while((str = bf.readLine())!=null){
            STFNLPTokenizer stfnlpTokenizer = new STFNLPTokenizer(str);
            while(stfnlpTokenizer.hasMoreTokens()){
                System.out.println(stfnlpTokenizer.nextToken());
            }
        }
    }
}
