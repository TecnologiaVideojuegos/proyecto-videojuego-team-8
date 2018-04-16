package Slick2DTest;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WorldMap extends BasicGameState{
    
    Animation character, moveLeft, moveRight;
    Image world;
    
    int[] duration = {200,200};
    boolean escapemenu = false;
    
    float characterPositionX = 0;
    float characterPositionY = 0;
    float shiftX = characterPositionX ;
    float shiftY = characterPositionY + 300;
    
    WorldMap(int worldMap) {
    }
  
    public int getID() {
        return 1;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        world = new Image("Imagen/mapa.jpg");
        
        Image[] walkLeft = {new Image("Imagen/conejo.png"),new Image("Imagen/conejo.png")}; 
        Image[] walkRight = {new Image("Imagen/conejo.png"),new Image("Imagen/conejo.png")};
        
        moveRight = new Animation(walkRight,duration,false);
        moveLeft = new Animation(walkRight,duration,false);
        character =moveLeft;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        world.draw(characterPositionX,characterPositionY);
        character.draw(shiftX,shiftY);
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 400, 200);
    
        if(escapemenu){
            g.drawString("Resume (R)", 400, 330);
            g.drawString("Main Menu (M)", 400, 280);
            g.drawString("Quit (Q)", 400, 230);
            if (!escapemenu){
                g.clear();
            }
           
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {    
        Input input = gc.getInput();
        
        //Building 1 entrance
        if ((characterPositionX > -203 && characterPositionX < -130)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(2);
            }
        }
        
        //right movement
        if(input.isKeyDown(Input.KEY_D)){
            character =moveRight;
            characterPositionX -= i * .1f;
                if (characterPositionX < -957){
                    characterPositionX += i *.1f;
                }
        }
        
        //left movement
        if(input.isKeyDown(Input.KEY_A)){
            character =moveLeft;
            characterPositionX += i * .1f;
                if (characterPositionX > 517){
                    characterPositionX -= i *.1f;
                }
        }
        
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            escapemenu = true;
        }
        
       if (escapemenu){
           if(input.isKeyDown(Input.KEY_R)){
               escapemenu = false;
           }
           if (input.isKeyDown(Input.KEY_M)){
               sbg.enterState(0);
           }
           if (input.isKeyDown(Input.KEY_Q)){
               System.exit(0);
           }
           
       }
    }
      
}

