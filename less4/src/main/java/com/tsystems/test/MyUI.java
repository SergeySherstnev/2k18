package com.tsystems.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    TextField rowField = new TextField("Размер массива:");
    TextField resField = new TextField("Диагональ:");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        Button button = new Button("Построить");


        button.addClickListener(e -> {
            updateArray();
        });


        layout.addComponents(rowField, button, resField);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    protected void updateArray() {
        int tmpRow=1;
        String outText = new String();
        if (rowField.getValue().matches("[-+]?\\d+") ) {
            tmpRow = Integer.parseInt(rowField.getValue());
            TstArray myArray = new TstArray(tmpRow);
            outText = myArray.getDiag();
        }
        else {
            outText = "Please, insert numeric value";
        }

        resField.setValue(outText);
    }
}
