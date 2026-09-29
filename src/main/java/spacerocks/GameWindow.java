package spacerocks;

import javax.swing.JFrame;

class GameWindow{
    private final JFrame frame;
    private final GamePanel panel;

    public GameWindow(SpaceRocks game) {
        frame = new JFrame("Space Rocks"); // Title Bar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing the window terminates program
        frame.setResizable(false); //panel is a fixed size, so the window is too

        panel = new GamePanel(game); //the window contains the panel, the panel does the drawing
        frame.add(panel);
        frame.pack(); //sizes the window to fit the panel's preferred size

        frame.setLocationRelativeTo(null); //center of screen
        frame.setVisible(true); //pops up on your screen
        panel.requestFocusInWindow(); //so key presses go to the panel
    }

    public GamePanel getPanel(){
        return panel;
    }
}
