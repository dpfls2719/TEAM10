package Structure;

public class Horizontal extends Structure{
// private Text span;
// private Header header;
  private static Boolean isAtx=false;
  private static int horizontalSize;

	public Horizontal()
	{
	}

	public static void setAtx(){
	  if(getLine().charAt(0)=='<')
	  {
		  isAtx=true;
	  }
  }

  public static void setHorizontalSize(int size)
  {
  	horizontalSize = size;
  }
  public static int getHorizontalSize()
  {
    return horizontalSize;
  }
  public String createText()
  {
	setAtx();
	toText.setAtx(isAtx);
	translated = toText.translate(this);
	return translated;
  }

}
