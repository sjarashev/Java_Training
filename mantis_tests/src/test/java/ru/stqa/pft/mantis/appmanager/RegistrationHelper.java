package ru.stqa.pft.mantis.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class RegistrationHelper extends HelperBase{

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Signup']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//button[@type='submit']"));
  }

  public void resetPasswordByAdmin(String user) throws InterruptedException {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), "administrator");
    click(By.xpath("//input[@value='Login']"));
    type(By.name("password"), "root");
    click(By.xpath("//input[@value='Login']"));
    click(By.xpath("//i[@class='menu-icon fa fa-gears']"));
    click(By.linkText("Manage Users"));
    click(By.linkText(user));
    TimeUnit.SECONDS.sleep(1);
    click(By.xpath("//input[@value='Reset Password']"));
  }
}
