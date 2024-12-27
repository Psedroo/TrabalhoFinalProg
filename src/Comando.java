package src;

import logicircuit.CmdProcessor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Comando implements CmdProcessor {
    //Construtor da classe
    public String process(String cmd) {
        return knowComand(cmd);
    }

    //Metodo para saber qual o comando usado
    public String knowComand(String cmd){

        //Separa o comando em duas partes, pelo primeiro espaço encontrado
        String[] cmdTokens = cmd.trim().split(" ", 2);

        //System.out.println(cmdTokens.length);


        switch (cmdTokens[0].toUpperCase()) {
            case "ADD":
                ADD add = new ADD(cmdTokens[1]); //Cria um novo objeto do tipo ADD
                add.addPortaLogica(); //Chama o metodo "addPortaLogica()"
                break;
            case "WIRE":
                break;

            case "TURN":
                break;
        }
        return "Comando Invalido:)";
    }
}
