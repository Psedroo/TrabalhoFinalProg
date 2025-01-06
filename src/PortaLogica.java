package src;

import logicircuit.LCComponent;

public class PortaLogica extends Componente {
        private boolean outputPin;

    //Construtor sem legenda
    public PortaLogica(String id, LCComponent component, int x, int y, String legenda){
        super(id,component,x,y,legenda);
        this.outputPin = false;
    }

    public boolean getOutputPin() {
        return outputPin;
    }

    public void setOutputPin(boolean outputPin) {
        this.outputPin = outputPin;
    }



}
