package src;

import logicircuit.LCComponent;
import logicircuit.LCDFrameCmd;
import logicircuit.LCDPanel;
import logicircuit.LCInputPin;

import static logicircuit.LCComponent.BIT3_DISPLAY;

public class Main {
    public static LCDPanel panel;

    public static void main(String[] args) {
        Circuito circuito = new Circuito();

        Comando Com = new Comando(circuito);
//        System.out.println("Checkpoint Main2");
        LCDFrameCmd frame = new LCDFrameCmd(Com,"Demo de Logic Circuit", 900, 700);
        panel = frame.drawPanel();
        circuito.draw();
    }
}
