package src;

import logicircuit.LCComponent;

public class AND extends PortaLogica implements Processo{
    private boolean inputPinA;
    private boolean inputPinB;

    public AND(String id, LCComponent component, int x, int y, String legenda, boolean outputPin, boolean inputPinA, boolean inputPinB) {
        super(id,component,x,y,legenda,outputPin);
        this.inputPinA = inputPinA;
        this.inputPinB = inputPinB;
    }

    public void Processar(boolean inputPinA, boolean inputPinB){
        setOutputPin(inputPinA && inputPinB);
    }

    public void drawComponente(){
        LCComponent ptl = getComponent();
        Main.panel.drawComponent(ptl, getX(), getY(), getLegenda());
    }

}
