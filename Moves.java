public class Moves
{
   State state = new State();
	boolean pass;
   Castle castle = new Castle();
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
      	if((p_endRow + 1 == p_startRow & p_endColumn + 2 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn + 2 == p_startColumn) || (p_endRow - 2 == p_startRow & p_endColumn + 1 == p_startColumn) || (p_endRow - 2 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn - 2 == p_startColumn) || (p_endRow + 1 == p_startRow & p_endColumn - 2 == p_startColumn) || (p_endRow + 2 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow + 2 == p_startRow & p_endColumn + 1 == p_startColumn))
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
      // down
      if(p_endRow > p_startRow)
      {
          //down right row++ col++
         if(p_endColumn > p_startColumn)
         {
            if(p_endRow - p_startRow == p_endColumn - p_startColumn)
            {
               pass = true;
               for(int i = 1; i < p_endRow - p_startRow; i++)
               {
                  if(state.Board[p_startRow + i][p_startColumn + i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
         // down left row++ col--
         else if(p_endColumn < p_startColumn)
         {
            if(p_endRow - p_startRow == p_startColumn - p_endColumn)
            {
               pass = true;
               for(int i = 1; i < p_endRow - p_startRow; i++)
               {
                  if(state.Board[p_startRow + i][p_startColumn - i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
      }
      // up
      else if(p_endRow < p_startRow)
      {
         // up right row-- col++
         if(p_endColumn > p_startColumn)
         {
            if(p_startRow - p_endRow == p_endColumn - p_startColumn)
            {
               pass = true;
               for(int i = 1; i < p_startRow - p_endRow; i++)
               {
                  if(state.Board[p_startRow - i][p_startColumn + i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
         // up left row-- col--
         else if(p_endColumn < p_startColumn)
         {
            if(p_startRow - p_endRow == p_startColumn - p_endColumn)
            {
               pass = true;
               for(int i = 1; i < p_startRow - p_endRow; i++)
               {
                  if(state.Board[p_startRow - i][p_startColumn - i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
      }
	}
	void queen(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{
      // right
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
         // left
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
      // down
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
         // up
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
      // down
      if(p_endRow > p_startRow)
      {
         //down right row++ col++
         if(p_endColumn > p_startColumn)
         {
            if(p_endRow - p_startRow == p_endColumn - p_startColumn)
            {
               pass = true;
               for(int i = 1; i < p_endRow - p_startRow; i++)
               {
                  if(state.Board[p_startRow + i][p_startColumn + i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
         // down left row++ col--
         else if(p_endColumn < p_startColumn)
         {
            if(p_endRow - p_startRow == p_startColumn - p_endColumn)
            {
               pass = true;
               for(int i = 1; i < p_endRow - p_startRow; i++)
               {
                  if(state.Board[p_startRow + i][p_startColumn - i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
      }
      // up
      else if(p_endRow < p_startRow)
      {
         // up right row-- col++
         if(p_endColumn > p_startColumn)
         {
            if(p_startRow - p_endRow == p_endColumn - p_startColumn)
            {
               pass = true;
               for(int i = 1; i < p_startRow - p_endRow; i++)
               {
                  if(state.Board[p_startRow - i][p_startColumn + i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
         // up left row-- col--
         else if(p_endColumn < p_startColumn)
         {
            if(p_startRow - p_endRow == p_startColumn - p_endColumn)
            {
               pass = true;
               for(int i = 1; i < p_startRow - p_endRow; i++)
               {
                  if(state.Board[p_startRow - i][p_startColumn - i] != "z")
                  {
                     pass = false;
                     break;
                  }
               }
            }
         }
      }
	}
	void wking(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{
      if((p_endRow + 1 == p_startRow & p_endColumn + 1 == p_startColumn) || (p_endRow + 1 == p_startRow & p_endColumn == p_startColumn) || (p_endRow + 1 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn + 1 == p_startColumn) || (p_endRow == p_startRow & p_endColumn + 1 == p_startColumn))
      {
         pass = true;
      }
      if(state.wCastleUpLeftMoved == false & state.wKingMoved == false & p_endRow == p_startRow & p_endColumn + 2 == p_startColumn)
      {
         if(castle.checkCastle(p_endRow, p_endColumn))
         {
            pass = true;
            castle.initCastle(p_endRow, p_endColumn);
         }
         else
         {
            pass = false;
         }
      }
      if(state.wCastleUpRightMoved == false & state.wKingMoved == false & p_endRow == p_startRow & p_endColumn - 2 == p_startColumn)
      {
         if(castle.checkCastle(p_endRow, p_endColumn))
         {
            pass = true;
            castle.initCastle(p_endRow, p_endColumn);
         }
         else
         {
            pass = false;
         }
      }
	}
	void bking(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{
      if((p_endRow + 1 == p_startRow & p_endColumn + 1 == p_startColumn) || (p_endRow + 1 == p_startRow & p_endColumn == p_startColumn) || (p_endRow + 1 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn - 1 == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn == p_startColumn) || (p_endRow - 1 == p_startRow & p_endColumn + 1 == p_startColumn) || (p_endRow == p_startRow & p_endColumn + 1 == p_startColumn))
      {
         pass = true;
      }
      if(state.bCastleDownLeftMoved == false & state.bKingMoved == false & p_endRow == p_startRow & p_endColumn + 2 == p_startColumn)
      {
         if(castle.checkCastle(p_endRow, p_endColumn))
         {
            pass = true;
            castle.initCastle(p_endRow, p_endColumn);
         }
         else
         {
            pass = false;
         }
      }
      if(state.bCastleDownRightMoved == false & state.bKingMoved == false & p_endRow == p_startRow & p_endColumn - 2 == p_startColumn)
      {
         if(castle.checkCastle(p_endRow, p_endColumn))
         {
            pass = true;
            castle.initCastle(p_endRow, p_endColumn);
         }
         else
         {
            pass = false;
         }
      }
	}
   void wpawn(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
   {
      if(p_startRow == 1 && p_endColumn == p_startColumn)
      {
         if(p_startRow + 2 == p_endRow)
         {
            if(state.Board[2][p_endColumn] != "z")
            {
               pass = false;
            }
            else if(state.Board[2][p_endColumn] == "z" && state.Board[p_endRow][p_endColumn] == "z")
            {
               pass = true;
            }
         }
         else if(p_startRow + 1 == p_endRow && state.Board[p_endRow][p_endColumn] == "z")
         {
            pass = true;
         }
      }
      else if(p_startRow > 1 && p_startRow < 8 && p_endColumn == p_startColumn)
      {
         if(p_startRow + 1 == p_endRow)
         {
            if(state.Board[p_startRow + 1][p_endColumn] != "z")
            {
               pass = false;
            }
            else if(state.Board[p_startRow + 1][p_endColumn] == "z")
            {
               pass = true;
            }
         }
      }
      //down right pawn attack
      if(p_startRow + 1 == p_endRow && p_startColumn + 1 == p_endColumn)
      {
         if(state.Board[p_endRow][p_endColumn] != "z" && !state.Board[p_endRow][p_endColumn].startsWith("w"))
         {
            pass = true;
         }
         else
         {
            pass = false;
         }
      }
      //down left pawn attack
      else if(p_startRow + 1 == p_endRow && p_startColumn - 1 == p_endColumn && !state.Board[p_endRow][p_endColumn].startsWith("w"))
      {
         if(state.Board[p_endRow][p_endColumn] != "z")
         {
            pass = true;
         }
         else
         {
            pass = false;
         }
      }
      if(pass == true & p_endRow == 7 && p_startRow == 6)
      {
         if(!state.wDead.isEmpty())
         {
            for(int i = 0; i < state.wDead.size(); i++)
            {
               if(state.wDead.get(i) != "wp")
               {
                  System.out.println("Conversion turned on for w");
                  state.Convert = true;
                  state.cTurn = "w";
                  state.cRow = p_endRow;
                  state.cColumn = p_endColumn;
               }
               if(i == (state.wDead.size() - 1))
               {
                  if(state.wDead.get(i) == "wp")
                  {
                     state.cHold = true;
                     state.wcHold = true;
                     state.addwHold(p_endRow, p_endColumn);
                  }
               }
            }
         }
         else
         {
            state.cHold = true;
            state.wcHold = true;
            state.addwHold(p_endRow, p_endColumn);
         }
      }
   }
	void bpawn(int p_startRow, int p_startColumn, int p_endRow, int p_endColumn)
	{
      if(p_startRow == 6 && p_endColumn == p_startColumn)
      {
         if(p_startRow - 2 == p_endRow)
         {
            if(state.Board[5][p_endColumn] != "z")
            {
               pass = false;
            }
            else if(state.Board[5][p_endColumn] == "z" && state.Board[p_endRow][p_endColumn] == "z")
            {
               pass = true;
            }
         }
         else if(p_startRow - 1 == p_endRow && state.Board[p_endRow][p_endColumn] == "z")
         {
            pass = true;
         }
      }
      else if(p_startRow < 6 && p_startRow >= 0 && p_endColumn == p_startColumn)
      {
         if(p_startRow - 1 == p_endRow)
         {
            if(state.Board[p_startRow - 1][p_endColumn] != "z")
            {
               pass = false;
            }
            else if(state.Board[p_startRow - 1][p_endColumn] == "z")
            {
               pass = true;
            }
         }
      }
      //up right pawn attack
      if(p_startRow - 1 == p_endRow && p_startColumn + 1 == p_endColumn)
      {
         if(state.Board[p_endRow][p_endColumn] != "z" && state.Board[p_endRow][p_endColumn].startsWith("w"))
         {
            pass = true;
         }
         else
         {
            pass = false;
         }
      }
      // up left pawn attack
      else if(p_startRow - 1 == p_endRow && p_startColumn - 1 == p_endColumn)
      {
         if(state.Board[p_endRow][p_endColumn] != "z" && state.Board[p_endRow][p_endColumn].startsWith("w"))
         {
            pass = true;
         }
         else
         {
            pass = false;
         }
      }
      if(pass == true & p_endRow == 0 && p_startRow == 1)
      {
         if(!state.bDead.isEmpty())
         {
            for(int i = 0; i < state.bDead.size(); i++)
            {
               if(state.bDead.get(i) != "bp")
               {
                  System.out.println("Conversion turned on for b");
                  state.Convert = true;
                  state.cTurn = "b";
                  state.cRow = p_endRow;
                  state.cColumn = p_endColumn;
               }
               if(i == (state.bDead.size() - 1))
               {
                  if(state.bDead.get(i) == "bp")
                  {
                     state.cHold = true;
                     state.bcHold = true;
                     state.addbHold(p_endRow, p_endColumn);
                  }
               }
            }
         }
         else
         {
            state.cHold = true;
            state.bcHold = true;
            state.addbHold(p_endRow, p_endColumn);
         }
      }
	}
}