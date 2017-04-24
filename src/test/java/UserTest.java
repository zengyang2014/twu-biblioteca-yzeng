import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {
    private User user = null;
    @Before
    public void setUp() {
        user = new User("testNum","testPassword", "testName");
    }
    @Test
    public void userSuccessLogin() throws Exception {
        assertTrue(user.login("testNum","testPassword"));
    }

    @Test
    public void userFailedLogin() throws Exception {
        assertTrue(!user.login("falseNum","falsePassword"));
    }

    @Test
    public void shouldShowUserInfo() throws Exception {
        user = new User("testNum","testPassword", "testName", "testEmail", "testPhoneNumber");
        String expectString = "testName testEmail testPhoneNumber";
        assertTrue(expectString.equals(user.userInfo()));
    }
}
