package com.company.smartbudget.view.register;


import com.company.smartbudget.entity.User;
import com.company.smartbudget.view.login.LoginView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import io.jmix.security.role.RoleGrantedAuthorityUtils;
import io.jmix.security.role.assignment.RoleAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@AnonymousAllowed
@Route(value = "register-view")
@Menu()
@ViewController(id = "RegisterView")
@ViewDescriptor(path = "register-view.xml")
public class RegisterView extends StandardView {

    @Autowired
    private UnconstrainedDataManager dataManager;
    @ViewComponent
    private TypedTextField<Object> firstNameField;
    @ViewComponent
    private TypedTextField<Object> lastNameField;
    @ViewComponent
    private TypedTextField<Object> emailField;
    @ViewComponent
    private PasswordField passwordField;
    @ViewComponent
    private TypedTextField<Object> usernameField;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    protected RoleGrantedAuthorityUtils roleGrantedAuthorityUtils;
    @Autowired
    private RoleAssignmentRepository roleAssignmentRepository;

    @Subscribe(id = "backToLoginBtn", subject = "clickListener")
    public void onBackToLoginBtnClick(final ClickEvent<JmixButton> event) {
        UI.getCurrent().navigate(LoginView.class);
    }

    @Subscribe(id = "registerBtn", subject = "clickListener")
    public void onRegisterBtnClick(final ClickEvent<JmixButton> event) {
        User newUser = dataManager.create(User.class);
        newUser.setFirstName(firstNameField.getValue());
        newUser.setLastName(lastNameField.getValue());
        newUser.setUsername(usernameField.getValue());
        newUser.setEmail(emailField.getValue());
        newUser.setPassword(passwordEncoder.encode(passwordField.getValue()));

        dataManager.save(newUser);
        UI.getCurrent().navigate(LoginView.class);
    }
}