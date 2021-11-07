import java.awt.Color;

public class Game_Lives extends A_TextObject{

	public Game_Lives(int x_, int y_) {
		super(x_, y_, Color.white);
	}

	@Override
	public String toString() {
		return "";
	}
	public int type() {
		return A_Const.TYPE_LIVES; 
	}
}