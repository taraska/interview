package vaadin.ivannikov.app.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

public class MainLayout extends VerticalLayout implements RouterLayout {
    public MainLayout() {
        add(new H1("My App Header"));
    }
}
