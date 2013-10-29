package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import blocks.Block_Disint;

import particles.AdvParticle;
import particles.Particle;

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
		
		//maximum number of particles in an array
		int maxpart = 1000;
		
		//particle object array
		Particle[]  array_2 = new Particle[maxpart];
		//advparticle object array
		AdvParticle[]  array = new AdvParticle[maxpart];
		
		//block_disint object initialisation
		Block_Disint one = new Block_Disint(400,300,1.0f,0.5f,0.0f,true);
		Block_Disint two = new Block_Disint(300,300,0.0f,0.5f,1.0f,true);
		Block_Disint three = new Block_Disint(200,300,0.0f,1.0f,0.5f,true);
		
		// Initialising OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		for(int i = 0;i <= maxpart - 1;i++){
			//initialising particle and advparticle objects
			array[i] = new AdvParticle(300,600,1.0f,0.0f,0.0f,30,30,30,30,false,true);
			array_2[i] = new Particle(300,600,1.0f,0.0f,0.0f,2, 8, false,true);
		}
		
		while (!Display.isCloseRequested()) {
			
			// rendering OpenGL
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
	                                		
			//loop through all the particles
			for(int i = 0;i <= maxpart - 1;i++){
			    //running "run" method on particle object 
				array[i].run();		
				 //running "run" method on advparticle object 
				array_2[i].run();	
			}
			
			 //running "run" method on block_disint objects 
			one.run();
			two.run();
			three.run();
			
			//place advparticles when left click
			if(Mouse.isButtonDown(0)){
				for(int i = 0;i <= maxpart - 1;i++){
					if(array[i].active == false){
						array[i].x = Mouse.getX();
						array[i].y = Mouse.getY();
						array[i].active = true;
					
						break;
					}
				}
			}
			//place particles when right click
			if(Mouse.isButtonDown(1)){
				for(int i = 0;i <= maxpart - 1;i++){
					if(array_2[i].active == false){
						array_2[i].x = Mouse.getX();
						array_2[i].y = Mouse.getY();
						array_2[i].active = true;
					
						break;
					}
				}
			}
		
			 //wait for space key to be pressed
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				//set disintegrated variable to true in all block_disint objects
				one.disintegrated = true;
				two.disintegrated = true;
				three.disintegrated = true;
			}
		
		
			//update the screen
			Display.update();
		}
		//destroy display
		Display.destroy();
	}
	
	public static void main(String[] argv) {
	    //print version number
		System.out.println("Particle Engine v0.1.3");
	    //create new window class
		Engine window = new Engine();
	    //start
		window.start();
	}
	
}



