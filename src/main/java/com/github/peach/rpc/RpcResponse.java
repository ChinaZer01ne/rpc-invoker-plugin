package com.github.peach.rpc;
/**
 * @author Zer01ne
 * @since 2022/6/18 17:59
 */
public class RpcResponse {
    /**
     * 响应体
     */
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}
