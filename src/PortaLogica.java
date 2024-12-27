package src;

import logicircuit.LCComponent;

public class PortaLogica extends Componente {
    private boolean state;
    private String legend;

    public PortaLogica(LCComponent component, int x, int y){
        super(component,x,y);
        this.state = false;
        this.legend = null;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }
}
