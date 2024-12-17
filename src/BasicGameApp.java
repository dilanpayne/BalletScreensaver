// My brother, Brady Payne, introduced the "else" component of the if statement, which I then wrote myself and grew to understand
//Basic Game Application
// Basic Object, Image, Movement
// Threaded

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//*******************************************************************************

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too
    Image backgroundPic;

    boolean DancerVSTomato1 = false;
    boolean DancerVSTomato2 = false;
    boolean DancerVSFlower1 = false;


    Dancer Dancer1;
    ThingThrown Tomato1;
    ThingThrown Tomato2;
    ThingThrown Flower1;
    Spotlight Spotlight;

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor

        setUpGraphics();

        backgroundPic = Toolkit.getDefaultToolkit().getImage("StageBackdrop.jpg");

        //variable and objects
        //create (construct) the objects needed for the game
        Dancer1 = new Dancer(600, 330, 3, 0, 125, 260);
        Dancer1.name = "Dancer1";
        Dancer1.pic = Toolkit.getDefaultToolkit().getImage("Dancer1.png");
        Dancer1.sadpic = Toolkit.getDefaultToolkit().getImage("SadDancer.png");

        Tomato1 = new ThingThrown(50, 50, 3, 1, 40, 40);
        Tomato1.name = "Tomato1";
        Tomato1.pic = Toolkit.getDefaultToolkit().getImage("Tomato.png");

        Tomato2 = new ThingThrown(400, 302, 1, 3, 40, 40);
        Tomato2.name = "Tomato2";
        Tomato2.pic = Toolkit.getDefaultToolkit().getImage("Tomato.png");

        Flower1 = new ThingThrown(120, 433, 1, 3, 70, 70);
        Flower1.name = "Flower1";
        Flower1.pic = Toolkit.getDefaultToolkit().getImage("Flower.png");

        Spotlight = new Spotlight(0, 0, 1, 0, 100, 100);
        Spotlight.name = "Spotlight";
        Spotlight.pic = Toolkit.getDefaultToolkit().getImage("Spotlight.png");


    } // end BasicGameApp constructor


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            collide();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    public void moveThings() {
        Dancer1.glide();
        Dancer1.printInfo();
        Tomato1.tomatotoss();
        Tomato1.printInfo();
        Tomato2.tomatotoss();
        Tomato2.printInfo();
        Flower1.flowertoss();
        Flower1.printInfo();
        Spotlight.wrap();

        //call the move() code for each object
    }

    public void collide() {
                if (Tomato1.hitbox.intersects(Dancer1.hitbox) == true && DancerVSTomato1 == false) {
                    DancerVSTomato1 = true;
                    Tomato1.dx = -Tomato1.dx;
                    Tomato1.dy = -Tomato1.dy;
                    Dancer1.dx = -Dancer1.dx;
                    Dancer1.dy = -Dancer1.dy;
                    Tomato1.width = Tomato1.width + 1;
                    Tomato1.height = Tomato1.height + 1;
                    Dancer1.width = Dancer1.width - 5;
                    Dancer1.height = Dancer1.height - 5;
                    Dancer1.isHappy = false;


        }
        if (Tomato1.hitbox.intersects(Dancer1.hitbox) == false) { // resets the collision boolean as soon as they separate
            DancerVSTomato1 = false;
        }

        if (Tomato2.hitbox.intersects(Dancer1.hitbox) == true && DancerVSTomato2 == false) {
            DancerVSTomato2 = true;
            Tomato2.dx = -Tomato2.dx;
            Tomato2.dy = -Tomato2.dy;
            Dancer1.dx = -Dancer1.dx;
            Dancer1.dy = -Dancer1.dy;
            Tomato2.width = Tomato2.width + 1;
            Tomato2.height = Tomato2.height + 1;
            Dancer1.width = Dancer1.width - 5;
            Dancer1.height = Dancer1.height - 5;
            Dancer1.isHappy = false;

        }
        if (Tomato2.hitbox.intersects(Dancer1.hitbox) == false) { // resets the collision boolean as soon as they separate
            DancerVSTomato2 = false;
        }

        if (Tomato1.hitbox.intersects(Tomato2.hitbox)){
            Tomato1.dx = -Tomato1.dx;
            Tomato1.dy = -Tomato1.dy;
            Tomato2.dx = -Tomato2.dx;
            Tomato2.dy = -Tomato2.dy;

        }

        if (Flower1.hitbox.intersects(Dancer1.hitbox) == true && DancerVSFlower1 == false) {
            DancerVSFlower1 = true;
            Flower1.dx = -Flower1.dx;
            Flower1.dy = -Flower1.dy;
            Dancer1.dx = -Dancer1.dx;
            Dancer1.dy = -Dancer1.dy;
            Flower1.width = Flower1.width + 1;
            Flower1.height = Flower1.height + 1;
            Dancer1.width = Dancer1.width + 10;
            Dancer1.height = Dancer1.height + 10;
            Dancer1.isHappy = true;


        }
        if (Flower1.hitbox.intersects(Dancer1.hitbox) == false) { // resets the collision boolean as soon as they separate
            DancerVSFlower1 = false;
        }

        if (Flower1.hitbox.intersects(Tomato1.hitbox)){
            Flower1.dx = -Flower1.dx;
            Flower1.dy = -Flower1.dy;
            Tomato1.dx = -Tomato1.dx;
            Tomato1.dy = -Tomato1.dy;

        }

        if (Flower1.hitbox.intersects(Tomato2.hitbox)){
            Flower1.dx = -Flower1.dx;
            Flower1.dy = -Flower1.dy;
            Tomato2.dx = -Tomato2.dx;
            Tomato2.dy = -Tomato2.dy;

        }
    }



    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        g.drawImage(backgroundPic, 0, 0, WIDTH, HEIGHT, null);
        if (Dancer1.isHappy == true) {
            System.out.println("HAPPY");
            g.drawImage(Dancer1.pic, Dancer1.xpos, Dancer1.ypos, Dancer1.width, Dancer1.height, null);
        }
        else {
            g.drawImage(Dancer1.sadpic, Dancer1.xpos, Dancer1.ypos, Dancer1.width, Dancer1.height, null);
            System.out.println("SAD");
        }
        g.drawRect(Dancer1.hitbox.x, Dancer1.hitbox.y, Dancer1.hitbox.width, Dancer1.hitbox.height);

        g.drawImage(Tomato1.pic, Tomato1.xpos, Tomato1.ypos, Tomato1.width, Tomato1.height, null);
        g.drawRect(Tomato1.hitbox.x, Tomato1.hitbox.y, Tomato1.hitbox.width, Tomato1.hitbox.height);

        g.drawImage(Tomato2.pic, Tomato2.xpos, Tomato2.ypos, Tomato2.width, Tomato2.height, null);
        g.drawRect(Tomato2.hitbox.x, Tomato2.hitbox.y, Tomato2.hitbox.width, Tomato2.hitbox.height);

        g.drawImage(Flower1.pic, Flower1.xpos, Flower1.ypos, Flower1.width, Flower1.height, null);
        g.drawRect(Flower1.hitbox.x, Flower1.hitbox.y, Flower1.hitbox.width, Flower1.hitbox.height);

        g.drawImage(Spotlight.pic, Spotlight.xpos, Spotlight.ypos, Spotlight.width, Spotlight.height, null);

        g.dispose();
        bufferStrategy.show();
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }
}