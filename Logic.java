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
	public boolean Evaluate(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn, String p_type)
	{
        System.out.println("Logic.Evaluate line 14");
		// if destination is not same team
		if(!sameType(p_endRow, p_endColumn))
		{
            System.out.println("Logic.Evaluate line 18");
			// if destination is legal move
			if(moves.Legal(p_startRow, p_startColumn, p_endRow, p_endColumn, p_type))
			{
                System.out.println("Logic.Evaluate line 22");
				// temporarily move
				moveTemp(p_startRow, p_startColumn, p_endRow, p_endColumn);
				// update king position
				checkKing();
				// see if king is in check after temporarily moving
				if(!danger.inDanger(kRow, kColumn))
				{
                    System.out.println("Logic.Evaluate line 30");
					// check if move is a killing move, taking off of wAlive list
					checkKill();
					return true;
				}
				else
				{
                    System.out.println("Logic.Evaluate line 37");
					moveBack(p_startRow, p_startColumn, p_endRow, p_endColumn);
					return false;
				}
			}
			else
			{
                System.out.println("Logic.Evaluate line 44");
				return false;
			}
		}
		else
		{
            System.out.println("Logic.Evaluate line 50");
			return false;
		}
	}
    public boolean CMEvaluate(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn, String p_type)
    {
        System.out.println("Logic.CMEvaluate line 56");
        if(!sameType(p_endRow, p_endColumn))
        {
            System.out.println("Logic.CMEvaluate line 59");
            if(moves.Legal(p_startRow, p_startColumn, p_endRow, p_endColumn, p_type))
            {
                System.out.println("Logic.CMEvaluate line 62");
                moveTemp(p_startRow, p_startColumn, p_endRow, p_endColumn);
                checkKing();
                if(!danger.inDanger(kRow, kColumn))
                {
                    System.out.println("Logic.CMEvaluate line 67");
                    moveBack(p_startRow, p_startColumn, p_endRow, p_endColumn);
                    return true;
                }
                else
                {
                    System.out.println("Logic.CMEvaluate line 73");
                    moveBack(p_startRow, p_startColumn, p_endRow, p_endColumn);
                    return false;
                }
            }
            else
            {
                System.out.println("Logic.CMEvaluate line 80");
                return false;
            }
        }
        else
        {
            System.out.println("Logic.CMEvaluate line 86");
            return false;
        }
    }

	boolean sameType(int p_endRow, int p_endColumn)
	{
        if(p_endRow < 0 || p_endRow > 7 || p_endColumn < 0 || p_endColumn > 7)
        {
            return true;
        }
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
   
   	void moveBack(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
   	{
      	state.Board[p_startRow][p_startColumn] = tempPieceStart;
      	state.Board[p_endRow][p_endColumn] = tempPieceEnd;
      	state.kill = false;
      	state.Convert = false;
      	state.cRow = 0;
      	state.cColumn = 0;
      	state.cTurn = "";
   	}

    void checkKing()
    {
    	for(int i = 0; i < 8; i++)
    	{
    		for(int j = 0; j < 8; j++)
    		{
    			if(state.Board[i][j].equals(Team+"k"))
    			{
    				kRow = i;
    				kColumn = j;
    				break;
    			}
    		}
    	}
    }

    void checkKill()
    {
    	if(!tempPieceEnd.startsWith(Team) && tempPieceEnd != "z")
    	{
    		if(Team.equals("b"))
    		{
    			state.wDead.add(tempPieceEnd);
    			for(int i = 0; i < state.wAlive.size(); i++)
    			{
    				if(state.wAlive.get(i).type.equals(tempPieceEnd))
    				{
    					state.wAlive.remove(i);
    					break;
    				}
    			}
    		}
    		else if(Team.equals("w"))
    		{
    			state.bDead.add(tempPieceEnd);
    			for(int i = 0; i < state.bAlive.size(); i++)
    			{
    				if(state.bAlive.get(i).type.equals(tempPieceEnd))
    				{
    					state.bAlive.remove(i);
    					break;
    				}
    			}
    		}
    	}
    }
}