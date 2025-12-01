package com.company.smartbudget.view.target;

import com.company.smartbudget.entity.Target;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "targets/:id", layout = MainView.class)
@ViewController(id = "Target.detail")
@ViewDescriptor(path = "target-detail-view.xml")
@EditedEntityContainer("targetDc")
public class TargetDetailView extends StandardDetailView<Target> {
}