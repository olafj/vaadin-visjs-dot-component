import { css, html, LitElement} from "lit-element";
import * as vis from "vis-network/standalone/esm/vis-network";

class VisJsDot extends LitElement {

    static get properties() {
        return {
            src: { type: String }
        };
    }

    static get styles() {
        return css`
            #canvas-container {
                width: 100%;
                height: 100%;
            }
        `
    };

    constructor() {
        super();
        this.src = '';
    }


    firstUpdated(_changedProperties) {
        super.firstUpdated(_changedProperties);

        var container = this.shadowRoot.getElementById("canvas-container");

        var options = {};
        var data = {};
        var network = new vis.Network(container, data, options);

        this.fetchDotSource().then(dot => {
            data = vis.parseDOTNetwork(dot);
            network.setData(data);
        })
    }

    render() {
        return html`
            <div id="canvas-container"></div>
        `;
    }

    async fetchDotSource() {
        const response = await fetch(this.src);
        const dot = await response.text();
        return dot;
    }


}

customElements.define("visjs-dot", VisJsDot);