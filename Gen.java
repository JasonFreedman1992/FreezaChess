public class Gen
{
	State state = new State();
	String Team;
	String OTeam;
	public int endRow;
	public int endColumn;
	void setOTeam()
   	{
      	if(state.Turn.equals("w"))
      	{
         	OTeam = "b";
      	}
      	else if(state.Turn.equals("b"))
      	{
         	OTeam = "w";
      	}
      	Team = state.Turn;
	}
	public Gen(inf p_inf)
	{
      	switch(p_inf.type)
      	{
         	case "wc":
            	castle(p_inf.startRow, p_inf.startColumn);
            	break;
        	   case "wn":
            	knight(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "wb":
            	bishop(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "wq":
            	queen(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "wk":
            	wking(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "wp":
            	wpawn(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "bc":
            	castle(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "bn":
            	knight(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "bb":
            	bishop(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "bq":
            	queen(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "bk":
            	bking(p_inf.startRow, p_inf.startColumn);
            	break;
         	case "bp":
            	bpawn(p_inf.startRow, p_inf.startColumn);
            	break;
      	}
	}
	void castle(int p_startRow, int p_startColumn)
	{
		for(int i = 0; i < 8; i++)
		{
			
		}
	}
	void knight(int p_startRow, int p_startColumn)
	{

	}
	void bishop(int p_startRow, int p_startColumn)
	{

	}
	void queen(int p_startRow, int p_startColumn)
	{

	}
	void wpawn(int p_startRow, int p_startColumn)
	{

	}
	void wking(int p_startRow, int p_startColumn)
	{

	}
	void bpawn(int p_startRow, int p_startColumn)
	{

	}
	void bking(int p_startRow, int p_startColumn)
	{

	}
}