package com.github.peach;

import com.github.peach.ui.RpcInvokerForm;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author peach
 * @since 2022/5/21 16:46
 */
public class PeachInvokerToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        RpcInvokerForm rpcInvokerForm = new RpcInvokerForm();
        rpcInvokerForm.getApplication().setText(project.getName());
        ContentFactory factory = ContentFactory.SERVICE.getInstance();
        Content content = factory.createContent(rpcInvokerForm.getMainScrollPanel(), "", true);
        toolWindow.getContentManager().addContent(content);
    }

}
