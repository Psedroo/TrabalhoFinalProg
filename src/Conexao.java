package src;

import logicircuit.LCInputPin;

public class Conexao {
    Componente begin;
    Componente end;
    LCInputPin pin;
    boolean state;

    public Conexao(Componente begin, Componente end, LCInputPin pin, boolean state) {
        this.begin = begin;
        this.end = end;
        this.pin = pin;
        this.state = state;
    }

    public Componente getBegin() {
        return begin;
    }

    public void setBegin(Componente begin) {
        this.begin = begin;
    }

    public Componente getEnd() {
        return end;
    }

    public void setEnd(Componente end) {
        this.end = end;
    }

    public LCInputPin getPin() {
        return pin;
    }

    public void setPin(LCInputPin pin) {
        this.pin = pin;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void drawConexao() {
        Main.panel.drawWire(begin.getComponent(), begin.getX(), begin.getY(), end.getComponent(), end.getX(), end.getY(), pin, state);
    }
}
