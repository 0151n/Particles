
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Particle {
	Random rand = new Random(); 
	
	
	boolean left = rand.nextBoolean();
	boolean up = rand.nextBoolean();
	int x;
	int y;
	int yg;
	int xg;
	float r;
	float g;
	float b;
	int inxg;
	int inyg;
	
	float quadangle;
	boolean neg;
	boolean active;
	boolean moving;
	
	public Particle(int inx,int iny,float inr,float ing ,float inb,int in_xg,int in_yg,boolean in_active,boolean rainbow) {
		x = inx;
		y = iny;
		if(rainbow){
		r = rand.nextFloat();
		g = rand.nextFloat();
		b = rand.nextFloat();
		}else{
			r = inr;
			b = inb;
			g = ing; 
		}
		active = in_active;
		moving = true;
		inxg = in_xg;
		inyg = in_yg;
		
	}
	public void run () {
	if(active == true){
	    if(moving == true){
		//set random variables for falling calculations
		xg = rand.nextInt(inxg);
		yg = rand.nextInt(inyg);
		neg = rand.nextBoolean();

	
		if(y >= (2 + yg)) y -= yg;
		
		if(y > 4){
	
		    if(neg && x >= (4 + xg))x -= xg;
	
		    else if(!neg && x <= (800 - xg)) x += xg;
	
		}
}

	GL11.glColor3f(r, g, b);
	GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(x + 2,y - 2);
	    GL11.glVertex2f(x + 2,y + 2);
	    GL11.glVertex2f(x - 2,y + 2);
	    GL11.glVertex2f(x - 2,y - 2);
	GL11.glEnd();
	
	}
	
	}


}
