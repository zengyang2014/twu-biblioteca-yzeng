package receivers;

import interfaces.Input;
import interfaces.Output;
import lists.BookList;
import lists.MovieList;
import models.Book;
import models.User;
import services.ConsoleInput;
import services.ConsoleOutput;

public class Receiver {
    private Output console;
    private Input input;
    private BookList bookList;
    private MovieList movieList;
    private boolean isLogin;
    private User user;

    public Receiver(BookList bookList, MovieList movieList, boolean isLogin, User user) {
        console = new ConsoleOutput();
        input = new ConsoleInput();
        this.bookList = bookList;
        this.movieList = movieList;
        this.isLogin = isLogin;
        this.user = user;
    }

    public Receiver(Output output, Input input, BookList bookList, MovieList movieList, boolean isLogin, User user) {
        this.console = output;
        this.input = input;
        this.bookList = bookList;
        this.movieList = movieList;
        this.isLogin = isLogin;
        this.user = user;
    }

    public void doQuit() {
        return;
    }

    public void doPrintWrongMessage() {
        doPrintMessage("Select a valid option!");
    }

    public void doPrintMessage(String message) {
        console.print(message);
    }

    public void doPrintMenu() {
        doPrintMessage("Main Manu:\n * 1. List Books\n * 2. List Movies \n" +
                " * 3. Return models.Book \n * 4. Login  \n * 5. Show models.User Info \n * 0. exit");
    }

    public void doListBookDetail() {
        doPrintMessage(bookList.booksListDetail());
        doPrintMessage("interfaces.Input the index of book which need to checkout.");
        doCheckoutBook();
    }

    public void doCheckoutBook() {
        Integer index = Integer.parseInt(input.read());
        if (isLogin) {
            if (bookList.removeBook(index)) {
                doPrintMessage("Thank you! Enjoy the book");
            } else {
                doPrintMessage("That book is not available.");
            }
        }else {
            doPrintMessage("Please Login!");
        }
    }

    public void doListMovies() {
        doPrintMessage(movieList.movieListDetail());
    }

    public void doReturnBook() {
        doPrintMessage("Please input the data of return book. (name, author, published year)");
        if (isLogin) {
            if (bookList.addBook(new Book(input.read(), input.read(), input.read()))) {
                doPrintMessage("Thank you for returning the book.");
            } else {
                doPrintMessage("That is not a valid book to return.");
            }
        }else {
            doPrintMessage("Please Login!");
        }
    }

    public void doLogin() {
        isLogin = user.login(input.read(), input.read());
    }

    public void doShowUserInfo() {
        doPrintMessage(user.userInfo());
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }
}
