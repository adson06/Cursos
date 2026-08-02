package loja;

import java.util.Random;

public class Banco {
    public boolean pagamentoRecebido() {
        return new Random().nextBoolean();
    }
}