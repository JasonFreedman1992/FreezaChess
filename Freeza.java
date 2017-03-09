public class Freeza
{
	String Team;
	Logic logic = new Logic();
	public Freeza(String p_Team)
	{
		Team = p_Team;
		logic.Team = p_Team;
		logic.danger.Team = p_Team;
	}
	State state = new State();
	String type;

	public void run()
	{
		//
		// while not state.Convert
		//
		if(!state.Convert)
		{
			
		}
		//
		// state.Convert
		//
		else
		{
			
		}
	}

	void initPool()
	{

	}
	void initGuess()
	{
		
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