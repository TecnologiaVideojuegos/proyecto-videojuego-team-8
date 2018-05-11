package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Laberinto extends BasicGameState{

     //Animation character, moveLeft, moveRight,moveUp,moveDown;
    Image conejo;
    private Image laberinto;
    //int[] duration = {200,200};
    private Input entrada;
    float characterPositionX = 580,  characterPositionY = 648;
    BasicGameState prevState = Principal.prevState;
    
    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.laberinto = new Image("puzzle_laberi/final.tmx");
       this.conejo = new Image("res/conejo.png");
       Principal.prevState = this;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.laberinto.drawCentered(960,540);
        this.conejo.draw(characterPositionX,characterPositionY);
        
       
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}