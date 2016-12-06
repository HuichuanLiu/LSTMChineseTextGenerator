package word2vec;


import org.deeplearning4j.models.embeddings.wordvectors.WordVectorsImpl;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by lj-18 on 2016/12/2.
 */
public class test {
    public static void main(String[] args) throws Exception
    {
        testWord2vec();
    }

    public static void testCsvHandler() throws IOException {
        CsvHandler csvHandler = new CsvHandler();
    }

    private static void testWord2vec() throws Exception {
        Word2Vectors word2Vectors = new Word2Vectors();
        word2Vectors.buildWord2Vec();
        WordVectorsImpl wordVec = word2Vectors.loadExistingModel();

        Collection<String> words = wordVec.wordsNearest("我",10);
        int count = 0;
        for(String word:words){
            System.out.print(word+"\t");
            count++;
        }
        System.out.println("\n"+count);
    }
}

