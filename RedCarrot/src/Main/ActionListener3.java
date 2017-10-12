/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 仑
 */
public class ActionListener3 implements ActionListener {

    QFrame qf_oprated;

    public ActionListener3(QFrame qfin) {
        qf_oprated = qfin;
    }

    public void actionPerformed(ActionEvent evt) {
        qf_oprated.second_recorded++;
//        System.out.println("action3 " + qf_oprated.second_recorded);
    }

}
