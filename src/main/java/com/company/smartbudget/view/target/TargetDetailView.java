package com.company.smartbudget.view.target;

import com.company.smartbudget.entity.Category;
import com.company.smartbudget.entity.Target;
import com.company.smartbudget.entity.User;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.component.datetimepicker.TypedDateTimePicker;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Route(value = "targets/:id", layout = MainView.class)
@ViewController(id = "Target.detail")
@ViewDescriptor(path = "target-detail-view.xml")
@EditedEntityContainer("targetDc")
public class TargetDetailView extends StandardDetailView<Target> {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @ViewComponent
    private TypedDateTimePicker<LocalDateTime> createDateField;

    // вставка id авторизированного пользователя
    @Subscribe
    public void onInitEntity(final InitEntityEvent<Target> event) {
        Target target = event.getEntity();
        // Получаем текущего пользователя
        User currentUser = (User) currentAuthentication.getUser();
        // Устанавливаем его в поле user
        target.setUser_id(currentUser);

        //автоматическое заполнение даты
        target.setCreateDate(LocalDateTime.now());
    }




}