/**
 * Created by yzeng on 13/04/2017.
 */
public class CellGenerator {
    private static final int MAX_CELL_SPACE = 70;
    public static String generateOneCell(String cellElement) {
        String oneCell = "";
        oneCell += cellElement + createSpace(MAX_CELL_SPACE - cellElement.length());
        return oneCell;
    }

    public static String createSpace(int spaceNum) {
        String spaces = "";
        for(int i = 0; i < spaceNum; i++) {
            spaces += " ";
        }
        return spaces;
    }
}
