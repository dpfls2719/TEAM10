package markdown;

public interface MDElement{

  public accept(MDElementVisitor visitor);
}
