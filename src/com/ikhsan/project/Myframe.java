package com.ikhsan.project;

import javax.swing.*;

public class Myframe extends JFrame {

    Myframe (){
        JTextArea gambarsatu = new JTextArea();

        JFrame frame = new JFrame();

        frame.setTitle("Aplikasi Penjualan Buku Hadits");
        frame.setContentPane(new PembelianBukuHadits().getBase());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,510);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.show();
        frame.requestFocus();




        ImageIcon logo = new ImageIcon("10.jpg");
        frame.setIconImage(logo.getImage());
    }
}
