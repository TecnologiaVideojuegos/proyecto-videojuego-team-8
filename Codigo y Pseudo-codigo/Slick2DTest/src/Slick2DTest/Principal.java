package Slick2DTest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Principal extends StateBasedGame{
    MinijuegoLlave minijuego = new MinijuegoLlave();
    public static boolean llave = false;
    public static boolean tuberia = false;
    public static boolean de32a8 = false;
    public static BasicGameState prevState  = null;
    public static BasicGameState prevState2  = null;
    public static int puntuacionMinijuegoLlave = 0;
    public static int vidasMinijuegoLlave = 3;
    public static Inventario inventario = new Inventario();
    public static float characterPositionX8; 

    public static boolean isTuberia() {
        return tuberia;
    }

    public static void setTuberia(boolean tuberia) {
        Principal.tuberia = tuberia;
    }
   

    
    public boolean isLlave() {
        return llave;
    }

    public void setLlave(boolean llave) {
        this.llave = llave;
    }
    
    public static void setPuntuacionMinijuegoLlave(int puntuacionMinijuegoLlave) {
        Principal.puntuacionMinijuegoLlave = puntuacionMinijuegoLlave;
    }

    public static void setVidasMinijuegoLlave(int vidasMinijuegoLlave) {
        Principal.vidasMinijuegoLlave = vidasMinijuegoLlave;
    }
    
    
    
    public static void main(String[] args) {
        
        try{
        AppGameContainer contenedor = new AppGameContainer(new Principal());
        contenedor.setDisplayMode(1366,768, false);
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
       this.addState(new Habitacion1(this));
       this.addState(new Habitacion2(minijuego));
       this.addState(new Habitacion3());
       this.addState(new Inventario());
       this.addState(new Recepcion());
       this.addState(new Hall1());
       this.addState(new MinijuegoLlave());
       this.addState(new GameOverMinijuegoLlave(minijuego));
       this.addState(new GameWinMinijuegoLlave(minijuego));
       this.addState(new EscenaNiña1());
       this.addState(new EscenaNiña2());
       this.addState(new EscenaNiña3());
       this.addState(new EscenaNiña4());
       this.addState(new EscenaNiña5());
       this.addState(new EscenaNiña6());
       this.addState(new EscenaNiña7());
       this.addState(new EscenaNiña8());
       this.addState(new EscenaNiña9());
       this.addState(new EscenaNiña10());
       this.addState(new EscenaViejo1());
       this.addState(new EscenaViejo2());
       this.addState(new EscenaViejo3());
       this.addState(new EscenaViejo4());
       this.addState(new EscenaViejo5());
       this.addState(new EscenaViejo6());
       this.addState(new EscenaViejo7());
       this.addState(new EscenaViejo8());
       this.addState(new EscenaViejo9());
       this.addState(new EscenaViejo10());
       this.addState(new Hallviejo_tuberia());
       
    }    

}
