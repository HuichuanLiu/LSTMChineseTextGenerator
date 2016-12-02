package word2vec;

import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;
import org.deeplearning4j.text.tokenization.tokenizer.Tokenizer;
import edu.stanford.nlp.ling.CoreLabel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lj-18 on 2016/12/2.
 */
public class STFNLPTokenizer implements Tokenizer{
    private STFNLP stfnlp = new STFNLP();
    private List<CoreLabel> coreLabels = null;
    private int id = 0;
    private List<String> tokenList;
    private TokenPreProcess tokenPreProcess=null;

    public STFNLPTokenizer(String sentence) throws IOException {
        coreLabels = stfnlp.posTag(sentence);
    }
    public boolean hasMoreTokens(){
        if(id<coreLabels.size()){
            return true;
        }
        else{
            return false;
        }
    }

    public int countTokens(){
        return coreLabels.size();
    }

    public String nextToken(){
        String token = stfnlp.getWord(coreLabels.get(id++));
        return token;
    }

    public List<String> getTokens(){
        tokenList = new ArrayList<String>();
        for (CoreLabel coreLabel:coreLabels){
            tokenList.add(stfnlp.getWord(coreLabel));
        }
        return tokenList;
    }

    public void setTokenPreProcessor(TokenPreProcess tokenPreProcessor) {
    }

}
