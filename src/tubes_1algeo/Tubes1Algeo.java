/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes_1algeo;

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Tubes1Algeo {
    
    public static void main(String[] args) {
        bacaMenu();
    }
    
    public static void menu(){
        System.out.println("\nMENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Tambah Matriks");
        System.out.println("5. Kurang Matriks");
        System.out.println("6. Kali Matriks");
        System.out.println("7. Keluar");
        System.out.println();
        System.out.print("Pilih menu (1-7): ");
    }
    public static void pil1(){
        System.out.println("1. Metode eliminasi Gauss ");
        System.out.println("2. Metode matriks balikan");
        System.out.println();
        System.out.print("Pilih sub-menu (1-2): ");
    }
    public static void bacaMenu(){
        Scanner scan = new Scanner(System.in);
        menu();
        MATRIKS m1 = new MATRIKS();
        MATRIKS m2 = new MATRIKS();
        MATRIKS mhasil = new MATRIKS();
        Determinan deter = new Determinan();
        Matriks_Balikan invers = new Matriks_Balikan();
        OperasiMatriks  opr = new OperasiMatriks();
        int pilihan = scan.nextInt();
        switch(pilihan){
            case 1: //SPL
                pil1();
                int metode1 = scan.nextInt();
                switch(metode1){                    
                    case 1: //Metode eliminasi Gaus
                        System.out.println("\n=== Eliminasi Gauss ===");
                        System.out.print("Masukkan jumlah persamaan: ");
                        int i = scan.nextInt();
                        System.out.print("Masukkan jumlah peubah: ");
                        int j = scan.nextInt();   
                        m1.SetBrs(i);
                        m1.SetKol(j+1);
                        m1.keyboardSPL(i,j+1);

                        m1.eliminasiGauss();
                        double[][] solusi = new double[100][100];
                        int[] jumlahSolusi = new int[1];

                        m1.eliminasiGauss();
                        System.out.println();                          
                        //Menuliskan solusi
                        m1.solusiEliminasiGauss(solusi, jumlahSolusi);
                        m1.tulisSolusi(solusi);
                        System.out.println();
                        System.out.println("Menuju menu utama......");
                        break;
                        
                    case 2: //Metode matriks balikan1   
                        System.out.println("Masukkan matriks augmented. (Kolom terakhir adalah hasil)");
                        m1.bacaMatriks1();
                        System.out.println("Matriks yang diinputkan: ");
                        m1.tulisMatriks();
                        System.out.println("\nSolusi SPL adalah: ");
                        m1.balikan();                       
                        break;
                    default:
                        System.out.println("Menu tidak tersedia.\n");
                }
                bacaMenu();
                break;
            case 2: //Determinan
                m1.bacaMatriks1();
                System.out.println("Matriks yang diinputkan: ");
                m1.tulisMatriks();
                if (m1.isSquare()){
                    System.out.println("\nDeterminannya adalah " + deter.detKofaktor(m1));
                } else{
                    System.out.println("\nBukan matriks persegi, determinan tidak dapat dicari.");
                }
                bacaMenu();
                break;
            case 3: //Matriks balikan
                m1.bacaMatriks1();
                System.out.println("Matriks yang diinputkan: ");
                m1.tulisMatriks();
                if (m1.isSquare()){
                    if(deter.detKofaktor(m1) == 0){
                        System.out.println("\nTidak memiliki Invers");
                    } else{
                        mhasil = invers.MatriksBalikanAdjoin(m1);
                        System.out.println("\nHasil invers matriks: ");
                        mhasil.tulisMatriks();
                    }
                } else{
                    System.out.println("\nBukan matriks persegi, invers tidak dapat dicari.");
                }
                bacaMenu();
                break;
            case 4:
                System.out.println("Matriks 1:");
                m1.bacaMatriks1();  
                System.out.println("Matriks yang diinputkan: ");
                m1.tulisMatriks();
                System.out.println("Matriks 2:");
                m2.bacaMatriks1();
                System.out.println("Matriks yang diinputkan: ");
                m2.tulisMatriks();
                if(m1.getBrs() == m2.getBrs() && m1.getKol() == m2.getKol()){
                    System.out.println("\nHasil tambah:");
                    mhasil = opr.tambah(m1, m2);
                    mhasil.tulisMatriks();
                }else {
                    System.out.println("Ordo tidak sama.");
                }
                bacaMenu();
                break;
            case 5:
                System.out.println("Matriks 1:");
                m1.bacaMatriks1();  
                System.out.println("Matriks yang diinputkan: ");
                m1.tulisMatriks();
                System.out.println("Matriks 2:");
                m2.bacaMatriks1();
                System.out.println("Matriks yang diinputkan: ");
                m2.tulisMatriks();
                if(m1.getBrs() == m2.getBrs() && m1.getKol() == m2.getKol()){
                    System.out.println("\nHasil kurang:");
                    mhasil = opr.kurang(m1, m2);
                    mhasil.tulisMatriks();
                }else {
                    System.out.println("Ordo tidak sama.");
                }
                bacaMenu();
                break;
             case 6:
                System.out.println("Matriks 1:");
                m1.bacaMatriks1();  
                System.out.println("Matriks yang diinputkan: ");
                m1.tulisMatriks();
                System.out.println("Matriks 2:");
                m2.bacaMatriks1();
                System.out.println("Matriks yang diinputkan: ");
                m2.tulisMatriks();
                if(m1.getKol() == m2.getBrs()){
                    System.out.println("\nHasil kali:");
                    mhasil = opr.kaliMatriks(m1, m2);
                    mhasil.tulisMatriks();
                }else {
                    System.out.println("Ordo tidak valid.");
                }
                bacaMenu();
                break;
            case 7: //Keluar
                System.out.println("Terima kasih :)");
                break;
            default:
                System.out.println("Menu tidak tersedia.\n");
                bacaMenu();
        }
    }
}