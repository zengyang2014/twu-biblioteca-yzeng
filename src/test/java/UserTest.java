import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {
    private User user = null;
    @Before
    public void setUp() {
        user = new User("testName","testPassword");
    }
    @Test
    public void userSuccessLogin() throws Exception {
        assertTrue(user.login("testName","testPassword"));
    }

    @Test
    public void userFailedLogin() throws Exception {
        assertTrue(!user.login("falseName","falsePassword"));
    }
}
