import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameJFrame extends JFrame{
    private int[][] DataArr = new int[3][3];
    private  int person = 1;
    public GameJFrame() {
        BuildJFrame();
        BuildMenuBar();
        InitData();
        BuildImage();
        this.setVisible(true);
    }
    private void BuildJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(616, 863);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
    private void BuildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu GameMenu = new JMenu("Game");
        JMenu AboutMenu = new JMenu("About");

        JMenuItem NewGame = new JMenuItem("New Game");
        NewGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                person = 1;
                InitData();
                BuildImage();
            }
        });
        JMenuItem ExitGame = new JMenuItem("Exit");
        ExitGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        GameMenu.add(NewGame);
        GameMenu.add(ExitGame);

        JMenuItem Help = new JMenuItem("Help");
        AboutMenu.add(Help);

        menuBar.add(GameMenu);
        menuBar.add(AboutMenu);

        this.setJMenuBar(menuBar);
    }
    private void InitData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                DataArr[i][j] = 0;
            }
        }
    }
    private void BuildImage() {
        this.getContentPane().repaint();
        this.getContentPane().removeAll();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (DataArr[i][j] == 0) {
                    ImageIcon img = new ImageIcon("images//Space.jpg");
                    JButton button = new JButton(img);
                    button.setBounds(200 * i, 200 + 200 * j, 200, 200);
                    button.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    final int row = i;
                    final int col = j;
                    button.addActionListener((e) -> {
                        if (person == 1) {
                            DataArr[row][col] = 1;
                            person = 2;
                            System.out.println(row + " " + col + "变黑");
                            for (int y = 0; y < 3; y++) {
                                for (int x = 0; x < 3; x++) {
                                    System.out.print(DataArr[y][x] + " ");
                                }
                                System.out.println();
                            }
                            BuildImage();
                        } else if (person == 2) {
                            DataArr[row][col] = 2;
                            person = 1;
                            System.out.println(row + " " + col + "变白");
                            BuildImage();
                        }
                    });
                    this.getContentPane().add(button);

                } else if (DataArr[i][j] == 1) {
                    ImageIcon img = new ImageIcon("images//Black.jpg");
                    JLabel label = new JLabel(img);
                    label.setBounds( 200 * i, 200 + 200 * j, 200, 200);
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(label);
                } else if (DataArr[i][j] == 2) {
                    ImageIcon img = new ImageIcon("images//White.jpg");
                    JLabel label = new JLabel(img);
                    label.setBounds(200 * i, 200 + 200 * j, 200, 200);
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(label);
                }
            }
            if (isVictory() == 0) {
                if (person == 1) {
                    ImageIcon img = new ImageIcon("images//NowIsBlack.jpg");
                    JLabel label = new JLabel(img);
                    label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(label);
                } else if (person == 2) {
                    ImageIcon img = new ImageIcon("images//NowIsWhite.jpg");
                    JLabel label = new JLabel(img);
                    label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(label);
                }
            } else if (isVictory() == 1) {
                person = 0;
                ImageIcon img = new ImageIcon("images//BlackWin.jpg");
                JLabel label = new JLabel(img);
                label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(label);
            } else if (isVictory() == 2) {
                person = 0;
                ImageIcon img = new ImageIcon("images//WhiteWin.jpg");
                JLabel label = new JLabel(img);
                label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(label);
            } else if (isVictory() == 3) {
                person = 0;
                ImageIcon img = new ImageIcon("images//Nobody.jpg");
                JLabel label = new JLabel(img);
                label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(label);
            }
            this.getContentPane().repaint();
        }
    }
    private int isVictory() {
        for (int i = 0; i < 3; i++) {
            if ((DataArr[i][0] == 1) && (DataArr[i][1] == 1) && (DataArr[i][2] == 1)) {
                return 1;
            } else if ((DataArr[i][0] == 2) && (DataArr[i][1] == 2) && (DataArr[i][2] == 2)) {
                return 2;
            }
        }
        for (int i = 0; i < 3; i++) {
            if ((DataArr[0][i] == 1) && (DataArr[1][i] == 1) && (DataArr[2][i] == 1)) {
                return 1;
            } else if ((DataArr[0][i] == 2) && (DataArr[1][i] == 2) && (DataArr[2][i] == 2)) {
                return 2;
            }
        }
        if ((DataArr[0][0] == 1) && (DataArr[1][1] == 1) && (DataArr[2][2] == 1)) {
            return 1;
        } else if ((DataArr[0][0] == 2) && (DataArr[1][1] == 2) && (DataArr[2][2] == 2)) {
            return 2;
        }
        if ((DataArr[0][2] == 1) && (DataArr[1][1] == 1) && (DataArr[2][0] == 1)) {
            return 1;
        } else if ((DataArr[0][2] == 2) && (DataArr[1][1] == 2) && (DataArr[2][0] == 2)) {
            return 2;
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (DataArr[i][j] != 0) {
                    count++;
                }
            }
        }
        if (count == 9) {
            return 3;
        }
        return 0;
    }
}
