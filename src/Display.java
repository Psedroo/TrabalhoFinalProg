package src;

import logicircuit.LCComponent;

public class Display extends Componente implements Processo{
    private boolean inputPinA;
    private boolean inputPinB;
    private boolean inputPinC;
    private int value;

    public Display(String id, LCComponent component, int x, int y, String legenda){
        super(id,component,x,y,legenda);
        this.value = 0;
        this.inputPinA = false;
        this.inputPinB = false;
        this.inputPinC = false;
    }

    public boolean getInputPinA() {
        return inputPinA;
    }

    @Override
    public void setInputPinA(boolean inputPinA) {
        this.inputPinA = inputPinA;
        //Sempre que o pin é definido com um novo valor é chamada a função processar para atualizar o display
        Processar();
    }

    public boolean getInputPinB() {
        return inputPinB;
    }

    @Override
    public void setInputPinB(boolean inputPinB) {
        this.inputPinB = inputPinB;
        Processar();
    }

    public boolean getInputPinC() {
        return inputPinC;
    }

    @Override
    public void setInputPinC(boolean inputPinC) {
        this.inputPinC = inputPinC;
        Processar();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void Processar(){
        int valor=0;
        System.out.println("processar" + getInputPinA());
        System.out.println(getInputPinB());
        System.out.println(getInputPinC());
        if(getInputPinA()){
            valor+=4;
        }
        if (getInputPinB()){
            valor+=2;
        }
        if (getInputPinC()){
            valor+=1;
        }
        setValue(valor);
    }

    public String toString(){
        return getId() + ":" + getComponent() + "@" + getX() + "," + getY() + " " + getLegenda();
    }
    public Display fromString(String linha){
        String[] campos = linha.split("$");
        return new Display(campos[0], LCComponent.valueOf(campos[1]),Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),campos[4]);
    }
}
