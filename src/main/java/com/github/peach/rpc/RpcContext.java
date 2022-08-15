package com.github.peach.rpc;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

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
     * 刷新配置
     * @return com.github.peach.rpc.RpcContext
     */
    public static RpcContext refreshContext(String server) {
        RpcContext context = new RpcContext();
        String zkServer = "192.168.1.100:2181";
        try (CuratorFramework framework = CuratorFrameworkFactory.builder()
                .connectString(zkServer)
                .connectionTimeoutMs(6000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 5))
                .build()) {
            framework.start();
            List<String> serverNode = framework.getChildren().forPath("/" + server);
            context.setServers(serverNode);
        } catch (Exception e) {
            return new RpcContext();
        }
        return context;
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
