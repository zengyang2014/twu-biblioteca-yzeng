public class ConsoleOutput implements Output {
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
