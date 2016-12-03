package word2vec;
/*This package contains functions of Standford CoreNLP project, including:
 * PoS tagger for dictionary sentiment analysis: getPoS
 * uni-gramn for ML based senti analysis
 */

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;


import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class STFNLP {
	private Properties props;
	private StanfordCoreNLP pipeline;
	private List<CoreLabel> tokens;	
	
	// specify parameters and build the pipeline
	public STFNLP() throws IOException {
		props = new Properties(); 
		
		/*
		 *  fail to manually set parameters, error type: classNotFound:ChineseSegmenterAnnotator
		 *  wait for debugging 
		 *  temporarily use default parameter set
		 */
		
		try {
            props.load(StanfordCoreNLP.class.getResourceAsStream("/StanfordCoreNLP-chinese.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		props.put("annotators", "segment,ssplit");
		//alter default parameters
		/*
		props.put("annotators", "tokenize, ssplit, pos");
		props.put("segment.model","edu/stanford/nlp/models/segmenter/chinese/ctb.gz");
		props.put("segment.sighanCorporaDict","edu/stanford/nlp/models/segmenter/chinese");
		props.put("segment.serDictionary","edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz");
		props.put("segment.sighanPostProcessing","true");
		props.put("ssplit.boundaryTokenRegex","[.]|[!?]+|[。]|[！？]+");
		props.put("pos.model","edu/stanford/nlp/models/pos-tagger/chinese-distsim/chinese-distsim.tagger");
		props.put("ner.model","edu/stanford/nlp/models/ner/chinese.misc.distsim.crf.ser.gz");
		props.put("ner.applyNumericClassifiers","false");
		props.put("ner.useSUTime","false");
		props.put("parse.model","edu/stanford/nlp/models/lexparser/chinesePCFG.ser.gz");
		*/


		//pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");
		pipeline = new StanfordCoreNLP(props);
	}
	
	public List<CoreLabel> posTag(String s){
		Annotation annotation = new Annotation(s);
		pipeline.annotate(annotation);
		List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);  
		//id = 0 because input is limited in one input line
		CoreMap taggedS = sentences.get(0);
		tokens = taggedS.get(CoreAnnotations.TokensAnnotation.class);
		return tokens;
	}
	// get Part-of-Speech
	public String getPoS(CoreLabel token){
		return token.getString(PartOfSpeechAnnotation.class);
	}
	
	public String getWord(CoreLabel token){
		return token.getString(TextAnnotation.class);  
	}
	
}
