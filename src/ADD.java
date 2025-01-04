package src;
import logicircuit.LCComponent;
import java.util.Arrays;

public class ADD {
    private String[] txt;

    public ADD(String[] txt) {
        this.txt = txt;
    }

    public String addPortaLogica(Circuito circuito){
        String[] cmdTokens = txt[1].split("[:@, ]"); //Divide a String em tokens dividindo a pelos ":@, "
        String returnValue = null;
        String legenda = null;

        System.out.println(txt.length);
        System.out.println(cmdTokens[0]); //id
        System.out.println(cmdTokens[1]); //Tipo de componente (AND,OR...)
        System.out.println(cmdTokens[2]); // Coordenada x
        System.out.println(cmdTokens[3]); // Coordenada y


        if ((txt.length > 2) && !cmdTokens[3].isEmpty()) { //verificar se tem legenda ou nao
            legenda = String.join(" ", Arrays.copyOfRange(cmdTokens, 4, cmdTokens.length));
//            System.out.println("tem legenda");
        } else {
            legenda = "";
        }


        switch (cmdTokens[1].toUpperCase()) {
            case "SWITCH":

                //Cria uma instancia do objeto
                Switch_Led CompSwitch = new Switch_Led(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]),false, legenda);
                returnValue = circuito.addCompCircuito(CompSwitch);
                circuito.draw();
//                    System.out.println("Checkpoint1");
                break;

            case "AND":

//                Cria uma instancia do objeto
                AND andComp = new AND(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), legenda, );
                returnValue = circuito.addCompCircuito(andComp);

                    System.out.println("Checkpoint1");
                break;

            /*default:
                if ((cmdTokens.length > 4) && !cmdTokens[4].isEmpty()) { //verificar se tem legenda ou nao
                    legenda = String.join(" ", Arrays.copyOfRange(cmdTokens, 4, cmdTokens.length));

                } else {
                    legenda = "";
                }
                //Cria uma instancia do objeto com legenda
                PortaLogica portalogica = new PortaLogica(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]), Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), );
                returnValue = circuito.addCompCircuito(portalogica);
                portalogica.drawComponete();
//                    System.out.println("Checkpoint1");

//                System.out.println("Checkpoint2");
                circuito.showComponentes();*/
        }
        return returnValue;
    }

}
