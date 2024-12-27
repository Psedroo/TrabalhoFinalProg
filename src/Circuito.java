package src;

import logicircuit.LCDPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuito {
    private Map<String, Componente> componenetes;
    private List<Conexao> conexoes;
    private LCDPanel drawPanel;

    public Circuito(LCDPanel drawPanel) {
        componenetes = new HashMap<>();
        conexoes = new ArrayList<>();
        this.drawPanel = drawPanel;
    }
}
