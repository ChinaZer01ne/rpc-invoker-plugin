package com.github.peach.rpc;

import com.github.peach.rpc.impl.DefaultRpcSender;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryOneTime;

import java.util.List;

/**
 * @author Zer01ne
 * @since 2022/6/18 17:55
 */
public class RpcContext {

    private List<String> servers;
    private String port;
    private String tag;
    /**
     * 请求
     */
    private RpcRequest rpcRequest;
    /**
     * 请求发送器
     */
    private RpcSender rpcSender = new DefaultRpcSender();

    /**
     * 刷新配置
     * @return com.github.peach.rpc.RpcContext
     */
    public static RpcContext refreshContext(String server) {
        RpcContext context = new RpcContext();
        String zkServer = "192.168.1.100:2181";
        try (CuratorFramework framework = CuratorFrameworkFactory.builder()
                .connectString(zkServer)
                .connectionTimeoutMs(3000)
                .retryPolicy(new RetryOneTime(200))
                .build()) {
            framework.start();
            List<String> serverNode = framework.getChildren().forPath("/" + server);
            context.setServers(serverNode);
        } catch (Exception e) {
            return new RpcContext();
        }
        return context;
    }
    /**
     * 校验请求合法性
     * @return boolean
     */
    public boolean check(){
        if (servers == null || servers.size() == 0) {
            return false;
        }
        if (StringUtils.isBlank(rpcRequest.getMethod())) {
            return false;
        }
        if (StringUtils.isBlank(rpcRequest.getHostName())) {
            return false;
        }
        return true;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public RpcRequest getRpcRequest() {
        return rpcRequest;
    }

    public void setRpcRequest(RpcRequest rpcRequest) {
        this.rpcRequest = rpcRequest;
    }

    public RpcSender getRpcSender() {
        return rpcSender;
    }

    public void setRpcSender(RpcSender rpcSender) {
        this.rpcSender = rpcSender;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RpcContext{");
        sb.append("servers=").append(servers);
        sb.append(", port='").append(port).append('\'');
        sb.append(", tag='").append(tag).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
