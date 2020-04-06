package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Klasa odpowiedzialna za obsługę zdarzeń z pochodzących z graficznego interfejsu użytkownika
 */

public class Menu extends JPanel{
    /** Zmienna przechowująca obrazek tła*/
    private ImageIcon MainMenuImage;

    public Menu() {
        this.removeAll();
        initializeLayout();
        initializeVariables();
        Fonts fontName = new Fonts();
        Color aqua = new Color (51, 134, 175);
        Color citron = new Color (200, 220, 24);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton startButton = new JButton("Start!");
        JButton rankingButton = new JButton("Best Scores");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeAll();
                repaint();
                revalidate();
                setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.fill = GridBagConstraints.BOTH;
                add(new Name(getWidth(),getHeight()), gbc);

            }
        });

        startButton.setFont(fontName.getFont(32));
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setForeground(citron);


        rankingButton.setFont(fontName.getFont(32));
        rankingButton.setOpaque(false);
        rankingButton.setContentAreaFilled(false);
        rankingButton.setBorderPainted(false);
        rankingButton.setForeground(citron);


        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.insets = new Insets(15, 15, 15, 15);
        this.add(startButton, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = -1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(15, 15, 15, 15);
        this.add(rankingButton, gbc);

        //gbc.gridx = 0;
        //gbc.gridy = 3;
        //components_container.add(b_instructions, gbc);





    }
    /** metoda inicjalizująca obrazek tła za pomocą metody obiektu ImageFactory*/
    private void initializeVariables() {
        this.MainMenuImage = ImageFactory.createImage(Image.MainMenu);
        }

    /** metoda ustawiająca rozmiar okna za pomocą danych z pliku Config.txt*/
    private void initializeLayout() {
        setPreferredSize(new Dimension(PropertiesLoad.xSize, PropertiesLoad.ySize));
    }

    /** metoda przesłaniająca metodę paintComponent, w celu odpowiedniego skalowania obrazka w tle*/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MainMenuImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

    }
    

}
