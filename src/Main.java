package src;

import logicircuit.LCComponent;
import logicircuit.LCDFrameCmd;
import logicircuit.LCDPanel;

public class Main {
    public static LCDPanel panel;

    public static void main(String[] args) {
        Circuito circuito = new Circuito();
//        System.out.println("Checkpoint Main1");
        Comando Com = new Comando(circuito);
//        System.out.println("Checkpoint Main2");
        LCDFrameCmd frame = new LCDFrameCmd(Com,"Demo de Logic Circuit", 900, 700);
        panel = frame.drawPanel();
    }
}
