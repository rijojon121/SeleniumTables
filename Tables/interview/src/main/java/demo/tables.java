
/*
 1)Static table
 2)Dynamic table 
 3)Pagination table 
 */

package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

public class tables {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();

        Thread.sleep(3000);
        
        //find total number of rows in the table 
        
        int rows =  driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        
        System.out.println("Total Number to Rows are :" + rows);

        //Find total numbers of columns in the tablen

        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();

        System.out.println("Total number of Columns are : "+ cols);

        //Get a text from a specific row and specific columns 

        String specificData =  driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText(); // always write xpaths to retrive data from the table 

        System.out.println("Text from 5th row and 1st column is : "+ specificData);

        // get all the text from all the rows and columns 

        for(int r=2;r<rows;r++){
            for(int c=1;c<cols;c++){
              String allData =   driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
              System.out.print(allData + "\t");
            }
            System.out.println();
        }

        // req : print mukesh booknames

        //first create a for loop for all author names to filter of mukesh
        //then use if condition for mukesh and print the bookname 

        for(int r=2;r<=rows;r++){
            String AuthorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if(AuthorName.equals("Mukesh")){
                String AuthorBookName =  driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
        
                System.out.println(AuthorName + "\t" + AuthorBookName);
            }
        }

        // find the total price of all the books in the table 

        //logic : first find locator for the column since price is constant 

        int TotalPrice = 0;
        for(int r=2;r<=rows;r++){
            String bookPrice =  driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
            TotalPrice = TotalPrice+Integer.parseInt(bookPrice);
        }
        System.out.println("Total Price of the books: "+ TotalPrice);




        
        Thread.sleep(3000);
      
        driver.close();


    }
}
