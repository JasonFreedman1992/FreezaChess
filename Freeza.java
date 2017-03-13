import java.util.*;

public class Freeza
{
	String Team;
	Logic logic = new Logic();
	State state = new State();
	ArrayList<infPossible> possibleMoves = new ArrayList<infPossible>();
	public Freeza(String p_team)
	{
		Team = p_team;
		logic.Team = p_team;
		logic.danger.Team = p_team;
	}

	public inf getPiece(int p_i)
	{
		if(Team == "w")
		{
			return state.wAlive.get(p_i);
		}
		else
		{
			return state.bAlive.get(p_i); 
		}
	}

	public void run()
	{
		if(Team == "w")
		{
			for(int i = 0; i < wAlive.size(); i++)
			{
				possibleMoves.
			}
		}
		else
		{

		}
	}
}