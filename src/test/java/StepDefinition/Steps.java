package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	WebDriver driver;

	@Given("Abrir Chrome")
	public void abrir_Chrome() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se abre el navegador chrome y se dirige al sitio web de pruebas");
		System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9090/ReservaHora/index.jsp");
	}

	@When("ingresa Usuario {string} y Password {string}")
	public void ingresa_Usuario_y_Password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se ingresan las credenciales de usuario ya cargadas en la base de datos");
		driver.findElement(By.id("username")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
	}

	@Then("inicia sesion")
	public void inicia_sesion() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se inicia sesion exitosamente y se muestra el listado de horas agendadas");
		System.out.println("Si las credenciales son incorrectas se mostrara el mensaje de Credenciales Invalidas");
		driver.findElement(By.id("loginbtn")).click();
	}
	
	@Given("Abrir Navegador Chrome")
	public void abrir_Navegador_Chrome() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se abre el navegador chrome y se dirige al sitio web de pruebas");
		System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9090/ReservaHora/index.jsp");
	}

	@When("ingresar Usuario {string} y Password {string}")
	public void ingresar_Usuario_y_Password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se ingresan las credenciales de usuario ya cargadas en la base de datos");
		driver.findElement(By.id("username")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
	}
	
	@When("iniciar sesion")
	public void iniciar_sesion() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se inicia sesion exitosamente y se muestra el listado de horas agendadas");
		driver.findElement(By.id("loginbtn")).click();
	}
	
	@When("hace click en Nuevo Agendamiento")
	public void hace_click_en_Nuevo_Agendamiento() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Con el acceso correto el usuario hace click en Nuevo Agendamiento para crear un nuevo registro");
		driver.findElement(By.id("agendar")).click();
	}

	@Then("ingresa los datos para el agendamiento idmascota {string} rutDueno {string} nombreMascota {string} fecha y hora {string}")
	public void ingresa_los_datos_para_el_agendamiento_idmascota_rutDueno_nombreMascota_fecha_y_hora(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se poblan los inputs con los datos para el registro");
		driver.findElement(By.id("idMascota")).sendKeys(string);
		driver.findElement(By.id("rutDueno")).sendKeys(string2);
		driver.findElement(By.id("nombreMascota")).sendKeys(string3);
		driver.findElement(By.id("datetimepicker")).sendKeys(string4);
	}

	@Then("crea nuevo agendamiento")
	public void crea_nuevo_agendamiento() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("En este paso se guardan los datos al hacer click en guardar y el nuevo registro aparece en la lista");
	    driver.findElement(By.id("guardar")).click();
	    driver.navigate().refresh();
	}
}
