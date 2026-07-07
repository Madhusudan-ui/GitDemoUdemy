package HTTPAndSSLCertifications;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Proxy {
	
	public static void main(String[] args) {
	
	ChromeOptions options = new ChromeOptions();
	Proxy proxy = new Proxy();
	proxy.setHttpProxy("ipadadress:4444");
	options.setCapability("proxy", proxy);
	


	WebDriver driver = new ChromeDriver(options);
	driver.get("https://expired.badssl.com/");
	System.out.println(driver.getTitle());

}
}
