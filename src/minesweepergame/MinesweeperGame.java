package minesweepergame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;

public class MinesweeperGame extends JFrame implements ActionListener {

    MineSweeperImpl msi = new MineSweeperImpl();
    JButton[][] list = new JButton[8][8];
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    Dimension frameD = new Dimension(350, 400);
    Dimension PanalD = new Dimension(500, 400);
    public MinesweeperGame() {

    }

    void initComponents() {

        setTitle("MineSweep");
        setMinimumSize(frameD);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        jPanel2.setSize(450, 450);
        jPanel2.setVisible(true);
        jPanel2.setBorder(new ButtonBorder(Color.black, Color.darkGray, Color.lightGray, Color.lightGray));

        jPanel3.setSize(450, 100);
        Button b = new Button("restart");
        b.addActionListener(this);
        jPanel3.add(b);
        jPanel3.setVisible(true);
        initPanel();
        
        jPanel2.add(jPanel3);
        jPanel2.add(jPanel1);
        this.add(jPanel2);
        jPanel1.setVisible(true);
        setVisible(true);
    }
    
    void initPanel(){
        jPanel1.setMinimumSize(PanalD);
        jPanel1.setBorder(new ButtonBorder(Color.black, Color.darkGray, Color.lightGray, Color.lightGray));

        GridLayout gl = new GridLayout(8, 8);
        jPanel1.setLayout(gl);
        ButtonBorder br = new BasicBorders.ButtonBorder(Color.black, Color.darkGray, Color.lightGray, Color.lightGray);
        Icon icn =new ImageIcon("tile.png");
        Font f=new Font("Serif", Font.BOLD, 20);
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                list[i][j] = new JButton(i + " " + j,icn);
                list[i][j].setVisible(true);
                list[i][j].setFont(f);
                list[i][j].setBorder(br);
                list[i][j].addActionListener(this);
                jPanel1.add(list[i][j]); //adds button to grid
            }
        }
    }
    static MinesweeperGame mine;
    public static void main(String args[]) {
        mine = new MinesweeperGame();
        mine.initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("restart")) {
            this.dispose();
            mine= new MinesweeperGame();
            mine.initComponents();

        } else {
            int i = e.getActionCommand().charAt(0) - 48;
            int j = e.getActionCommand().charAt(2) - 48;
            int ans = msi.clicked(i, j);

            switch (ans) {
                case 9:
                    list[i][j].setText("X");
                    list[i][j].setBackground(Color.red);
                    msi.gameOver(list);
                    break;
                case 0:
                    msi.openZeros(list, i, j);
                    break;
                default:
                    list[i][j].setText(Integer.toString(ans));
                    list[i][j].setEnabled(false);
                    list[i][j].setBackground(Color.yellow);
                    break;
            }
        }
    }
}
