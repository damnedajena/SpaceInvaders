import java.awt.Color;

public class Game_Aliens extends A_GameObject{
	protected int state;

	public Game_Aliens(double x_, double y_, int s) {
		super(x_, y_, 0, A_Const.AlienSpeed, A_Const.AlienRadius, Color.white);
		isMoving = false;
		state = s;
	}
//	@Override
//	public void move(double diffSeconds) {
//		 //move one step
//		x += Math.cos(alfa)*speed*diffSeconds;		    
//		if( x <= 5 ) {
//			alfa = 0;
//			A_Const.row_y = ;
//		} else if( x >= A_Const.WORLD_WIDTH - 2*radius +5 ) {
//			alfa = Math.PI;
//			row_y+=50;
//		}
//		reflectOnBorders();
//	}

	protected Game_Bullet shoot() {
		double a,x,y;
		switch (state) {
		case 0: a = -Math.PI/2; x = this.x; y=this.y-this.radius; break; 
		case 1: a = Math.PI; x = this.x; y=this.y;  break;
		case 2: a = Math.PI/2; x = this.x; y=this.y+this.radius +5;  break;
		case 3: a = 0; x = this.x; y=this.y; break;
		default: a = -Math.PI/2; x = this.x; y=this.y; break;
		}
		return (new Game_Bullet( x, y, a, Color.white));
	}
	
	@Override
	int type() {
		return A_Const.TYPE_ALIEN;
	}

}
