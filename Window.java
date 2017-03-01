import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Window extends JFrame
{
	JLabel[][] spots = new JLabel[8][8];
	JLabel bar = new JLabel();
	JLabel[] bdead = new JLabel[15];
	JLabel[] wdead = new JLabel[15];
	// white images pre-loaded
	ImageIcon wc = new ImageIcon("wc.jpg");
    ImageIcon wn = new ImageIcon("wn.jpg");
    ImageIcon wb = new ImageIcon("wb.jpg");
    ImageIcon wq = new ImageIcon("wq.jpg");
    ImageIcon wk = new ImageIcon("wk.jpg");
    ImageIcon wp = new ImageIcon("wp.jpg");
    // black images pre-loaded
    ImageIcon bc = new ImageIcon("bc.jpg");
    ImageIcon bn = new ImageIcon("bn.jpg");
    ImageIcon bb = new ImageIcon("bb.jpg");
    ImageIcon bq = new ImageIcon("bq.jpg");
    ImageIcon bk = new ImageIcon("bk.jpg");
    ImageIcon bp = new ImageIcon("bp.jpg");

    State state = new State();
    Player WPlayer = new Player("w");
    Player BPlayer = new Player("b");
    int column;
    int row;
    String type;
    //
    // listen class for board
    //
    class listen extends MouseAdapter
    {
        int i;
        int j;
        public listen(int p_i, int p_j)
        {
            i = p_i;
            j = p_j;
        }
        public void mouseClicked(MouseEvent e)
        {
        	if(!state.Convert)
        	{
        		row = i;
        		column = j;
        		type = state.Board[i][j];
        		if(state.Turn == "w")
        		{
        			WPlayer.run(row, column, type);
        			System.out.println(WPlayer.logic.moves.pass);
        		}
        		else
        		{
        			BPlayer.run(row, column, type);
        			System.out.println(BPlayer.logic.moves.pass);
        		}
            	System.out.println("spot: " + row + " , " + column);
        	}
        }
    }
    //
    // listen class for dead pieces (dlisten)
    //
    class dlisten extends MouseAdapter
    {
        int i;
        String type = "";
        public dlisten(int p_i)
        {
            i = p_i;
        }
        public void mouseClicked(MouseEvent e)
        {
      		System.out.println("dead spot: " + i);
      		if(state.Convert)
      		{

      		}
      		else
      		{

      		}
      	}
   	}
    public void init(int p_width, int p_height)
    {
        setTitle("Freeza Chess");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        initBar();
        initBarDead();
        initBoard();
        initListeners();
        state.newGame();
        Render();
    }
    //
    // initialize bar
    //
    void initBar()
    {
        add(bar);
        bar.setSize(800, 150);
        bar.setLocation(100, 930);
        bar.setOpaque(true);
        bar.setBackground(Color.black);
    } 
    //
    // initialize dead bars for b and w
    //
    void initBarDead()
    {
        for(int i = 0; i < 15; i++)
        {
       		wdead[i] = new JLabel();
        	wdead[i].setBackground(Color.darkGray);
        	wdead[i].setOpaque(true);
        	add(wdead[i]);
        	wdead[i].setSize(100,100);
	        if(i < 8)
	        {
	           wdead[i].setLocation(1000, (i+1) * 125 - 50);
	        }
	        else
	        {
	           wdead[i].setLocation(1125, (i+1 - 7) * 125 - 175);
	        }
     	}
     	for(int i = 0; i < 15; i++)
      	{
         	bdead[i] = new JLabel();
         	bdead[i].setBackground(Color.darkGray);
         	bdead[i].setOpaque(true);
        	add(bdead[i]);
        	bdead[i].setSize(100,100);
        	if(i < 8)
         	{
          	    bdead[i].setLocation(1250, (i+1) * 125 - 50);
        	}
        	else
        	{
            	bdead[i].setLocation(1375, (i+1 - 7) * 125 - 175);
        	}
      	}
   	}
    //
    // initialize board
    //
    void initBoard()
    {
       for(int i = 0; i < 8; i++)
       {
         	for(int j = 0; j < 8; j++)
         	{
            	spots[i][j] = new JLabel();
            	add(spots[i][j]);
            	spots[i][j].setSize(100,100);
            	spots[i][j].setLocation((j+1) * 100, (i+1)  * 100);
            	spots[i][j].setOpaque(true);
	            if((i+j) % 2 == 0)
	            {
	               spots[i][j].setBackground(Color.white); // black board spots
	            }
	            else
	            {
	               spots[i][j].setBackground(Color.black); // black board spots
	            }
	        }
	    }
   	}
    void initListeners()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
            	spots[i][j].addMouseListener(new listen(i, j));
         	}
      	}
        for(int i = 0; i < 15; i++)
        {
        	wdead[i].addMouseListener(new dlisten(i));
        	bdead[i].addMouseListener(new dlisten(i));
        }
    }
	//
    // render total board
    //
    public void Render()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
	            switch(state.Board[i][j])
	            {
	               	case "wc":
	                  	spots[i][j].setIcon(wc);
	                  	break;
	              	case "wn":
	             	    spots[i][j].setIcon(wn);
	                	break;
		            case "wb":
		                spots[i][j].setIcon(wb);
	    	            break;
	                case "wk":
	                  	spots[i][j].setIcon(wk);
	                  	break;
	               	case "wq":
	                  	spots[i][j].setIcon(wq);
	                  	break;
	               	case "wp":
	                  	spots[i][j].setIcon(wp);
	                  	break;
	              	case "bc":
	                  	spots[i][j].setIcon(bc);
	                  	break;
	               	case "bn":
	                  	spots[i][j].setIcon(bn);
	                  	break;
	               	case "bb":
	                  	spots[i][j].setIcon(bb);
	                  	break;
	               	case "bq":
	                  	spots[i][j].setIcon(bq);
	                  	break;
	               	case "bk":
	                  	spots[i][j].setIcon(bk);
	                  	break;
	               	case "bp":
	                  	spots[i][j].setIcon(bp);
	                  	break;
	               	case "z":
	                  	spots[i][j].setIcon(null);
	                  	break;
	            }
	        }
        } 
        //
        // render bar
        //
      	switch(state.Turn)
      	{
         	case "b":
            	bar.setBackground(Color.black);
            	break;
         	case "w":
            	bar.setBackground(Color.white);
            	break;
      	}
   	}
}