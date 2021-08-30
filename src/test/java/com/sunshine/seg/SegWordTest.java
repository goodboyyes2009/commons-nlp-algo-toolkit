package com.sunshine.seg;

import com.google.common.io.Files;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-26 下午3:37
 */
public class SegWordTest {
    private final Logger logger = LoggerFactory.getLogger(SegWordTest.class);
    List<BaseSegmenter> segmenters;
    String pkuPath = "/home/hj/data/nlp/icwb2-data/testing/pku_test.utf8";
    String msrPath = "/home/hj/data/nlp/icwb2-data/testing/msr_test.utf8";

    String msrDictPath = "/home/hj/data/nlp/icwb2-data/gold/msr_training_words.utf8";
    String pkuDictPath = "/home/hj/data/nlp/icwb2-data/gold/pku_training_words.utf8";

    String dictOutDir = "/home/hj/data/nlp/seg-custom";
    String commonOutDir = "/home/hj/data/nlp/seg-custom";

    @Before
    public void init() {
        segmenters = SegWordFactory.createAllSegmenters();
    }

    @Test
    public void testPKUSegWord() {
        BaseSegmenter.outDir = commonOutDir;
        testSeg(pkuPath);
    }

    @Test
    public void testMSRSegWord() {
        BaseSegmenter.outDir = commonOutDir;
        testSeg(msrPath);
    }


    @Test
    public void testCustomDictMSRSegWord() {
        BaseSegmenter.outDir = dictOutDir;
        String jiebaMSRDict = "/home/hj/datastory/programs/commons-nlp-algo-toolkit/lib";
        testSegUseCustomDict(msrPath, msrDictPath, jiebaMSRDict);
    }

    @Test
    public void testCustomDictPKUSegWord() {
        BaseSegmenter.outDir = dictOutDir;
        String jiebaDict = "/home/hj/datastory/programs/commons-nlp-algo-toolkit/src/main/resources";
        testSegUseCustomDict(pkuPath, pkuDictPath, jiebaDict);
    }

    private void testSeg(String dataPath) {
        setPrintWriter(dataPath);
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(dataPath)), "UTF-8");
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                for (BaseSegmenter segmenter : segmenters) {
                    List<String> token = segmenter.segWord(line);
                    String newLine;
                    if (token == null) {
                        newLine = line;
                    } else {
                        newLine = String.join(" ", token);
                    }
                    segmenter.outAppender(newLine);
                }
            }
            closeAndFlush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testSegUseCustomDict(String dataPath, String dictPath, String jiebaDictDir) {
        setCustomDict(dictPath, jiebaDictDir);
        testSeg(dataPath);
    }


    private void setPrintWriter(String path) {
        String fileName = Files.getNameWithoutExtension(path);
        segmenters.stream().forEach(baseSegmenter -> {
            String className = baseSegmenter.getClass().getName();
            String substring = className.substring(className.lastIndexOf(".") + 1);
            baseSegmenter.setFileName(substring + "_" + fileName + ".txt");
            try {
                baseSegmenter.setPrintWriter(new PrintWriter(baseSegmenter.getPath(), "UTF-8"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    private void setCustomDict(String dictPath, String jiebaDictDir) {
        segmenters.forEach(segmenter -> {
            try {
                if (segmenter instanceof JieBaSegmenter) {
                    segmenter.loadCustomDict(jiebaDictDir);
                } else {
                    segmenter.loadCustomDict(dictPath);
                }
            } catch (Exception e) {
                logger.error("加载字典失败,{}", e.getMessage(), e);
            }
        });
    }


    private void closeAndFlush() {
        segmenters.stream().forEach(segmenter -> {
            segmenter.getPrintWriter().flush();
            segmenter.getPrintWriter().close();
        });
    }

    @Test
    public void testEvaluateSpeed() {
        segmenters.forEach(baseSegmenter -> {
            baseSegmenter.evaluateSpeed();
        });
    }
}