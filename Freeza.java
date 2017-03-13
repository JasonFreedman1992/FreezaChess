import java.util.*;

public class Freeza
{
	String Team;
	Logic logic = new Logic();
	State state = new State();
	LinkedList<infPossible> possibleMoves = new LinkedList<infPossible>();
	public Freeza(String p_team)
	{
		Team = p_team;
		logic.Team = p_team;
		logic.danger.Team = p_team;
	}

	public void run()
	{
		if(Team == "w")
		{
			for(int i = 0; i < state.wAlive.size(); i++)
			{
				int startRow = state.wAlive.get(i).startRow;
				int startColumn = state.wAlive.get(i).startColumn;
				Gen gen = new Gen(state.wAlive.get(i));
				int endRow = gen.endRow;
				int endColumn = gen.endColumn;
				possibleMoves.add(new infPossible(startRow, startColumn, endRow, endColumn));
			}
		}
		else
		{

		}
	}
}