package src;

import logicircuit.LCComponent;
import logicircuit.LCInputPin;

import static logicircuit.LCInputPin.*;

public class Conexao {
    Componente begin;
    Componente end;
    LCInputPin pin;
    boolean state;

    public Conexao(Componente begin, Componente end, LCInputPin pin) {
        this.begin = begin;
        this.end = end;
        this.pin = pin;
        this.state = false;
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

    public void drawConexao(){
        Main.panel.drawWire(begin.getComponent(), begin.getX(), begin.getY(), end.getComponent(), end.getX(), end.getY(), pin, getStatusBegin());
    }

    public boolean getStatusBegin(){
        boolean returnvalue = false;
        if(begin instanceof PortaLogica){
            returnvalue=((PortaLogica) begin).getOutputPin();
        }else if(begin instanceof Switch){
            returnvalue=((Switch) begin).getEstado();
        }
        return returnvalue;
    }

    public String toString(){
        return begin.getId() + " " + end.getId() + " " + pin;
    }
//    public Conexao fromSrting(String linha){
//        String[] campos = linha.split("$");
//        return new Conexao(, Componente (campos[2]),LCInputPin.valueOf(campos[3]));
//    }

}
