package com.github.peach.rpc;
/**
 * @author Zer01ne
 * @since 2022/6/18 17:55
 */
public interface RpcInvoker {

    /**
     * rpc执行策略
     * @param context :
     * @return com.github.peach.rpc.RpcResponse
     */
    RpcResponse invoker(RpcContext context);
}
