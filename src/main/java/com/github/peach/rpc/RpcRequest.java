package com.github.peach.rpc;


/**
 * @author Zer01ne
 * @since 2022/6/18 17:59
 */
public class RpcRequest {
    /**
     * 主机名
     */
    private String hostName;
    /**
     * tag
     */
    private String tag;
    /**
     * 接口名
     */
    private String className;
    /**
     * 方法名
     */
    private String method;
    /**
     * 参数
     */
    private Object param;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RpcRequest{");
        sb.append("hostName='").append(hostName).append('\'');
        sb.append(", tag='").append(tag).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append(", param=").append(param);
        sb.append('}');
        return sb.toString();
    }
}
