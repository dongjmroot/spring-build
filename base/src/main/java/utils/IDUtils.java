package utils;

import java.util.UUID;

public class IDUtils {
    public IDUtils() {
    }

    //随机12位做uuid
    public static String getTraceID() {
        return UUID.randomUUID().toString().substring(0, 13).replace("-", "");
    }
}
