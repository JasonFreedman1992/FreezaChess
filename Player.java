public class Player
{
	String Team;
	Logic logic = new Logic();
	public Player(String p_team)
	{
		Team = p_team;
		logic.Team = p_team;
		logic.danger.Team = p_team;
	}
	State state = new State();
	int clickCount;
	int startRow;
	int startColumn;
	int endRow;
	int endColumn;
	String type;
	public void run(int p_row, int p_column, String p_type)
	{
		if(!state.checkMate)
		{
			if(clickCount == 0)
			{
				if(sameType(p_type))
				{
					startRow = p_row;
					startColumn = p_column;
					type = p_type;
					clickCount++;
				}
				else
				{
					clickCount = 0;
				}
			}
			else if(clickCount == 1)
			{
				endRow = p_row;
				endColumn = p_column;
				if(logic.Evaluate(startRow, startColumn, endRow, endColumn, type))
				{
					if(!state.Convert)
					{
						state.changeTurn();
					}
				}
				clickCount = 0;
			}
		}
	}

	boolean sameType(String p_type)
	{
		if(p_type.startsWith(Team))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}