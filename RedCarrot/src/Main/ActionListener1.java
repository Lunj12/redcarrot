/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author 仑
 */
public class ActionListener1 implements ActionListener {

    int time;
    JLabel jlbout;
    String answer;
    Timer tm1;

    public ActionListener1(int t, JLabel jlb) {
        time = t;
        jlbout = jlb;


    }

    public void actionPerformed(ActionEvent evt) {
        if (time >= 0) {
            jlbout.setText(time + "s");
            time--;
        }

    }
};
