package ru.geekbrains.Home6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class home6 {
    static String ABC = "0ABCDEFGHIGKLMWXYZ12345NOPQRSTUV6789";
    static Random rnd = new Random();

    public static void main(String[] args) {
        createFile("1.txt",createString(100));
        createFile("2.txt",createString(100));
    }
    public static String createString(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            sb.append(ABC.charAt(rnd.nextInt(ABC.length())));
        }
        return sb.toString();
    }

    public static void createFile(String fileName, String text){
        try{
            PrintWriter pw = new PrintWriter(fileName);
            pw.write(text);
            pw.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}





package ru.geekbrains.Home6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class paste {
    static String ABC = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    public static void main(String[] args) {
        createFile("1.txt",createString(100));
        createFile("2.txt",createString(100));
        glueFiles (new String[]{"1.txt","2.txt"},"3.txt");
    }
    public static void glueFiles(String[] names, String distinationName){
        try{
            FileOutputStream fos = new FileOutputStream(distinationName);
            for (String name: names){
                FileInputStream fis = new FileInputStream(name);
                int i;
                do {
                    i = fis.read();
                    if(i != -1){
                        fos.write(i);
                    }
                }while (i != -1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String createString(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            sb.append(ABC.charAt(rnd.nextInt(ABC.length())));
        }
        return sb.toString();
    }

    public static void createFile(String fileName, String text){
        try{
            PrintWriter pw = new PrintWriter(fileName);
            pw.write(text);
            pw.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}




package ru.geekbrains.Home6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class search extends Object {
    public static void main(String[] args) {
        serchFile("Love.txt","Good morning");
    }
    public static void serchFile(String fileName, String word){
        try{
            FileInputStream fileInputStream = new FileInputStream("Love.txt");
            int symbol = 0;
            int index = 0;
            byte[] wordBytes = word.getBytes();
            do{
                symbol = fileInputStream.read();
                if (wordBytes[index] == symbol){
                    index++;
                    if (index == wordBytes.length){
                        System.out.println("Слово найдено.");
                        break;
                    }
                }else{
                    index = 0;
                }
            }while (symbol != -1);


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
