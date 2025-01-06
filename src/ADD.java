package src;
import logicircuit.LCComponent;
import java.util.Arrays;

public class ADD {
    private String[] txt;

    public ADD(String[] txt) {
        this.txt = txt;
    }

    public String addComponente(Circuito circuito){
        //Divide a String em tokens dividindo a pelos ":@, "
        String[] cmdTokens = txt[1].split("[:@, ]");
        String returnValue = null;
        String legenda = null;

        System.out.println(txt.length);
//        System.out.println(txt[2]); //id
        System.out.println(cmdTokens[0]); //id
        System.out.println(cmdTokens[1]); //Tipo de componente (AND,OR...)
        System.out.println(cmdTokens[2]); // Coordenada x
        System.out.println(cmdTokens[3]); // Coordenada y

        //verificar se tem legenda ou nao
        if ((txt.length > 2) && !cmdTokens[3].isEmpty()) {
            legenda = String.join(" ", Arrays.copyOfRange(txt, 2, txt.length));
//            System.out.println("tem legenda");
        } else {
            legenda = "";
        }


        switch (cmdTokens[1].toUpperCase()) {
            case "SWITCH":

                //Cria uma instancia do objeto
                Switch CompSwitch = new Switch(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]),legenda);
                returnValue = circuito.addCompCircuito(CompSwitch);

//                    System.out.println("Checkpoint1");
                break;

            case "AND":

//                Cria uma instancia do objeto
                AND andComp = new AND(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), legenda);
                returnValue = circuito.addCompCircuito(andComp);
                andComp.Processar();
                break;

            case "OR":

                OR orComp = new OR(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), legenda);
                returnValue = circuito.addCompCircuito(orComp);
                orComp.Processar();
                break;

            case "NOT":

                NOT notComp = new NOT(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), legenda);
                returnValue = circuito.addCompCircuito(notComp);
                notComp.Processar();
                break;

            case "XOR":

                XOR xorComp = new XOR(cmdTokens[0], LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]), legenda);
                returnValue = circuito.addCompCircuito(xorComp);
                xorComp.Processar();
                break;

            case "LED":

                Led ledComp = new Led(cmdTokens[0],LCComponent.valueOf(cmdTokens[1]),Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]),legenda);
                returnValue = circuito.addCompCircuito(ledComp);
                break;
            case "3BD":
                Display DispComp = new Display(cmdTokens[0],LCComponent.BIT3_DISPLAY,Integer.parseInt(cmdTokens[2]), Integer.parseInt(cmdTokens[3]),legenda);
                returnValue = circuito.addCompCircuito(DispComp);
                DispComp.Processar();
                break;
        }
        circuito.draw();
        return returnValue;
    }

}
