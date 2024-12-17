import java.awt.*;

public class ThingThrown {

    public String name;
    public Image pic;
    public int xpos;
    public int ypos;
    public int dx = 50;
    public int dy = 50;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle hitbox;

    public ThingThrown() {
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

    public ThingThrown(int paramXpos, int paramYpos,
                       int paramDx, int paramDy,
                       int paramWidth, int paramHeight) {
        xpos = paramXpos;
        ypos = paramYpos;
        dx = paramDx;
        dy = paramDy;
        width = paramWidth;
        height = paramHeight;
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

    public void tomatotoss() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (ypos >= 660) {
            dy = -dy;
        }
        if (xpos >= 960) {
            dx = -dx;
        }
        if (ypos <= 0) {
            dy = -dy;
        }
        if (xpos <= 0) {
            dx = -dx;
        }
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

    public void flowertoss() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (ypos >= 640) {
            dy = -dy;
        }
        if (xpos >= 940) {
            dx = -dx;
        }
        if (ypos <= 0) {
            dy = -dy;
        }
        if (xpos <= 0) {
            dx = -dx;
        }
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

    public void printInfo() {
        System.out.println(name + " is at (" + xpos + ", " + ypos + ")");
    }
}