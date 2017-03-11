public class Danger
{
	String Team;
	String OTeam;
	State state = new State();
   Moves moves = new Moves();
   String tempPieceEnd;
   String tempPieceStart;
   String rangeType;
   int rangeRow;
   int rangeColumn;
   String checkType;
   int checkRow;
   int checkColumn;
   boolean checkUp;
   boolean checkDown;
   boolean checkRight;
   boolean checkLeft;
   boolean checkUpRight;
   boolean checkUpLeft;
   boolean checkDownRight;
   boolean checkDownLeft;
   boolean checkPawn;
   boolean checkKnight;
   boolean rangeFound = false;

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
         checkUp = false;
         checkDown = false;
         checkRight = false;
         checkLeft = false;
         checkDownRight = false;
         checkDownLeft = false;
         checkUpRight = false;
         checkUpLeft = false;
         setOTeam();
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
                  checkType = state.Board[p_row + i][p_column];
                  checkRow = p_row + i;
                  checkColumn = p_column;
                  checkDown = true;
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
                  checkType = state.Board[p_row - i][p_column];
                  checkRow = p_row - i;
                  checkColumn = p_column;
                  checkUp = true;
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
                  checkType = state.Board[p_row][p_column + i];
                  checkRow = p_row;
                  checkColumn = p_column + i;
                  checkRight = true;
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
                  checkType = state.Board[p_row][p_column - i];
                  checkRow = p_row;
                  checkColumn = p_column - i;
                  checkLeft = true;
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
                  rangeType = state.Board[p_row + i][p_column + i];
                  checkRow = p_row + i;
                  checkColumn = p_column + i;
                  checkDownRight = true;
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
                  checkType = state.Board[p_row + i][p_column - i];
                  checkRow = p_row + i;
                  checkColumn = p_column - i;
                  checkDownLeft = true;
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
                  checkType = state.Board[p_row - i][p_column + i];
                  checkRow = p_row - i;
                  checkColumn = p_column + i;
                  checkUpRight = true;
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
                  checkType = state.Board[p_row - i][p_column - i];
                  checkRow = p_row - i;
                  checkColumn = p_column - i;
                  checkUpLeft = true;
               	return true;
            	}
         	}
      	}
      	// knight check
      	if(p_row + 1 < 8 && p_column + 2 < 8)
      	{
         	if(state.Board[p_row + 1][p_column + 2].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row + 1][p_column + 2];
               checkRow = p_row + 1;
               checkColumn = p_column + 2;
               checkKnight = true;
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 1 >= 0 && p_column + 2 < 8)
      	{
         	if(state.Board[p_row - 1][p_column + 2].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row - 1][p_column + 2];
               checkRow = p_row - 1;
               checkColumn = p_column + 2;
               checkKnight = true;
            	return true;
         	}
      	}
      	// knight check
     	   if(p_row - 2 >= 0 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row - 2][p_column + 1].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row - 2][p_column + 1];
               checkRow = p_row - 2;
               checkColumn = p_column + 1;
               checkKnight = true;
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 2 >= 0 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row - 2][p_column - 1].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row - 2][p_column - 1];
               checkRow = p_row - 2;
               checkColumn = p_column - 1;
               checkKnight = true;
            	return true;
         	}
      	}
      	// knight check
      	if(p_row - 1 >= 0 && p_column - 2 >= 0)
      	{
         	if(state.Board[p_row - 1][p_column - 2].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row - 1][p_column - 2];
               checkRow = p_row - 1;
               checkColumn = p_column - 2;
               checkKnight = true;
            	return true;
         	}
      	}
      	// knight check
      	if(p_row + 1 < 8 && p_column - 2 >= 0)
      	{
         	if(state.Board[p_row + 1][p_column - 2].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row + 1][p_column - 2];
               checkRow = p_row + 1;
               checkColumn = p_column - 2;
               checkKnight = true;
            	return true;
         	}
      	}
     	   // knight check
      	if(p_row + 2 < 8 && p_column - 1 >= 0)
      	{
         	if(state.Board[p_row + 2][p_column - 1].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row + 2][p_column - 1];
               checkRow = p_row + 2;
               checkColumn = p_column - 1;
               checkKnight = true;
            	return true;
         	}
      	}
      	// knight check
      	if(p_row + 2 < 8 && p_column + 1 < 8)
      	{
         	if(state.Board[p_row + 2][p_column + 1].equals(OTeam+"n"))
         	{
               checkType = state.Board[p_row + 2][p_column + 1];
               checkRow = p_row + 2;
               checkColumn = p_column + 1;
               checkKnight = true;
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
                  checkPawn = true;
                  return true;
               }
            }
            if(p_row + 1 < 8 && p_column - 1 >= 0)
            {
               if(state.Board[p_row + 1][p_column - 1].equals(OTeam+"p"))
               {
                  checkPawn = true;
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
                  checkPawn = true;
                  return true;
               }
            }
            if(p_row - 1 >= 0 && p_column - 1 >= 0)
            {
               if(state.Board[p_row - 1][p_column - 1].equals(OTeam+"p"))
               {
                  checkPawn = true;
                  return true;
               }
            }
         }
	      return false;
    }
   public boolean range(int p_row, int p_column)
   {
      rangeFound = false;
      setOTeam();
      // down
      for(int i = 1; i < 8; i++)
      {
         if(p_row + i < 8) 
         {
            if(!state.Board[p_row + i][p_column].equals(Team+"c") && !state.Board[p_row + i][p_column].equals(Team+"q") && state.Board[p_row + i][p_column] != "z")
            {
               break;
            }
            else if(state.Board[p_row + i][p_column].equals(Team+"c") || state.Board[p_row + i][p_column].equals(Team+"q"))
            {
               rangeType = state.Board[p_row + i][p_column];
               rangeRow = p_row + i;
               rangeColumn = p_column;
               rangeFound = true;
               return true;
            }
         }
      }
      // up
      for(int i = 1; i < 8; i++)
      {
         if(p_row - i >= 0)
         {
            if(!state.Board[p_row - i][p_column].equals(Team+"c") && !state.Board[p_row - i][p_column].equals(Team+"q") && state.Board[p_row - i][p_column] != "z")
            {
               break;
            }
            else if(state.Board[p_row - i][p_column].equals(Team+"c") || state.Board[p_row - i][p_column].equals(Team+"q"))
            {
               rangeType = state.Board[p_row - i][p_column];
               rangeRow = p_row - i;
               rangeColumn = p_column;
               rangeFound = true;
               return true;
            }
         }
      }
      // right
      for(int i = 1; i < 8; i++)
      {
         if(p_column + i < 8)
         {
            if(!state.Board[p_row][p_column + i].equals(Team+"c") && !state.Board[p_row][p_column + i].equals(Team+"q") && state.Board[p_row][p_column + i] != "z")
            {
               break;
            }
            else if(state.Board[p_row][p_column + i].equals(Team+"c") || state.Board[p_row][p_column + i].equals(Team+"q"))
            {
               rangeType = state.Board[p_row][p_column + i];
               rangeRow = p_row;
               rangeColumn = p_column + i;
               rangeFound = true;
               return true;
            }
         }
      }
      // left
      for(int i = 1; i < 8; i++)
      {
         if(p_column - i >= 0)
         {
            if(!state.Board[p_row][p_column - i].equals(Team+"c") && !state.Board[p_row][p_column - i].equals(Team+"q") && state.Board[p_row][p_column - i] != "z")
            {
               break;
            }
            else if(state.Board[p_row][p_column - i].equals(Team+"c") || state.Board[p_row][p_column - i].equals(Team+"q"))
            {
               rangeType = state.Board[p_row][p_column - i];
               rangeRow = p_row;
               rangeColumn = p_column - i;
               rangeFound = true;
               return true;
            }
         }
      }
      //down right
      for(int i = 1; i < 8; i++)
      {
         if(p_row + i < 8 && p_column + i < 8)
         {
            if(!state.Board[p_row + i][p_column + i].equals(Team+"b") && !state.Board[p_row + i][p_column + i].equals(Team+"q") && state.Board[p_row + i][p_column + i] != "z")
            {
               break;
            }
            else if(state.Board[p_row + i][p_column + i].equals(Team+"b") || state.Board[p_row + i][p_column +i].equals(Team+"q"))
            {
               rangeType = state.Board[p_row + i][p_column + i];
               rangeRow = p_row + i;
               rangeColumn = p_column + i;
               rangeFound = true;
               return true;
            }
         }
      }
      // down left
      for(int i = 1; i < 8; i++)
      {
         if(p_row + i < 8 && p_column - i >= 0)
         {
            if(!state.Board[p_row + i][p_column - i].equals(Team+"b") && !state.Board[p_row + i][p_column - i].equals(Team+"q")  && state.Board[p_row + i][p_column - i] != "z")
            {
               break;
            }
            else if(state.Board[p_row + i][p_column - i].equals(Team+"b") || state.Board[p_row + i][p_column - i].equals(Team+"q"))
            {
               rangeType = state.Board[p_row + i][p_column - i];
               rangeRow = p_row + i;
               rangeColumn = p_column - i;
               rangeFound = true;
               return true;
            }
         }
      }
      // up right
      for(int i = 1; i < 8; i++)
      {
         if(p_row - i >= 0 && p_column + i < 8)
         {
            if(!state.Board[p_row - i][p_column + i].equals(Team+"b") && !state.Board[p_row - i][p_column + i].equals(Team+"q") && state.Board[p_row - i][p_column + i] != "z")
            {
               break;
            }
            else if(state.Board[p_row - i][p_column + i].equals(Team+"b") || state.Board[p_row - i][p_column + i].equals(Team+"q"))
            {
               rangeType = state.Board[p_row - i][p_column + i];
               rangeRow = p_row - i;
               rangeColumn = p_column + i;
               rangeFound = true;
               return true;
            }
         }
      }
      // up left
      for(int i = 1; i < 8; i++)
      {
         if(p_row - i >= 0 && p_column - i >= 0)
         {
            if(!state.Board[p_row - i][p_column - i].equals(Team+"b") && !state.Board[p_row - i][p_column - i].equals(Team+"q") && state.Board[p_row - i][p_column - i] != "z")
            {
               break;
            }
            else if(state.Board[p_row - i][p_column - i].equals(Team+"b") || state.Board[p_row - i][p_column - i].equals(Team+"q"))
            {
               rangeType = state.Board[p_row - i][p_column - i];
               rangeRow = p_row - i;
               rangeColumn = p_column - i;
               rangeFound = true;
               return true;
            }
         }
      }
      // knight check
      if(p_row + 1 < 8 && p_column + 2 < 8)
      {
         if(state.Board[p_row + 1][p_column + 2].equals(Team+"n"))
         {
            rangeType = state.Board[p_row + 1][p_column + 2];
            rangeRow = p_row + 1;
            rangeColumn = p_column + 2;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row - 1 >= 0 && p_column + 2 < 8)
      {
         if(state.Board[p_row - 1][p_column + 2].equals(Team+"n"))
         {
            rangeType = state.Board[p_row - 1][p_column + 2];
            rangeRow = p_row - 1;
            rangeColumn = p_column + 2;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row - 2 >= 0 && p_column + 1 < 8)
      {
         if(state.Board[p_row - 2][p_column + 1].equals(Team+"n"))
         {
            rangeType = state.Board[p_row - 2][p_column + 1];
            rangeRow = p_row - 2;
            rangeColumn = p_column + 1;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row - 2 >= 0 && p_column - 1 >= 0)
      {
         if(state.Board[p_row - 2][p_column - 1].equals(Team+"n"))
         {
            rangeType = state.Board[p_row - 2][p_column - 1];
            rangeRow = p_row - 2;
            rangeColumn = p_column - 1;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row - 1 >= 0 && p_column - 2 >= 0)
      {
         if(state.Board[p_row - 1][p_column - 2].equals(Team+"n"))
         {
            rangeType = state.Board[p_row - 1][p_column - 2];
            rangeRow = p_row - 1;
            rangeColumn = p_column - 2;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row + 1 < 8 && p_column - 2 >= 0)
      {
         if(state.Board[p_row + 1][p_column - 2].equals(Team+"n"))
         {
            rangeType = state.Board[p_row + 1][p_column - 2];
            rangeRow = p_row + 1;
            rangeColumn = p_column - 2;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row + 2 < 8 && p_column - 1 >= 0)
      {
         if(state.Board[p_row + 2][p_column - 1].equals(Team+"n"))
         {
            rangeType = state.Board[p_row + 2][p_column - 1];
            rangeRow = p_row + 2;
            rangeColumn = p_column - 1;
            rangeFound = true;
            return true;
         }
      }
      // knight check
      if(p_row + 2 < 8 && p_column + 1 < 8)
      {
         if(state.Board[p_row + 2][p_column + 1].equals(Team+"n"))
         {
            rangeType = state.Board[p_row + 2][p_column + 1];
            rangeRow = p_row + 2;
            rangeColumn = p_column + 1;
            rangeFound = true;
            return true;
         }
      }
      // pawn check against b pawns
      if(Team.equals("b"))
      {
         if(state.Board[p_row][p_column] == "z")
         {
            if(p_row == 4)
            {
               if(state.Board[p_row + 2][p_column].equals(Team+"p"))
               {
                  rangeRow = p_row + 2;
                  rangeColumn = p_column;
                  rangeFound = true;
                  return true;
               }
            }
            else
            {
               if(p_row + 1 < 8)
               {
                  if(state.Board[p_row + 1][p_column].equals(Team+"p"))
                  {
                     rangeRow = p_row + 1;
                     rangeColumn = p_column;
                     rangeFound = true;
                     return true;
                  }
               }
            }
         }
         else
         {
            if(p_row + 1 < 8 && p_column + 1 < 8)
            {
               if(state.Board[p_row + 1][p_column + 1].equals(Team+"p"))
               {
                  rangeRow = p_row + 1;
                  rangeColumn = p_column + 1;
                  rangeFound = true;
                  return true;
               }
            }
            if(p_row + 1 < 8 && p_column - 1 >= 0)
            {
               if(state.Board[p_row + 1][p_column - 1].equals(Team+"p"))
               {
                  rangeRow = p_row + 1;
                  rangeColumn = p_column - 1;
                  rangeFound = true;
                  return true;
               }
            }
         }
      }
      // pawn check against w pawns
      else if(Team.equals("w"))
      {
         if(state.Board[p_row][p_column] == "z")
         {
            if(p_row == 3)
            {
               if(state.Board[p_row - 2][p_column].equals(Team+"p"))
               {
                  rangeRow = p_row - 2;
                  rangeColumn = p_column;
                  rangeFound = true;
                  return true;
               }
            }
            else
            {
               if(p_row - 1 >= 0)
               {
                  if(state.Board[p_row - 1][p_column].equals(Team+"p"))
                  {
                     rangeRow = p_row - 1;
                     rangeColumn = p_column;
                     rangeFound = true;
                     return true;
                  }
               }
            }
         }
         else
         {
            if(p_row - 1 >= 0 && p_column + 1 < 8)
            {
               if(state.Board[p_row - 1][p_column + 1].equals(Team+"p"))
               {
                  rangeRow = p_row - 1;
                  rangeColumn = p_column + 1;
                  rangeFound = true;
                  return true;
               }
            }
            if(p_row - 1 >= 0 && p_column - 1 >= 0)
            {
               if(state.Board[p_row - 1][p_column - 1].equals(Team+"p"))
               {
                  rangeRow = p_row - 1;
                  rangeColumn = p_column - 1;
                  rangeFound = true;
                  return true;
               }
            }
         }
      }
      return false;
   }
   public boolean canMove(int p_row, int p_column, String p_type)
   {
         Logic logic = new Logic();
         logic.Team = state.Turn;
         switch(p_type)
         {
            case "wc":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column, "wc"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column, "wc"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column + 1, "wc"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column - 1, "wc"))
               {
                  return true;
               }
               break;
            case "wn":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 2, "wn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 2, "wn"))
               {
                  return true; 
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 2, p_column + 1, "wn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 2, p_column - 1, "wn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 2, "wn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 2, "wn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 2, p_column - 1, "wn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 2, p_column + 1, "wn"))
               {
                  return true;
               }
               break;
            case "wb":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 1, "wb"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 1, "wb"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 1, "wb"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 1, "wb"))
               {
                  return true;
               }
               break;
            case "wq":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column + 1, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column - 1, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 1, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 1, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 1, "wq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 1, "wq"))
               {
                  return true;
               }
               break;
            case "wp":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column, "wp"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 1, "wp"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 1, "wp"))
               {
                  return true;
               }
               break;
            case "bc":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column, "bc"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column, "bc"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column + 1, "bc"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column - 1, "bc"))
               {
                  return true;
               }
               break;
            case "bn":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 2, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 2, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 2, p_column + 1, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 2, p_column - 1, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 2, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 2, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 2, p_column - 1, "bn"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 2, p_column + 1, "bn"))
               {
                  return true;
               }
               break;
            case "bb":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 1, "bb"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 1, "bb"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 1, "bb"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 1, "bb"))
               {
                  return true;
               }
               break;
            case "bq":
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column + 1, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row, p_column - 1, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column + 1, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row + 1, p_column - 1, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 1, "bq"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 1, "bq"))
               {
                  return true;
               }
               break;
            case "bp":
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column, "bp"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column + 1, "bp"))
               {
                  return true;
               }
               if(logic.CMEvaluate(p_row, p_column, p_row - 1, p_column - 1, "bp"))
               {
                  return true;
               }
               break;
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
   //
   // temp move piece, if move puts king in check, temp move is reversed.
   //
   public void moveTemp(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
   {
      System.out.println("temp moving " + p_startRow + "," + p_startColumn + " to " + p_endRow + "," + p_endColumn);
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