import java.util.*;

public class State
{
    public static ArrayList<String> wDead = new ArrayList<String>(); 
	  public static ArrayList<String> bDead = new ArrayList<String>();
	  public static ArrayList<inf>wAlive = new ArrayList<inf>();
	  public static ArrayList<inf>bAlive = new ArrayList<inf>();
    public static boolean wCastleUpLeftMoved = false;
    public static boolean wCastleUpRightMoved = false;
    public static boolean wKingMoved = false;
	  public static boolean bCastleDownLeftMoved = false;
    public static boolean bCastleDownRightMoved = false;
    public static boolean bKingMoved = false;
    public static boolean Convert = false;
    public static boolean cHold = false;
    public static boolean bcHold = false;
    public static boolean wcHold = false;
    public static boolean checkMate = false;
    public static boolean staleMate = false;

	  public static String Turn = "b";
	  public static String[][] Board = new String[8][8];
    
    public void updateState()
    {

    }
    public void newGame()
    {
        //
        // initialize with all blanks at first
        //
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Board[i][j] = "z";
            }
        }
        //
        // set white pieces
        //
        Board[0][0] = "wc";
        Board[0][1] = "wn";
        Board[0][2] = "wb";
        Board[0][3] = "wq";
        Board[0][4] = "wk";
        Board[0][5] = "wb";
        Board[0][6] = "wn";
        Board[0][7] = "wc";
        // for(int i = 0; i < 8; i++)
        // {
        //    Board[1][i] = "wp";
        // }
      
        //
        // set black pieces
        //
        // for(int i = 0; i < 8; i++)
        // {
        //    Board[6][i] = "bp";
        // }
        Board[7][0] = "bc";
        Board[7][1] = "bn";
        Board[7][2] = "bb";
        Board[7][3] = "bq";
        Board[7][4] = "bk";
        Board[7][5] = "bb";
        Board[7][6] = "bn";
        Board[7][7] = "bc";  
    }
   	private void updateAlive()
   	{
      	wAlive.clear();
      	bAlive.clear();
      	for(int i = 0; i < 8; i++)
      	{
         	  for(int j = 0; j < 8; j++)
         	  {
              	if(Board[i][j].startsWith("b"))
            	  {
              	  	bAlive.add(new inf(Board[i][j],i,j));
            	  }
           	    if(Board[i][j].startsWith("w"))
            	  {
                		wAlive.add(new inf(Board[i][j],i,j));
            	  }
           	}
      	}
   	}
	  class inf
	  {
		    int startRow = 0;
		    int startColumn = 0;
		    String type = "";
        inf(String p_type, int p_startRow, int p_startColumn)
        {
            startRow = p_startRow;
            startColumn = p_startColumn;
            type = p_type;
        }
	  }
}