package com.github.peach.ui;

import com.github.peach.rpc.RpcContext;
import com.github.peach.rpc.RpcInvoker;
import com.github.peach.rpc.RpcRequest;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * 插件UI实体
 *
 * @author Zer01ne
 * @since 2022/6/18 17:09
 */
public class RpcInvokerForm {
    /**
     * 滚动条
     */
//    private Project project;
    /**
     * 滚动条
     */
    private JScrollPane mainScrollPanel;
    /**
     * 主面板
     */
    private JPanel mainPanel;
    /**
     * 应用名标签
     */
    private JLabel applicationLabel;
    /**
     * 应用名
     */
    private JTextField application;
    /**
     * 主机地址标签
     */
    private JLabel hostLabel;
    /**
     * 主机地址标签
     */
    private JComboBox hostAddress;
    /**
     * 接口名标签
     */
    private JLabel interfaceLabel;
    /**
     * 接口名
     */
    private JTextField interfaceName;
    /**
     * 方法名标签
     */
    private JLabel methodLabel;
    /**
     * 方法名
     */
    private JTextField method;
    /**
     * 环境标签
     */
    private JLabel envLabel;
    /**
     * 环境
     */
    private JComboBox<String> env;
    /**
     * 刷新配置按钮
     */
    private JButton refresh;
    /**
     * 发送请求按钮
     */
    private JButton send;
    /**
     * 格式化json
     */
    private JButton prettyJsonRequestButton;
    /**
     * 压缩json
     */
    private JButton miniJsonRequestButton;
    /**
     * 格式化json
     */
    private JButton prettyJsonResponseButton;
    /**
     * 压缩json
     */
    private JButton miniJsonResponseButton;
    /**
     * 请求参数标签
     */
    private JLabel requestLabel;
    /**
     * 请求参数
     */
    private JTextArea request;
    /**
     * 响应参数标签
     */
    private JLabel responseLabel;
    /**
     * 响应内容
     */
    private JTextArea response;


