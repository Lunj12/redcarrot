/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author 仑
 */
public class Blanksprep {

    ArrayList<String> buffer = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();
    String word;
    int bn;

    public Blanksprep(String wordin, int blank_number) {
        word = wordin;
        bn = blank_number;
        splitString(word);
    }

    public void splitString(String str) {
        int i;
        for (i = 0; i < str.length(); i++) {
            buffer.add(str.substring(i, i + 1));
        }
    }

    public String getresult() {
        int[] blank_indices = new int[bn];
        String result;
        int random_number = 0;

        for (int i = 0; i < bn; i++) {
            int flag = 0;

            while (flag == 0) {
                random_number = (int) (Math.random() * word.length());
                flag = 1;
                for (int j = 0; j < i; j++) {
                    if (random_number == blank_indices[j]) {
                        flag = 0;
                    }
                }
            }
            blank_indices[i] = random_number;
            
        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < bn; j++) {
                if (i == blank_indices[j]) {
                    buffer.set(i, "_");
                }
            }
        }
        for (int i = 0; i < bn; i++) {
            System.out.println(blank_indices[i]);
        }
        for (int i = 0; i < buffer.size(); i++) {
            System.out.println(buffer.get(i));
        }

        result = String.join("", buffer);

        return result;
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        Blanksprep bp = new Blanksprep(a, 3);
//        for(int i=0;i<bp.buffer.size();i++){System.out.println(bp.buffer.get(i));}
        System.out.println(bp.getresult());

    }
}
