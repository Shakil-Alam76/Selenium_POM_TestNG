import Pages.Login;
import Pages.SignUp;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestRunner extends Setup {

    Login objLogin;
  @Test (priority=1)
    public void doLogin() throws IOException, ParseException {
        driver.get("http://automationpractice.com");
        objLogin=new Login(driver);

      JSONParser jsonParser=new JSONParser();
       Object obj=jsonParser.parse(new FileReader("./src/test/resources/user.json"));
       JSONObject jsonObject=(JSONObject) obj;
       String email=(String) jsonObject.get("email");
       String password=(String) jsonObject.get("password");


         String user=objLogin.doLogin(email,password);
         Assert.assertEquals(user, "Shakil Alam Shanto");

         // Without Json
      // String user= objLogin.doLogin("2019200010001@seu.edu.bd", "Shantocse#764576");
      // Assert.assertEquals(user, "Shakil Alam Shanto");

  }

  @Test (priority=2)
  public void inputEmail(){
      driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
     SignUp objSignup=new SignUp(driver);
     objSignup.emailSubmit("shakil.shantocse@gmail.com");
  }

}
