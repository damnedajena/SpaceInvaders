import java.awt.Color;

public class Game_SpaceInvaders extends A_TextObject{

	public Game_SpaceInvaders(int x_, int y_) {
		super(x_, y_, Color.red);
	}

	@Override
	public String toString() {
		String s =  "  Space\n" +
				"Invaders";
		return s;
	}
	public int type() {
		return A_Const.TYPE_SPACEINVADERS; 
	}

}
