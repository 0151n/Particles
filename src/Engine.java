

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
public class Engine {

	

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setFullscreen(false);
			Display.create();
		
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		

		boolean left = Mouse.isButtonDown(0); // is left mouse button down.
		int maxpart = 1000;
		int x = Mouse.getX();
		int y = Mouse.getY();
		//collision detection variables
		double dist;
		int distx;
		int disty;
		
		//Main particle array
		Particle[]  array = new Particle[maxpart];
	
	
		// initializing OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		for(int i = 0;i <= maxpart - 1;i++){
			array[i] = new Particle(300,600,1.0f,0.0f,0.0f,1,10,false,true);
		
		}
		while (!Display.isCloseRequested()) {
			
			// rendering OpenGL
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
	                                		
			//loop through all the particles
			for(int i = 0;i <= maxpart - 1;i++){
			    //running "run" method on particle object 
				array[i].run();

				//collion detection (if you can call it that)			
				//get some variables to make it more readable
				
				for(int n = 0;n <= maxpart - 1;n++){
			if(array[n].active == true){
			
			distx = array[i].x - array[n].x;
			disty = array[i].y - array[n].y;
			
			dist = Math.sqrt((distx * distx) + (disty * disty));
			
			if(dist <= 10)array[n].moving = false;
			else array[n].moving = true;
				
			}	
			}
			
				
			}
			//wierd way of implementing but it works
			//place particles when left click
			if( left = Mouse.isButtonDown(0)){
				for(int i = 0;i <= maxpart - 1;i++){
					if(array[i].active == false){
						array[i].x = Mouse.getX();
						array[i].y = Mouse.getY();
						array[i].active = true;
					
						break;
					}
				}
			}
			//remove on right click
			if( left = Mouse.isButtonDown(1)){
				for(int i = 0;i <= maxpart - 1;i++){
					if(array[i].active == true){
						array[i].active = false;
						break;
					}
				}
			}
		
		
			//sleep of 10 milliseconds
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//update the screen
			Display.update();
		}
		//destroy display
		Display.destroy();
	}
	
	public static void main(String[] argv) {
	    //print verison number
		System.out.println("Particle Engine v1.0");
	    //create new window class
		Engine window = new Engine();
	    //start
		window.start();
	}
	
}




