import java.awt.Color;

public class Game_ExitButton extends A_TextObject{

	protected int width; 
	protected int height;
	
	public Game_ExitButton(int x_, int y_) {
		super(x_, y_, Color.white);
		width = 65;
		height = 46; 
	}

	@Override
	public String toString() {
		return "QUIT";
	}
	public int type() {
		return A_Const.TYPE_QUITBUTTON; 
	}

}
