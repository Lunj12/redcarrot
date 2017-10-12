/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author 仑
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NewTaskFrame extends JFrame{
 /**
  * 
  */
 private static final long serialVersionUID = 1L;

 public static void main(String[] args)
  {
   NewTaskFrame newframe = new NewTaskFrame("新建下载任务");
   newframe.setSize(600,300);
   newframe.setLayout(null);
   newframe.setResizable(false);
   newframe.setLocation(300, 300);

newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   newframe.getContentPane().setBackground(Color.LIGHT_GRAY);
   newframe.setVisible(true);
  }
  
  public NewTaskFrame (String str)
  {
   super(str);
  }
}

