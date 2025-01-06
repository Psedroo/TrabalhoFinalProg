package src;

import logicircuit.LCComponent;

public class Switch extends Componente {

    private boolean estado;

    public Switch(String id, LCComponent component, int x, int y, String legenda){
        super(id,component,x,y,legenda);
        this.estado = false;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String toString(){
        return getId() + ":" + getComponent() + "@" + getX() + "," + getY() + " " + getLegenda();
    }
    public AND fromSrting(String linha){
        String[] campos = linha.split("$");
        return new AND(campos[0], LCComponent.valueOf(campos[1]),Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),campos[4]);
    }
}
