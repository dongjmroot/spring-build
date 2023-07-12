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
 * @Description 关键字词过滤工具类
 * @title: KeyWordHandleUtils
 * @projectName study
 * @date 2022/6/217:31
 */
@Component
public class KeyWordHandleUtils {

    /**
     * DFAContent 装敏感词库的字符串
     */
    public static final List<String> KeyWordList = new ArrayList<>();

    /**
     * tree 敏感词树
     */
    private static final WordTree keyWordTree = new WordTree();


    /**
     * 读取敏感词文件
     *
     * @return {@link String}
     * @throws Exception 异常
     */
    public static List<String> fileRead() throws Exception {
        InputStream inputStream = KeyWordHandleUtils.class.getClassLoader().getResourceAsStream("KeyWord.txt");

        assert inputStream != null;
        return IOUtils.readLines(inputStream, "GB2312");
    }


    /**
     * 初始化敏感词库树
     */
    public static void addKeyWords() throws Exception {
        KeyWordList.addAll(fileRead());
    }


    /**
     * 使用dfa查找敏感词汇(最后调这个方法)
     *
     * @param content 用户输入的内容
     * @return 内容中的敏感词集合
     */
    public static List<String> findKeyWordStr(String content) {
        return keyWordTree.matchAll(content, -1, true, true)
                .stream().distinct().collect(Collectors.toList());

    }

}
