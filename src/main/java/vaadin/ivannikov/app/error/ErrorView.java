package vaadin.ivannikov.app.error;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.servlet.http.HttpServletResponse;
import vaadin.ivannikov.app.view.MainLayout;

@Route(value = "error", layout = MainLayout.class)
@PageTitle("Error")
public class ErrorView extends VerticalLayout implements HasErrorParameter<Exception> {

    private final Span error = new Span();

    public ErrorView() {
        add(new H1("Something went wrong"), error);
    }

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<Exception> parameter) {
        error.setText(parameter.getCustomMessage());
        return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    }
}

