package word2vec;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class WordVectors {
    private static Logger log = LoggerFactory.getLogger(WordVectors.class);
    /*
     * build word2vec model from corpus
     */
    public WordVectors() throws Exception {

        log.info("Load & Vectorize Sentences....");
        //load corpus of word2vec, line by line
        SentenceIterator iter = new BasicLineIterator("D:\\Workspaces\\Data\\csv4qq1000.csv");
        //apply Stanford CoreNLP Tokenizer to get separated words and punctuations
        TokenizerFactory t = new STFTokenizerFactory();
        //EmojiPreprocessor removes emojis from raw texts
        t.setTokenPreProcessor(new EmojiPreprocessor());

        log.info("Building model....");
        Word2Vec vec = new Word2Vec.Builder()
                .minWordFrequency(10)
                .iterations(1)
                .layerSize(200) // dimension of produced vectors
                .seed(42) //random seed
                .windowSize(5) // context range
                .iterate(iter)
                .tokenizerFactory(t)
                .build();

        log.info("Fitting Word2Vec model....");
        vec.fit();

        log.info("Writing word vectors to text file....");

        // Write word vectors to file
        WordVectorSerializer.writeWordVectors(vec, "pathToWriteto.txt");

        // Prints out the closest 10 words to "day". An example on what to do with these Word Vectors.
        log.info("Closest Words:");
        Collection<String> lst = vec.wordsNearest("我们", 10);
        System.out.println("10 Words closest to 'day': " + lst);

        // TODO resolve missing UiServer
//        UiServer server = UiServer.getInstance();
//        System.out.println("Started on port " + server.getPort());
    }


}
