package steps;

import entidades.NotaDeAluguel;
import entidades.TipoAluguel;
import io.cucumber.java.be.I;
import org.junit.Assert;
import servicos.AluguelService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import entidades.Filme;
import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class AlugarFilmesSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaDeAluguel nota;
    String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

    @Dado("um filme com estoque de {int} unidades")
    public void um_filme_com_estoque_de_unidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @E("que o preco do aluguel seja R$ {int}")
    public void que_o_preco_do_aluguel_seja_r$(Integer int1) {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }
    }

    @Entao("o preco do aluguel sera R$ {int}")
    public void o_preco_do_aluguel_sera_r$(Integer int1) {
        Assert.assertTrue(int1 == nota.getPreco());
    }

    @E("o estoque do filme sera {int} unidade")
    public void o_estoque_do_filme_sera_unidade(Integer int1) {
        Assert.assertTrue(int1 == filme.getEstoque());
    }


    @Entao("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        System.out.println(erro);
        Assert.assertTrue(erro.equals("Filme sem estoque"));
    }

    @Dado("^que o tipo de aluguel seja (.*)$")
    public void que_o_tipo_de_aluguel_seja_extendido(String categoria) {
        tipoAluguel = categoria.equals("semanal")? TipoAluguel.SEMANAL: categoria.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
    }

    @Entao("a data de entrega sera em {int} dias")
    public void a_data_de_entrega_sera_em_dias(Integer int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertTrue(format.format(dataEsperada).equals(format.format(dataReal)));
    }

    @Entao("a pontuacao sera de {int} pontos")
    public void a_pontuacao_sera_de_pontos(Integer int1) {
        Assert.assertTrue(int1 == nota.getPontuacao());
    }


    @Dado("um filme")
    public void umFilme(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));
    }


}
