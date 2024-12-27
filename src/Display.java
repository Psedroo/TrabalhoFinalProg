package src;

import logicircuit.LCComponent;

public class Display extends Componente {
    private int value;

    public Display(LCComponent component, int x, int y, int value){
        super(component,x,y);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
