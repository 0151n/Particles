package particles;

import org.lwjgl.opengl.GL11;

public class AdvParticle extends Particle{

	//horizontal and vertical velocity and duration
	int h_vel;
	int h_dur;
	int v_vel;
	int v_dur;
	
	//temporary horizontal and vertical velocity and duration
	int tmp_h_vel;
	int tmp_h_dur;
	int tmp_v_vel;
	int tmp_v_dur;	
	
	public AdvParticle(int inx, int iny, float inr, float ing, float inb,
			int h_velocity, int h_duration,int v_velocity,int v_duration, boolean in_active, boolean rainbow) {
		
		super(inx, iny, inr, ing, inb, h_velocity, h_duration, in_active, rainbow);
		
		//set values from arguments
		
		//horizontal
		h_vel = h_velocity;
		h_dur = h_duration;
		
		tmp_h_vel = h_velocity;
		tmp_h_dur = h_duration;
		
		//vertical
		v_vel = v_velocity;
		v_dur = v_duration;
		
		tmp_v_vel = v_velocity;
		tmp_v_dur = v_duration;
	}
	
	
	@Override
	public void run() {

		if(active == true){
			if(moving == true){
		
        //gravity
		yg = 8;
	
	//calculations for gravity & velocity
		if(h_vel > 0 && h_dur > 0){
			x += h_vel;
			h_vel--;
			h_dur--;
		}
		
		if(v_vel > 0 && v_dur > 0){
			y += v_vel;
			v_vel--;
			v_dur--;
		}

		
	
	if(!collision)y -= yg;
		
	//if the particle is outside the screen set it's "active" variable to false
		if(y < 2)active = false;
	
	
		    if(x >= 800)active = false;
	
		    else if(x <= 0)active = false;
	
	
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
		//when the particle becomes inactive set it's horizontal & vertical,
		//velocity & duration to there initial value
		
		if(!active){
			h_vel = tmp_h_vel;
			h_dur = tmp_h_dur;
			
			v_vel = tmp_v_vel;
			v_dur = tmp_v_dur;
		}
	}

}
