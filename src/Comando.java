package src;

import logicircuit.CmdProcessor;
import logicircuit.LCComponent;
import logicircuit.LCInputPin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

//--------------------------
        /*System.out.println("Inicio");
        for (String token : cmdTokens) {
            System.out.println(token);
        }
        System.out.println("Inicio");*/
//---------------------------

        String returnValue = null;
        switch (cmdTokens[0].toUpperCase()) {
            case "ADD":
                ADD add = new ADD(cmdTokens); //Cria um novo objeto do tipo ADD
                returnValue = add.addPortaLogica(this.circuito);

                break;

            case "WIRE":
                boolean state=false;
                if ((cmdTokens.length > 3) && !cmdTokens[3].isEmpty()) { //verificar se tem estado
                    state = Boolean.parseBoolean(cmdTokens[4]);
                }

                Componente outputCom = circuito.getComponente(cmdTokens[1]);
                Componente inputCom = circuito.getComponente(cmdTokens[2]);
                LCInputPin pin = LCInputPin.valueOf(cmdTokens[3]);
                Conexao con = new Conexao(outputCom, inputCom, pin, state);
                con.drawConexao();
                break;

            case "TURN":
                break;

            default:
                returnValue="Valor invalido";
                break;
        }
        return returnValue;
    }
}
