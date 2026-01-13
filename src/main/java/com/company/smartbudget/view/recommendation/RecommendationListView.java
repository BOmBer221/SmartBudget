package com.company.smartbudget.view.recommendation;

import com.company.smartbudget.entity.Recommendation;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "recommendations", layout = MainView.class)
@ViewController(id = "Recommendation.list")
@ViewDescriptor(path = "recommendation-list-view.xml")
@LookupComponent("recommendationsDataGrid")
@DialogMode(width = "64em")
public class RecommendationListView extends StandardListView<Recommendation> {
}