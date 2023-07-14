package menu;

public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP,
    /**
     * 根据请求者用户进行限流
     */
    USER
}
