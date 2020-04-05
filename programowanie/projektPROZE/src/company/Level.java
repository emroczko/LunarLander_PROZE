package company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.TimerTask;

public class Level extends JPanel{
    private ImageIcon backgroundImage;
    private Timer timer;
    private Lander lander;
    private boolean inGame = true;

    public Level() {
        initializeVariables();
        initializeLayout();
    }

    private void initializeVariables() {
        this.lander = new Lander();
        this.backgroundImage = ImageFactory.createImage(Image.Earth1);
        this.timer = new Timer(10, new GameLoop(this));
        this.timer.start();

    }

    private void initializeLayout() {
        setPreferredSize(new Dimension(PropertiesLoad.xSize, PropertiesLoad.ySize));
    }

    private void drawPlayer(Graphics g) {
        g.drawImage(lander.getImage(), lander.getX(), lander.getY(), this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            drawPlayer(g);
        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
            Toolkit.getDefaultToolkit().sync();
        }
    }
    public void doOneLoop(){
        this.update();
        this.repaint();
    }

    private void update(){

    }


}



