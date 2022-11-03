package com.github.peach;

import com.github.peach.ui.RpcInvokerForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;

import javax.swing.*;
import java.util.Objects;

public class RpcInvokeAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project project = e.getProject();
        ToolWindow toolWindow = ToolWindowManager.getInstance(Objects.requireNonNull(project)).getToolWindow("peach-invoker");
        Objects.requireNonNull(toolWindow).show();
        System.out.println(123);
        PsiJavaFile file = (PsiJavaFile) e.getData(CommonDataKeys.PSI_FILE);
        assert file != null;
        PsiMethod method = (PsiMethod) e.getData(CommonDataKeys.PSI_ELEMENT);
        assert method != null;
        PsiClass clazz = (PsiClass) method.getParent();
        String interfaceName = file.getPackageName() + "." + clazz.getName();
        String methodName = method.getName();
    }
}
