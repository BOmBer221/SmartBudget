package com.company.smartbudget.view.users;

import com.company.smartbudget.entity.Users;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "userses", layout = MainView.class)
@ViewController(id = "Users.list")
@ViewDescriptor(path = "users-list-view.xml")
@LookupComponent("usersesDataGrid")
@DialogMode(width = "64em")
public class UsersListView extends StandardListView<Users> {
}