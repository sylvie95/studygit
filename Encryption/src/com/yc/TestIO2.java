package com.yc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestIO2 {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Administrator\\Desktop\\4309214522.txt"); //创建文件对象
try {
           // 通过文件对象创建文件输入流
            FileInputStream filein = new FileInputStream(f);
            //创建写入流
            File file=new File("C:\\Users\\Administrator\\Desktop\\test2.txt");
            if(!file.exists())
                file.createNewFile();
            FileOutputStream out=new FileOutputStream(file,false);
            StringBuffer sb=new StringBuffer();
            
          //创建字节数组，用于接收从文件中读取的字节
            byte buf[] = new byte[1024];
            String instr = ""; //接收字节转化的字符串
            int length = filein.read(buf);
            instr = new String(buf,0,length);//将字节转化成字符串   
            System.out.println(instr);
            
            //写入
            sb.append(instr);
            out.write(sb.toString().getBytes("utf-8"));
            
            filein.close();  //关闭输入流
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
}