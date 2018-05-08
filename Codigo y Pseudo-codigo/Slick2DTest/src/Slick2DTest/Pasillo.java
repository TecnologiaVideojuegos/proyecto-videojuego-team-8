package Slick2DTest;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Pasillo extends BasicGameState{
    
    Animation character, moveLeft, moveRight,nomove;
    Image personaje1;
    Image p;
    private Image pasillo;
    int[] duration = {200,200,200,200};
    private Input entrada;
        float characterPositionX = 24,  characterPositionY = 406;
    BasicGameState prevState = Principal.prevState;



    @Override
    public int getID() {
       return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.pasillo = new Image("res/pasillo.jpg");
       
       personaje1 = new Image("res/personaje1.png");
      
       Principal.prevState = this;
       Image[] walkRight = {new Image("res/personaje2.png"),new Image("res/personaje3.png"),new Image("res/personaje4.png"),new Image("res/personaje5.png")}; 
       Image[] walkLeft = {new Image("res/personaje2.png"),new Image("res/personaje3.png"),new Image("res/personaje4.png"),new Image("res/personaje5.png")};
       Image[] nowalk = {new Image("res/personaje1.png"),new Image("res/personaje1.png"),new Image("res/personaje1.png"),new Image("res/personaje1.png")};
        
       moveRight = new Animation(walkRight, duration, true);
       moveLeft = new Animation(walkLeft,duration,true);
       nomove = new Animation(nowalk,duration,true);
      
       character = nomove;

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        this.pasillo.drawCentered(683,384);//fondo.drawCentered(683,384);//683 y 384
        this.character.draw(characterPositionX,characterPositionY);
        
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 683, 384);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        entrada = gc.getInput();
        
        //Building 1 entrance
        /*if ((characterPositionX > 665 && characterPositionX < 747) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(4);
            }*/
        
        if ((characterPositionX > 1221)){
                Principal.prevState = this;
                sbg.enterState(8);
            }
        
        if ((characterPositionX < -67)){
                Principal.prevState = this;
                sbg.enterState(1);
            }
        
        if(entrada.isKeyDown(Input.KEY_I)){
            Principal.prevState2 = this;
            sbg.enterState(7);
        }
        
        if ((characterPositionX > 21 && characterPositionX < 158) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(4);
            }
        
        if ((characterPositionX > 561 && characterPositionX < 700) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(5);
            }
        
        if ((characterPositionX > 1087 && characterPositionX < 1221) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(6);
            }

        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)){
                character = nomove;
            }
        
        if(entrada.isKeyDown(Input.KEY_D)){
            character = moveRight;
            characterPositionX += i * .10f;
        }
        
        if(entrada.isKeyDown(Input.KEY_A)){
            character = moveLeft;
            characterPositionX -= i * .10f;
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
               
}
        
    }
    

