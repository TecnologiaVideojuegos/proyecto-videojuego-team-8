package Slick2DTest;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Slick2DTest extends StateBasedGame {

    public static final String gameName = "Videojuego";
    public static final int startMenu = 0;
    public static final int worldMap =1;
    public static final int habitacion1 =2;
    
    public Slick2DTest(String gameName) {
        super(gameName);
        this.addState(new MainMenu(startMenu));
        this.addState(new WorldMap(worldMap));
        this.addState(new Habitacion1(habitacion1));
    }
    
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(startMenu).init(gc, this);
        this.getState(worldMap).init(gc, this);
        this.getState(habitacion1).init(gc, this);
        this.enterState(startMenu);
    }

    public static void main(String[] args) {
        AppGameContainer agc;
        try{
            agc = new AppGameContainer(new Slick2DTest(gameName));
            agc.setDisplayMode(1000, 1000, false);
            agc.start();
        }catch (SlickException e){
            e.printStackTrace();
        }
        
    }
    
}