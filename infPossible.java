public class infPossible
{
    int startRow = 0;
    int startColumn = 0;
    int endRow = 0;
    int endColumn = 0;
    String type = "";
    infPossible(String p_type, int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
    {
        startRow = p_startRow;
        startColumn = p_startColumn;
        endRow = p_endRow;
        endColumn = p_endColumn;
        type = p_type;
    }
}