package steps;

import drivers.CreateDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class SeuBarrigaSteps extends  CreateDriver{

    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        System.setProperty("webdriver.gecko.driver", "/home/rafael/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://seubarriga.wcaquino.me/login");
    }

    @Quando("informo o usuário {string}")
    public void informo_o_usuário(String string) {
        driver.findElement(By.id("email")).sendKeys(string);
    }

    @Quando("a senha {string}")
    public void a_senha(String string) {
        driver.findElement(By.id("senha")).sendKeys(string);
    }

    @Quando("seleciono entrar")
    public void seleciono_entrar() {
        driver.findElement(By.xpath("//*[text()='Entrar']")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizo_a_página_inicial() {
       String textoDeBemVindo = driver.findElement(By.xpath("//div[text()='Bem vindo, rsaraiva!']")).getText();
       Assert.assertTrue(textoDeBemVindo.equals("Bem vindo, rsaraiva!"));
    }

    @Quando("seleciono Contas")
    public void seleciono_contas() {
        driver.findElement(By.xpath("//*[text()='Contas ']")).click();
    }

    @Quando("seleciono Adicionar")
    public void seleciono_adicionar() {
        driver.findElement(By.xpath("//*[text()='Adicionar']")).click();
    }
    @Quando("informo a conta {string}")
    public void informo_a_conta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
    }

    @Quando("seleciono Salvar")
    public void seleciono_salvar() {
        driver.findElement(By.xpath("//*[text()='Salvar']")).click();
    }
    @Então("a conta é inserida com sucesso")
    public void a_conta_é_inserida_com_sucesso() {
        String textoContaAdicionada = driver.findElement(By.xpath("//*[text()='Conta adicionada com sucesso!']")).getText();
        Assert.assertTrue(textoContaAdicionada.equals("Conta adicionada com sucesso!"));
        driver.quit();
    }

    @Então("sou notificar que o nome da conta é obrigatório")
    public void souNotificarQueONomeDaContaÉObrigatório() {
        String textoNomeDaContaEObrigatorio = driver.findElement(By.xpath("//*[text()='Informe o nome da conta']")).getText();
        Assert.assertTrue(textoNomeDaContaEObrigatorio.equals("Informe o nome da conta"));
        driver.quit();
    }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        String textoContaJaExiste = driver.findElement(By.xpath("//*[text()='Já existe uma conta com esse nome!']")).getText();
        Assert.assertTrue(textoContaJaExiste.equals("Já existe uma conta com esse nome!"));
        driver.quit();
    }

}
