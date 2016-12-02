package word2vec;

import edu.stanford.nlp.ling.CoreLabel;

import java.io.*;
import java.util.List;

/**
 * Created by lj-18 on 2016/12/2.
 */
public class CsvHandler {

    public CsvHandler() throws IOException {
        File file = new File("D:/Workspaces/Data/csv4qq1000.csv");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String str = null;

        STFNLP stfnlp = new STFNLP();
        while((str = bf.readLine())!=null){
            List<CoreLabel> listC = stfnlp.posTag(str);
            for(CoreLabel coreLable:listC){
                System.out.println(stfnlp.getWord(coreLable)+" ");
            }
        }
    }

    public void printLineByLine(){

    }
}
