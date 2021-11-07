import java.awt.Color;

public class Game_Avatar extends A_GameObject {
	protected int state = 0;
	protected int score = 0;

	public Game_Avatar(double x_, double y_ ) {
		super(x_, y_, 0, A_Const.AvatarSpeed, A_Const.AvatarRadius, Color.green);
		isMoving = false;		
	}

	@Override
	public void move(double diffSeconds) {
		if(!isMoving) return;	  
		// move one step
		if(state ==0 || state ==2) {
			x += Math.cos(alfa)*speed*diffSeconds;		    
			if( x <= 5 ) {
				isMoving = false; 
			} else if( x >= A_Const.WORLD_WIDTH - 2*radius ) isMoving = false;
		}else {
			y += Math.sin(alfa)*speed*diffSeconds;		    
			if( y <= 5 ) {
				isMoving = false; 
			} else if( y >= A_Const.WORLD_HEIGHT - 2*radius ) isMoving = false;
		}
		
	}

	@Override
	int type() {
		return A_Const.TYPE_AVATAR;
	}

}
