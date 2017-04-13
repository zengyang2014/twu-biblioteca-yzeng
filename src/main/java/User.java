public class User {
    private String userLibraryNum;
    private String userPassword;
    private String userName;
    private String email;
    private String phoneNum;
    private BookList rentBooks;

    User(String userLibraryNum, String userPassword, String userName) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.userLibraryNum = userLibraryNum;
    }

    User(String userLibraryNum, String userPassword, String userName, String email, String phoneNum) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.userLibraryNum = userLibraryNum;
        this.email = email;
        this. phoneNum = phoneNum;
    }

    public boolean login(String libraryNum, String userPassword) {
        if(this.userLibraryNum.equals(libraryNum) && this.userPassword.equals(userPassword)) {
            return true;
        }
        return  false;
    }
}
