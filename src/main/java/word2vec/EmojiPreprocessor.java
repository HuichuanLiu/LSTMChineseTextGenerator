package word2vec;

import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;

/**
 * Created by lj-18 on 2016/12/3.
 * Provides preprocessor to stripe off emojis
 */
public class EmojiPreprocessor implements TokenPreProcess {
    @Override
    public String preProcess(String token) {
        return cleanEmoji(token);
    }

    private static String cleanEmoji(String sentence){
        String str;
        str = sentence.replaceAll("\\(&[\\u4e00-\\u9fa5]*\\)","");
        System.out.println("Preprocessed: "+str);
        return str;
    }
}
