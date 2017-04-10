/**
 * Created by yzeng on 11/04/2017.
 */
public class ConsoleOutput implements Output {
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
