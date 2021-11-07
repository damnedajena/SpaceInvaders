import java.awt.Color;

public class Game_Bullet extends A_GameObject {

	public Game_Bullet(double x_, double y_, double a_, Color c_) {
		super(x_, y_, a_, A_Const.BulletSpeed, A_Const.BulletRadius, c_);
	}

	@Override
	public void move(double diffSeconds) {
		// move one step
		x += Math.cos(alfa)*speed*diffSeconds;
		y += Math.sin(alfa)*speed*diffSeconds;		   
		if( y <-5 || y > 650) isLiving = false;

		A_GameObjectList collide = world.getPhysicsSystem().getCollisions(this);

		for(int i=0; i<collide.size(); i++)
		{ 
			if( collide.get(i).type() == A_Const.TYPE_ALIEN ) {
				collide.get(i).isLiving=false;
				this.isLiving = false;
				((Game_Avatar) world.avatar).score += 50;
			}else{
				A_Const.AVATAR_LIFE--; 
				this.isLiving = false;
				if( A_Const.AVATAR_LIFE <= 0 ) {
					isLiving= false; 
					((Game_World) world).menu = true;
					world.gameOver = true; 
				}
			}
		}
	}

	@Override
	int type() {
		return A_Const.TYPE_BULLET;
	}

}
