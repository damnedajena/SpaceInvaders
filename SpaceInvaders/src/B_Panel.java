import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.*;

class B_Panel extends JPanel implements A_GraphicSystem
{
	// constants
	private static final long serialVersionUID = 1L;


	// InputSystem is an external instance
	private B_InputSystem inputSystem = new B_InputSystem();
	private A_World       world       = null;
	private BufferedImage image = null;

	// GraphicsSystem variables
	//
	private GraphicsConfiguration graphicsConf = 
			GraphicsEnvironment.getLocalGraphicsEnvironment().
			getDefaultScreenDevice().getDefaultConfiguration();
	private BufferedImage imageBuffer;
	private Graphics      graphics;



	public B_Panel()
	{ 
		this.setSize(A_Const.WORLD_WIDTH,A_Const.WORLD_HEIGHT);  
		imageBuffer = graphicsConf.createCompatibleImage(
				this.getWidth(), this.getHeight());	 
		graphics = imageBuffer.getGraphics();

		// initialize Listeners
		this.addMouseListener(inputSystem);
		this.addMouseMotionListener(inputSystem);
		this.addKeyListener(inputSystem);

	}

	public void clear() {
		if(((Game_World) world).menu && !world.gameOver) { 
			String path = Paths.get("resource/menu__background.jpg").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, 0,0,null);
		}else if ( world.gameOver) {
			String path = Paths.get("resource/gameOverBackground.jpg").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, 0,0,null);
			graphics.setColor(Color.black);
			graphics.setFont( new Font( "Arial", Font.BOLD, 24));
			graphics.drawString("Score: " + 
					Integer.toString(((Game_Avatar) world.avatar).score), 100, 550);

		}else {
			graphics.setColor(Color.black);
			graphics.fillRect(
					0, 0,A_Const.WORLD_WIDTH,A_Const.WORLD_HEIGHT);
			graphics.setColor(Color.white);
			graphics.setFont( new Font( "Arial", Font.BOLD, 24));
			graphics.drawString("Score: " + 
					Integer.toString(((Game_Avatar) world.avatar).score), 280, 30);
		}
	}


	public final void draw(A_GameObject obj)
	{	  
		if(!((Game_World) world).menu) {
			if( obj.type() == A_Const.TYPE_AVATAR ) {
				int x = (int)(obj.x- obj.radius);
				int y = (int)(obj.y- obj.radius);
				String pp; 
				Game_Avatar a = (Game_Avatar) obj;
				if(a.state == 0) { 
					pp="9"; 
				}else if (a.state == 1) {
					pp = "11";
				} else if(a.state == 2) {
					pp = "10";
				}else  {
					pp = "12"; 
				}
				String path = Paths.get("resource/avatar" + pp + ".png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x,y,null);
			}else if( obj.type() == A_Const.TYPE_ALIEN ) {
				int x = (int)(obj.x-obj.radius);
				int y = (int)(obj.y-obj.radius);
				String pp; 
				Game_Aliens a = (Game_Aliens) obj;
				if(a.state == 0) { 
					pp="9"; 
				}else if (a.state == 1) {
					pp = "12";
				} else if(a.state == 2) {
					pp = "10";
				}else  {
					pp = "11"; 
				}
				String path = Paths.get("resource/aliens" + pp+ ".png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x,y,null);
			}else if( obj.type() == A_Const.TYPE_BULLET ) {
				int x = (int)(obj.x-obj.radius);
				int y = (int)(obj.y-obj.radius);
				graphics.setColor(obj.color);
				graphics.fillRect(x, y, obj.radius, 2*obj.radius);
			}
		}
	}



	public final void draw(A_TextObject text)
	{	  
		if(text.type() == A_Const.TYPE_SPACEINVADERS && ((Game_World) world).menu) {
			String path = Paths.get("resource/SpaceInvaders.png").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);
		}else if( text.type() == A_Const.TYPE_LIVES && !world.gameOver && !((Game_World) world).menu){
			if( A_Const.AVATAR_LIFE >= 1) {
				int x = (int)(text.x);
				int y = (int)(text.y);
				String path = Paths.get("resource/lives.png").toAbsolutePath().toString();
				try {
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				graphics.drawImage(image, x,y,null);

				if( A_Const.AVATAR_LIFE >= 2) {
					graphics.drawImage(image, x+30,y,null);
					if( A_Const.AVATAR_LIFE >= 3) {
						graphics.drawImage(image, x+60,y,null);
					}
				}
			}
		}else if( text.type() == A_Const.TYPE_PLAYBUTTON &&((Game_World) world).menu) {
			String path;
			if( world.gameOver) {
				path = Paths.get("resource/newGameBlack.png").toAbsolutePath().toString();
			}else {
				path = Paths.get("resource/newGameWhite.png").toAbsolutePath().toString();
			}				
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);
		}else if ( text.type() == A_Const.TYPE_QUITBUTTON && ((Game_World) world).menu) {
			String path;
			if( world.gameOver) {
				path = Paths.get("resource/quitBlack.png").toAbsolutePath().toString();
			}else {
				path = Paths.get("resource/quitWhite.png").toAbsolutePath().toString();
			}
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);

		}else if ( text.type() == A_Const.TYPE_GAMEOVER && world.gameOver) {
			String path = Paths.get("resource/gameOverText.png").toAbsolutePath().toString();
			try {
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(image, text.x, text.y,null);

		}
	}


	public void redraw()
	{ this.getGraphics().drawImage(imageBuffer, 0, 0, this);
	}

	public final A_InputSystem getInputSystem() { return inputSystem; }
	public final void setWorld(A_World world_)  {this.world = world_;}
}

