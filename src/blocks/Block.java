package blocks;
import org.lwjgl.opengl.GL11;


public class Block {

	//position
	int x;
	int y;

	//color
	float r;
	float g;
	float b;
	
	//state
	boolean active;


	
	public Block(int in_x,int in_y,float in_r,float in_g, float in_b,boolean in_active){
		x = in_x;
		y = in_y;
	
		r = in_r;
		g = in_g;
		b = in_b;
		
		active = in_active;
	}
	
	
	public void run() {
	
	
		GL11.glColor3f(r, g, b);
		GL11.glBegin(GL11.GL_QUADS);
		    GL11.glVertex2f(x + 10,y - 10);
		    GL11.glVertex2f(x + 10,y + 10);
		    GL11.glVertex2f(x - 10,y + 10);
		    GL11.glVertex2f(x - 10,y - 10);
		GL11.glEnd();
	
	
	}
	
	
}
	
