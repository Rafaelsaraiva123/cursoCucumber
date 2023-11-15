package entidades;

import java.util.Date;

public class NotaDeAluguel {
    public int preco;
    private Date dataEntrega;
    private int pontuacao;

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }

}
