package com.company.smartbudget.view.target;

import com.company.smartbudget.entity.Target;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "targets", layout = MainView.class)
@ViewController(id = "Target.list")
@ViewDescriptor(path = "target-list-view.xml")
@LookupComponent("targetsDataGrid")
@DialogMode(width = "64em")
public class TargetListView extends StandardListView<Target> {
}