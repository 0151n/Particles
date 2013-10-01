

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
public class Engine {

	
	public static int maxpart = 1000;
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setFullscreen(false);
			Display.create();
			setDisplayMode(800,600,false);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}

		/*	
	 * int y = 100;
		int x = 100;
		boolean up = false;
		boolean left = false;
		*/
		boolean left = Mouse.isButtonDown(0); // is left mouse button down.
		// int maxpart = 100000;
		int x = Mouse.getX();
		int y = Mouse.getY();
		//dirt[]  array = new dirt[maxpart];
		Particle[]  array = new Particle[maxpart];
		//array[0] = new Particle(300,600,1.0f,0.0f,0.0f,false);
		//Ball one = new Ball(300,600,1.0f,0.0f,0.0f);
	
		// init OpenGL here
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		for(int i = 0;i <= maxpart - 1;i++){
			array[i] = new Particle(300,600,1.0f,0.0f,0.0f,2,10,false,true);
			//array[i] = new dirt(300,600,0,0,false);
		}
		while (!Display.isCloseRequested()) {
			
			// render OpenGL here
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
					
			// set the color of the quad (R,G,B,A)
	
			// draw quad
			//function hiding lwjgl stuff;
		
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))setDisplayMode(800,600,false);
			
			for(int i = 0;i <= maxpart - 1;i++){
				array[i].run();
			/*super collision algorithm
			 * --super slow
			 * --super small
			 * --super crappy
			 */
			
				for(int n = 0;n <= maxpart - 1;n++){
			if(array[n].active == true){
					if(array[n].x <= (array[i].x + 10) && array[n].x + 10 >= (array[i].x)){
							if(array[n].y + 10 >= (array[i].y) && array[n].y <= (array[i].y + 10)){
								array[n].moving = false;
							}
							else array[n].moving = true;
						
					}
						else array[n].moving = true;
			}	
			}
			
				
			}
			
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
			if( left = Mouse.isButtonDown(1)){
				for(int i = 0;i <= maxpart - 1;i++){
					if(array[i].active == true){
						array[i].active = false;
						break;
					}
				}
			}
		
		
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//update the screen
			Display.update();
		}
		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		System.out.println("Particle Engine v1.2");
		Engine window = new Engine();
		window.start();
	}
	
	
	public void checkx(Particle array[]){
		

		for(int n = 0;n <= Engine.maxpart - 1;n++){
			
			
			for(int i = 0;i <= Engine.maxpart - 1;i++){
				if(array[n].x <= (array[i].x +5) && array[n].x >= (array[i].x -5)){
					if(array[n].y <= (array[i].y + 5) && array[n].y >= (array[i].y -5)){
						array[n].moving = false;
					}
				}
			}
		}	
			
		}
	
	
	
	/**
	 * Set the display mode to be used 
	 * 
	 * @param width The width of the display required
	 * @param height The height of the display required
	 * @param fullscreen True if we want fullscreen mode
	 */
	public void setDisplayMode(int width, int height, boolean fullscreen) {

	    // return if requested DisplayMode is already set
	    if ((Display.getDisplayMode().getWidth() == width) && 
	        (Display.getDisplayMode().getHeight() == height) && 
		(Display.isFullscreen() == fullscreen)) {
		    return;
	    }

	    try {
	        DisplayMode targetDisplayMode = null;
			
		if (fullscreen) {
		    DisplayMode[] modes = Display.getAvailableDisplayModes();
		    int freq = 0;
					
		    for (int i=0;i<modes.length;i++) {
		        DisplayMode current = modes[i];
						
			if ((current.getWidth() == width) && (current.getHeight() == height)) {
			    if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
			        if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
				    targetDisplayMode = current;
				    freq = targetDisplayMode.getFrequency();
	                        }
	                    }

			    // if we've found a match for bpp and frequence against the 
			    // original display mode then it's probably best to go for this one
			    // since it's most likely compatible with the monitor
			    if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
	                        (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
	                            targetDisplayMode = current;
	                            break;
	                    }
	                }
	            }
	        } else {
	            targetDisplayMode = new DisplayMode(width,height);
	        }

	        if (targetDisplayMode == null) {
	            System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
	            return;
	        }

	        Display.setDisplayMode(targetDisplayMode);
	        Display.setFullscreen(fullscreen);
				
	    } catch (LWJGLException e) {
	        System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
	    }
	}

}




