import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteForum {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","D:\\development\\selenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testCadastro() throws Exception {
    driver.get(baseUrl + "/forum_servlet/");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("teste");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("teste");
    
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(1000);
    
    assertEquals("Usuário e/ou senha inválido(s).", driver.findElement(By.id("mensagem")).getText());
    driver.findElement(By.linkText("Cadastrar usuário")).click();
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Teste");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("teste");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("teste@mail.com");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("teste");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("teste");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("teste");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(1000);
    
    assertEquals("Tópicos", driver.findElement(By.cssSelector("h2")).getText());
  }
  
  @Test
  public void testRanking() throws Exception {
    driver.get(baseUrl + "/forum_servlet/");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("Pedro");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("pedro123");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.linkText("Ranking de usuários")).click();
    Thread.sleep(1000);
    
    assertEquals("Pedro", driver.findElement(By.xpath("//tr[2]/td[3]")).getText());
  }

  @Test
  public void testTopico() throws Exception {
    driver.get(baseUrl + "/forum_servlet/");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("Pedro");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("pedro123");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.linkText("Criar tópico")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.name("titulo")).clear();
    driver.findElement(By.name("titulo")).sendKeys("Topico teste");
    driver.findElement(By.name("conteudo")).clear();
    driver.findElement(By.name("conteudo")).sendKeys("conteudo teste");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(1000);
    
    assertEquals("Pedro Fagundes", driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
