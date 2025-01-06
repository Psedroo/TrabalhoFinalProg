package src;

import logicircuit.LCComponent;

public class NOT extends PortaLogica implements Processo {
    private boolean inputPinA;

    public NOT(String id, LCComponent component, int x, int y, String legenda) {
        super(id, component, x, y, legenda);
        this.inputPinA = false;
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

    public void Processar() {
        setOutputPin(!inputPinA);
    }

    public String toString(){
        return getId() + ":" + getComponent() + "@" + getX() + "," + getY() + " " + getLegenda();
    }
    public NOT fromString(String linha){
        String[] campos = linha.split("$");
        return new NOT(campos[0], LCComponent.valueOf(campos[1]),Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),campos[4]);
    }

}
