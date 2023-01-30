package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectLocator = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
			// WebDriverManager.firefoxdriver().setup(); //Download hơi lâu nên xài manual
			System.setProperty("webdriver.gecko.driver", projectLocator + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
			// System.setProperty("webdriver.chrome.driver", projectLocator +
			// "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.EDGE_CHROMIUM) {
			// System.setProperty("webdriver.edge.driver", projectLocator +
			// "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser == Browser.OPERA) {
			System.setProperty("webdriver.opera.driver", projectLocator + "\\browserDriver\\msedgedriver.exe");
			// WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browser == Browser.CHROME_HEADLESS) {
			// System.setProperty("webdriver.edge.driver", projectLocator +
			// "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			// System.setProperty("webdriver.edge.driver", projectLocator +
			// "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("-headless");
			firefoxOpt.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOpt);
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
			// WebDriverManager.firefoxdriver().setup(); //Download hơi lâu nên xài manual
			System.setProperty("webdriver.gecko.driver", projectLocator + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
			// System.setProperty("webdriver.chrome.driver", projectLocator +
			// "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.EDGE_CHROMIUM) {
			// System.setProperty("webdriver.edge.driver", projectLocator +
			// "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser == Browser.OPERA) {
			System.setProperty("webdriver.opera.driver", projectLocator + "\\browserDriver\\msedgedriver.exe");
			// WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browser == Browser.CHROME_HEADLESS) {
			// System.setProperty("webdriver.edge.driver", projectLocator +
			// "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			// System.setProperty("webdriver.edge.driver", projectLocator +
			// "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("-headless");
			firefoxOpt.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOpt);
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public String getDirectorySlash(String folderName) {
		if (isMac() || isLinux()) {
			folderName = "/" + folderName + "/";
		} else if (isWindow()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindow() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isLinux() {
		return (osName.toLowerCase().indexOf("linux") >= 0);
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
