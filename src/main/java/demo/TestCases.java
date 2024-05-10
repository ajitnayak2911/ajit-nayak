package demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        // Implicitly wait for elements to be found
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Fill out the form fields
        WebElement nameField = driver.findElement(By.xpath("(//input[@tabindex='0'])[1]"));
        nameField.click();
        nameField.sendKeys("Ajit Nayak");

        Thread.sleep(3000);


        

        // Get the current epoch time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Convert it to seconds (optional, depends on the expected format)
        long currentTimeSeconds = currentTimeMillis / 1000;

        WebElement practising_AutomationField = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        practising_AutomationField.sendKeys("I want to be the best QA Engineer!" + currentTimeSeconds);

        Thread.sleep(5000);

        WebElement selectexpradiobutton = driver.findElement(By.xpath("(//div[@class='vd3tt'])[2]"));
        
        if (!selectexpradiobutton.isSelected()) {
            // Select the radio button
            selectexpradiobutton.click();
        }

        Thread.sleep(10000);

        // Find the checkbox element and select Java,Selenium,TestNG

        WebElement checkbox1 =driver.findElement(By.xpath("//span[text()='Java']"));
        checkbox1.click();
        Thread.sleep(2000);
        WebElement checkbox2=driver.findElement(By.xpath("//span[text()='Selenium']"));
        checkbox2.click();
        Thread.sleep(3000);
        WebElement checkbox4=driver.findElement(By.xpath("//span[text()='TestNG']"));
        checkbox4.click();
        // List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='eBFwI']"));

        // // Define the texts to match as per the selection to be done
        // String[] targetTexts = {"Java", "Selenium", "TestNG"};

        
        // int count = 0;
        // for (WebElement checkbox : checkboxes) {
        //     if (checkboxes.contains(targetTexts)) {
        //         // Select the checkbox
        //         checkbox.click();
        //         count++;
        //         break; 
        //     }
        // }

        // Break the loop if you have selected all checkboxes
        // if (count == targetTexts.length) {
        //     break;
        
        Thread.sleep(5000);
    
           // Locate the dropdown element for "How should you be addressed?" and select the desired value
        WebElement dropdownElement = driver.findElement(By.xpath("//span[text()='Choose']"));
        dropdownElement.click();

        Thread.sleep(5000);

        dropdownElement.getText();
        WebElement selectoption=driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
        selectoption.click();

        Thread.sleep(5000);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the date 7 days ago
        LocalDate date7DaysAgo = currentDate.minusDays(7);

        // Format the date as "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormatted = date7DaysAgo.format(formatter);

        // Locate the date input field
        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));

        // Clear the date field (if needed)
        dateField.clear();

        // Enter the date 7 days ago into the date input field
        dateField.sendKeys(dateFormatted);

       Thread.sleep(10000);



       // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Format the time as "hh", "mm", and "a" (with AM/PM)
        DateTimeFormatter hourMinuteFormatter = DateTimeFormatter.ofPattern("hh");
        //DateTimeFormatter amPmFormatter = DateTimeFormatter.ofPattern("a");
        String hour = currentTime.format(hourMinuteFormatter);
        String minute = currentTime.format(DateTimeFormatter.ofPattern("mm"));
        //String amPm = currentTime.format(amPmFormatter);

        // Locate and enter the hour input field
        WebElement hourField = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        //hourField.clear();
        hourField.sendKeys(hour);

        // Locate and enter the minute input field
        WebElement minuteField = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        //minuteField.clear();
        minuteField.sendKeys(minute);

        // Locate and click the AM/PM dropdown
        // WebElement amPmDropdown = driver.findElement(By.xpath("(//div[@class='e2CuFe eU809d'])[2]"));
        // amPmDropdown.click();

        // Locate and select the AM/PM option
        //WebElement amPmOption = driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']//span[text()='" + amPm + "']"));

           
        //amPmOption.click();

        Thread.sleep(5000);
        
        System.out.println("end Test case: testCase01");
    }
    }   

