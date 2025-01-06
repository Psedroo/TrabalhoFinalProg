package src;

import logicircuit.LCComponent;

public class Componente {
    private String id;
    private LCComponent component;
    private int x, y;
    private String legenda;

    public Componente(String id, LCComponent component, int x, int y, String legenda) {
        this.id = id;
        this.component = component;
        this.x = x;
        this.y = y;
        this.legenda = legenda;
    }

    public boolean getInputPinA() throws Exception {
        throw new Exception("Nao tenho este input");
    }

    public void setInputPinA(boolean inputPinA) throws Exception {
        throw new Exception("Nao tenho este input");
    }

    public boolean getInputPinB()  throws Exception {
        throw new Exception("Nao tenho este input");
    }


    public void setInputPinB(boolean inputPinB) throws Exception {
        throw new Exception("Nao tenho este input");
    }

    public boolean getInputPinC()  throws Exception {
        throw new Exception("Nao tenho este input");
    }

    public void setInputPinC(boolean inputPinC) throws Exception {
        throw new Exception("Nao tenho este input");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LCComponent getComponent() {
        return component;
    }

    public void setComponent(LCComponent component) {
        this.component = component;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }
}
