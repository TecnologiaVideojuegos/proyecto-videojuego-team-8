package Slick2DTest;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Video_inicial extends BasicGameState {
    
    private Music music;
    private boolean terminado;
    private Animation playvideo,play;
    int[] duration = {4000,4000,5000,4000,4000,4000,4000,4000,2000,4000,6000,4000,2000,4000,4000,5000,3000};
    private Image fachada1,fachada2,fachada3,fachada4,fachada5,fachada6,fachada7,fachada8,fachada9,fachada10,fachada11,fachada12,fachada13,fachada14,fachada15,fachada16,fachada17;
    private boolean playmusica = true;
    
    @Override
    public int getID() {
      return 7; 
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        music = new Music("res/musicaintro.ogg");
        fachada1 = new Image("res/fachada1.jpg");
        fachada2 = new Image("res/fachada2.jpg");
        fachada3 = new Image("res/fachada3.jpg");
        fachada4 = new Image("res/fachada4.jpg");
        fachada5 = new Image("res/fachada5.jpg");
        fachada6 = new Image("res/fachada6.jpg");
        fachada7 = new Image("res/fachada7.jpg");
        fachada8 = new Image("res/fachada8.jpg");
        fachada9 = new Image("res/fachada9.jpg");
        fachada10 = new Image("res/fachada10.jpg");
        fachada11 = new Image("res/fachada11.jpg");
        fachada12 = new Image("res/fachada12.jpg");
        fachada13 = new Image("res/fachada13.jpg");
        fachada14 = new Image("res/fachada14.jpg");
        fachada15 = new Image("res/fachada15.jpg");
        fachada16 = new Image("res/fachada16.jpg");
        fachada17 = new Image("res/fachada17.jpg");
        
        Image[] Imagenesvideo ={fachada1,fachada2,fachada3,fachada4,fachada5,fachada6,fachada7,fachada8,fachada9,fachada10,fachada11,fachada12,fachada13,fachada14,fachada15,fachada16,fachada17};
        playvideo = new Animation(Imagenesvideo, duration, true);
        play = playvideo;
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
      
       this.play.draw();
       
       play.stopAt(16);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
       if (playmusica){
            this.music.play();
            playmusica=false;
  }
        if (play.isStopped()){
            this.music.stop();
            sbg.enterState(1);
        }
    }
    
    
    
    
    
}
