/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author 仑
 */
public class RecordIO {

    String fileName = "E:\\Education\\Courses\\Java\\WordingReport.txt";
    QFrame qfin;

    public RecordIO(QFrame QFin) {
        qfin = QFin;
    }

    public void savarecord() throws IOException, ClassNotFoundException {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));

            bw.newLine();
            bw.write(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            bw.newLine();
            bw.write("User: " + qfin.username);
            bw.newLine();
            bw.write("ID." + qfin.idnumber);
            bw.newLine();
            bw.write("Number of Total Questions : " + qfin.question_count);
            bw.newLine();
            bw.write("Number of Right Answers : " + qfin.true_count);
            bw.newLine();
            bw.write("Accuracy Rate : " + ((float) (qfin.true_count) / (float) (qfin.question_count)) * 100 + "%");
            bw.newLine();
            bw.write("Total Time Used : " + qfin.second_recorded + " s");
            bw.newLine();

            bw.close();
        } catch (IOException iox) {
            System.out.println("Problem writing " + fileName);
        }
    }

    public static void main(String[] args) {
        try {
            new RecordIO(new QFrame(new SettingFrame(new LoginFrame()))).savarecord();
        } catch (Exception e) {
        }
    }
}
