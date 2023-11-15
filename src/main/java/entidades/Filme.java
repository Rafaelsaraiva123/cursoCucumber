package entidades;

public class Filme {

    public int aluguel;
    private int estoque;

    public void setEstoque(Integer int1) {
        this.estoque = int1;
    }

    public void setAluguel(Integer int1) {
        this.aluguel = int1;
    }

    public int getAluguel() {
        return aluguel;
    }

    public Integer getEstoque() {
        return estoque;
    }

}
