package LSTMLearning;

import org.deeplearning4j.models.embeddings.wordvectors.WordVectorsImpl;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.DataSetPreProcessor;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import word2vec.Word2Vectors;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by lj-18 on 2016/12/5.
 */
public class Word2VecIterator implements DataSetIterator {

    public Word2VecIterator(int miniBatchSize,int exampleLength) throws FileNotFoundException {
        Word2Vectors word2Vectors = new Word2Vectors();
        WordVectorsImpl word2Vec = word2Vectors.loadExistingModel();
    }
    @Override
    public DataSet next(int num) {
        return null;
    }

    @Override
    public int totalExamples() {
        return 0;
    }

    @Override
    public int inputColumns() {
        return 0;
    }

    @Override
    public int totalOutcomes() {
        return 0;
    }

    @Override
    public boolean resetSupported() {
        return false;
    }

    @Override
    public boolean asyncSupported() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public int batch() {
        return 0;
    }

    @Override
    public int cursor() {
        return 0;
    }

    @Override
    public int numExamples() {
        return 0;
    }

    @Override
    public void setPreProcessor(DataSetPreProcessor preProcessor) {

    }

    @Override
    public DataSetPreProcessor getPreProcessor() {
        return null;
    }

    @Override
    public List<String> getLabels() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public DataSet next() {
        return null;
    }
}
