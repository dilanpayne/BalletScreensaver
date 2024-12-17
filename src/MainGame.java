public class MainGame {
    //Character santa;

    public static void main(String[] args) {
        MainGame myGame = new MainGame();
    }

    public MainGame() {
        setUpGraphics();
        run();
    }

    public void setUpGraphics() {
        // brings up game window, allows us to draw images on it
    }

    public void moveThings() {
    }

    public void render(){
        // draw character images to the screen

    }

    public void pause(){
    }

    public void run() {
        while (true) { // game loop
            System.out.println("WHILE LOOP in run function in MainGame");;
            //moveThings();
            //render();
            //pause();
        }
    }

}
