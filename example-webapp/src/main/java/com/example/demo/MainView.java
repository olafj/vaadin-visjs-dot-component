package com.example.demo;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import de.olafj.vaadin.visjsdot.VisJsDotComponent;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    public MainView() {

        var visJsDot = new VisJsDotComponent();

        var dotGraphContent = "digraph {\n" +
                "  node [shape=circle fontsize=16]\n" +
                "  edge [length=100, color=gray, fontcolor=black]\n" +
                "\n" +
                "  A -> A[label=0.5];\n" +
                "  B -> B[label=1.2] -> C[label=0.7] -- A;\n" +
                "  B -> D;\n" +
                "  D -> {B; C}\n" +
                "  D -> E[label=0.2];\n" +
                "  F -> F;\n" +
                "  A [\n" +
                "    fontcolor=white,\n" +
                "    color=red,\n" +
                "  ]\n" +
                "}";

        visJsDot.setSource(() -> {
            return new ByteArrayInputStream(dotGraphContent.getBytes(StandardCharsets.UTF_8));
        });

        visJsDot.setWidth("600px");
        visJsDot.setHeight("600px");
        visJsDot.getStyle().set("border", "1px solid yellow");


        add(visJsDot);


    }
}
