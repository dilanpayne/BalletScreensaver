import java.awt.*;

public class Spotlight {
        public String name;
        public Image pic;
        public int xpos;
        public int ypos;
        public int dx = 50;
        public int dy = 50;
        public int width;
        public int height;

        public Spotlight(int paramXpos, int paramYpos,
                         int paramDx, int paramDy,
                         int paramWidth, int paramHeight) {
            xpos = paramXpos;
            ypos = paramYpos;
            dx = paramDx;
            dy = paramDy;
            width = paramWidth;
            height = paramHeight;
        }

    public void wrap() { // add if statements to say if he is going off each side come back
        xpos = xpos + dx;

        ypos = ypos + dy;

        if (xpos >= 1000) {
            xpos = -width;
        }

        if (ypos >= 800) {
            ypos = -height;

        }
    }
}
