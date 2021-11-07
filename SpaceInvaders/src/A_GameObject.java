import java.awt.Color;

abstract class A_GameObject 
{

  protected double  x,y;
  protected double  alfa  = 0;
  protected double  speed = 0;
  protected int     radius = 7;                              
  protected Color   color;
  
  // if the object is existing, moving etc
  protected boolean isLiving = true;
  protected boolean isMoving = true;  
      
  // GameObjects sometimes call physics methods
  protected static A_World         world;
  
  
  // construct GameObject
  public A_GameObject(double x_, double y_, 
		              double a_, double s_, 
		              int r_, Color color_)
  { 
	x=x_;    y=y_; 
    alfa=a_; speed=s_;
    radius = r_;
    color = color_;
  }
  
  
  // move one step to direction <alfa>
  public void move(double diffSeconds)
  {  
    if(!isMoving) return;	  
	  
	// move one step
    x += Math.cos(alfa)*speed*diffSeconds;
    y += Math.sin(alfa)*speed*diffSeconds;   	  
  }
  
  abstract int type();
  static void setWorld(A_World w) {world=w;}
  
}
