import java.awt.Color;

public class Game_PhysicsSystem extends A_PhysicsSystem
{

	Game_PhysicsSystem(A_World w)
	{ super(w);
	}


	//
	// collisions (we consider only bullets with avatar/alien)
	//
	public A_GameObjectList getCollisions(A_GameObject object)
	{
		A_GameObjectList result = new A_GameObjectList();

		int len = world.gameObjects.size();

		if(object.color == Color.white) { //white bullet
			double dist = object.radius+world.avatar.radius;
			double dx   = object.x-world.avatar.x;
			double dy   = object.y-world.avatar.y;

			if(dx*dx+dy*dy < dist*dist){ 
				result.add(world.avatar);
			}
			
		}else { 
			for(int i=1; i<len; i++) {
				A_GameObject obj2 = world.gameObjects.get(i);

				//we dont care if bullets collide with each other
				if(obj2.type() != A_Const.TYPE_ALIEN) continue; //return result; 

				// check if aliens collide with bullets
				double dist = object.radius+obj2.radius;
				double dx   = object.x-obj2.x;
				double dy   = object.y-obj2.y;
				if(dx*dx+dy*dy < dist*dist) { 
					result.add(obj2);
				}
			}
		}
		return result;
	}


}