package de.olafj.vaadin.visjsdot;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.server.AbstractStreamResource;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

@Tag("visjs-dot")
@NpmPackage(value = "vis-data", version = "7.1.2")
@NpmPackage(value = "vis-network", version = "9.1.0")
@JsModule("./src/visjs-dot.js")
public class VisJsDotComponent extends Component implements HasStyle, HasSize {

    public void setSource(String url) {
        this.getElement().setAttribute("src", url);
    }

    public void setSource(InputStreamFactory inputStreamFactory) {
        this.setSource(new StreamResource("graph.dot", inputStreamFactory));
    }

    public void setSource(StreamResource streamResource) {
        streamResource.setCacheTime(0);
        streamResource.setContentType("text/plain");
        this.getElement().setAttribute("src", streamResource);
    }

    public String getSource() {
        return this.getElement().getAttribute("src");
    }


}