    public RpcInvokerForm() {
//        application = new ComboBox<>();
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
//        model.addElement(project.getName());
//        application.setModel(model);
        // 发送rpc请求
        send.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.setHostName(hostAddress.getModel().getSelectedItem().toString());
                rpcRequest.setTag("");
                rpcRequest.setClassName(interfaceName.getText());
                rpcRequest.setMethod(method.getText());
                rpcRequest.setParam(request.getText());
                System.out.println(rpcRequest);
                new RpcInvoker().invoker(rpcRequest);
            }
        });
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RpcContext context = RpcContext.refreshContext(application.getText());
                System.out.println(context);
                List<String> servers = context.getServers();
                if (servers != null && servers.size() != 0) {
                    servers.forEach(hostAddress::addItem);
                }
            }
        });
        // 格式化json
        prettyJsonRequestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        miniJsonRequestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        prettyJsonResponseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        miniJsonResponseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RpcInvokerForm");
        frame.setContentPane(new RpcInvokerForm().mainScrollPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainScrollPanel = new JScrollPane();
        mainScrollPanel.setFocusCycleRoot(false);
        mainScrollPanel.setInheritsPopupMenu(false);
        mainScrollPanel.setMaximumSize(new Dimension(730, 362));
        mainScrollPanel.setMinimumSize(new Dimension(730, 362));
        mainScrollPanel.setPreferredSize(new Dimension(730, 362));
        mainScrollPanel.setVisible(true);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(7, 7, new Insets(5, 5, 5, 5), 5, -1));
        mainPanel.setAutoscrolls(false);
        mainPanel.setEnabled(true);
        mainPanel.setFocusTraversalPolicyProvider(false);
        mainPanel.setInheritsPopupMenu(false);
        mainPanel.setMaximumSize(new Dimension(730, 362));
        mainPanel.setMinimumSize(new Dimension(730, 362));
        mainPanel.setOpaque(true);
        mainPanel.setPreferredSize(new Dimension(730, 362));
        mainPanel.putClientProperty("html.disable", Boolean.FALSE);
        mainScrollPanel.setViewportView(mainPanel);
        applicationLabel = new JLabel();
        applicationLabel.setEnabled(true);
        applicationLabel.setHorizontalAlignment(10);
        applicationLabel.setText("application");
        mainPanel.add(applicationLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        interfaceName = new JTextField();
        interfaceName.setText("");
        mainPanel.add(interfaceName, new GridConstraints(2, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        interfaceLabel = new JLabel();
        interfaceLabel.setText("interface");
        mainPanel.add(interfaceLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        method = new JTextField();
        mainPanel.add(method, new GridConstraints(3, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        methodLabel = new JLabel();
        methodLabel.setText("method");
        mainPanel.add(methodLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        application = new JTextField();
        application.setEditable(true);
        mainPanel.add(application, new GridConstraints(0, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        hostLabel = new JLabel();
        hostLabel.setText("ip:port:tag");
        mainPanel.add(hostLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        send = new JButton();
        send.setText("send");
        mainPanel.add(send, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        hostAddress = new JComboBox();
        mainPanel.add(hostAddress, new GridConstraints(1, 1, 1, 5, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        refresh = new JButton();
        refresh.setText("refresh");
        mainPanel.add(refresh, new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        env = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("fat");
        defaultComboBoxModel1.addElement("uat");
        defaultComboBoxModel1.addElement("pre");
        defaultComboBoxModel1.addElement("pro");
        env.setModel(defaultComboBoxModel1);
        mainPanel.add(env, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        miniJsonRequestButton = new JButton();
        miniJsonRequestButton.setText("miniJson");
        mainPanel.add(miniJsonRequestButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prettyJsonRequestButton = new JButton();
        prettyJsonRequestButton.setText("prettyJson");
        mainPanel.add(prettyJsonRequestButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        requestLabel = new JLabel();
        requestLabel.setText("request");
        mainPanel.add(requestLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        responseLabel = new JLabel();
        responseLabel.setText("response");
        mainPanel.add(responseLabel, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prettyJsonResponseButton = new JButton();
        prettyJsonResponseButton.setText("prettyJson");
        mainPanel.add(prettyJsonResponseButton, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        envLabel = new JLabel();
        envLabel.setText("env");
        mainPanel.add(envLabel, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        response = new JTextArea();
        response.setText("");
        mainPanel.add(response, new GridConstraints(6, 3, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(350, 500), new Dimension(350, 500), null, 0, false));
        request = new JTextArea();
        request.setText("");
        mainPanel.add(request, new GridConstraints(6, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(350, 500), new Dimension(350, 500), null, 0, false));
        miniJsonResponseButton = new JButton();
        miniJsonResponseButton.setText("miniJson");
        mainPanel.add(miniJsonResponseButton, new GridConstraints(5, 5, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainScrollPanel;
    }

    public JScrollPane getMainScrollPanel() {
        return mainScrollPanel;
    }

//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }

    public JButton getPrettyJsonRequestButton() {
        return prettyJsonRequestButton;
    }

    public void setPrettyJsonRequestButton(JButton prettyJsonRequestButton) {
        this.prettyJsonRequestButton = prettyJsonRequestButton;
    }

    public JButton getMiniJsonRequestButton() {
        return miniJsonRequestButton;
    }

    public void setMiniJsonRequestButton(JButton miniJsonRequestButton) {
        this.miniJsonRequestButton = miniJsonRequestButton;
    }

    public JButton getPrettyJsonResponseButton() {
        return prettyJsonResponseButton;
    }

    public void setPrettyJsonResponseButton(JButton prettyJsonResponseButton) {
        this.prettyJsonResponseButton = prettyJsonResponseButton;
    }

    public JButton getMiniJsonResponseButton() {
        return miniJsonResponseButton;
    }

    public void setMiniJsonResponseButton(JButton miniJsonResponseButton) {
        this.miniJsonResponseButton = miniJsonResponseButton;
    }

    public void setMainScrollPanel(JScrollPane mainScrollPanel) {
        this.mainScrollPanel = mainScrollPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(JLabel applicationLabel) {
        this.applicationLabel = applicationLabel;
    }


    public JLabel getHostLabel() {
        return hostLabel;
    }

    public void setHostLabel(JLabel hostLabel) {
        this.hostLabel = hostLabel;
    }


    public JLabel getInterfaceLabel() {
        return interfaceLabel;
    }

    public void setInterfaceLabel(JLabel interfaceLabel) {
        this.interfaceLabel = interfaceLabel;
    }

    public JTextField getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(JTextField interfaceName) {
        this.interfaceName = interfaceName;
    }

    public JLabel getMethodLabel() {
        return methodLabel;
    }

    public void setMethodLabel(JLabel methodLabel) {
        this.methodLabel = methodLabel;
    }

    public JTextField getMethod() {
        return method;
    }

    public void setMethod(JTextField method) {
        this.method = method;
    }

    public JLabel getEnvLabel() {
        return envLabel;
    }

    public void setEnvLabel(JLabel envLabel) {
        this.envLabel = envLabel;
    }

    public JComboBox<String> getEnv() {
        return env;
    }

    public void setEnv(JComboBox<String> env) {
        this.env = env;
    }

    public JButton getRefresh() {
        return refresh;
    }

    public void setRefresh(JButton refresh) {
        this.refresh = refresh;
    }

    public JButton getSend() {
        return send;
    }

    public void setSend(JButton send) {
        this.send = send;
    }

    public JLabel getRequestLabel() {
        return requestLabel;
    }

    public void setRequestLabel(JLabel requestLabel) {
        this.requestLabel = requestLabel;
    }

    public JTextArea getRequest() {
        return request;
    }

    public void setRequest(JTextArea request) {
        this.request = request;
    }

    public JLabel getResponseLabel() {
        return responseLabel;
    }

    public void setResponseLabel(JLabel responseLabel) {
        this.responseLabel = responseLabel;
    }

    public JTextArea getResponse() {
        return response;
    }

    public void setResponse(JTextArea response) {
        this.response = response;
    }

    public JTextField getApplication() {
        return application;
    }

    public void setApplication(JTextField application) {
        this.application = application;
    }

    public JComboBox getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(JComboBox hostAddress) {
        this.hostAddress = hostAddress;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
