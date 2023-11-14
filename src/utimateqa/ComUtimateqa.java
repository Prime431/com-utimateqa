package utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class ComUtimateqa {
    static WebDriver driver;
    static String baseURL = "https://courses.ultimateqa.com/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the BrowserName");
        String browserName = scanner.nextLine();
        chooseBrowser(browserName);
        loginFunctionality();
        scanner.close();
    }

    // using method for choosing browser
    public static void chooseBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Enter Wrong browser name");
        }
    }

    public static void loginFunctionality() {
        driver.get(baseURL);// opening the URL
        System.out.println("Print the Title : " + driver.getTitle()); // printing the title
        System.out.println("Print the current URL : " + driver.getCurrentUrl()); // printing current url
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit time for holding the process
        System.out.println("Printing the page source : " + driver.getPageSource());// getting the page source
        driver.findElement(By.linkText("Sign In")).click();
        System.out.println("Print the current URL : " + driver.getCurrentUrl()); // printing current url
        driver.findElement(By.id("user[email]")).sendKeys("Vishal@gmail.com");//entering email
        driver.findElement(By.id("user[password]")).sendKeys("Password");//entering password
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.navigate().to(baseURL); // navigate to baseurl
        driver.navigate().forward(); // forwarding to homepage
        driver.navigate().to(baseURL);
        driver.navigate().refresh();// refreshing the page
        System.out.println("Testing is Pass");
        driver.close();//closing the browser

    }

}
