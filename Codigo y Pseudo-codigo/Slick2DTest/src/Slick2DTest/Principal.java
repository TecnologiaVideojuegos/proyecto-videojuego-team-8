package Slick2DTest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Principal extends StateBasedGame{
    public static BasicGameState prevState  = null;
    public static BasicGameState prevState2  = null;
    public static Inventario inventario = new Inventario();
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
       this.addState(new PantallaInicio());
       this.addState(new Pasillo());
       this.addState(new EscapeMenu());
       this.addState(new Habitacion1());
       this.addState(new Habitacion2(inventario));
       this.addState(new Habitacion3());
       this.addState(new Inventario());
      
    }
    
}
