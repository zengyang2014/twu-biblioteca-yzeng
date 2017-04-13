public class User {
    private String userName;
    private String userPassword;
    private BookList rentBooks;

    User() {
        userName = null;
        userPassword = null;
        rentBooks = null;
    }

    User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public boolean login(String userName, String userPassword) {
        if(this.userName.equals(userName) && this.userPassword.equals(userPassword)) {
            return true;
        }
        return  false;
    }
}
