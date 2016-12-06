package word2vec;

import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;
import org.deeplearning4j.text.tokenization.tokenizer.Tokenizer;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lj-18 on 2016/12/2.
 */
public class STFTokenizerFactory implements TokenizerFactory {
    private TokenPreProcess tokenPreProcess;
    @Override
    public Tokenizer create(String toTokenize) {
        //STFNLPTokenizer stfnlpTokenizer = null;
        try {
            //stfnlpTokenizer = new STFNLPTokenizer(toTokenize);
            //System.out.println("To tokenize: "+toTokenize);
            return new STFNLPTokenizer(toTokenize);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tokenizer create(InputStream toTokenize) {
        return null;
    }

    @Override
    public void setTokenPreProcessor(TokenPreProcess preProcessor) {
            tokenPreProcess = preProcessor;
    }

    @Override
    public TokenPreProcess getTokenPreProcessor() {
        return tokenPreProcess;
    }
}
