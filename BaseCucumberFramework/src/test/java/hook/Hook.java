package hook;

import java.time.Duration;

import org.framework.base.Base;
import org.framework.repository.WelcomePage;
import org.framework.utility.FrameworkLibrary;
import org.framework.utility.PropertyFileReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	Base base;
	public Hook(Base base) {
		this.base=base;
	}
	public void initObjects() {
		base.welcomePage=new WelcomePage(base.driver);
	}

	@Before
	public void initBrowser(Scenario scenario) throws Throwable {
		base.propertyFileReader=new PropertyFileReader();
		base.library=new FrameworkLibrary();
		if(base.propertyFileReader.getValueProperty("browser").equalsIgnoreCase("chrome")){
		base.driver=new ChromeDriver();
		}else if(base.propertyFileReader.getValueProperty("browser").equalsIgnoreCase("firefox")) {
		base.driver=new FirefoxDriver();
		}else
		scenario.log("Browser name is not valid");
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		base.driver.get("https://demowebshop.tricentis.com/");
		initObjects();
	}
	
	@After
	public void quitBrowser(Scenario scenario) {
	if(scenario.isFailed()) {
		try {
			scenario.attach(base.library.takeScreenshot(base.driver), "image/png", scenario.getName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	base.driver.close();
	}
}
