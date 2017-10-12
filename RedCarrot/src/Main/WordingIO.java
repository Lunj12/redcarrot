/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.*;
import java.io.File;
import jxl.*;

/**
 *
 * @author 仑
 */
public class WordingIO {

    int vocabulary;
    ArrayList word_en = new ArrayList();
    ArrayList word_cn = new ArrayList();
    String myCurrentDir = System.getProperty("user.dir"); 
    File wordsxls = new File(myCurrentDir + "\\GREwords.xls");
    Workbook book;
    Sheet sheet;
    Cell cell1, cell2, cell3;
    int word_index = 0;

    public WordingIO() {
        word_index = (int) (Math.random() * 6193);
    }

    public WordingIO(int vocabulary_in) {
        vocabulary = vocabulary_in;
        if (vocabulary == 0) {
            wordsxls = new File(myCurrentDir + "\\GREwords.xls");
            word_index = (int) (Math.random() * 6193);
        }
        
        if (vocabulary == 1) {
            wordsxls = new File("E:\\Education\\Courses\\Java\\TOEFLwords.xls");
            word_index = (int) (Math.random() * 2922);
        }
        
    }

    public String getword_en() {

        try {
            book = Workbook.getWorkbook(wordsxls);
            sheet = book.getSheet(0);
            cell1 = sheet.getCell(0, word_index);

            //   System.out.println(cell1.getContents());
            book.close();
        } catch (Exception e) {
        }
        return cell1.getContents();
    }

    public String getword_cn() {

        try {
            book = Workbook.getWorkbook(wordsxls);
            sheet = book.getSheet(0);
            cell1 = sheet.getCell(1, word_index);

            //   System.out.println(cell1.getContents());
            book.close();
        } catch (Exception e) {
        }
        return cell1.getContents();
    }

    public static void main(String[] args) {

        WordingIO test = new WordingIO(1);
        String str1 = test.getword_en();
        String str2 = test.getword_cn();
        System.out.println(str1 + " " + str2);
    }

}
