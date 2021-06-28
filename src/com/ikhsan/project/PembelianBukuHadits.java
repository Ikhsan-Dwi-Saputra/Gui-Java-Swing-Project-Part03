package com.ikhsan.project;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.UIManager.*;


public class PembelianBukuHadits{
    private JPanel base;
    private JLabel tiga;
    private JLabel empat;
    private JButton beliButton;
    private JTextArea output;
    private JTable ScrolPane;
    private JLabel satu;
    private JLabel dua;
    private JLabel Lima;
    private JLabel enam;
    private JLabel tujuh;
    private JLabel delapan;
    private JCheckBox syarahShahihMuslimCheckBox;
    private JCheckBox kumpulanHadistShahihBukhariCheckBox;
    private JCheckBox shahihBukhariMuslimCheckBox;
    private JCheckBox shahihHadistQudsiCheckBox;
    private JCheckBox riyadushShalihinCheckBox;
    private JCheckBox hadisTarbawaiCheckBox;
    private JCheckBox syarahHaditsArbaInCheckBox;
    private JCheckBox mencapaiShalatKhusyukCheckBox;
    private JTextField textField1;
    private JTable tableoutput;
    private JButton hitungButton;
    private JLabel hargaSatu;
    private JTextArea outputTextArea;
    private JTextField textFieldOutput;
    private JButton hapusButton;
    private DefaultTableModel tableModel;


    public PembelianBukuHadits() {
        this.Ascending();

        //-------------->Look And Feel
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        //TOMBOL SIMPAN
        beliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MENGAMBIL NAMA USER
                String nama = textField1.getText();

                //STACK <-----------------
                Stack<String> namabuku = new Stack<>();
                //NAMA BUKU HADIST
                namabuku.push("Syarah Shahih Muslim");
                namabuku.push("Kumpulan Hadits Shahih");
                namabuku.push("Shahih Bukhari Muslim");
                namabuku.push("Shahih Hadits Qudsi");
                namabuku.push("Riyadush Shalihin");
                namabuku.push("Hadits tarbawi");
                namabuku.push("Syarah Hadits Arba");
                namabuku.push("Mencapai Shalat Khusyuk");

                //LINKED LIST <--------------------------
                LinkedList<Double> buku = new LinkedList<>();
                //HARGA BUKU HADITS
                buku.add(120.000);
                buku.add(220.000);
                buku.add(100.000);
                buku.add(300.000);
                buku.add(170.000);
                buku.add(190.000);
                buku.add(130.000);
                buku.add(90.000);

                //------------>OUTPUT
                if (syarahShahihMuslimCheckBox.isSelected() == true) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, namabuku.get(0), buku.get(0) + "00"});
                    syarahShahihMuslimCheckBox.setSelected(false);
                }
                if (kumpulanHadistShahihBukhariCheckBox.isSelected() == true) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, namabuku.get(1), buku.get(1) + "00"});
                    kumpulanHadistShahihBukhariCheckBox.setSelected(false);
                }
                if (shahihBukhariMuslimCheckBox.isSelected()) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, namabuku.get(2), buku.get(2) + "00"});
                    shahihBukhariMuslimCheckBox.setSelected(false);
                }
                if (shahihHadistQudsiCheckBox.isSelected()) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, namabuku.get(3), buku.get(3) + "00"});
                    shahihHadistQudsiCheckBox.setSelected(false);
                }
                if (riyadushShalihinCheckBox.isSelected()) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1,namabuku.get(4), buku.get(4) + "00"});
                    riyadushShalihinCheckBox.setSelected(false);
                }
                if (hadisTarbawaiCheckBox.isSelected()) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1,namabuku.get(5), buku.get(5) + "00"});
                    hadisTarbawaiCheckBox.setSelected(false);
                }
                if (syarahHaditsArbaInCheckBox.isSelected()) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1,namabuku.get(6), buku.get(6) + "00"});
                    syarahHaditsArbaInCheckBox.setSelected(false);
                }
                if (mencapaiShalatKhusyukCheckBox.isSelected()) {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1,namabuku.get(7), buku.get(7) + "00"});
                    mencapaiShalatKhusyukCheckBox.setSelected(false);
                }
                if (textField1.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Harap Isi Nama Terlebih Dahulu", "EROR", JOptionPane.ERROR_MESSAGE);
                }
                if (textField1.getText().isEmpty() == false)
                    outputTextArea.setText("Nama Pembeli : " + nama +
                            "\n"+"Jumlah Buku : " + tableModel.getRowCount());
            }
        });

        //--------------> TOMBOL HITUNG
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { int narrow = tableoutput.getRowCount();
                double sum = 0;
                for (int i = 0; i < narrow; i++) {
                    double val = Double.valueOf(tableoutput.getValueAt(i, 2).toString());
                    sum += val;
                }
                textFieldOutput.setText("Rp." + Double.toString(sum) + "00");
            }
        });


        //------------------->TOMBOL HAPUS
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get selected row index
                try {
                    int SelectedRowIndex = tableoutput.getSelectedRow();
                    tableModel.removeRow(SelectedRowIndex);

                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Silahkan Pilih Buku Yang Ingin Dihapus Di Table", "Eror", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    //-------------> PANEL
    public JPanel getBase() {
        return base;
    }


    //TABLE <----------------------
    private void Ascending() {
        Object[] tableColom = {

                "No",
                "Nama Buku",
                "Harga",
        };
        Object[][] iniData = {
        };
        tableModel = new DefaultTableModel(iniData, tableColom);
        //SET TABLE MODEL
        tableoutput.setModel(tableModel);
        }

    //----------------------> GAMBAR
    private void createUIComponents() {
        // TODO: place custom component creation code her
         satu = new JLabel (new ImageIcon("1.jpeg"));
         dua = new JLabel (new ImageIcon("2.png"));
         tiga = new JLabel (new ImageIcon("3.jpg"));
         empat = new JLabel (new ImageIcon("4.jpg"));
         Lima = new JLabel (new ImageIcon("5.jpg"));
         enam = new JLabel (new ImageIcon("6.jpg"));
         tujuh = new JLabel (new ImageIcon("7.jpg"));
         delapan = new JLabel (new ImageIcon("8.jpg"));



    }
}

