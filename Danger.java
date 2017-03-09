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
      	// down
      	for(int i = 1; i < 8; i++)
      	{
         	if(p_row + i < 8)
         	{
            	if(!state.Board[p_row + i][p_column].equals(OTeam+"c") && !state.Board[p_row + i][p_column].equals(OTeam+"q") && !state.Board[p_row + i][p_column].equals("z"))
            	{
                  System.out.println("Danger.inDanger line 48");
               	break;
            	}
            	else if((state.Board[p_row + i][p_column].equals(OTeam+"c")) || (state.Board[p_row + i][p_column].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 53");
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
                  System.out.println("Danger.inDanger line 69");
               	break;
            	}
            	else if((state.Board[p_row - i][p_column].equals(OTeam+"c")) || (state.Board[p_row - i][p_column].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 74");
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
                  System.out.println("Danger.inDanger line 90");
               	break;
            	}
            	else if((state.Board[p_row][p_column + i].equals(OTeam+"c")) || (state.Board[p_row][p_column + i].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 95");
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
                  System.out.println("Danger.inDanger line 111");
        	   		break;
           		}
               else if((state.Board[p_row][p_column - i].equals(OTeam+"c")) || (state.Board[p_row][p_column - i].equals(OTeam+"q")))
               {
                  System.out.println("Danger.inDanger line 116");
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
                  System.out.println("Danger.inDanger line 132");
              	 	break;
            	}
            	else if((state.Board[p_row + i][p_column + i].equals(OTeam+"b")) || (state.Board[p_row + i][p_column +i].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 137");
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
                  System.out.println("Danger.inDanger line 153");
               	break;
            	}
            	else if((state.Board[p_row + i][p_column - i].equals(OTeam+"b")) || (state.Board[p_row + i][p_column - i].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 158");
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
                  System.out.println("Danger.inDanger line 174");
                  break;
            	}
            	else if((state.Board[p_row - i][p_column + i].equals(OTeam+"b")) || (state.Board[p_row - i][p_column + i].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 179");
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
                  System.out.println("Danger.inDanger line 195");
               	break;
            	}
            	else if((state.Board[p_row - i][p_column - i].equals(OTeam+"b")) || (state.Board[p_row - i][p_column - i].equals(OTeam+"q")))
            	{
                  System.out.println("Danger.inDanger line 200");
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
               System.out.println("Danger.inDanger line 214");
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
               System.out.println("Danger.inDanger line 227");
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
               System.out.println("Danger.inDanger line 240");
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
               System.out.println("Danger.inDanger line 253");
               checkType = state.Board[p_row - 2][p_column - 1];
               checkRow = p_row + 2;
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
               System.out.println("Danger.inDanger line 266");
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
               System.out.println("Danger.inDanger line 279");
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
               System.out.println("Danger.inDanger line 292");
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
               System.out.println("Danger.inDanger line 305");
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
               System.out.println("Danger.inDanger line 318");
            	return true;
         	}
      	}
      	// down opposite king check
      	if(p_row + 1 < 8)
      	{
         	if(state.Board[p_row + 1][p_column].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 327");
            	return true;
         	}
      	}
      	//right opposite king check
      	if(p_column + 1 < 8)
      	{
         	if(state.Board[p_row][p_column + 1].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 336");
            	return true;
         	}
      	}
      	//left opposite king check
      	if(p_column - 1 >= 0)
      	{
         	if(state.Board[p_row][p_column - 1].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 345");
            	return true;
         	}
     	   }
      	// down right king check
      	if(p_row + 1 < 8 & p_column + 1 < 8)
      	{
         	if(state.Board[p_row + 1][p_column + 1].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 354");
            	return true;
         	}
      	}
      	// down left king check
      	if(p_row + 1 < 8 & p_column - 1 >= 0)
      	{
         	if(state.Board[p_row + 1][p_column - 1].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 363");
            	return true;
         	}
      	}
      	// up right king check
      	if(p_row - 1 >= 0 & p_column + 1 < 8)
      	{
         	if(state.Board[p_row - 1][p_column + 1].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 372");
            	return true;
         	}
      	}
      	// up left king check
      	if(p_row - 1 >= 0 & p_column - 1 >= 0)
      	{
         	if(state.Board[p_row - 1][p_column - 1].equals(OTeam+"k"))
         	{
               System.out.println("Danger.inDanger line 381");
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
                  System.out.println("Danger.inDanger line 393");
                  checkPawn = true;
                  return true;
               }
            }
            if(p_row + 1 < 8 && p_column - 1 >= 0)
            {
               if(state.Board[p_row + 1][p_column - 1].equals(OTeam+"p"))
               {
                  System.out.println("Danger.inDanger line 402");
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
                  System.out.println("Danger.inDanger line 415");
                  checkPawn = true;
                  return true;
               }
            }
            if(p_row - 1 >= 0 && p_column - 1 >= 0)
            {
               if(state.Board[p_row - 1][p_column - 1].equals(OTeam+"p"))
               {
                  System.out.println("Danger.inDanger line 424");
                  checkPawn = true;
                  return true;
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
            if(!state.Board[p_row + i][p_column].equals(Team+"c") && !state.Board[p_row + i][p_column].equals(Team+"q") && state.Board[p_row + i][p_column] != "z")
            {
               System.out.println("Danger line 443");
               break;
            }
            else if(state.Board[p_row + i][p_column].equals(Team+"c") || state.Board[p_row + i][p_column].equals(Team+"q"))
            {
               System.out.println("Danger line 447");
               rangeType = state.Board[p_row + i][p_column];
               rangeRow = p_row + i;
               rangeColumn = p_column;
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
               System.out.println("Danger line 462");
               break;
            }
            else if(state.Board[p_row - i][p_column].equals(Team+"c") || state.Board[p_row - i][p_column].equals(Team+"q"))
            {
               System.out.println("Danger line 467");
               rangeType = state.Board[p_row - i][p_column];
               rangeRow = p_row - i;
               rangeColumn = p_column;
               return true;
            }
         }
      }
      // right
      for(int i = 1; i < 8; i++)
      {
         if(p_column + i < 8)
         {
            if(state.Board[p_row][p_column + i].equals(Team+"c") && !state.Board[p_row][p_column + i].equals(Team+"q") && state.Board[p_row][p_column + i] != "z")
            {
               System.out.println("Danger line 482");
               break;
            }
            else if(state.Board[p_row][p_column + i].equals(Team+"c") || state.Board[p_row][p_column + i].equals(Team+"q"))
            {
               System.out.println("Danger line 487");
               rangeType = state.Board[p_row][p_column + i];
               rangeRow = p_row;
               rangeColumn = p_column + i;
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
               System.out.println("Danger line 502");
               break;
            }
            else if(state.Board[p_row][p_column - i].equals(Team+"c") || state.Board[p_row][p_column - i].equals(Team+"q"))
            {
               System.out.println("Danger line 507");
               rangeType = state.Board[p_row][p_column - i];
               rangeRow = p_row;
               rangeColumn = p_column - i;
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
               System.out.println("Danger line 522");
               break;
            }
            else if(state.Board[p_row + i][p_column + i].equals(Team+"b") || state.Board[p_row + i][p_column +i].equals(Team+"q"))
            {
               System.out.println("Danger line 527");
               rangeType = state.Board[p_row + i][p_column + i];
               rangeRow = p_row + i;
               rangeColumn = p_column + i;
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
               System.out.println("Danger line 542");
               break;
            }
            else if(state.Board[p_row + i][p_column - i].equals(Team+"b") || state.Board[p_row + i][p_column - i].equals(Team+"q"))
            {
               System.out.println("Dangerline 547");
               rangeType = state.Board[p_row + i][p_column - i];
               rangeRow = p_row + i;
               rangeColumn = p_column - i;
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
               System.out.println("Danger line 562");
               break;
            }
            else if(state.Board[p_row - i][p_column + i].equals(Team+"b") || state.Board[p_row - i][p_column + i].equals(Team+"q"))
            {
               System.out.println("Danger line 567");
               rangeType = state.Board[p_row - i][p_column + i];
               rangeRow = p_row - i;
               rangeColumn = p_column + i;
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
               System.out.println("Danger line 582");
               break;
            }
            else if(state.Board[p_row - i][p_column - i].equals(Team+"b") || state.Board[p_row - i][p_column - i].equals(Team+"q"))
            {
               System.out.println("Danger line 587");
               rangeType = state.Board[p_row - i][p_column - i];
               rangeRow = p_row - i;
               rangeColumn = p_column - i;
               return true;
            }
         }
      }
      // knight check
      if(p_row + 1 < 8 && p_column + 2 < 8)
      {
         if(state.Board[p_row + 1][p_column + 2].equals(Team+"n"))
         {
            System.out.println("Danger line 600");
            rangeType = state.Board[p_row + 1][p_column + 2];
            rangeRow = p_row + 1;
            rangeColumn = p_column + 2;
            return true;
         }
      }
      // knight check
      if(p_row - 1 >= 0 && p_column + 2 < 8)
      {
         if(state.Board[p_row - 1][p_column + 2].equals(Team+"n"))
         {
            System.out.println("Danger line 612");
            rangeType = state.Board[p_row - 1][p_column + 2];
            rangeRow = p_row - 1;
            rangeColumn = p_column + 2;
            return true;
         }
      }
      // knight check
      if(p_row - 2 >= 0 && p_column + 1 < 8)
      {
         if(state.Board[p_row - 2][p_column + 1].equals(Team+"n"))
         {
            System.out.println("Danger line 624");
            rangeType = state.Board[p_row - 2][p_column + 1];
            rangeRow = p_row - 2;
            rangeColumn = p_column + 1;
            return true;
         }
      }
      // knight check
      if(p_row - 2 >= 0 && p_column - 1 >= 0)
      {
         if(state.Board[p_row - 2][p_column - 1].equals(Team+"n"))
         {
            System.out.println("Danger line 636");
            rangeType = state.Board[p_row - 2][p_column - 1];
            rangeRow = p_row + 2;
            rangeColumn = p_column - 1;
            return true;
         }
      }
      // knight check
      if(p_row - 1 >= 0 && p_column - 2 >= 0)
      {
         if(state.Board[p_row - 1][p_column - 2].equals(Team+"n"))
         {
            System.out.println("Danger line 648");
            rangeType = state.Board[p_row - 1][p_column - 2];
            rangeRow = p_row - 1;
            rangeColumn = p_column - 2;
            return true;
         }
      }
      // knight check
      if(p_row + 1 < 8 && p_column - 2 >= 0)
      {
         if(state.Board[p_row + 1][p_column - 2].equals(Team+"n"))
         {
            System.out.println("Danger line 660");
            rangeType = state.Board[p_row + 1][p_column - 2];
            rangeRow = p_row + 1;
            rangeColumn = p_column - 2;
            return true;
         }
      }
      // knight check
      if(p_row + 2 < 8 && p_column - 1 >= 0)
      {
         if(state.Board[p_row + 2][p_column - 1].equals(Team+"n"))
         {
            System.out.println("Dangerline 672");
            rangeType = state.Board[p_row + 2][p_column - 1];
            rangeRow = p_row + 2;
            rangeColumn = p_column - 1;
            return true;
         }
      }
      // knight check
      if(p_row + 2 < 8 && p_column + 1 < 8)
      {
         if(state.Board[p_row + 2][p_column + 1].equals(Team+"n"))
         {
            System.out.println("Danger line 684");
            rangeType = state.Board[p_row + 2][p_column + 1];
            rangeRow = p_row + 2;
            rangeColumn = p_column + 1;
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
                  System.out.println("Danger line 700");
                  rangeType = state.Board[p_row + 2][p_column];
                  rangeRow = p_row + 2;
                  rangeColumn = p_column;
                  return true;
               }
            }
            else
            {
               if(state.Board[p_row + 1][p_column].equals(Team+"p"))
               {
                  System.out.println("Danger line 711");
                  rangeType = state.Board[p_row + 1][p_column];
                  rangeRow = p_row + 1;
                  rangeColumn = p_column;
                  return true;
               }
            }
         }
         else
         {
            if(p_row + 1 < 8 && p_column + 1 < 8)
            {
               if(state.Board[p_row + 1][p_column + 1].equals(Team+"p"))
               {
                  System.out.println("Danger line 725");
                  rangeType = state.Board[p_row + 1][p_column + 1];
                  rangeRow = p_row + 1;
                  rangeColumn = p_column + 1;
                  return true;
               }
            }
            if(p_row + 1 < 8 && p_column - 1 >= 0)
            {
               if(state.Board[p_row + 1][p_column - 1].equals(Team+"p"))
               {
                  System.out.println("Danger line 736");
                  rangeType = state.Board[p_row + 1][p_column - 1];
                  rangeRow = p_row + 1;
                  rangeColumn = p_column - 1;
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
                  System.out.println("Danger line 754");
                  rangeType = state.Board[p_row - 2][p_column];
                  rangeRow = p_row - 2;
                  rangeColumn = p_column;
                  return true;
               }
            }
            else
            {
               if(state.Board[p_row - 1][p_column].equals(Team+"p"))
               {
                  System.out.println("Danger line 765");
                  rangeType = state.Board[p_row - 1][p_column];
                  rangeRow = p_row - 1;
                  rangeColumn = p_column;
                  return true;
               }
            }
         }
         else
         {
            if(p_row - 1 >= 0 && p_column + 1 < 8)
            {
               if(state.Board[p_row - 1][p_column + 1].equals(Team+"p"))
               {
                  System.out.println("Danger line 779");
                  rangeType = state.Board[p_row - 1][p_column + 1];
                  rangeRow = p_row - 1;
                  rangeColumn = p_column + 1;
                  return true;
               }
            }
            if(p_row - 1 >= 0 && p_column - 1 >= 0)
            {
               if(state.Board[p_row - 1][p_column - 1].equals(Team+"p"))
               {
                  System.out.println("Danger line 790");
                  rangeType = state.Board[p_row - 1][p_column - 1];
                  rangeRow = p_row - 1;
                  rangeColumn = p_column - 1;
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
         System.out.println();
         switch(p_type)
         {
            case "wc":
               System.out.println("Danger line 809");
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
               System.out.println("Danger line 828");
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
               System.out.println("Danger line 863");
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
               System.out.println("Danger line 882");
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
               System.out.println("Danger line 917");
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
               System.out.println("Danger line 932");
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
               System.out.println("Danger line 951");
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
               System.out.println("Danger line 986");
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
               System.out.println("Danger line 1005");
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
               System.out.println("Danger line 1040");
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
               System.out.println("Danger line 1068");
               moveBack(p_row, p_column, p_row - 1, p_column);
               return true;
            }
            else
            {
               System.out.println("Danger line 1074");
               moveBack(p_row, p_column, p_row - 1, p_column);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row - 1][p_column].startsWith(Team) && state.Board[p_row - 1][p_column] != "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column);
            if(!inDanger(p_row - 1, p_column))
            {
               System.out.println("Danger line 1084");
               moveBack(p_row, p_column, p_row - 1, p_column);
               return true;
            }
            else
            {
               System.out.println("Danger line 1090");
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
               System.out.println("Danger line 1103");
               moveBack(p_row, p_column, p_row + 1, p_column);
               return true;
            }
            else
            {
               System.out.println("Danger line 1109");
               moveBack(p_row, p_column, p_row + 1, p_column);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row + 1][p_column].startsWith(Team) && state.Board[p_row + 1][p_column] != "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column);
            if(!inDanger(p_row + 1, p_column))
            {
               System.out.println("Danger line 1119");
               moveBack(p_row, p_column, p_row + 1, p_column);
               return true;
            }
            else
            {
               System.out.println("Danger line 1125");
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
               System.out.println("Danger line 1138");
               moveBack(p_row, p_column, p_row, p_column + 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1144");
               moveBack(p_row, p_column, p_row, p_column + 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row][p_column + 1].startsWith(Team) && state.Board[p_row][p_column + 1] != "z")
         {
            moveTemp(p_row, p_column, p_row, p_column + 1);
            if(!inDanger(p_row, p_column + 1))
            {
               System.out.println("Danger line 1154");
               moveBack(p_row, p_column, p_row, p_column + 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1160");
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
               System.out.println("Danger line 1173");
               moveBack(p_row, p_column, p_row, p_column - 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1179");
               moveBack(p_row, p_column, p_row, p_column - 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row][p_column - 1].startsWith(Team) && state.Board[p_row][p_column - 1] != "z")
         {
            moveTemp(p_row, p_column, p_row, p_column - 1);
            if(!inDanger(p_row, p_column - 1))
            {
               System.out.println("Danger line 1189");
               moveBack(p_row, p_column, p_row, p_column - 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1195");
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
               System.out.println("Danger line 1208");
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1214");
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row + 1][p_column + 1].startsWith(Team) && state.Board[p_row + 1][p_column + 1] != "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column + 1);
            if(!inDanger(p_row + 1, p_column + 1))
            {
               System.out.println("Danger line 1224");
               moveBack(p_row, p_column, p_row + 1, p_column + 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1230");
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
               System.out.println("Danger line 1243");
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1249");
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row + 1][p_column - 1].startsWith(Team) && state.Board[p_row + 1][p_column - 1] != "z")
         {
            moveTemp(p_row, p_column, p_row + 1, p_column - 1);
            if(!inDanger(p_row + 1, p_column - 1))
            {
               System.out.println("Danger line 1259");
               moveBack(p_row, p_column, p_row + 1, p_column - 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1265");
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
               System.out.println("Danger line 1278");
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1284");
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row - 1][p_column + 1].startsWith(Team) && state.Board[p_row - 1][p_column + 1] != "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column + 1);
            if(!inDanger(p_row - 1, p_column + 1))
            {
               System.out.println("Danger line 1294");
               moveBack(p_row, p_column, p_row - 1, p_column + 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1300");
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
               System.out.println("Danger line 1313");
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1319");
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
            }
         }
         // if position trying to check is an enemy piece, check to see if after taking that piece are you still in check
         else if(!state.Board[p_row - 1][p_column - 1].startsWith(Team) && state.Board[p_row - 1][p_column - 1] != "z")
         {
            moveTemp(p_row, p_column, p_row - 1, p_column - 1);
            if(!inDanger(p_row - 1, p_column - 1))
            {
               System.out.println("Danger line 1329");
               moveBack(p_row, p_column, p_row - 1, p_column - 1);
               return true;
            }
            else
            {
               System.out.println("Danger line 1335");
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
      System.out.println();
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
      System.out.println();
      state.Board[p_startRow][p_startColumn] = tempPieceStart;
      state.Board[p_endRow][p_endColumn] = tempPieceEnd;
   }
}