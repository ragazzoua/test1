package github.tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class SignInButtonTest  extends TestBase{

    @Test
    public void signInButtonTest() throws IOException {
        app.getNavigationHelper().clickSignInButton();
        app.getScreenShot();
    }
}
