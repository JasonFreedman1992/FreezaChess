public class Castle
{
	State state = new State();
   	public boolean checkCastle(int p_endRow, int p_endColumn)
   	{
      	if(castlePath(p_endRow, p_endColumn))
      	{
         	if(castleDanger(p_endRow, p_endColumn) == false)
         	{
            	return true;
         	}
         	else
         	{
            	return false;
         	}
      	}
      	else
      	{
         	return false;
      	}
   	}
   //
   // initializes the castling move if all legalities are met.
   //
   public void initCastle(int p_endRow, int p_endColumn)
   {
      if(p_endRow == 7 && p_endColumn == 2)
      {
         state.Board[7][0] = "z";
         state.Board[7][3] = "bc";
         state.bCastleDownLeftMoved = true;
         state.bCastleDownRightMoved = true;
         state.bKingMoved = true;
      }
      else if(p_endRow == 7 && p_endColumn == 6)
      {
         state.Board[7][7] = "z";
         state.Board[7][5] = "bc";
         state.bCastleDownLeftMoved = true;
         state.bCastleDownRightMoved = true;
         state.bKingMoved = true;
      }
      else if(p_endRow == 0 && p_endColumn == 2)
      {
         state.Board[0][0] = "z";
         state.Board[0][3] = "wc";
         state.wCastleUpLeftMoved = true;
         state.wCastleUpRightMoved = true;
         state.wKingMoved = true;
      }
      else if(p_endRow == 0 && p_endColumn == 6)
      {
         state.Board[0][7] = "z";
         state.Board[0][5] = "wc";
         state.wCastleUpLeftMoved = true;
         state.wCastleUpRightMoved = true;
         state.wKingMoved = true;
      }
   }
   	//
   	// checks if any pieces in castling path
   	//
   	private boolean castlePath(int p_endRow, int p_endColumn)
   	{
   	   if(p_endRow == 7 && p_endColumn == 2)
   	   {
          	for(int i = 3; i > 0; i--)
        	   {
            	if(state.Board[7][i] != "z")
            	{
               	return false;
            	}
         	}
      	}
      	else if(p_endRow == 7 && p_endColumn == 6)
      	{
         	for(int i = 5; i < 7; i++)
         	{
            	if(state.Board[7][i] != "z")
            	{
               	return false;
            	}
         	}
      	}
      	else if(p_endRow == 0 && p_endColumn == 2)
      	{
         	for(int i = 3; i > 0; i--)
         	{
            	if(state.Board[0][i] != "z")
            	{
               	return false;
            	}
         	}
      	}
      	else if(p_endRow == 0 && p_endColumn == 6)
      	{
         	for(int i = 5; i < 7; i++)
         	{
            	if(state.Board[0][i] != "z")
            	{
               	return false;
            	}
         	}
      	}
      	return true;
   	}
   //
   // checks if king is castling through check or into check, cannot castle in check
   //
   private boolean castleDanger(int p_endRow, int p_endColumn)
   {
      Danger danger = new Danger();
      if(p_endRow == 7 && p_endColumn == 2)
      {
         for(int i = 4; i > 0; i--)
         {
            if(!danger.inDanger(7, i))
            {

            }
            else
            {
               return true;
            }
         }
      }
      else if(p_endRow == 7 && p_endColumn == 6)
      {
         for(int i = 4; i < 7; i++)
         {
            if(!danger.inDanger(7, i))
            {
               
            }
            else
            {
               return true;
            }
         }
      }
      else if(p_endRow == 0 && p_endColumn == 2)
      {
         for(int i = 4; i > 0; i--)
         {
            if(!danger.inDanger(0, i))
            {
            
            }
            else
            {
               return true;
            }
         }
      }
      else if(p_endRow == 0 && p_endColumn == 6)
      {
         for(int i = 4; i < 7; i++)
         {
            if(!danger.inDanger(0, i))
            {
            
            }
            else
            {
               return true;
            }
         }
      }
      return false;
   }
}