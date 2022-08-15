package com.github.peach.rpc.impl;

import com.github.peach.rpc.RpcContext;
import com.github.peach.rpc.RpcInvoker;
import com.github.peach.rpc.RpcResponse;

/**
 * gpc invoker
 * @author Zer01ne
 * @since 2022/8/15 22:58
 */
public class DefaultRpcInvoker implements RpcInvoker {

    private RpcContext context;
    @Override
    public RpcResponse invoker(RpcContext context) {
        this.context = context;
        if (!context.check()) {
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.setBody("This response form peach-invoker plugin : your request is illegal， please check your request body!");
            return rpcResponse;
        }
        System.out.println("rpc request send...");
        return send(context);
    }
    /**
     * 发送请求
     * @param context :
     * @return com.github.peach.rpc.RpcResponse
     */
    private RpcResponse send(RpcContext context) {
        return new RpcResponse();
    }
}
