
- 测试默认的分词
```bash
scripts/score gold/pku_training_words.utf8 gold/pku_test_gold.utf8 /home/hj/data/nlp/seg-common/FudanNLPSegmenter_pku_test.txt > /home/hj/data/nlp/seg-common/fnlp_pku_score.utf8

scripts/score gold/msr_training_words.utf8 gold/msr_test_gold.utf8 /home/hj/data/nlp/seg-common/FudanNLPSegmenter_msr_test.txt > /home/hj/data/nlp/seg-common/fnlp_msr_score.utf8

scripts/score gold/msr_training_words.utf8 gold/msr_test_gold.utf8 /home/hj/data/nlp/seg-common/HanLPSegmenter_msr_test.txt > /home/hj/data/nlp/seg-common/hanlp_msr_score.utf8

scripts/score gold/pku_training_words.utf8 gold/pku_test_gold.utf8 /home/hj/data/nlp/seg-common/HanLPSegmenter_pku_test.txt > /home/hj/data/nlp/seg-common/hanlp_pku_score.utf8

scripts/score gold/pku_training_words.utf8 gold/pku_test_gold.utf8 /home/hj/data/nlp/seg-common/JieBaSegmenter_pku_test.txt > /home/hj/data/nlp/seg-common/jieba_pku_score.utf8

scripts/score gold/msr_training_words.utf8 gold/msr_test_gold.utf8 /home/hj/data/nlp/seg-common/JieBaSegmenter_msr_test.txt > /home/hj/data/nlp/seg-common/jieba_msr_score.utf8
```

- 测试自定义词典的分词
```bash
scripts/score gold/pku_training_words.utf8 gold/pku_test_gold.utf8 /home/hj/data/nlp/seg-custom/FudanNLPSegmenter_pku_test.txt > /home/hj/data/nlp/seg-custom/fnlp_pku_score.utf8

scripts/score gold/msr_training_words.utf8 gold/msr_test_gold.utf8 /home/hj/data/nlp/seg-custom/FudanNLPSegmenter_msr_test.txt > /home/hj/data/nlp/seg-custom/fnlp_msr_score.utf8

scripts/score gold/msr_training_words.utf8 gold/msr_test_gold.utf8 /home/hj/data/nlp/seg-custom/HanLPSegmenter_msr_test.txt > /home/hj/data/nlp/seg-custom/hanlp_msr_score.utf8

scripts/score gold/pku_training_words.utf8 gold/pku_test_gold.utf8 /home/hj/data/nlp/seg-custom/HanLPSegmenter_pku_test.txt > /home/hj/data/nlp/seg-custom/hanlp_pku_score.utf8

scripts/score gold/pku_training_words.utf8 gold/pku_test_gold.utf8 /home/hj/data/nlp/seg-custom/JieBaSegmenter_pku_test.txt > /home/hj/data/nlp/seg-custom/jieba_pku_score.utf8

scripts/score gold/msr_training_words.utf8 gold/msr_test_gold.utf8 /home/hj/data/nlp/seg-custom/JieBaSegmenter_msr_test.txt > /home/hj/data/nlp/seg-custom/jieba_msr_score.utf8
```