package com.sunshine.seg;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: hj
 * @date: 21-8-20 下午3:54
 */
@Setter
@Getter
public abstract class BaseSegmenter {
    public static String outDir = "/root";
    public static String textPath = "/home/hj/datastory/programs/cws_evaluation/data/speed-test-text.txt";
    String fileName = "segResult.txt";

    private PrintWriter printWriter;

    /**
     * 分词
     *
     * @param text
     * @return
     */
    protected abstract List<Object> doSegWord(String text);

    /**
     * 将Object转换成String
     *
     * @param o
     * @return
     */
    protected abstract String transSegWordResult(Object o);

    public List<String> segWord(String text) {
        List<Object> objs = doSegWord(text);
        if (objs != null) {
            return objs.stream().filter(Objects::nonNull).map(o -> transSegWordResult(o)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 加载用户字典
     *
     * @param path
     */
    public void loadCustomDict(String path) throws Exception {
        return;
    }


    public String getPath() {
        return outDir + File.separator + fileName;
    }

    public void outAppender(String line) {
        if (printWriter != null) {
            printWriter.println(line);
        }
    }

    /**
     * 测试每秒处理字的个数
     */
    public void evaluateSpeed() {
        try (FileInputStream inputStream = new FileInputStream(new File(textPath));
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            String line;
            long start = System.currentTimeMillis();
            double costTime;
            long wordLen = 0;
            long sentenceCount = 0;
            while ((line = reader.readLine()) != null) {
                if (line == null || line.trim().length() == 0) {
                    continue;
                }
                wordLen = wordLen + line.length();
                sentenceCount = sentenceCount + 1;
                segWord(line);
            }
            costTime = (System.currentTimeMillis() - start) / (double) 1000;
            System.out.println("==========================" + this.getClass().getSimpleName() + "=============================");
            System.out.printf("%.2f万字/秒\n", wordLen / 10000 / costTime);
            System.out.printf("%.2f万条句子/秒\n", sentenceCount / 10000 / costTime);
            System.out.println("平均每条句子中包含：" + (wordLen / sentenceCount) + "字");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
