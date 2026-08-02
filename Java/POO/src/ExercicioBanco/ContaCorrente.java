package ExercicioBanco;

public class ContaCorrente extends Conta{

    private boolean isUtilizaCheque;

    public void informarCheque(boolean isUtilizaCheque){
        this.isUtilizaCheque = isUtilizaCheque;
    }
}
