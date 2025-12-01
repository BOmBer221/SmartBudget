package com.company.smartbudget.view.users;

import com.company.smartbudget.entity.Users;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "userses/:id", layout = MainView.class)
@ViewController(id = "Users.detail")
@ViewDescriptor(path = "users-detail-view.xml")
@EditedEntityContainer("usersDc")
public class UsersDetailView extends StandardDetailView<Users> {
}