package com.company.smartbudget.view.recommendation;

import com.company.smartbudget.entity.Recommendation;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "recommendations/:id", layout = MainView.class)
@ViewController(id = "Recommendation.detail")
@ViewDescriptor(path = "recommendation-detail-view.xml")
@EditedEntityContainer("recommendationDc")
public class RecommendationDetailView extends StandardDetailView<Recommendation> {
}