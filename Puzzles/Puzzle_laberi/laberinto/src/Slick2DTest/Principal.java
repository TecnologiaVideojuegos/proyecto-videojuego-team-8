package Slick2DTest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Principal extends StateBasedGame{
    public static BasicGameState prevState  = null;
    public static BasicGameState prevState2  = null;

    public static void main(String[] args) {
        
        try{
        AppGameContainer contenedor = new AppGameContainer(new Principal());
        contenedor.setDisplayMode(1920, 1080, false);
        contenedor.setShowFPS(false);
        contenedor.start();
       }catch(SlickException slick){
           slick.printStackTrace();
           System.exit(1);
       }       
    }
  
    

    public Principal() throws SlickException {
        super("Hellsingly");
       
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       this.addState(new Laberinto());
      
      
    }
    
}
