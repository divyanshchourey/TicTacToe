import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame = new JFrame("TicTacToe");
    TicTacToeLogic gameLogic = new TicTacToeLogic();
    JLabel playerStatus = new JLabel("Player: "+((gameLogic.player == gameLogic.X)? 1 : 2));
    JButton btn00 = new JButton(" ");
    JButton btn01 = new JButton(" ");
    JButton btn02 = new JButton(" ");
    JButton btn10 = new JButton(" ");
    JButton btn11 = new JButton(" ");
    JButton btn12 = new JButton(" ");
    JButton btn20 = new JButton(" ");
    JButton btn21 = new JButton(" ");
    JButton btn22 = new JButton(" ");
    Color frameColor = new Color(242, 218, 187);
    Font btnFont = new Font("Arial", 1, 20);

    public GUI(){
        frame.setBounds(200, 200, 400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(frameColor);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawLine(155, 90, 155, 280); // Horizontal line
                g.drawLine(155+60, 90, 155+60, 280); // Vertical line
                g.drawLine(90, 155, 280, 155);
                g.drawLine(90, 155+60, 280, 155+60); // Diagonal line
            }
        };

        drawingPanel.setBounds(0, 0, 500, 350);
//        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setOpaque(false);
        frame.add(drawingPanel);

        gameLogic.clearBoard();

    }

    public void showLabels(){
        JLabel title = new JLabel("TicTacToe");
        title.setBounds(110, 20, 150, 25);
        title.setFont(new Font("Arial", 1, 30));
        title.setForeground(new Color(214, 124, 6));
        frame.add(title);

        playerStatus.setBounds(100, 60, 100, 20);
        playerStatus.setFont(new Font("Arial", 2, 15));
        frame.add(playerStatus);
    }

    public void showButton(){

        btn00.setBounds(100, 100, 50, 50);
        btn00.setBackground(frameColor);
        btn00.addActionListener(this);
        btn00.setBorderPainted(false);
        btn00.setFocusPainted(false);
        btn00.setContentAreaFilled(false);
        btn00.setOpaque(false);
        btn00.setActionCommand("00");
        btn00.setFont(btnFont);
        frame.add(btn00);

        btn01.setBounds( 160, 100,50, 50);
        btn01.addActionListener(this);
        btn01.setActionCommand("01");
        btn01.setBorderPainted(false);
        btn01.setFocusPainted(false);
        btn01.setContentAreaFilled(false);
        btn01.setOpaque(false);
        btn01.setFont(btnFont);
        frame.add(btn01);

        btn02.setBounds( 220, 100,50, 50);
        btn02.addActionListener(this);
        btn02.setActionCommand("02");
        btn02.setBorderPainted(false);
        btn02.setFocusPainted(false);
        btn02.setContentAreaFilled(false);
        btn02.setOpaque(false);
        btn02.setFont(btnFont);
        frame.add(btn02);

        btn10.setBounds(100, 160, 50, 50);
        btn10.addActionListener(this);
        btn10.setActionCommand("10");
        btn10.setBorderPainted(false);
        btn10.setFocusPainted(false);
        btn10.setContentAreaFilled(false);
        btn10.setOpaque(false);
        btn10.setFont(btnFont);
        frame.add(btn10);

        btn11.setBounds( 160, 160,50, 50);
        btn11.addActionListener(this);
        btn11.setActionCommand("11");
        btn11.setBorderPainted(false);
        btn11.setFocusPainted(false);
        btn11.setContentAreaFilled(false);
        btn11.setOpaque(false);
        btn11.setFont(btnFont);
        frame.add(btn11);

        btn12.setBounds( 220, 160,50, 50);
        btn12.addActionListener(this);
        btn12.setActionCommand("12");
        btn12.setBorderPainted(false);
        btn12.setFocusPainted(false);
        btn12.setContentAreaFilled(false);
        btn12.setOpaque(false);
        btn12.setFont(btnFont);
        frame.add(btn12);

        btn20.setBounds(100, 220, 50, 50);
        btn20.addActionListener(this);
        btn20.setActionCommand("20");
        btn20.setBorderPainted(false);
        btn20.setFocusPainted(false);
        btn20.setContentAreaFilled(false);
        btn20.setOpaque(false);
        btn20.setFont(btnFont);
        frame.add(btn20);

        btn21.setBounds( 160, 220,50, 50);
        btn21.addActionListener(this);
        btn21.setActionCommand("21");
        btn21.setBorderPainted(false);
        btn21.setFocusPainted(false);
        btn21.setContentAreaFilled(false);
        btn21.setOpaque(false);
        btn21.setFont(btnFont);
        frame.add(btn21);

        btn22.setBounds( 220, 220,50, 50);
        btn22.addActionListener(this);
        btn22.setActionCommand("22");
        btn22.setBorderPainted(false);
        btn22.setFocusPainted(false);
        btn22.setContentAreaFilled(false);
        btn22.setOpaque(false);
        btn22.setFont(btnFont);
        frame.add(btn22);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("Button " + command + " clicked!");

        if(command.equals("00")){
            btn00.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(0, 0);
        } else if(command.equals("01")) {
            btn01.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(0, 1);
        } else if(command.equals("02")) {
            btn02.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(0, 2);
        } else if(command.equals("10")) {
            btn10.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(1, 0);
        } else if(command.equals("11")) {
            btn11.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(1, 1);
        } else if(command.equals("12")) {
            btn12.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(1, 2);
        } else if(command.equals("20")) {
            btn20.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(2, 0);
        } else if(command.equals("21")) {
            btn21.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(2, 1);
        } else if(command.equals("22")) {
            btn22.setText((gameLogic.player == gameLogic.X)? "X": "O");
            gameLogic.putMark(2, 2);
        } else {
            System.out.println("Other");
        }
        System.out.println(gameLogic);
        playerStatus.setText("Player: "+((gameLogic.player == gameLogic.X)? 1 : 2));
//        if(gameLogic.winner() == -1 || gameLogic.winner() == 0 || gameLogic.winner() == 1){
//            JOptionPane.showMessageDialog(frame, "Player: "+((gameLogic.player == gameLogic.X)? 1 : 2)+" Won");
//        }
        
        if((gameLogic.isWin((gameLogic.player == gameLogic.X)? gameLogic.O: gameLogic.X))){
            JOptionPane.showMessageDialog(frame, "Player: "+((gameLogic.player == gameLogic.X)? 2 : 1)+" Won");
            frame.dispose();
        } else if(gameLogic.isTie()){
            JOptionPane.showMessageDialog(frame, "Tie");
            frame.dispose();
        }

    }

}
