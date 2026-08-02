package loja;

import java.util.Random;

public class Credito {
    public boolean verificarCredito(Cliente cliente) {
        return !cliente.isInadimplente() && new Random().nextBoolean();
    }
}