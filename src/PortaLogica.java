package src;

import logicircuit.LCComponent;

public class PortaLogica extends Componente {
        private boolean outputPin;

    //Construtor sem legenda
    public PortaLogica(String id, LCComponent component, int x, int y, String legenda, boolean outputPin){
        super(id,component,x,y,legenda);
        this.outputPin = outputPin;
    }

    public boolean isOutputPin() {
        return outputPin;
    }

    public void setOutputPin(boolean outputPin) {
        this.outputPin = outputPin;
    }



}
