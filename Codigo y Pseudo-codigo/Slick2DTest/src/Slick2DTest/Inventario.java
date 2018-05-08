package Slick2DTest;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Inventario extends BasicGameState {
    
private Image inventario;   
private Input entrada;
private int posicion;
private boolean meter = true;
//private Graphics g;

    @Override
    public int getID() {
        return 7;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.inventario = new Image("res/inventario.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.inventario.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);
        
        gc.getGraphics().drawString("tuberia", 236, 434);
        
        entrada = gc.getInput();
        
        if(entrada.isKeyDown(Input.KEY_S)){
                BasicGameState prevState2 = Principal.prevState2;
                Principal.prevState2 = this;
                sbg.enterState (prevState2.getID());
           }
        
       
            
       
        
    }

    public void setMeter(boolean meter) {
        this.meter = meter;
    }
    
    /*public void dibujarObjeto(Graphics g){
        g.drawString("tuberia", 884, 596);
    }*/
    
   
    
}
