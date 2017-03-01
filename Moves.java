public class Moves
{
	State state = new State();
	boolean pass;
	public boolean Legal(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn, String p_type)
	{
	 	// reset
      	pass = false;
      	switch(p_type)
      	{
         	case "wc":
            	castle(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
        	case "wn":
            	knight(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "wb":
            	bishop(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "wq":
            	queen(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "wk":
            	wking(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "wp":
            	wpawn(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "bc":
            	castle(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "bn":
            	knight(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "bb":
            	bishop(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "bq":
            	queen(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "bk":
            	bking(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
         	case "bp":
            	bpawn(p_startRow, p_startColumn, p_endRow, p_endColumn);
            	break;
      	}
      	if(pass == true)
      	{
      		return true;
      	}
      	else
      	{
      		return false;
      	}
	}
	void castle(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{
		// right left
        if(p_endRow == p_startRow)
        {
         	if(p_endColumn > p_startColumn)
         	{
         		pass = true;
            	for(int i = p_startColumn + 1; i < p_endColumn; i++)
            	{
               		if(state.Board[p_startRow][i] != "z")
               		{
                  		pass = false;
                  		break;
               		}
            	}
         	}
         	else if(p_endColumn < p_startColumn)
         	{
         		pass = true;
            	for(int i = p_startColumn - 1; i > p_endColumn; i--)
            	{
               		if(state.Board[p_startRow][i] != "z")
               		{
                  		pass = false;
                  		break;
               		}
            	}
         	}
      	}
      	// down up
      	else if(p_endColumn == p_startColumn)
      	{
         	if(p_endRow > p_startRow)
         	{
         		pass = true;
            	for(int i = p_startRow + 1; i < p_endRow; i++)
            	{
               		if(state.Board[i][p_startColumn] != "z")
               		{
                  		pass = false;
                  		break;
               		}
            	}
         	}
         	else if(p_endRow < p_startRow)
         	{
         		pass = true;
            	for(int i = p_startRow - 1; i > p_endRow; i--)
            	{
               		if(state.Board[i][p_startColumn] != "z")
               		{
                  		pass = false;
                  		break;
               		}
            	}
         	}
      	}
	}
	void knight(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{
      	if ((p_endRow + 1 == p_startRow & p_endColumn + 2 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn + 2 == p_startColumn) || (p_endRow - 2 == p_startRow & p_endColumn + 1 == p_startColumn) || (p_endRow - 2 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn - 2 == p_startColumn) || (p_endRow + 1 == p_startRow & p_endColumn - 2 == p_startColumn) || (p_endRow + 2 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow + 2 == p_startRow & p_endColumn + 1 == p_startColumn))
      	{
         	pass = true;
      	}
      	else
      	{
         	pass = false;
      	}
	}
	void bishop(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{

	}
	void queen(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{

	}
	void wking(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{

	}
	void wpawn(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{

	}
	void bking(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{

	}
	void bpawn(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{

	}
}