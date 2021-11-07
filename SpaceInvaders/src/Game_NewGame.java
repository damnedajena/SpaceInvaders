import java.awt.Color;

public class Game_NewGame extends A_TextObject{
	protected int width; 
	protected int height; 

	public Game_NewGame(int x_, int y_) {
		super(x_, y_, Color.white);
		height = 46; 
		width = 150; 
	}

	@Override
	public String toString() {
		return "Start";
	}
	public int type() {
		return A_Const.TYPE_PLAYBUTTON; 
	}

}
