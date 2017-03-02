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
    public static boolean checkMate = false;
    public static boolean staleMate = false;
    public static boolean kill = false;
	public static String Turn = "b";
    public static String cTurn = "";
    public static int cRow = 0;
    public static int cColumn = 0;
	public static String[][] Board = new String[8][8];
    public void changeTurn()
    {
        if(Turn == "w")
        {
            Turn = "b";
        }
        else if(Turn == "b")
        {
            Turn = "w";
        }
    }
    public void update()
    {
        updateAlive();
        if(!wKingMoved && Board[0][4] != "wk")
        {
            wKingMoved = true;
            wCastleUpRightMoved = true;
            wCastleUpLeftMoved = true;
        }
        if(!wCastleUpLeftMoved && Board[0][0] != "wc")
        {
            wCastleUpLeftMoved = true;
        }
        if(!wCastleUpRightMoved && Board[0][7] != "wc")
        {
            wCastleUpRightMoved = true;
        }
        if(!bKingMoved && Board[7][4] != "bk")
        {
            bKingMoved = true;
            bCastleDownRightMoved = true;
            bCastleDownLeftMoved = true;
        }
        if(!bCastleDownLeftMoved && Board[7][0] != "bc")
        {
            bCastleDownLeftMoved = true;
        }
        if(!bCastleDownRightMoved && Board[7][7] != "bc")
        {
            bCastleDownRightMoved = true;
        }
        updateCheckMate();
    }
    void updateCheckMate()
    {
        int kRow = 0;
        int kColumn = 0;
        Danger danger = new Danger();
        if(Turn == "w")
        {
            for(int i = 0; i < wAlive.size(); i++)
            {
                if(wAlive.get(i).type == "wk")
                {
                    kRow = wAlive.get(i).startRow;
                    kColumn = wAlive.get(i).startColumn;
                }
            }
        }
        else if(Turn == "b")
        {
            for(int i = 0; i < bAlive.size(); i++)
            {
                if(bAlive.get(i).type == "bk")
                {
                    kRow = bAlive.get(i).startRow;
                    kColumn = bAlive.get(i).startColumn;
                }
            }
        }
        // if king can move away, out of check
        if(danger.checkRunAway(kRow, kColumn))
        {
            checkMate = false;
        }
        // if king cant move away, out of check
        else
        {
            // if king is in check at this state
            if(danger.inDanger(kRow, kColumn))
            {
                
            }
            // if king is not in check at this state
            else
            {

            }
        }
    }
    public void newGame()
    {
        Turn = "b";
        wCastleUpLeftMoved = false;
        wCastleUpRightMoved = false;
        wKingMoved = false;
        bCastleDownLeftMoved = false;
        bCastleDownRightMoved = false;
        bKingMoved = false;
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
        for(int i = 0; i < 8; i++)
        {
           Board[1][i] = "wp";
        }
      
        //set black pieces
        for(int i = 0; i < 8; i++)
        {
           Board[6][i] = "bp";
        }
        Board[7][0] = "bc";
        Board[7][1] = "bn";
        Board[7][2] = "bb";
        Board[7][3] = "bq";
        Board[7][4] = "bk";
        Board[7][5] = "bb";
        Board[7][6] = "bn";
        Board[7][7] = "bc";  
        update();
    }
   	void updateAlive()
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