package particles;

import java.util.Random;
import org.lwjgl.opengl.GL11;


public class Particle {
	Random rand = new Random(); 
	
	
	boolean left = rand.nextBoolean();
	boolean up = rand.nextBoolean();
	public int x;
	public int y;
	int yg;
	int xg;
	float r;
	float g;
	float b;
	int inxg;
	int inyg;
	
	
	boolean neg;
	public boolean active;
	public boolean moving;
	public boolean collision = false;
	
	public Particle(int inx,int iny,float inr,float ing ,float inb,int in_xg,int in_yg,boolean in_active,boolean rainbow) {
		x = inx;
		y = iny;
		
        if(rainbow){
		r = rand.nextFloat();
		g = rand.nextFloat();
		b = rand.nextFloat();
              	   }
         else{
		r = inr;
		b = inb;
		g = ing; 
	        }
		
            //Ha, in_active, get it?
            active = in_active;
	        moving = true;
	        neg = true;
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

	//subtract yg
	if(!collision)y -= yg;
		
		if(y < 2)active = false;
	
			//depending on the random value of neg, add or subtract xg from x
		
		    if(neg)x -= xg;
	
		    else if(!neg) x += xg;
	
	
        }
	//draw the particle to the screen
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