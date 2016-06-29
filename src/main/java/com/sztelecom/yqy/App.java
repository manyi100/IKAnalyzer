package com.sztelecom.yqy;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;

/**
 *
 * @author lxw的大数据田地 -- lxw1234.com
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        String text = "lxw的大数据田地 -- lxw1234.com 专注Hadoop、Spark、Hive等大数据技术博客。 北京优衣库";
//        IKAnalyzer支持两种分词模式：最细粒度和智能分词模式，如果构造函数参数为false，那么使用最细粒度分词。
        Analyzer analyzer = new IKAnalyzer(true);
        StringReader reader = new StringReader(text);
        TokenStream ts = analyzer.tokenStream("", reader);
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
        while(ts.incrementToken()){
            System.out.print(term.toString()+"|");
        }
        analyzer.close();
        reader.close();
    }

}