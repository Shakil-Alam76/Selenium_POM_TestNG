package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    WebDriver driver;

    @FindBy(id="email_create")
    WebElement emailInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement submitCreatAccount;


    public SignUp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void emailSubmit(String email){
        emailInput.sendKeys(email);
        submitCreatAccount.click();
    }


}
