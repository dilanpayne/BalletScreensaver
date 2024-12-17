import java.awt.*;

public class Dancer {

    public String name;
    public Image pic;
    public Image sadpic;;
    public int xpos;
    public int ypos;
    public int dx = 50;
    public int dy = 50;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle hitbox;
    public boolean isHappy = true;

    public Dancer() {
        hitbox = new Rectangle(xpos, ypos, width, height);

    }

    public Dancer(int paramXpos, int paramYpos,
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

    public void glide() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (ypos >= 700 - height || ypos <= 0) {
            dy = -dy;
            // bottom or top bounce
        }
        if (xpos >= 1000 - width || xpos <= 0) {
            dx = -dx;
            //right or left bounce
        }
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

        public void printInfo(){
        System.out.println(name + " is at (" + xpos + ", " + ypos + ")");

    }
}