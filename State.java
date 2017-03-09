import java.util.*;
import javax.swing.JOptionPane;

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
    public static boolean kCanMove = false;
    String tempPieceStart;
    String tempPieceEnd;
    public void changeTurn()
    {
        if(Turn == "w")
        {
            Turn = "b";
            update();
        }
        else if(Turn == "b")
        {
            Turn = "w";
            update();
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
    //
    // checks for checkmate but also accounts for stalemates as well
    //
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
            System.out.println("State.updateCheckMate() line 105");
            kCanMove = true;
            checkMate = false;
        }
        else
        {
            System.out.println("state.updateCheckMate() line 111");
            kCanMove = false;
        }
        // if king is in check at this state
        if(danger.inDanger(kRow, kColumn))
        {
            // check danger up
            if(!kCanMove)
            {
                if(danger.checkUp)
                {
                    for(int i = kRow - 1; i >= danger.checkRow; i--)
                    {
                        if(danger.range(kRow - i, kColumn))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 129");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 135");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger down
                else if(danger.checkDown)
                {
                    for(int i = kRow + 1; i <= danger.checkRow; i++)
                    {
                        if(danger.range(kRow + i, kColumn))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 153");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 159");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger right
                else if(danger.checkRight)
                {
                    for(int i = kColumn + 1; i <= danger.checkColumn; i++)
                    {
                        if(danger.range(kRow, kColumn + i))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow, kColumn + i);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 177");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow, kColumn + i);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 183");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow, kColumn + i);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger left
                else if(danger.checkLeft)
                {
                    for(int i = kColumn - 1; i >= danger.checkColumn; i--)
                    {
                        if(danger.range(kRow, kColumn - i))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow, kColumn - i);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 201");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow, kColumn - i);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 207");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow, kColumn - i);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger upright
                else if(danger.checkUpRight)
                {
                    for(int i = 1; i <= kRow - danger.checkRow; i++)
                    {
                        if(danger.range(kRow - i, kColumn + i))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn + i);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 225");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn + i);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 231");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn + i);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger upleft
                else if(danger.checkUpLeft)
                {
                    for(int i = 1; i <= kRow - danger.checkRow; i++)
                    {
                        if(danger.range(kRow - i, kColumn - i))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn - i);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 249");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn - i);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 255");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow - i, kColumn - i);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger downleft
                else if(danger.checkDownLeft)
                {
                    for(int i = 1; i <= danger.checkRow - kRow; i++)
                    {
                        if(danger.range(kRow + i, kColumn - i))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn - i);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 273");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn - i);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 279");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn - i);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                // check danger downright
                else if(danger.checkDownRight)
                {
                    for(int i = 1; i <= danger.checkRow - kRow; i++)
                    {
                        if(danger.range(kRow + i, kColumn + i))
                        {
                            danger.moveTemp(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn + i);
                            if(danger.inDanger(kRow, kColumn))
                            {
                                System.out.println("state.updateCheckMate() line 297");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn + i);
                                checkMate = true;
                            }
                            else
                            {
                                System.out.println("state.updateCheckMate() line 302");
                                danger.moveBack(danger.rangeRow, danger.rangeColumn, kRow + i, kColumn + i);
                                checkMate = false;
                            }
                        }
                    }
                    checkMate = true;
                }
                else if(danger.checkKnight)
                {
                    if(danger.range(danger.checkRow, danger.checkColumn))
                    {
                        danger.moveTemp(danger.rangeRow, danger.rangeColumn, danger.checkRow, danger.checkColumn);
                        if(danger.inDanger(kRow, kColumn))
                        {
                            System.out.println("state.updateCheckMate() line 318");
                            danger.moveBack(danger.rangeRow, danger.rangeColumn, danger.checkRow, danger.checkColumn);
                            checkMate = true;
                        }
                        else
                        {
                            System.out.println("state.updateCheckMate() line 324");
                            danger.moveBack(danger.rangeRow, danger.rangeColumn, danger.checkRow, danger.checkColumn);
                            checkMate = false;
                        }
                    }
                }
                else if(danger.checkPawn)
                {
                    if(danger.range(danger.checkRow, danger.checkColumn))
                    {
                        danger.moveTemp(danger.rangeRow, danger.rangeColumn, danger.checkRow, danger.checkColumn);
                        if(danger.inDanger(kRow, kColumn))
                        {
                            System.out.println("state.updateCheckMate() line 337");
                            danger.moveBack(danger.rangeRow, danger.rangeColumn, danger.checkRow, danger.checkColumn);
                            checkMate = true;
                        }
                        else
                        {
                            System.out.println("state.updateCheckMate() line 343");
                            danger.moveBack(danger.rangeRow, danger.rangeColumn, danger.checkRow, danger.checkColumn);
                            checkMate = false;
                        }
                    }
                }
            }
            else
            {
                System.out.println("state.updateCheckMate() line 352");
                checkMate = false;
            }
        }
        // if king is not in check at this state
        else
        {
            // if king can move checkmate false;
            if(kCanMove)
            {
                System.out.println("state.updateCheckMate() line 362");
                checkMate = false;
            }
            else
            {
                if(anyCanMove())
                {
                    System.out.println("state.updateCheckMate() line 369");
                    checkMate = false;
                }
                else
                {
                    System.out.println("state.updateCheckMate() line 374");
                    checkMate = true;
                }
            }
        }
        updateMessage();
    }
    boolean anyCanMove()
    {
        Danger danger = new Danger();
        if(Turn == "w")
        {
            for(int i = 0; i < wAlive.size(); i++)
            {
                if(wAlive.get(i).type != "wk")
                {
                    if(danger.canMove(wAlive.get(i).startRow, wAlive.get(i).startColumn, wAlive.get(i).type))
                    {
                        System.out.println("state.anycanMove() line 392");
                        return true;
                    }
                    else
                    {

                    }
                }
                if(i == wAlive.size() - 1)
                {
                   System.out.println("state.anycanMove() line 402");
                   return false;
                }
            }
        }
        else
        {
            for(int i = 0; i < bAlive.size(); i++)
            {
                if(bAlive.get(i).type != "bk")
                {
                    if(danger.canMove(bAlive.get(i).startRow, bAlive.get(i).startColumn, bAlive.get(i).type))
                    {
                        System.out.println("state.anycanMove() line 415");
                        return true;
                    }
                    else
                    {

                    }
                }
                if(i == bAlive.size() - 1)
                {
                    System.out.println("state.anycanMove() line 425");
                    return false;
                }
            }
        }
        return false;
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
    }
    void updateMessage()
    {
        if(checkMate)
        {
            JOptionPane.showMessageDialog(null, "CheckMate, game is over.");
        }
        else
        {

        }
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