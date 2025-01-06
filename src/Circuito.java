package src;

import logicircuit.LCComponent;
import logicircuit.LCInputPin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Circuito {
    private HashMap<String, Componente> componentes;
    private HashSet<Conexao> conexoes;

    public Circuito() {
        componentes = new HashMap<>();
        conexoes = new HashSet<>();
    }

    public HashMap<String, Componente> getComponenentes() {
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

    public Componente getComponenteById(String id) {
        Componente compId = componentes.get(id);
        System.out.println(compId);
        return componentes.get(id);
    }

    public String addCompCircuito(Componente comp){
        String status = null;
        if(componentes.containsKey(comp.getId())){
            status = "Componente ja está definido";
        }else{
            componentes.put(comp.getId(),comp);
            status = "Adicionado com sucesso";
        }
//        System.out.println(status);
        return status;
    }

    public String addConexao(String begin, String end, LCInputPin pin) {
        String status = null;
        Conexao con;
        Componente compBegin = componentes.get(begin);
        Componente compEnd = componentes.get(end);
        if (compBegin == null || compEnd == null) {
            status = "Componente não encontrado";
        } else {

            con = new Conexao(compBegin, compEnd, pin);
//          Verifica se o componente de inicio esta ligado para tornar a conexao verde antes de a guardar
            if(con.getStatusBegin()){
                con.setState(true);
            }
            conexoes.add(con);
            status = "Conexão adicionada com sucesso";
        }
        return status;
    }

    public void showComponentes(){
        for(Componente cp: componentes.values()) {
            System.out.println(cp.getId());
        }
    }
    public void showConexoes(){
        for(Conexao cp: conexoes) {
            System.out.println(cp.getBegin() +"/"+cp.getEnd());
        }
    }

    public void draw() {
        Main.panel.clear();

        for (Componente comp : componentes.values()) {
            if (comp.getComponent() == LCComponent.BIT3_DISPLAY && comp instanceof Display) {
                Main.panel.drawComponent(LCComponent.BIT3_DISPLAY, comp.getX(), comp.getY(), ((Display) comp).getValue());
            } else {
                if (comp.getComponent() == LCComponent.LED && comp instanceof Led) {
                    Led led = (Led)comp;
                    Main.panel.drawComponent(LCComponent.LED, comp.getX(), comp.getY(), led.getInputPinA(), comp.getLegenda());
                }else{
                    if (comp.getComponent() == LCComponent.SWITCH && comp instanceof Switch) {
                        Switch sw = (Switch)comp;
                        Main.panel.drawComponent(LCComponent.SWITCH,comp.getX(), comp.getY(), sw.getEstado(), comp.getLegenda());
                    }else{
                        Main.panel.drawComponent(comp.getComponent(), comp.getX(), comp.getY(), comp.getLegenda());
                    }
                }
            }
        }

        for (Conexao con : conexoes) {

                Main.panel.drawWire(con.getBegin().getComponent(), con.getBegin().getX(), con.getBegin().getY(),
                        con.getEnd().getComponent(), con.getEnd().getX(), con.getEnd().getY(), con.getPin(),
                        con.getState());

        }
    }

    public void setStateConexao(String begin, String end){
        for(Conexao con: conexoes){
            if(con.getBegin().getId().equals(begin) && con.getEnd().getId().equals(end)){
                if(con.getBegin() instanceof PortaLogica){
                    PortaLogica pt = (PortaLogica) con.getBegin();
                    con.setState(pt.getOutputPin());
                }
            }
        }
    }

    public void setStateConexaoSwitch(){
        for(Conexao con: conexoes){
            if(con.getBegin() instanceof Switch){
                Switch sw1 = (Switch) con.getBegin();
                con.setState(sw1.getEstado());
//                System.out.println(sw1.getEstado());
//                System.out.println(sw1.getId());
            }
        }
    }

    //Define o estado dos pin do componente
    public void setInputPin(){
        for(Conexao con: conexoes){
            //define o estado da conexão
            setStateConexao(con.getBegin().getId(), con.getEnd().getId());
            for(Componente comp: componentes.values()){

                if(comp.getId().equals(con.getEnd().getId())){

                    //Verificar o pin
                    if(con.getPin()==LCInputPin.PIN_A){

                        //Por definiçao lança um erro(definido em componente)
                        try{

                            //tenta chamar a funçao "setInputPinA(true)" que foi overrited, se nao conseguir chama a que esta na class componente
                            comp.setInputPinA(con.getState());

                        //Apanha o erro mandado na class componente
                        } catch (Exception e) {

                            System.out.println("Nao existe esse pin A");
                        }
                    }
                    if(con.getPin()==LCInputPin.PIN_B){
                        try{
                            comp.setInputPinB(con.getState());
                        } catch (Exception e) {
                            System.out.println("Nao existe esse pin B");
                        }
                    }
                    if(con.getPin()==LCInputPin.PIN_C){
                        try{
                            comp.setInputPinC(con.getState());
                        } catch (Exception e) {
                            System.out.println("Nao existe esse pin C");
                        }
                    }
                }
            }
        }
    }

    //Função de atualizar
    public void update(){
        setStateConexaoSwitch();
        for(int i=0; i< componentes.size()+1; i++){
            setInputPin();
        }

    }

    public boolean validateComp(String id){
        return componentes.containsKey(id);
    }

    //Verifica se o pin ja esta conectado a algum fio
    public boolean getDispPin(String end, String pin){
        Componente compEnd = getComponenteById(end);

        for(Conexao con: conexoes){
            if(con.getEnd().getId().equals(compEnd.getId()) && con.getPin().toString().equals(pin)){
                return false;
            }
        }
        return true;
    }

    public String Save( String name){
        try (FileWriter writer = new FileWriter(name)) {

            for(Componente comp: componentes.values()){
                writer.write("ADD " + comp.toString() + "\n");
            }

            for (Conexao con : conexoes) {
                writer.write("WIRE "+con.toString() + "\n");  // Escreve cada conexão numa nova linha
            }
            System.out.println("Conexões guardadas com sucesso!");
            return "Guardado com sucesso!";
        } catch (Exception e) {
            return "Erro ao guardar!";
        }
    }






}
