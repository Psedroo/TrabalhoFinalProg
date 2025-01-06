package src;

import logicircuit.CmdProcessor;
import logicircuit.LCInputPin;

import java.io.BufferedReader;
import java.io.FileReader;

public class Comando implements CmdProcessor {
    private Circuito circuito;

    public Comando(Circuito circuito){
        this.circuito = circuito;
    }

    //Construtor da classe
    public String process(String cmd) {
        return knowComand(cmd);
    }

    //Metodo para saber qual o comando usado
    public String knowComand(String cmd) {

        //Separa o comando em duas partes, pelo primeiro espaço encontrado
        String[] cmdTokens = cmd.trim().split(" ");


        String returnValue = null;
        switch (cmdTokens[0].toUpperCase()) {
            case "ADD":
                ADD add = new ADD(cmdTokens); //Cria um novo objeto do tipo ADD
                returnValue = add.addComponente(this.circuito);
                break;

            case "WIRE":
                if(circuito.getDispPin(cmdTokens[2], cmdTokens[3])){
                    LCInputPin pin = LCInputPin.valueOf(cmdTokens[3]);
                    returnValue = circuito.addConexao(cmdTokens[1], cmdTokens[2], pin);
                }else{
                    returnValue = "O pin de input nao está disponivel";
                }
                circuito.showConexoes();
                break;

            case "TURN":
                Componente sw;
                if(!circuito.validateComp(cmdTokens[2])){
                    returnValue="Componente Invalido";
                }else{
                    sw = circuito.getComponenteById(cmdTokens[2]);
                    if(sw instanceof Switch){
                        if(cmdTokens[1].equalsIgnoreCase("ON")){
                            ((Switch) sw).setEstado(true);
                        } else if (cmdTokens[1].equalsIgnoreCase("OFF")) {
                            ((Switch) sw).setEstado(false);
                        }else{
                            returnValue="Estado invalido";
                        }
                    }
                }
                break;

            case "SAVE":
                circuito.Save(cmdTokens[1]);
                break;

            case "OPEN":
                try (BufferedReader reader = new BufferedReader(new FileReader(cmdTokens[1]))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        process(linha);

                    }
                    System.out.println("Componentes lidos com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro a dar upload");
                }
                break;

            default:
                returnValue="Valor invalido";
                break;
        }
        circuito.update();
        circuito.draw();
        return returnValue;
    }
}
