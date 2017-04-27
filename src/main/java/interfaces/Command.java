package interfaces;

public interface Command {
    boolean shouldExecute(String command);
    void execute();
}
