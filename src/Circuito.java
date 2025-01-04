package src;

import logicircuit.LCDPanel;

import java.util.*;

public class Circuito {
    private HashMap<String, Componente> componentes;
    private HashSet<Conexao> conexoes;

    public Circuito() {
        componentes = new HashMap<>();
        conexoes = new HashSet<>();
    }

    public HashMap<String, Componente> getComponenetes() {
        return componentes;
    }

    public void setComponenetes(HashMap<String, Componente> componenetes) {
        this.componentes = componenetes;
    }

    public HashSet<Conexao> getConexoes() {
        return conexoes;
    }

    public void setConexoes(HashSet<Conexao> conexoes) {
        this.conexoes = conexoes;
    }

    public String addCompCircuito(Componente comp){
        String status = null;
        if(componentes.containsKey(comp.getId())){
            status = "Componente ja está definindo";
        }else{
            componentes.put(comp.getId(),comp);
            status = "Adicionado com sucesso";
        }
        System.out.println(status);
        return status;
    }

    public Componente getComponente(String id) {
        return componentes.get(id);
    }

    public void showComponentes(){
        for(Componente cp: componentes.values()) {
            System.out.println(cp.getId());
        }
    }

    public void draw() {
        Main.panel.clear();;
        for(Componente comp: componentes.values()) {
            Main.panel.drawComponent(comp.getComponent(), comp.getX(), comp.getY());
        }
        for(Conexao con: conexoes) {
            Main.panel.drawWire(con.getBegin().getComponent(),con.getBegin().getX(),con.getBegin().getY(),con.getEnd().getComponent(),con.getEnd().getX(),con.getEnd().getY(),con.getPin(),con.getState());

        }
    }
}
