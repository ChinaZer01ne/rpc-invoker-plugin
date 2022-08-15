package com.github.peach.rpc;
/**
 * @author Zer01ne
 * @since 2022/6/18 17:55
 */
public class RpcInvoker {

    private RpcContext context;

    public RpcResponse invoker(RpcRequest request) {
        System.out.println("rpc request send...");
        return new RpcResponse();
    }
}
