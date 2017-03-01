public class Danger
{
	String Team;
	String OTeam;
	State state = new State();
	void setOTeam()
	{
		if(Team == "w")
		{
			OTeam = "b";
		}
		else
		{
			OTeam = "w";
		}
	}
	public boolean inDanger(int p_row, int p_column)
	{
		setOTeam();
      	// down
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row + i < 8)
         	{
            	if(!state.Board[p_row + i][p_column].startsWith(OTeam+"c") && !state.Board[p_row + i][p_column].startsWith(OTeam+"q") && !state.Board[p_row + i][p_column].startsWith("z"))
            	{
               		break;
            	}
            	else if((state.Board[p_row + i][p_column] == OTeam+"c") || (state.Board[p_row + i][p_column] == OTeam+"q"))
            	{
               		return true;
            	}
         	}
      	}
      	// up
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row - i >= 0)
         	{
            	if(!state.Board[p_row - i][p_column].startsWith(OTeam+"c") && !state.Board[p_row - i][p_column].startsWith(OTeam+"q") && !state.Board[p_row - i][p_column].startsWith("z"))
            	{
               		break;
            	}
            	else if((state.Board[p_row - i][p_column] == OTeam+"c") || (state.Board[p_row - i][p_column] == OTeam+"q"))
            	{
               		return true;
            	}
         	}
      	}
      	// right
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_column + i < 8)
         	{
            	if(state.Board[p_row][p_column + i].startsWith(OTeam+"c") && !state.Board[p_row][p_column + i].startsWith(OTeam+"q") && !state.Board[p_row][p_column + i].startsWith("z"))
            	{
               		break;
            	}
            	else if((state.Board[p_row][p_column + i] == OTeam+"c") || (state.Board[p_row][p_column + i] == OTeam+"q"))
            	{
               		return true;
            	}
         	}
      	}
      	// left
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_column - i >= 0)
         	{
            	if(!state.Board[p_row][p_column - i].startsWith(OTeam+"c") && !state.Board[p_row][p_column - i].startsWith(OTeam+"q") && !state.Board[p_row][p_column - i].startsWith("z"))	
        		{
        	   		break;
           		}
        	}
            else if((state.Board[p_row][p_column - i] == OTeam+"c") || (state.Board[p_row][p_column - i] == OTeam+"q"))
            {
               return true;
            }
        }
      	//down right
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row + i < 8 && p_column + i < 8)
         	{
            	if(!state.Board[p_row + i][p_column + i].startsWith(OTeam+"b") && !state.Board[p_row + i][p_column + i].startsWith(OTeam+"q") && !state.Board[p_row + i][p_column + i].startsWith("z"))
            	{
              	 	break;
            	}
            	else if((state.Board[p_row + i][p_column + i] == OTeam+"b") || (state.Board[p_row + i][p_column +i] == OTeam+"q"))
            	{
               		return true;
            	}
        	}
      	}
      	// down left
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row + i < 8 && p_column - i >= 0)
         	{
            	if(!state.Board[p_row + i][p_column - i].startsWith(OTeam+"b") && !state.Board[p_row + i][p_column - i].startsWith(OTeam+"q")  && !state.Board[p_row + i][p_column - i].startsWith("z"))
            	{
               		break;
            	}
            	else if((state.Board[p_row + i][p_column - i] == OTeam+"b") || (state.Board[p_row + i][p_column - i] == OTeam+"q"))
            	{
               		return true;
            	}
         	}
      	}
      	// up right
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row - i >= 0 && p_column + i < 8)
         	{
            	if(!state.Board[p_row - i][p_column + i].startsWith(OTeam+"b") && !state.Board[p_row - i][p_column + i].startsWith(OTeam+"q") && !state.Board[p_row - i][p_column + i].startsWith("z"))
            	{
               		break;
            	}
            	else if((state.Board[p_row - i][p_column + i] == OTeam+"b") || (state.Board[p_row - i][p_column + i] == OTeam+"q"))
            	{
               		return true;
            	}
         	}
      	}
      	// up left
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row - i >= 0 && p_column - i >= 0)
         	{
            	if(!state.Board[p_row - i][p_column - i].startsWith(OTeam+"b") && !state.Board[p_row - i][p_column - i].startsWith(OTeam+"q") && !state.Board[p_row - i][p_column - i].startsWith("z"))
            	{
               		break;
            	}
            	else if((state.Board[p_row - i][p_column - i] == OTeam+"b") || (state.Board[p_row - i][p_column - i] == OTeam+"q"))
            	{
               		return true;
            	}
         	}
      	}
      	// knight check
      	if(p_row + 1 < 8 && p_column + 2 < 8)
      	{
         	if(state.Board[p_row + 1][p_column + 2] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 1 >= 0 && p_column + 2 < 8)
      	{
         	if(state.Board[p_row - 1][p_column + 2] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// knight check
     	 if(p_row - 2 >= 0 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row - 2][p_column + 1] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 2 >= 0 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row - 2][p_column - 1] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 1 >= 0 && p_column - 2 >= 0)
      	{
         	if(state.Board[p_row - 1][p_column - 2] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row + 1 < 8 && p_column - 2 >= 0)
      	{
         	if(state.Board[p_row + 1][p_column - 2] == OTeam+"n")
         	{
            	return true;
         	}
      	}
     	// knight check
      	if(p_row + 2 < 8 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row + 2][p_column - 1] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row + 2 < 8 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row + 2][p_column + 1] == OTeam+"n")
         	{
            	return true;
         	}
      	}
      	// pawn check against b pawns
      	if(p_row + 1 < 8 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row +1][p_column + 1] == OTeam+"p")
         	{
            	return true;
         	}
      	}
      	// pawn check against b pawns
      	if(p_row + 1 < 8 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row +1 ][p_column - 1] == OTeam+"p")
         	{
            	return true;
         	}
      	}
      	// up opposite king check
      	if(p_row - 1 >= 0)
     	{
         	if(state.Board[p_row - 1][p_column] == OTeam+"k")
         	{
            	return true;
         	}
      	}
      	// down opposite king check
      	if(p_row + 1 < 8)
      	{
         	if(state.Board[p_row + 1][p_column] == OTeam+"k")
         	{
            	return true;
         	}
      	}
      	//right opposite king check
      	if(p_column + 1 < 8)
      	{
         	if(state.Board[p_row][p_column + 1] == OTeam+"k")
         	{
            	return true;
         	}
      	}
      	//left opposite king check
      	if(p_column - 1 >= 0)
      	{
         	if(state.Board[p_row][p_column - 1] == OTeam+"k")
         	{
            	return true;
         	}
     	 }
      	// down right king check
      	if(p_row + 1 < 8 & p_column + 1 < 8)
      	{
         	if(state.Board[p_row + 1][p_column + 1] == OTeam+"k")
         	{
            	return true;
         	}
      	}
      	// down left king check
      	if(p_row + 1 < 8 & p_column - 1 >= 0)
      	{
         	if(state.Board[p_row + 1][p_column - 1] == OTeam+"k")
         	{
            	return true;
         	}
      	}
      	// up right king check
      	if(p_row - 1 >= 0 & p_column + 1 < 8)
      	{
         	if(state.Board[p_row - 1][p_column + 1] == OTeam+"k")
         	{
            	return true;
         	}
      	}
      	// up left king check
      	if(p_row - 1 >= 0 & p_column - 1 >= 0)
      	{
         	if(state.Board[p_row - 1][p_column - 1] == OTeam+"k")
         	{
            	return true;
         	}
      	}
	    return false;
	}
}