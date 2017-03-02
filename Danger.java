public class Danger
{
	String Team;
	String OTeam;
	State state = new State();
   String tempPieceEnd;
   String tempPieceStart;
	void setOTeam()
   {
      if(state.Turn.equals("w"))
      {
         OTeam = "b";
      }
      else if(state.Turn.equals("b"))
      {
         OTeam = "w";
      }
      Team = state.Turn;
	}
	public boolean inDanger(int p_row, int p_column)
	{
         setOTeam();
         System.out.println("OTEAM = " + OTeam);
         System.out.println("state.Turn = " + state.Turn);
      	// down
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row + i < 8)
         	{
            	if(!state.Board[p_row + i][p_column].equals(OTeam+"c") && !state.Board[p_row + i][p_column].equals(OTeam+"q") && !state.Board[p_row + i][p_column].equals("z"))
            	{
               	break;
            	}
            	else if((state.Board[p_row + i][p_column].equals(OTeam+"c")) || (state.Board[p_row + i][p_column].equals(OTeam+"q")))
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
            	if(!state.Board[p_row - i][p_column].equals(OTeam+"c") && !state.Board[p_row - i][p_column].equals(OTeam+"q") && !state.Board[p_row - i][p_column].equals("z"))
            	{
               	break;
            	}
            	else if((state.Board[p_row - i][p_column].equals(OTeam+"c")) || (state.Board[p_row - i][p_column].equals(OTeam+"q")))
            	{
               	return true;
            	}
         	}
      	}
      	// right;
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_column + i < 8)
         	{
            	if(!state.Board[p_row][p_column + i].equals(OTeam+"c") && !state.Board[p_row][p_column + i].equals(OTeam+"q") && !state.Board[p_row][p_column + i].equals("z"))
            	{
               	break;
            	}
            	else if((state.Board[p_row][p_column + i].equals(OTeam+"c")) || (state.Board[p_row][p_column + i].equals(OTeam+"q")))
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
            	if(!state.Board[p_row][p_column - i].equals(OTeam+"c") && !state.Board[p_row][p_column - i].equals(OTeam+"q") && !state.Board[p_row][p_column - i].equals("z"))	
        		   {
        	   		break;
           		}
               else if((state.Board[p_row][p_column - i].equals(OTeam+"c")) || (state.Board[p_row][p_column - i].equals(OTeam+"q")))
               {
                  return true;
               }
            }
         }
      	//down right
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row + i < 8 && p_column + i < 8)
         	{
            	if(!state.Board[p_row + i][p_column + i].equals(OTeam+"b") && !state.Board[p_row + i][p_column + i].equals(OTeam+"q") && !state.Board[p_row + i][p_column + i].equals("z"))
            	{
              	 	break;
            	}
            	else if((state.Board[p_row + i][p_column + i].equals(OTeam+"b")) || (state.Board[p_row + i][p_column +i].equals(OTeam+"q")))
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
            	if(!state.Board[p_row + i][p_column - i].equals(OTeam+"b") && !state.Board[p_row + i][p_column - i].equals(OTeam+"q")  && !state.Board[p_row + i][p_column - i].equals("z"))
            	{
               	break;
            	}
            	else if((state.Board[p_row + i][p_column - i].equals(OTeam+"b")) || (state.Board[p_row + i][p_column - i].equals(OTeam+"q")))
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
            	if(!state.Board[p_row - i][p_column + i].equals(OTeam+"b") && !state.Board[p_row - i][p_column + i].equals(OTeam+"q") && !state.Board[p_row - i][p_column + i].equals("z"))
            	{
                  break;
            	}
            	else if((state.Board[p_row - i][p_column + i].equals(OTeam+"b")) || (state.Board[p_row - i][p_column + i].equals(OTeam+"q")))
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
            	if(!state.Board[p_row - i][p_column - i].equals(OTeam+"b") && !state.Board[p_row - i][p_column - i].equals(OTeam+"q") && !state.Board[p_row - i][p_column - i].equals("z"))
            	{
               	break;
            	}
            	else if((state.Board[p_row - i][p_column - i].equals(OTeam+"b")) || (state.Board[p_row - i][p_column - i].equals(OTeam+"q")))
            	{
               	return true;
            	}
         	}
      	}
      	// knight check
      	if(p_row + 1 < 8 && p_column + 2 < 8)
      	{
         	if(state.Board[p_row + 1][p_column + 2].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 1 >= 0 && p_column + 2 < 8)
      	{
         	if(state.Board[p_row - 1][p_column + 2].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// knight check
     	   if(p_row - 2 >= 0 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row - 2][p_column + 1].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 2 >= 0 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row - 2][p_column - 1].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 1 >= 0 && p_column - 2 >= 0)
      	{
         	if(state.Board[p_row - 1][p_column - 2].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row + 1 < 8 && p_column - 2 >= 0)
      	{
         	if(state.Board[p_row + 1][p_column - 2].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
     	   // knight check
      	if(p_row + 2 < 8 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row + 2][p_column - 1].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// knight check
      	if(p_row + 2 < 8 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row + 2][p_column + 1].equals(OTeam+"n"))
         	{
            	return true;
         	}
      	}
      	// up opposite king check
      	if(p_row - 1 >= 0)
     	   {
         	if(state.Board[p_row - 1][p_column].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}
      	// down opposite king check
      	if(p_row + 1 < 8)
      	{
         	if(state.Board[p_row + 1][p_column].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}
      	//right opposite king check
      	if(p_column + 1 < 8)
      	{
         	if(state.Board[p_row][p_column + 1].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}
      	//left opposite king check
      	if(p_column - 1 >= 0)
      	{
         	if(state.Board[p_row][p_column - 1].equals(OTeam+"k"))
         	{
            	return true;
         	}
     	   }
      	// down right king check
      	if(p_row + 1 < 8 & p_column + 1 < 8)
      	{
         	if(state.Board[p_row + 1][p_column + 1].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}
      	// down left king check
      	if(p_row + 1 < 8 & p_column - 1 >= 0)
      	{
         	if(state.Board[p_row + 1][p_column - 1].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}
      	// up right king check
      	if(p_row - 1 >= 0 & p_column + 1 < 8)
      	{
         	if(state.Board[p_row - 1][p_column + 1].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}
      	// up left king check
      	if(p_row - 1 >= 0 & p_column - 1 >= 0)
      	{
         	if(state.Board[p_row - 1][p_column - 1].equals(OTeam+"k"))
         	{
            	return true;
         	}
      	}

         // pawn check against b pawns
         if(OTeam.equals("b"))
         {
            if(p_row + 1 < 8 && p_column + 1 < 8)
            {
               if(state.Board[p_row + 1][p_column + 1].equals(OTeam+"p"))
               {
                  return true;
               }
            }
            if(p_row + 1 < 8 && p_column - 1 >= 0)
            {
               if(state.Board[p_row + 1][p_column - 1].equals(OTeam+"p"))
               {
                  return true;
               }
            }
         }
         // pawn check against w pawns
         else if(OTeam.equals("w"))
         {
            if(p_row - 1 >= 0 && p_column + 1 < 8)
            {
               if(state.Board[p_row - 1][p_column + 1].equals(OTeam+"p"))
               {
                  return true;
               }
            }
            if(p_row - 1 >= 0 && p_column - 1 >= 0)
            {
               if(state.Board[p_row - 1][p_column - 1].equals(OTeam+"p"))
               {
                  return true;
               }
            }
         }
	      return false;
    }
    // used for king run away on checkmate and queen runaway on stalemate testing
   public boolean checkRunAway(int p_row, int p_column)
   {
      setOTeam();
      if(p_row - 1 >= 0)
      {
         if(state.Board[p_row - 1][p_column] == "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column);
            if(!inDanger(p_row - 1, p_column))
            {
               moveBack(p_row, p_column, p_row - 1, p_column);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row - 1, p_column);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row - 1][p_column].startsWith(Team) && state.Board[p_row - 1][p_column] != "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column);
            if(!inDanger(p_row - 1, p_column) == true)
            {
               moveBack(p_row, p_column, p_row - 1, p_column);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row - 1, p_column);
            }
         }
      }
      // down opposite king check
      if(p_row + 1 < 8)
      {
         if(state.Board[p_row + 1][p_column] == "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column);
            if(!inDanger(p_row + 1, p_column))
            {
               moveBack(p_row, p_column, p_row + 1, p_column);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row + 1, p_column);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row + 1][p_column].startsWith(Team) && state.Board[p_row + 1][p_column] != "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column);
            if(!inDanger(p_row + 1, p_column))
            {
               moveBack(p_row, p_column, p_row + 1, p_column);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row + 1, p_column);
            }
         }
      }
      //right opposite king check
      if(p_column + 1 < 8)
      {
         if(state.Board[p_row][p_column + 1] == "z")
         {
            moveTemp(p_row, p_column, p_row, p_column + 1);
            if(!inDanger(p_row, p_column + 1))
            {
               moveBack(p_row, p_column, p_row, p_column + 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row, p_column + 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row][p_column + 1].startsWith(Team) && state.Board[p_row][p_column + 1] != "z")
         {
            moveTemp(p_row, p_column, p_row, p_column + 1);
            if(!inDanger(p_row, p_column + 1))
            {
               moveBack(p_row, p_column, p_row, p_column + 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row, p_column + 1);
            }
         }
      }
      //left opposite king check
      if(p_column - 1 >= 0)
      {
         if(state.Board[p_row][p_column - 1] == "z")
         {
            moveTemp(p_row, p_column, p_row, p_column - 1);
            if(!inDanger(p_row, p_column - 1))
            {
               moveBack(p_row, p_column, p_row, p_column - 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row, p_column - 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row][p_column - 1].startsWith(Team) && state.Board[p_row][p_column - 1] != "z")
         {
            moveTemp(p_row, p_column, p_row, p_column - 1);
            if(!inDanger(p_row, p_column - 1))
            {
               moveBack(p_row, p_column, p_row, p_column - 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row, p_column - 1);
            }
         }
      }
      // down right king check
      if(p_row + 1 < 8 & p_column + 1 < 8)
      {
         if(state.Board[p_row + 1][p_column + 1] == "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column + 1);
            if(!inDanger(p_row + 1, p_column + 1))
            {
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row + 1][p_column + 1].startsWith(Team) && state.Board[p_row + 1][p_column + 1] != "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column + 1);
            if(!inDanger(p_row + 1, p_column + 1))
            {
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
            }
         }
      }
      // down left king check
      if(p_row + 1 < 8 & p_column - 1 >= 0)
      {
         if(state.Board[p_row + 1][p_column - 1] == "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column - 1);
            if(!inDanger(p_row + 1, p_column - 1))
            {
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row + 1][p_column - 1].startsWith(Team) && state.Board[p_row + 1][p_column - 1] != "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column - 1);
            if(!inDanger(p_row + 1, p_column - 1))
            {
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
            }
         }
      }
      // up right king check
      if(p_row - 1 >= 0 & p_column + 1 < 8)
      {
         if(state.Board[p_row - 1][p_column + 1] == "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column + 1);
            if(!inDanger(p_row - 1, p_column + 1))
            {
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row - 1][p_column + 1].startsWith(Team) && state.Board[p_row - 1][p_column + 1] != "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column + 1);
            if(!inDanger(p_row - 1, p_column + 1))
            {
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
            }
         }
      }
      // up left king check
      if(p_row - 1 >= 0 & p_column - 1 >= 0)
      {
         if(state.Board[p_row - 1][p_column - 1] == "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column - 1);
            if(!inDanger(p_row - 1, p_column - 1))
            {
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row - 1][p_column - 1].startsWith(Team) && state.Board[p_row - 1][p_column - 1] != "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column - 1);
            if(!inDanger(p_row - 1, p_column - 1))
            {
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
               return true;
            }
            else
            {
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
            }
         }
      }
      return false;
   }
   public boolean range(int p_row, int p_column)
   {
      setOTeam();
      // down
      for(int i = 1; i < 8; i++)
      {
         if(p_row + i < 8) 
         {
            if(!state.Board[p_row + i][p_column].equals(OTeam+"c") && !state.Board[p_row + i][p_column].startsWith(OTeam+"q") && !state.Board[p_row + i][p_column].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row + i][p_column] == "bc") || (state.Board[p_row + i][p_column] == "bq"))
            {
               // rangePiece = state.Board[p_row + i][p_column];
               // rangeRow = p_row + i;
               // rangeColumn = p_column;
               return true;
            }
         }
      }
      // up
      for(int i = 1; i < 8; i++)
      {
         if(p_row - i >= 0)
         {
            if(!state.Board[p_row - i][p_column].startsWith("bc") && !state.Board[p_row - i][p_column].startsWith("bq") && !state.Board[p_row - i][p_column].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row - i][p_column] == "bc") || (state.Board[p_row - i][p_column] == "bq"))
            {
               // rangePiece = state.Board[p_row - i][p_column];
               // rangeRow = p_row - i;
               // rangeColumn = p_column;
               return true;
            }
         }
      }
      // right
      for(int i = 1; i < 8; i++)
      {
         if(p_column + i < 8)
         {
            if(state.Board[p_row][p_column + i].startsWith("bc") && !state.Board[p_row][p_column + i].startsWith("bq") && !state.Board[p_row][p_column + i].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row][p_column + i] == "bc") || (state.Board[p_row][p_column + i] == "bq"))
            {
               // rangePiece = state.Board[p_row][p_column + i];
               // rangeRow = p_row;
               // rangeColumn = p_column + i;
               return true;
            }
         }
      }
      // left
      for(int i = 1; i < 8; i++)
      {
         if(p_column - i >= 0)
         {
            if(!state.Board[p_row][p_column - i].startsWith("bc") && !state.Board[p_row][p_column - i].startsWith("bq") && !state.Board[p_row][p_column - i].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row][p_column - i] == "bc") || (state.Board[p_row][p_column - i] == "bq"))
            {
               // rangePiece = state.Board[p_row][p_column - i];
               // rangeRow = p_row;
               // rangeColumn = p_column - i;
               return true;
            }
         }
      }
      //down right
      for(int i = 1; i < 8; i++)
      {
         if(p_row + i < 8 && p_column + i < 8)
         {
            if(!state.Board[p_row + i][p_column + i].startsWith("bb") && !state.Board[p_row + i][p_column + i].startsWith("bq") && !state.Board[p_row + i][p_column + i].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row + i][p_column + i] == "bb") || (state.Board[p_row + i][p_column +i] == "bq"))
            {
               // rangePiece = state.Board[p_row + i][p_column + i];
               // rangeRow = p_row + i;
               // rangeColumn = p_column + i;
               return true;
            }
         }
      }
      // down left
      for(int i = 1; i < 8; i++)
      {
         if(p_row + i < 8 && p_column - i >= 0)
         {
            if(!state.Board[p_row + i][p_column - i].startsWith("bb") && !state.Board[p_row + i][p_column - i].startsWith("bq")  && !state.Board[p_row + i][p_column - i].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row + i][p_column - i] == "bb") || (state.Board[p_row + i][p_column - i] == "bq"))
            {
               // rangePiece = state.Board[p_row + i][p_column - i];
               // rangeRow = p_row + i;
               // rangeColumn = p_column - i;
               return true;
            }
         }
      }
      // up right
      for(int i = 1; i < 8; i++)
      {
         if(p_row - i >= 0 && p_column + i < 8)
         {
            if(!state.Board[p_row - i][p_column + i].startsWith("bb") && !state.Board[p_row - i][p_column + i].startsWith("bq") && !state.Board[p_row - i][p_column + i].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row - i][p_column + i] == "bb") || (state.Board[p_row - i][p_column + i] == "bq"))
            {
               // rangePiece = state.Board[p_row - i][p_column + i];
               // rangeRow = p_row - i;
               // rangeColumn = p_column + i;
               return true;
            }
         }
      }
      // up left
      for(int i = 1; i < 8; i++)
      {
         if(p_row - i >= 0 && p_column - i >= 0)
         {
            if(!state.Board[p_row - i][p_column - i].startsWith("bb") && !state.Board[p_row - i][p_column - i].startsWith("bq") && !state.Board[p_row - i][p_column - i].startsWith("z"))
            {
               break;
            }
            else if((state.Board[p_row - i][p_column - i] == "bb") || (state.Board[p_row - i][p_column - i] == "bq"))
            {
               // rangePiece = state.Board[p_row - i][p_column - i];
               // rangeRow = p_row - i;
               // rangeColumn = p_column - i;
               return true;
            }
         }
      }
      // knight check
      if(p_row + 1 < 8 && p_column + 2 < 8)
      {
         if(state.Board[p_row + 1][p_column + 2] == "bn")
         {
            // rangePiece = state.Board[p_row + 1][p_column + 2];
            // rangeRow = p_row + 1;
            // rangeColumn = p_column + 2
            return true;
         }
      }
      // knight check
      if(p_row - 1 >= 0 && p_column + 2 < 8)
      {
         if(state.Board[p_row - 1][p_column + 2] == "bn")
         {
            // rangePiece = state.Board[p_row - 1][p_column + 2];
            // rangeRow = p_row - 1;
            // rangeColumn = p_column + 2
            return true;
         }
      }
      // knight check
      if(p_row - 2 >= 0 && p_column + 1 < 8)
      {
         if(state.Board[p_row - 2][p_column + 1] == "bn")
         {
            // rangePiece = state.Board[p_row - 2][p_column + 1];
            // rangeRow = p_row - 2;
            // rangeColumn = p_column + 1
            return true;
         }
      }
      // knight check
      if(p_row - 2 >= 0 && p_column - 1 >= 0)
      {
         if(state.Board[p_row - 2][p_column - 1] == "bn")
         {
            // rangePiece = state.Board[p_row - 2][p_column - 1];
            // rangeRow = p_row + 2;
            // rangeColumn = p_column - 1
            return true;
         }
      }
      // knight check
      if(p_row - 1 >= 0 && p_column - 2 >= 0)
      {
         if(state.Board[p_row - 1][p_column - 2] == "bn")
         {
            // rangePiece = state.Board[p_row - 1][p_column - 2];
            // rangeRow = p_row - 1;
            // rangeColumn = p_column - 2
            return true;
         }
      }
      // knight check
      if(p_row + 1 < 8 && p_column - 2 >= 0)
      {
         if(state.Board[p_row + 1][p_column - 2] == "bn")
         {
            // rangePiece = state.Board[p_row + 1][p_column - 2];
            // rangeRow = p_row + 1;
            // rangeColumn = p_column - 2
            return true;
         }
      }
      // knight check
      if(p_row + 2 < 8 && p_column - 1 >= 0)
      {
         if(state.Board[p_row + 2][p_column - 1] == "bn")
         {
            // rangePiece = state.Board[p_row + 2][p_column - 1];
            // rangeRow = p_row + 2;
            // rangeColumn = p_column - 1
            return true;
         }
      }
      // knight check
      if(p_row + 2 < 8 && p_column + 1 < 8)
      {
         if(state.Board[p_row + 2][p_column + 1] == "bn")
         {
            // rangePiece = state.Board[p_row + 2][p_column + 1];
            // rangeRow = p_row + 2;
            // rangeColumn = p_column + 1
            return true;
         }
      }
      // pawn check against b pawns
      if(OTeam.equals("b"))
      {
         if(p_row + 1 < 8 && p_column + 1 < 8)
         {
            if(state.Board[p_row + 1][p_column + 1].equals(OTeam+"p"))
            {
               return true;
            }
         }
         if(p_row + 1 < 8 && p_column - 1 >= 0)
         {
            if(state.Board[p_row + 1][p_column - 1].equals(OTeam+"p"))
            {
               return true;
            }
         }
      }
      // pawn check against w pawns
      else if(OTeam.equals("w"))
      {
         if(p_row - 1 >= 0 && p_column + 1 < 8)
         {
            if(state.Board[p_row - 1][p_column + 1].equals(OTeam+"p"))
            {
               return true;
            }
         }
         if(p_row - 1 >= 0 && p_column - 1 >= 0)
         {
            if(state.Board[p_row - 1][p_column - 1].equals(OTeam+"p"))
            {
               return true;
            }
         }
      }
      return false;
   }
   //
   // temp move piece, if move puts king in check, temp move is reversed.
   //
   public void moveTemp(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
   {
      tempPieceEnd = state.Board[p_endRow][p_endColumn];
      state.Board[p_endRow][p_endColumn] = state.Board[p_startRow][p_startColumn];
      tempPieceStart = state.Board[p_startRow][p_startColumn];
      state.Board[p_startRow][p_startColumn] = "z";
   }
   //
   // moveBack reverses move and resets some values
   //
   public void moveBack(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
   {
      state.Board[p_startRow][p_startColumn] = tempPieceStart;
      state.Board[p_endRow][p_endColumn] = tempPieceEnd;
   }
}