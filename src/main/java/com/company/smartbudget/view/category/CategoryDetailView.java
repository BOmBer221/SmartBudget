package com.company.smartbudget.view.category;

import com.company.smartbudget.entity.Category;
import com.company.smartbudget.entity.User;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Route(value = "categories/:id", layout = MainView.class)
@ViewController(id = "Category.detail")
@ViewDescriptor(path = "category-detail-view.xml")
@EditedEntityContainer("categoryDc")
public class CategoryDetailView extends StandardDetailView<Category> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(final StandardDetailView.InitEntityEvent<Category> event) {
        Category category = event.getEntity();
        // Получаем текущего пользователя
        User currentUser = (User) currentAuthentication.getUser();
        // Устанавливаем его в поле user
        category.setUser_id(currentUser);

    }
}