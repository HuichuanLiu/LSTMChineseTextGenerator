package word2vec;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectorsImpl;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.models.word2vec.wordstore.VocabCache;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;

public class Word2Vectors {
    private static Logger log = LoggerFactory.getLogger(Word2Vectors.class);
    /*
     * build word2vec model from corpus
     */
    private Word2Vec vec;

    public void buildWord2Vec() throws Exception {

        log.info("Load & Vectorize Sentences....");
        //load corpus of word2vec, line by line
        //SentenceIterator iter = new BasicLineIterator("D:\\Workspaces\\Data\\csv4qq1000.csv");
        //SentenceIterator iter = new BasicLineIterator("D:\\Workspaces\\Data\\spaceText.txt");
        SentenceIterator iter = new BasicLineIterator("D:\\Workspaces\\Data\\qqRecordFull.csv");
        //apply Stanford CoreNLP Tokenizer to get separated words and punctuations
        TokenizerFactory t = new STFTokenizerFactory();
        //EmojiPreprocessor removes emojis from raw texts
        t.setTokenPreProcessor(new EmojiPreprocessor());

        log.info("Building model....");
        vec = new Word2Vec.Builder()
                .minWordFrequency(5)
                .iterations(1)
                .layerSize(100) // dimension of produced vectors
                .seed(42) //random seed
                .windowSize(5) // context range
                .iterate(iter)
                .tokenizerFactory(t)
                .build();

        log.info("Fitting Word2Vec model....");
        vec.fit();

        log.info("Writing word vectors to text file....");

        // Write word vectors to file
        WordVectorSerializer.writeWord2VecModel(vec, "qqtest.txt");
        //WordVectorSerializer.writeWord2VecModel(vec, "spaceTextW2V.txt");
        // Prints out the closest 10 words to "day". An example on what to do with these Word Vectors.
        log.info("Closest Words:");
        //Collection<String> lst = vec.wordsNearest("我", 10);
        //System.out.println("10 Words closest to 'day': " + lst);

        // TODO resolve missing UiServer
//        UiServer server = UiServer.getInstance();
//        System.out.println("Started on port " + server.getPort());
    }

    public void getVectorOf(String word) throws FileNotFoundException {
        VocabCache vocabCache = vec.getVocab();
        //System.out.println(vocabCache.indexOf(word));
    }

    public boolean isBuilt(){
        if(vec!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public WordVectorsImpl loadExistingModel() throws FileNotFoundException {
        String path = System.getProperty("user.dir") +"\\qqtest.txt";
        File file = new File(path);
        boolean a  =file.exists();
        return WordVectorSerializer.readWord2VecModel(file);
        //return WordVectorSerializer.loadStaticModel(file);
    }
}
