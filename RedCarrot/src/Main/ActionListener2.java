/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author 仑
 */
public class ActionListener2 implements ActionListener {

    int time;
    JTextField jtfout;
    JLabel jlbout;
    JLabel jlb_message;
    JButton jbt_dis;
    String answer;
    Timer tm1;

    public ActionListener2(String str, JLabel jlb1, JLabel jlb2, JButton jbt) {

        jlbout = jlb1;
        answer = str;
        jlb_message = jlb2;
        jbt_dis = jbt;
    }

    public void actionPerformed(ActionEvent evt) {
        jlbout.setText(answer);
        jlb_message.setText("Time Out!");
        jbt_dis.setEnabled(false);
    }

}
