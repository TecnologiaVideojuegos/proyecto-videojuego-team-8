package minijuegos;

import java.util.ArrayList;
import java.util.Random;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
/**
 *
 * @author Luismi
 */
public class GameState1 extends BasicGameState{

    Image pasadizo;
    Animation character, moveLeft, moveRight,nomove;
    private ArrayList<Circle> balls;
    private Circle mouseBall;
    private Rectangle boxconejo;
    private int timePassed;
    private Random random;
    private Image conejo;
    private Input entrada;
    private float posicionX=200, posicionY=480;
    private int posX=200,posY= 486;
    int[] duration = {200,200,200,200};
    //float characterPositionX = 580,  characterPositionY = 648;
    //BasicGameState prevState = Principal.prevState;
    //Image personaje1;
    
    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {
        //personaje1 = new Image("respuzzles/0.png");
        pasadizo = new Image("respuzzles/pasadizo.png");
        balls = new ArrayList<Circle>();
        mouseBall = new Circle(0,0,30);
        timePassed = 0;
        random = new Random();
        conejo = new Image("respuzzles/00.png");
        boxconejo = new Rectangle(posX,posY,38,102);
        //Principal.prevState = this;
        Image[] walkRight = {new Image("respuzzles/11.png"),new Image("respuzzles/22.png"),new Image("respuzzles/33.png"),new Image("respuzzles/44.png")}; 
        Image[] walkLeft = {new Image("respuzzles/1.png"),new Image("respuzzles/2.png"),new Image("respuzzles/3.png"),new Image("respuzzles/4.png")}; 
        Image[] nowalk = {new Image("respuzzles/00.png"),new Image("respuzzles/00.png"),new Image("respuzzles/00.png"),new Image("respuzzles/00.png")}; 
    
        moveRight = new Animation(walkRight, duration, true);
        moveLeft = new Animation(walkLeft,duration,true);
        nomove = new Animation(nowalk,duration,true);
        character = nomove;
    }
    
    public void update(GameContainer container, StateBasedGame sbg, int delta)
            throws SlickException {
        
        System.out.println("X: "+posX+ "Y: "+ posY);
        entrada = container.getInput();
        
        if (entrada.isKeyDown(Input.KEY_D)) {
            character = moveRight;
            posicionX += delta * .5f;
            boxconejo.setX(posicionX);
        }
        if (entrada.isKeyDown(Input.KEY_A)) {
            character = moveLeft;
            posicionX -= delta * .5f;
            boxconejo.setX(posicionX);
        }
        if (entrada.isKeyDown(Input.KEY_S)) {
            character = moveRight;
            posicionY += delta * .5f;
            boxconejo.setY(posicionY);
        }
        if (entrada.isKeyDown(Input.KEY_W)) {
            character = moveLeft;
            posicionY -= delta * .5f;
            boxconejo.setY(posicionY);
        }
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)){
            character = nomove;
        }
        
        timePassed += delta;
        if (timePassed > 500) {
            timePassed = 0;
            balls.add(new Circle(0,70+random.nextInt(400),10));
        }
        for (Circle c : balls) {
            c.setCenterX(c.getCenterX()+(delta/3f));
        }
        for (int i = balls.size()-1; i >= 0; i--) {
            Circle c = balls.get(i);
            if (c.getCenterX() > 810) {
                balls.remove(i);
            }else if (c.intersects(boxconejo)) {
                balls.remove(i);
                Inicio.Vidas--;
            }
        }
        //Aqui sería la condicion para cambiar de stage
        if (Inicio.Vidas <= 0) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }
    
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
            throws SlickException {
        pasadizo.draw();
        g.drawString(" "+posicionX +" "+posicionY,100,100);
        g.drawString("Estado 1", 10, 50);
        g.setColor(Color.transparent);
        g.fill(boxconejo);
        this.character.draw(posicionX,posicionY);
        
        g.setColor(Color.white);
        for(Circle c : balls) {
            g.fill(c);            
        }
        g.drawString ("Vidas: " + Inicio.Vidas, 10, 100);
        g.drawString ("Puntuacion: " + Inicio.Puntuacion, 10, 120);

    }
    
    
    public int getID() {
        return 0;
    }    
    
}
