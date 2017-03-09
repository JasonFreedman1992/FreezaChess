import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Window extends JFrame
{
	JLabel[][] spots = new JLabel[8][8];
	JLabel bar = new JLabel();
	JLabel[] bdead = new JLabel[23];
	JLabel[] wdead = new JLabel[23];
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
    Freeza WFreeza = new Freeza("w");
    Freeza BFreeza = new Freeza("b");
    public JButton initGame = new JButton("New Game");
    public JButton initFreeza = new JButton("Start Freeza");
    public JButton initQueen = new JButton("Queen");
    public JButton initKnight = new JButton("Knight");
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
            System.out.println("spot: " + row + " , " + column);
        	if(!state.Convert)
        	{
        		row = i;
        		column = j;
        		type = state.Board[i][j];
        		if(state.Turn == "w")
        		{
                    System.out.println("state turn = w");
        			WPlayer.run(row, column, type);
        		}
        		else
        		{
                    System.out.println("state turn = b");
        			BPlayer.run(row, column, type);
        		}
                Render();
                RenderDead();
        	}
        }
    }
    void initFreezaButton()
    {
        initFreeza.setSize(125, 40);
        initFreeza.setLocation(125, 30);
        initFreeza.setText("Start Freeza");
        initFreeza.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {  

            }
        });
        add(initFreeza);
        initFreeza.setVisible(true);
    }
    void initGameButton()
    {
        initGame.setSize(125, 40);
        initGame.setLocation(275, 30);
        initGame.setText("New Game");
        initGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                state.newGame();
                Render();
                RenderDead();
            }
        });
        add(initGame);
        initGame.setVisible(true);
    }
    void initKnightButton()
    {
        initKnight.setSize(125, 40);
        initKnight.setLocation(425, 30);
        initKnight.setText("Knight");
        initKnight.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(state.Convert)
                {
                    if(state.cTurn == "b")
                    {
                        state.Board[state.cRow][state.cColumn] = "bn";
                        state.bDead.add("bp");
                    }
                    else if(state.cTurn == "w")
                    {
                        state.Board[state.cRow][state.cColumn] = "wn";
                        state.wDead.add("wp");
                    }
                    state.Convert = false;
                    state.changeTurn();
                    Render();
                    RenderDead();
                    state.update();
                }

            }
        });
        add(initKnight);
        initKnight.setVisible(true);
    }
    void initQueenButton()
    {
        initQueen.setSize(125, 40);
        initQueen.setLocation(575, 30);
        initQueen.setText("Queen");
        initQueen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(state.Convert)
                {
                    if(state.cTurn == "b")
                    {
                        state.Board[state.cRow][state.cColumn] = "bq";
                        state.bDead.add("bp");
                    }
                    else if(state.cTurn == "w")
                    {
                        state.Board[state.cRow][state.cColumn] = "wq";
                        state.wDead.add("wp");
                    }
                    state.Convert = false;
                    state.changeTurn();
                    Render();
                    RenderDead();
                    state.update();
                }
            }
        });
        add(initQueen);
        initQueen.setVisible(true);
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
        initFreezaButton();
        initGameButton();
        initKnightButton();
        initListeners();
        initQueenButton();
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
        for(int i = 0; i < 23; i++)
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
	        else if(i > 7 && i < 16)
	        {
	           wdead[i].setLocation(1125, (i+1 - 7) * 125 - 175);
	        }
            else if(i > 15 && i < 23)
            {
               wdead[i].setLocation(1250, (i+1 - 15) * 125 - 175);
            }
     	}
     	for(int i = 0; i < 23; i++)
      	{
         	bdead[i] = new JLabel();
         	bdead[i].setBackground(Color.darkGray);
         	bdead[i].setOpaque(true);
        	add(bdead[i]);
        	bdead[i].setSize(100,100);
        	if(i < 8)
         	{
          	    bdead[i].setLocation(1375, (i+1) * 125 - 50);
        	}
        	else if(i > 7 && i < 16)
        	{
            	bdead[i].setLocation(1500, (i+1 - 7) * 125 - 175);
        	}
            else if(i > 15 && i < 23)
            {
                bdead[i].setLocation(1625, (i+1 - 15) * 125 - 175);
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
    private void RenderDead()
    {
        if(!state.wDead.isEmpty())
        {
            for(int i = 0; i < state.wDead.size(); i++)
            {
                switch(state.wDead.get(i))
                {
                case "wc":
                    wdead[i].setIcon(wc);
                    wdead[i].setText("wc");
                    break;
                case "wn":
                    wdead[i].setIcon(wn);
                    wdead[i].setText("wn");
                    break;
                case "wb":
                    wdead[i].setIcon(wb);
                    wdead[i].setText("wb");
                    break;
                case "wq":
                    wdead[i].setIcon(wq);
                    wdead[i].setText("wq");
                    break;
                case "wp":
                    wdead[i].setIcon(wp);
                    wdead[i].setText("wp");
                    break;
                }
            }
            for(int i = state.wDead.size(); i < 23; i++)
            {
                wdead[i].setIcon(null);
                wdead[i].setText("");         
            }
        }
        else
        {
            for(int i = state.wDead.size(); i < 23; i++)
            {
                wdead[i].setIcon(null);
                wdead[i].setText("");         
            }
        }
        if(!state.bDead.isEmpty())
        {
            for(int i = 0; i < state.bDead.size(); i++)
            {
                switch(state.bDead.get(i))
                {
                case "bc":
                    bdead[i].setIcon(bc);
                    bdead[i].setText("bc");
                    break;
                case "bn":
                    bdead[i].setIcon(bn);
                    bdead[i].setText("bn");
                    break;
                case "bb":
                    bdead[i].setIcon(bb);
                    bdead[i].setText("bb");
                    break;
                case "bq":
                    bdead[i].setIcon(bq);
                    bdead[i].setText("bq");
                    break;
                case "bp":
                    bdead[i].setIcon(bp);
                    bdead[i].setText("bp");
                    break;
                }
            }
            for(int i = state.bDead.size(); i < 23; i++)
            {
                bdead[i].setIcon(null);
                bdead[i].setText("");         
            }
        }
        else
        {
            for(int i = state.bDead.size(); i < 23; i++)
            {
                bdead[i].setIcon(null);
                bdead[i].setText("");         
            }
        }
    } 
}