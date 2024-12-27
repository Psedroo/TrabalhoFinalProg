package src;

import logicircuit.LCComponent;

public class Componente {
    private String id;
    private LCComponent component;
    private int x, y;

    public Componente(LCComponent component, int x, int y) {
        this.id = null;
        this.component = component;
        this.x = x;
        this.y = y;
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
}
