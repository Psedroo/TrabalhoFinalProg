package src;

import logicircuit.LCComponent;

public class AND extends PortaLogica implements Processo{
    private boolean inputPinA;
    private boolean inputPinB;

    public AND(String id, LCComponent component, int x, int y, String legenda) {
        super(id,component,x,y,legenda);
        this.inputPinA = false;
        this.inputPinB = false;
    }

    @Override
    public boolean getInputPinA() {
        return inputPinA;
    }

    @Override
    public void setInputPinA(boolean inputPinA) {
        this.inputPinA = inputPinA;
        Processar();
    }

    @Override
    public boolean getInputPinB() {
        return inputPinB;

    }

    @Override
    public void setInputPinB(boolean inputPinB) {
        this.inputPinB = inputPinB;
        Processar();
    }

    public void Processar(){
        setOutputPin(inputPinA && inputPinB);
    }

    public String toString(){
        return getId() + ":" + getComponent() + "@" + getX() + "," + getY() + " " + getLegenda();
    }

    public AND fromString(String linha){
        String[] campos = linha.split("$");
        return new AND(campos[0], LCComponent.valueOf(campos[1]),Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),campos[4]);
    }

}
