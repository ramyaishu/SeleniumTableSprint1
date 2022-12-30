package stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BearTable
{
    public  WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest test;
    public Date d;
    int size,count;
    String str[] = new String[3];
    String[] array;
    boolean flag;

    @When("^the user clock the url$")
    public void the_user_clock_the_url() throws Throwable {
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
        String date =  simpleDateFormat.format(d);
        TakesScreenshot shot = (TakesScreenshot) driver;
        File file = shot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file,new File("./screenshots/"+date+".png"));

       // reports=new ExtentReports(FileUtils.copyFile(file,new File("./screenshots/"+date+".png"));
        test=reports.createTest("Test Report");

        driver.get("http://seleniumtableassignment.s3-website-us-west-2.amazonaws.com/");
        test.log(Status.INFO,"TestStarted");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


    }

    @When("^the user verifies the details in the bears table$")
    public void the_user_verifies_the_details_in_the_bears_table() throws Throwable {
        size= driver.findElements(By.xpath("//table[@class='adap-table']//td[text()='Black']")).size();


    }

    @Then("^the number of rows returned should be (\\d+)$")
    public void the_number_of_rows_returned_should_be(int arg1) throws Throwable {
        System.out.println(size);
        Assert.assertEquals(size, arg1);
        test.log(Status.INFO, "color test passed");
        reports.flush();
    }

    @Then("^close the browser$")
    public void close_the_browser() throws Throwable
    {
        driver.quit();

    }

    @When("^the user verifies the details in the cat table$")
    public void the_user_verifies_the_details_in_the_cat_table() throws Throwable
    {
        int i = 0;
        List<WebElement> catCount = driver.findElements(By.xpath(
                "//table[@class='adap-table']//following-sibling::table//tbody//tr//child::td[contains(text(),'lbs')]"));
        for (WebElement s : catCount) {
            str[i] = s.getText();
            array = str[i].split(" ");

            if (Integer.parseInt(array[0]) < 15) {
                flag = true;
            } else {
                flag = false;
                break;
            }

            i++;
        }
        System.out.println(flag);

        }

        @Then("^it should return \"([^\"]*)\"$")
        public void it_should_return (String arg1) throws Throwable {

            Assert.assertFalse(Boolean.valueOf(arg1));
        }

        @When("^the user verifies the number of rows in the STAR WARS table$")
        public void the_user_verifies_the_number_of_rows_in_the_STAR_WARS_table () throws Throwable {
            count = driver
                    .findElements(By.xpath("//table[@class='adap-table']//following-sibling::table[2]//tbody//tr")).size();
        }

        @Then("^the number of rows should be (\\d+)$")
        public void the_number_of_rows_should_be ( int arg1) throws Throwable {
            System.out.println(count);
            Assert.assertEquals(count, arg1);


        }

        @When("^the user counts number of characters in the description column$")
        public void the_user_counts_number_of_characters_in_the_description_column () throws Throwable {
            String s2;
            List<WebElement> starList = driver.findElements(By.xpath(
                    "//table[@class='adap-table']//following-sibling::table[2]//tbody//tr//child::td[@class='description']"));
            for (WebElement s : starList) {
                s2 = s.getText();

                if (s2.length() < 350) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }

            }
            System.out.println(flag);


        }

        @Then("^the user should return \"([^\"]*)\"$")
        public void the_user_should_return (String arg1) throws Throwable {
            Assert.assertTrue(Boolean.valueOf(arg1));

        }


}
