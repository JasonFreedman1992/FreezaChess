import java.util.*;

public class Freeza
{
	String Team;
	Logic logic = new Logic();
	public Freeza(String p_team)
	{
		Team = p_team;
		logic.Team = p_team;
		logic.danger.Team = p_team;
	}
	public LinkedList<inf> guessPool = new LinkedList<inf>();
	State state = new State();
	int startRow;
	int startColumn;
	int endRow;
	int endColumn;
	String type;

	public void run()
	{
		//
		// while not state.Convert
		//
		if(!state.Convert)
		{
			if(!state.checkMate)
			{
				// initPool();
				initGuess();
			}
		}
		//
		// state.Convert
		//
		else
		{
			Conversion();
		}
	}

	// void initPool()
	// {
	// 	guessPool.clear();
	// 	if(Team == "w")
	// 	{
	// 		for(int i = 0; i < state.wAlive.size(); i++)
	// 		{
	// 			guessPool.add(new inf(state.wAlive.get(i).type, state.wAlive.get(i).startRow, state.wAlive.get(i).startColumn));
	// 		}
	// 	}
	// 	else if(Team == "b")
	// 	{
	// 		for(int i = 0; i < state.bAlive.size(); i++)
	// 		{
	// 			guessPool.add(new inf(state.bAlive.get(i).type, state.bAlive.get(i).startRow, state.bAlive.get(i).startColumn));
	// 		}
	// 	}
	// }
	void initGuess()
	{
		if(Team == "w")
		{
			Random r = new Random();
			int guess = r.nextInt(state.wAlive.size());
			int guess0 = r.nextInt(8);
			int guess1 = r.nextInt(8);
			type = state.wAlive.get(guess).type;
			startRow = state.wAlive.get(guess).startRow;
			startColumn = state.wAlive.get(guess).startColumn;
			endRow = guess0;
			endColumn = guess1;
			System.out.println("Freeza Guess: " + startRow + "," + startColumn + " " + endRow + "," + endColumn);
			if(logic.Evaluate(startRow, startColumn, endRow, endColumn, type))
			{
				if(!state.Convert)
				{
					state.changeTurn();
					state.legalCount++;
				}
				else
				{
					Conversion();
					state.changeTurn();
				}
			}
		}
		else if(Team == "b")
		{
			Random r = new Random();
			int guess = r.nextInt(state.bAlive.size());
			int guess0 = r.nextInt(8);
			int guess1 = r.nextInt(8);
			type = state.bAlive.get(guess).type;
			startRow = state.bAlive.get(guess).startRow;
			startColumn = state.bAlive.get(guess).startColumn;
			endRow = guess0;
			endColumn = guess1;
			System.out.println("Freeza Guess: " + startRow + "," + startColumn + " " + endRow + "," + endColumn);
			if(logic.Evaluate(startRow, startColumn, endRow, endColumn, type))
			{
				if(!state.Convert)
				{
					state.changeTurn();
					state.legalCount++;
				}
				else
				{
					Conversion();
					state.changeTurn();
				}
			}
		}
	}
	void Conversion()
	{
		Random r = new Random();
		int guess = r.nextInt(2);
		if(state.cTurn == "b")
		{
			if(guess == 0)
			{
				state.Board[state.cRow][state.cColumn] = "bn";
				state.bDead.add("bp");
			}
			else
			{
				state.Board[state.cRow][state.cColumn] = "bq";
				state.bDead.add("bp");
			}
		}
		else if(state.cTurn == "w")
		{
			if(guess == 0)
			{
				state.Board[state.cRow][state.cColumn] = "wn";
				state.wDead.add("wp");
			}
			else
			{
				state.Board[state.cRow][state.cColumn] = "wq";
				state.wDead.add("wp");
			}
		}
		state.Convert = false;
		state.legalCount++;
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