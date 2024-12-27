package src;
import logicircuit.LCComponent;
import java.util.Arrays;

import logicircuit.LCDFrameCmd;
import logicircuit.LCDPanel;
import static logicircuit.LCComponent.*;
import static logicircuit.LCComponent.SWITCH;

public class ADD {

    private String txt;

    public ADD(String txt) {
        this.txt = txt;

    }

    public void drawComponete(String[] cmdTokens ){

        String legenda = null; //Iniciar a variavel que guarda a legenda
        String Componente = "LCComponent" + cmdTokens[1];

        if ((cmdTokens.length > 4) && !cmdTokens[4].isEmpty()) { //verificar se tem legenda ou nao

            legenda = String.join(" ", Arrays.copyOfRange(cmdTokens, 4, cmdTokens.length)); //Se tiver guarada a na variavel

            //System.out.println(cmdTokens[1]);

            Main.panel.drawComponent(LCComponent.valueOf(cmdTokens[1]), Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), legenda); //Desenhar o componente

        }else{

            Main.panel.drawComponent(LCComponent.valueOf(cmdTokens[1]), Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3])); //Desenhar o componente sem legenda

        }
    }

    public void addPortaLogica(){
        String[] cmdTokens = txt.split("[:@, ]");
        System.out.println(txt);
        //System.out.println(cmdTokens[0]); //id
        //System.out.println(cmdTokens[1]); //Tipo de componente (AND,OR...)
        //System.out.println(cmdTokens[2]); // Coordenada x
        //System.out.println(cmdTokens[3]); // Coordenada y

        drawComponete(cmdTokens); //chamar o metodo drawComponete()
        switch (cmdTokens[1]) {
            case 1:
                break;

    }

}
