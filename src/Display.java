package src;

import logicircuit.LCComponent;

public class Display extends Componente {
    private int value;

    public Display(String id, LCComponent component, int x, int y, String legenda, int value){
        super(id,component,x,y,legenda);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
