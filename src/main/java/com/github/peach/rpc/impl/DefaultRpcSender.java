package com.github.peach.rpc.impl;

import com.github.peach.rpc.RpcContext;
import com.github.peach.rpc.RpcResponse;
import com.github.peach.rpc.RpcSender;

/**
 * @author Zer01ne
 * @since 2022/8/15 23:21
 */
public class DefaultRpcSender implements RpcSender {
    @Override
    public RpcResponse send(RpcContext context) {
        return new RpcResponse();
    }
}
