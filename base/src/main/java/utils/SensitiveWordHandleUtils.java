package utils;

import cn.hutool.dfa.WordTree;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dongjiaming
 * @Description 敏感词过滤工具类
 * @title: SensitiveWordHandleUtils
 * @projectName study
 * @date 2022/6/217:31
 */
@Component
public class SensitiveWordHandleUtils {

    /**
     * DFAContent 装敏感词库的字符串
     */
    private static final List<String> SensitiveWordDFAContent = new ArrayList<>();

    /**
     * tree 敏感词树
     */
    private static final WordTree sensitiveWordTree = new WordTree();

    /**
     * 读取敏感词文件
     *
     * @return {@link String}
     * @throws Exception 异常
     */
    public static List<String> fileRead() throws Exception {
        InputStream inputStream = SensitiveWordHandleUtils.class.getClassLoader().getResourceAsStream("KeyWord.txt");

        assert inputStream != null;
        return IOUtils.readLines(inputStream, "GB2312");
    }


    /**
     * 初始化敏感词库树
     */
    public static void addSensitiveWords() throws Exception {
        SensitiveWordDFAContent.addAll(fileRead());
        sensitiveWordTree.addWords(SensitiveWordDFAContent);
    }


    /**
     * 使用dfa查找敏感词汇(最后调这个方法)
     *
     * @param content 用户输入的内容
     * @return 内容中的敏感词集合
     */
    public static List<String> findSensitiveWordStr(String content) {
        return sensitiveWordTree.matchAll(content, -1, true, true)
                .stream().distinct().collect(Collectors.toList());

    }


    public static void main(String[] args) throws Exception {
        //添加敏感词 为DFAContent赋值
        addSensitiveWords();
        String content = "static_java_publicSunpublicMicrosystemsclassreturnava_int";
        List<String> wordList = findSensitiveWordStr(content);
        List<String> arrayList = new ArrayList<>();
        char a = '_';
        for (int i = 0; i < wordList.size(); i++) {
            if (i==0){
                String firstWord = wordList.get(i);
                char c = content.charAt((content.indexOf(firstWord))+firstWord.length());
                System.out.println(c);
                if (c != a){
                    arrayList.add(firstWord);
                }
            }else if (i== wordList.size()-1){
                String lastWord = wordList.get(i);
                char c = content.charAt((content.indexOf(lastWord)-1));
                System.out.println(c);
                if (c != a){
                    arrayList.add(lastWord);
                }
            }else {
                String midWord = wordList.get(i);
                char c1 = content.charAt((content.indexOf(midWord)-1));
                char c2 = content.charAt((content.indexOf(midWord) + midWord.length()));
                if (c1!=a && c2!=a ){
                    arrayList.add(midWord);
                }
            }
        }

        System.out.println(arrayList);

    }


}
