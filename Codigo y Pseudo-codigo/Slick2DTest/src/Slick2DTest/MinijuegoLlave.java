package Slick2DTest;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MinijuegoLlave extends BasicGameState{

    private ArrayList<Circle> balls;
    private Circle mouseBall;
    private int timePassed;
    private Random random;
   
    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {
        balls = new ArrayList<Circle>();
        mouseBall = new Circle(0,0,30);
        timePassed = 0;
        random = new Random();
    }
    
    public void update(GameContainer container, StateBasedGame sbg, int delta)
            throws SlickException {
        
        mouseBall.setCenterX(container.getInput().getMouseX());
        mouseBall.setCenterY(container.getInput().getMouseY());
        
        timePassed += delta;
        if (timePassed > 500) {
            timePassed = 0;
            balls.add(new Circle(200+random.nextInt(400),0,10));
        }
        for (Circle c : balls) {
            c.setCenterY(c.getCenterY()+(delta/5f));
        }
        for (int i = balls.size()-1; i >= 0; i--) {
            Circle c = balls.get(i);
            if (c.getCenterY() > 610) {
                balls.remove(i);
                Principal.vidasMinijuegoLlave--;
            }else if (c.intersects(mouseBall)) {
                balls.remove(i);
                Principal.puntuacionMinijuegoLlave++;
            }
        }
        if (Principal.puntuacionMinijuegoLlave ==3){
            
            sbg.enterState(11);
        }
        if (Principal.vidasMinijuegoLlave <= 0) {
            sbg.enterState(10);
        }
    }
    
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
            throws SlickException {
        g.drawString("Estado 1", 10, 50);
        g.setColor(Color.yellow);
        g.fill(mouseBall);
        
        g.setColor(Color.red);
        for(Circle c : balls) {
            g.fill(c);            
        }
        g.drawString ("Vidas: " + Principal.vidasMinijuegoLlave, 10, 100);
        g.drawString ("Puntuacion: " + Principal.puntuacionMinijuegoLlave, 10, 120);
    }
    
    public int getID() {
        return 9;
    }    
    
}
