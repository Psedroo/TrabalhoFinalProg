package src;

import logicircuit.LCComponent;
import logicircuit.LCDFrameCmd;
import logicircuit.LCDPanel;

public class Main {
    public static LCDPanel panel;

    public static void main(String[] args) {
        Comando Com = new Comando();
        LCDFrameCmd frame = new LCDFrameCmd(Com,"Demo de Logic Circuit", 900, 700);
        panel = frame.drawPanel();
       /* panel.drawComponent(LCComponent.AND,100,100);*/
    }
}
