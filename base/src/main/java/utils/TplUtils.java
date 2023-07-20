package utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cxq on 2018-01-07.
 */
public class TplUtils {

    //public static void main(String[] args) {
    //
    //    Map map = new HashMap();
    //    map.put("name", "张三");
    //    map.put("money", String.format("%.2f", 10.155));
    //    map.put("point", 10);
    //    System.out.println(processTemplate("您好${name}，晚上好！您目前余额：${money}元，积分：${point}", map));
    //}



    /**
     * 自定义渲染模板
     * @param template 模版
     * @param params   参数
     * @return
     */
    public static String processTemplate(String template, Map<String, Object> params) {
        if (template == null || params == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }



}
