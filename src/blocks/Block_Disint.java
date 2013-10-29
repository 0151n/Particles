package blocks;

import org.lwjgl.opengl.GL11;

import blocks.Block;

import particles.Particle;


public class Block_Disint extends Block{
	//counters
	int tmpx;
	int tmpy;
	
	
	//state
	public boolean disintegrated = false;
	boolean done = false;
	
	//particles
	Particle[]  array = new Particle[25]; 
	
	public Block_Disint(int in_x, int in_y, float in_r, float in_g, float in_b,
			boolean in_active) {
		
		super(in_x, in_y, in_r, in_g, in_b, in_active);
		
		x = in_x;
		y = in_y;
	
		r = in_r;
		g = in_g;
		b = in_b;
		
		active = in_active;
		
		
		for(int i = 0;i <= 25 - 1;i++){
			
			array[i] = new Particle(300,600,r,g,b,3,6,false,false);
		
		}
	}
	
	@Override
	public void run() {
		if(disintegrated && !done){
			tmpx = x - 10;
			tmpy = y - 10;
			int i = 0;
			
			for(int l = 0;l <= 4;l++){
				
				for(int m = 0;m <= 4;m++){
				array[i].x = tmpx;
				array[i].y = tmpy;
				tmpx += 4;
				
				array[i].active = true;
				i++;
				}
				tmpx = x - 10;
				tmpy += 4;
			}
			done = true;
		
		}
		else if(!disintegrated){
			GL11.glColor3f(r, g, b);
			GL11.glBegin(GL11.GL_QUADS);
			    GL11.glVertex2f(x + 10,y - 10);
			    GL11.glVertex2f(x + 10,y + 10);
			    GL11.glVertex2f(x - 10,y + 10);
			    GL11.glVertex2f(x - 10,y - 10);
			GL11.glEnd();
		}
		if(done){
			for(int i1 = 0;i1 <= 25 - 1;i1++){
				array[i1].run();
			}
		}
	}
}
