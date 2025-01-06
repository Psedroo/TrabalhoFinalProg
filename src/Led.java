package src;

import logicircuit.LCComponent;

public class Led extends Componente{
    private boolean inputPinA;

    public Led(String id, LCComponent component, int x, int y, String legenda) {
        super(id, component, x, y, legenda);
        this.inputPinA = false;
    }

    @Override
    public void setInputPinA(boolean estado) {
        this.inputPinA = estado;
    }

    @Override
    public boolean getInputPinA() {
        return inputPinA;
    }

    public String toString(){
        return getId() + ":" + getComponent() + "@" + getX() + "," + getY() + " " + getLegenda();
    }

    public Led fromString(String linha){
        String[] campos = linha.split("$");
        return new Led(campos[0], LCComponent.valueOf(campos[1]),Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),campos[4]);
    }
}
