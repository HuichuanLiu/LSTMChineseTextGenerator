package word2vec;


import java.io.IOException;

/**
 * Created by lj-18 on 2016/12/2.
 */
public class test {
    public static void main(String[] args) throws IOException
    {
        STFNLPTokenizer stfnlpTokenizer = new STFNLPTokenizer("我们今天晚上要去看准备要租的房子但是我不知道晚饭要吃什么");
        while(stfnlpTokenizer.hasMoreTokens()){
            System.out.println(stfnlpTokenizer.nextToken());
        }
    }
}

