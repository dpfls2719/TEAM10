package Structure;

public class List extends Structure{
	private int linesAdded=0; 
	private Boolean isSublist;
	private String nextLine;
	private static Boolean isOrdered;

	public List(Boolean isOrdered, String nextLine, Boolean isSublist) {
		this.isOrdered = isOrdered;
		this.isSublist = isSublist;
		this.nextLine= nextLine;
	}

	public int getLinesAdded()
	{
		return linesAdded;
	}
	
	public String getNextLine()
	{
		return nextLine;
	}
	
	public Boolean getIsSublist()
	{
		return isSublist;
	}
	
	public void setIsOrdered(Boolean isOrdered)
	{
		this.isOrdered = isOrdered; 
	}
	
	public Boolean getIsOrdered()
	{
		return isOrdered;
	}

	public String createText()
	{
		/*Structure pointer=this.getPrevStructure();
		while(pointer instanceof List)
		{
			this.setLine(this.getLine()+"\n"+pointer.getLine());
			pointer=pointer.getNextStructure();
			linesAdded++;
		}
		System.out.println(linesAdded);*/
		translated = toText.translate(this);
		return translated;
	}
}
