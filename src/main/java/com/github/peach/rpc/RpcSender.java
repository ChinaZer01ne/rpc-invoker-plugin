package com.github.peach.rpc;
/**
 * 请求发送策略
 * @author Zer01ne
 * @since 2022/8/15 23:20
 */
public interface RpcSender {
    /**
     * 请求发送策略
     * @param context
     * @return com.github.peach.rpc.RpcResponse
     */
    RpcResponse send(RpcContext context);
}
