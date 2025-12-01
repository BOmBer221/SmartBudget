package com.company.smartbudget.view.category;

import com.company.smartbudget.entity.Account;
import com.company.smartbudget.entity.Category;
import com.company.smartbudget.entity.User;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.collaborationengine.CollaborationMessage;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "categories", layout = MainView.class)
@ViewController(id = "Category.list")
@ViewDescriptor(path = "category-list-view.xml")
@LookupComponent("categoriesDataGrid")
@DialogMode(width = "64em")
public class CategoryListView extends StandardListView<Category> {

}