public class Logic
{
	String Team;
	Moves moves = new Moves();
	Danger danger = new Danger();
	State state = new State();
	String tempPieceStart;
	String tempPieceEnd;
	boolean pass = false;
	int kRow;
	int kColumn;
	public void Evaluate(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn, String p_type)
	{
		// if destination is not same team
		if(!sameType(p_endRow, p_endColumn))
		{
			// if destination is legal move
			if(moves.Legal(p_startRow, p_startColumn, p_endRow, p_endColumn, p_type))
			{
				moveTemp(p_startRow, p_startColumn, p_endRow, p_endColumn);
				checkKing();
				// see if king is in check after temporarily moving
				if(danger.inDanger(kRow, kColumn))
				{

				}
			}
			else
			{

			}
		}
		else
		{
			
		}
	}

	boolean sameType(int p_endRow, int p_endColumn)
	{
		if(state.Board[p_endRow][p_endColumn].startsWith(Team))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    void moveTemp(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
    {  
        tempPieceEnd = state.Board[p_endRow][p_endColumn];
        state.Board[p_endRow][p_endColumn] = state.Board[p_startRow][p_startColumn];
        tempPieceStart = state.Board[p_startRow][p_startColumn];
        state.Board[p_startRow][p_startColumn] = "z";
    }

    void checkKing()
    {
    	for(int i = 0; i < 8; i++)
    	{
    		for(int j = 0; j < 8; j++)
    		{
    			if(state.Board[i][j] == Team+"k")
    			{
    				kRow = i;
    				kColumn = j;
    			}
    		}
    	}
    }

    void checkKill()
    {

    }
}