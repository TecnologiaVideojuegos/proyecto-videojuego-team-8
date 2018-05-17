package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PreMinijuegoCuchillo extends BasicGameState{
    Input entrada;
    @Override
    public int getID() {
       return 74;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString ("Consigue escapar",610 ,354);
        g.drawString ("(W y S para moverse de arriba a abajo)",510 ,384);
        g.drawString ("(Pulsa espacio para continuar)",555 ,414);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada= gc.getInput();
        if (entrada.isKeyDown(Input.KEY_SPACE)){
            sbg.enterState(72);
        }
    }
    
}
