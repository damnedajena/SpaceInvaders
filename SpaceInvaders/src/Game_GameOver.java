import java.awt.Color;

public class Game_GameOver extends A_TextObject {

	public Game_GameOver(int x_, int y_) {
		super(x_, y_, Color.white);
	}

	@Override
	public String toString() {
		return "GAME OVER";
	}

	@Override
	protected int type() {
		return A_Const.TYPE_GAMEOVER; 
	}

}


