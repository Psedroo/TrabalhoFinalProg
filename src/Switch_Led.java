package src;

import logicircuit.LCComponent;

public class Switch_Led extends Componente {

    private boolean estado;

    public Switch_Led(String id, LCComponent component, int x, int y, boolean estado, String legenda){
        super(id,component,x,y,legenda);
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void drawComponete(){
        LCComponent ptl = getComponent();
        Main.panel.drawComponent(ptl, getX(), getY(), getEstado(), getLegenda() );
    }
}
