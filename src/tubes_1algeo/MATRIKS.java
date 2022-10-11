/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tubes_1algeo;
import java.util.Scanner;

public class MATRIKS {
    /*Tipe Matriks*/
    protected double[][] matriks;
    protected int baris;
    protected int kolom;
    Scanner input = new Scanner(System.in);
    
    /*Konstruktor*/
    MATRIKS(){
        matriks = new double[100][100];
    }
    public void MATRIKS(int i, int j){
        this.SetBrs(i);
        this.SetKol(j);
        matriks=new double[i+1][j+1];
    }
    public void makeMATRIKS(int i, int j){
        /*Membuat matriks kosong dengan ukuran ixj 
        semua elemen matriks berisi nilai 0*/
        this.baris=i;
        this.kolom=j;
        this.matriks = new double[this.baris][this.kolom];
        for (int a=0; a<baris; a++){
            for (int b=0; b<kolom; b++){
                this.matriks[a][b]=0;
            }
        }
    }
    
    public void makeMATRIKS2(int i, int j){
        /*Membuat matriks kosong dengan ukuran ixj 
        semua elemen matriks berisi nilai 1*/
        this.baris=i;
        this.kolom=j;
        this.matriks = new double[this.baris][this.kolom];
        for (int a=0; a<baris; a++){
            for (int b=0; b<kolom; b++){
                this.matriks[a][b]=1;
            }
        }
    }
    
    /*Selektor*/
    public int getBrs(){
        return baris;
    }
    
    public int getKol(){
        return kolom;
    }
    
    public double getElmt(int i, int j){
        /*Mendapatkan elemen indeks baris i dan indeks kolom j */
        return matriks[i][j];
    }
    
    public void SetBrs(int i){
        this.baris = i;
    }

    public void SetKol(int j){
        this.kolom = j;
    }
    
    public void SetElmt(int i, int j, double x){
        this.matriks[i][j] = x;
    }
    
    /****Fungsi pada Matriks****/
    /*Baca dan Tulis*/
    public void bacaMatriks1(){
        /*Baca Melalui Keyboard*/
        System.out.print("Masukkan jumlah baris: ");
        this.baris=input.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        this.kolom=input.nextInt();
        this.matriks = new double[this.baris][this.kolom];
        for (int i=0; i<baris; i++){
            for (int j=0; j<kolom; j++){
                this.matriks[i][j]=input.nextDouble();
            }
        }
    }
    
    public void bacaMatriks2(int i, int j){
        /*membaca matriks dengan ukuran ixj*/
        for (int brs=0; brs<i; brs++){
            for (int kol=0; kol<j; kol++){
                this.matriks[brs][kol]=input.nextDouble();
            }
        }
    }
    
    public void tulisMatriks(){
        /*Menampilkan matriks*/
        for(int i=0; i<baris; i++){
            for(int j=0; j<kolom; j++){
                System.out.printf("%.2f", this.matriks[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void keyboardSPL(int n, int m){
        System.out.println();
        for(int i = 1; i <= this.getBrs(); i++){
            for(int j = 1; j <= this.getKol(); j++){
                this.SetElmt(i,j,input.nextDouble());
            }
            System.out.println();
        }
    }
    
    public void swap(int R1, int R2){
        /*Menukar baris R1 dan R2*/
        for (int kol=0; kol<kolom; kol++ ){
            double temp=this.matriks[R1][kol];
            this.matriks[R1][kol]=this.matriks[R2][kol];
            this.matriks[R2][kol]=temp;
        }
    }
    
    public void plus(int R1, int R2, double K, double L){
        /* Menambah sekaligus kali: K*R1 + L*R2*/
        for (int kol=0; kol<kolom; kol++ ){
            this.matriks[R1][kol]=K*this.matriks[R1][kol] + L*this.matriks[R2][kol];
        }
    }
    
    public void minus(int R1, int R2, double K, double L){
        /* Mengurang sekaligus kali: K*R1 - L*R2*/
        for (int kol=0; kol<kolom; kol++ ){
            this.matriks[R1][kol]=K*this.matriks[R1][kol] - L*this.matriks[R2][kol];
        }
    }
    
    public void kaliKoef(int R, double X){
        /*Mengalikan seluruh baris R dengan X*/
        for (int j=this.getLead(R); j<this.kolom;j++){
            this.matriks[R][j]=this.matriks[R][j]*X;
        }
    }
    
    public void kaliKoef2(int R, double X){
        /*Mengalikan seluruh kolom R dengan X*/
        for (int j=0; j<this.baris;j++){
            this.matriks[j][R]=this.matriks[j][R]*X;
        }
    }
    
    public boolean isBrsZero(int R){
        /*Mengecek apakah seluruh elemen baris bernilai 0*/
        int j=0;
        while(this.matriks[R][j]==0 && j<this.kolom-1){
            j++;
        }
        return (this.matriks[R][j]==0);        
    }
    
    public boolean isSquare(){
        /*Mengecek apakah matriks merupakan matriks persegi*/
        return (this.getBrs()==this.getKol());
    }
    
    public int getLead(int R){
        /*Mengembalikan indeks pertama yang bukan 0 pada baris R*/
        boolean cek = true;
        int j = 0;
        while(j<kolom && cek){
            if(this.matriks[R][j]==0){
                j++;
            } else {
                cek=false;
            }
        }
         return j;
    }
    
    public void sortMatriks(){
        /*Mengurutkan matriks berdasarkan getLead yang mengurut membesar*/
        int temp;
        int minLead;
        for(int i=0; i<baris; i++){
            minLead = i;
            for(int j=i+1; j<baris; j++){
                temp = this.getLead(j);
                if(temp < this.getLead(minLead)){
                    minLead = j;
                }  
            }   
            this.swap(i,minLead);
        }  
    }
    
    public static double[] kaliMatriks2(MATRIKS m1, double [] m2){
        double[] M = new double [m1.kolom];
        for (int i=0;i<m1.baris;i++){
            for (int k=0; k<m1.kolom; k++){
                M[i]+=m1.matriks[i][k]*m2[k];
            }
        }
        return M;
    }
    
     public void makeIdentitas(int r){   
        for (int i = 0; i < r ; i++){
            for (int j = 0; j < r ; j++){
                if (i == j){
                    this.matriks[i][j] = 1;
                }
                else{
                    this.matriks[i][j] = 0;
                }
            }
	}
    }  
    
    
     public MATRIKS gabungMatriks(MATRIKS N1, MATRIKS N2){        
        MATRIKS gabungan = new MATRIKS();
        gabungan.MATRIKS(N1.baris,(N1.kolom+N2.kolom));

        if (N1.baris == N2.baris){
            for (int i = 0; i < N1.baris; i++){
                for (int j = 0; j < N1.kolom; j++){
                    gabungan.matriks[i][j] = N1.matriks[i][j];
		}
            }
            for (int i = 0; i < N1.baris; i++){
                for (int j = N1.kolom; j < N1.kolom + N2.kolom; j++){
                    gabungan.matriks[i][j] = N2.matriks[i][j-N1.kolom];
                }
            }
            return gabungan;
                 
        }
       
        
        else{
            
        }
        return gabungan;
    }
    
    public MATRIKS potongMatriks(MATRIKS m){
        MATRIKS N = new MATRIKS();
        N.MATRIKS(m.baris ,m.baris); 
              
        for (int i = 0; i < N.baris; i++){
            for (int j = 0; j < N.kolom; j++){
                 N.matriks[i][j]= m.matriks[i][j+m.baris];
            }
        } 
	
        return N;
    }
    
    public void gauss(){
        /*Melakukan OBE dengan metode eliminasi Gauss*/
        double leadKoef;
        double L;
        this.sortMatriks();
        /*Membuat seperti segitiga bawah bernilai 0*/
        for(int i=0;i<this.baris;i++){
            if (!this.isBrsZero(i)){
                leadKoef=this.matriks[i][this.getLead(i)];
                for (int j=i+1; j<this.baris;j++){
                    if(!this.isBrsZero(j)){
                        L=this.matriks[j][this.getLead(i)]/leadKoef;
                        this.minus(j, i, 1, L);
                    }
                    this.matriks[j][this.getLead(i)]=0; //agar tampilan bagus
                }
            }
        }
        /*Setiap elemen pertama yang bukan nol (lead) di tiap baris bernilai 1*/
        for (int i=0; i<this.baris; i++){
            if (!this.isBrsZero(i)){
                leadKoef=this.matriks[i][this.getLead(i)];
                double temp=1/leadKoef;
                this.kaliKoef(i, temp);
                this.matriks[i][this.getLead(i)]=1; //agar tampilan bagus
            }
        }
    }
    
    public void gaussJordan(){
        /*Melakukan OBE dengan metode eliminasi Gauss Jordan*/
        this.gauss();
        for (int i=this.baris-1; i>0; i--){
            if (!this.isBrsZero(i)){
                for (int j=i-1; j>=0; j--){
                    double L=this.matriks[j][this.getLead(i)];
                    this.minus(j, i, 1, L);
                    this.matriks[j][this.getLead(i)]=0; //agar tampilan bagus
                }
            }
        }
    }
    
    public void tulisHasil(){
        boolean tidakAda=false;
        /*cek apakah ada hasil*/
        int i=0;
        while (i<this.baris && !(tidakAda)){
            if (this.getLead(i)==this.kolom-1){
                tidakAda=true;
            }
            i++;
        }
        /*cek apakah solusi banyak*/
        boolean solBnyk=false;
        for(int R=0;R<this.kolom-1;R++){
            if (this.isBrsZero(R)){
                solBnyk=true;
            }
        }
        double [] nilai=new double[this.kolom-1];
        for (int x=0; x<this.kolom-1;x++){
            nilai[x]=0;
        }
        if (tidakAda){
            System.out.println("Solusi tidak ada");
        } else if (solBnyk){
            MATRIKS var = new MATRIKS();
            var.makeMATRIKS(this.kolom-1, this.kolom-1);
            var.makeIdentitas(this.kolom-1);
            for (int R=0;R<this.kolom-1;R++){
                if (!(this.isBrsZero(R))){
                    var.matriks[this.getLead(R)][this.getLead(R)]=0;
                }
            }
            char [] huruf = {'a','b','c','d','e','f','g','h','i','j','k','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','v','w','y','z'};
            for (int R=this.kolom-2;R>=0;R--){
                if(!(this.isBrsZero(R))) {
                    nilai[R]=this.matriks[R][this.kolom - 1];
                    if(R<this.kolom-2){
                        for (int k=this.getLead(R)+1;k<this.kolom-1;k++){
                            nilai[R]=nilai[R] - (this.matriks[R][k]*nilai[k]);
                            var.matriks[R][k]=var.matriks[R][k] + (this.matriks[R][k]*var.matriks[k][k]);
                        }
                    } 
                }
            }
            for(int R=0;R<this.kolom-1;R++){
                if (this.isBrsZero(R)){
                    System.out.printf("X%d = %c ;",R+1, huruf[R]);
                } else {
                    System.out.printf("X%d = ",R+1);
                    if(nilai[R]!=0){
                        System.out.printf("%.2f ", nilai[R]);
                        for (int l=0;l<this.kolom-1;l++){
                            if(var.matriks[R][l]!=0){
                                if (var.matriks[R][l]>0){
                                    System.out.printf("+ %.2f%c ", var.matriks[R][l], huruf[l]);
                                } else {
                                    double cek=var.matriks[R][l]*(-1);
                                    System.out.printf("- %.2f%c ", cek, huruf[l]);
                                }
                            }
                        }
                    } else{
                        boolean awal=true;
                        for (int l=0;l<this.kolom-1;l++){
                            if(var.matriks[R][l]!=0){
                                if (var.matriks[R][l]>0){
                                    if (awal){
                                        System.out.printf("%.2f%c ", var.matriks[R][l], huruf[l]);
                                        awal=false;
                                    } else{
                                        System.out.printf("+ %.2f%c ", var.matriks[R][l], huruf[l]);
                                    }
                                    
                                } else {
                                    if (awal){
                                        System.out.printf("%.2f%c ", var.matriks[R][l], huruf[l]);
                                        awal=false;
                                    } else{
                                        double cek=var.matriks[R][l]*(-1);
                                        System.out.printf("- %.2f%c", cek, huruf[l]);
                                    }
                                }
                            }
                        }
                    }
                    System.out.printf(";");
                }
            }
        } else{
            for (int R=this.kolom-2;R>=0;R--){
                nilai[R]=this.matriks[R][(this.kolom-1)];
                if (R<this.kolom-2){
                    for (int k=this.getLead(R)+1;k<this.kolom-1;k++){
                        nilai[R]=nilai[R] - (this.matriks[R][k]*nilai[k]);
                    }
                }    
                System.out.printf("X%d = %.2f ;", R+1, nilai[R]);
            }
        }
        System.out.println("\n");
    }
    
    public void cramer(){
        /*menyelesaikan SPL dengan metode cramer*/     
        MATRIKS A= new MATRIKS();
        A.makeMATRIKS(this.baris, this.baris);
        double [] hasil=new double[this.baris];
        for (int i=0;i<this.baris;i++){
            for (int j=0;j<this.kolom;j++){
                if (j==(this.kolom-1)){
                    hasil[i] = this.matriks[i][j];
                } else{
                    A.matriks[i][j]= this.matriks[i][j];
                }
                
            }
        }
        for (int k=0;k<A.kolom;k++){
            MATRIKS M = new MATRIKS();
            M.makeMATRIKS(A.baris, A.kolom);
            for (int i=0;i<A.baris;i++){
                for (int j=0;j<A.kolom;j++){
                    if (j==k){
                        M.matriks[i][j]=hasil[i];
                    } else {
                        M.matriks[i][j]=A.matriks[i][j];
                    }
                }
            }
            System.out.printf("x%d=%.2f ;", k+1 ,Determinan.detReduksi(A)/Determinan.detReduksi(M) );
        }
        System.out.println("\n");
    }
    
    public void balikan(){
        MATRIKS A= new MATRIKS();
        A.makeMATRIKS(this.baris, this.baris);
        double [] hasil=new double[this.baris];
        for (int i=0;i<this.baris;i++){
            for (int j=0;j<this.kolom;j++){
                if (j==(this.kolom-1)){
                    hasil[i] = this.matriks[i][j];
                } else{
                    A.matriks[i][j]= this.matriks[i][j];
                }
                
            }
        }
        double [] variabel;
        MATRIKS B = Matriks_Balikan.MatriksBalikanAdjoin(A);
        variabel = kaliMatriks2(B, hasil);
                
        for(int i=0;i<A.baris;i++){
            System.out.printf("X%d = %.2f ;", i+1, variabel[i]);
        }
        System.out.println("\n");
    }

     public MATRIKS minor(MATRIKS m, int b, int k){  
        MATRIKS Minor = new MATRIKS();
        Minor.MATRIKS(m.baris - 1, m.kolom - 1);
        int iMi, jMi, iM, jM;
        iMi = 0;
        for (iM = 0; iM <= m.baris-1; iM++)
            if (iM != b) {
                jMi = 0;
                for(jM = 0; jM <= m.kolom-1; jM++)
                    if (jM != k) {
                        Minor.matriks[iMi][jMi] = m.matriks[iM][jM];
                        jMi++;
                    }
                iMi++;
            }
        return Minor;
    }
    
    public double kofaktor(MATRIKS m, int i, int j){
        if ((i + j) % 2 == 0){
            return Determinan.detKofaktor(m.minor(m, i, j));
        }
        else{
            return Determinan.detKofaktor(m.minor(m, i, j))*(-1);
        }
    }
    
    public static MATRIKS  Mkofaktor(MATRIKS m){
        MATRIKS N = new MATRIKS();
        N.MATRIKS(m.baris, m.kolom);
        for (int i = 0; i <= m.baris-1; i++)
            for (int j = 0; j <= m.kolom-1; j++) {
                N.matriks[i][j] = m.kofaktor(m, i, j);
            }
        return N;
    }
    
    public MATRIKS transpose (MATRIKS m){
        MATRIKS N = new MATRIKS();
        N.MATRIKS(m.baris, m.kolom);

        for (int i = 0; i <= N.baris-1; i++) {
            for (int j = 0; j <= N.kolom-1; j++) {
                N.matriks[i][j] = m.matriks[j][i];
            }
        }
        return N;
    }
    
    public  MATRIKS adjoin(MATRIKS m) {
       
	if ((m.baris*m.kolom) != 1) {
            m.Mkofaktor(m);
            m.transpose(m);
        } else {
            m.matriks[0][0] = 1;
        }
        return m;
    }
    
    public MATRIKS Kali(MATRIKS m, double x){
       
        for (int i = 0; i < m.baris; i++) {
            for (int j = 0; j < m.kolom; j++) {
                m.matriks[i][j]= m.matriks[i][j]*x;
            }
        }
        return m;
    }
    
    public void salinMatriks(MATRIKS Msal){
        for(int i = 1; i <= this.getBrs(); i++){
            for(int j = 1; j <= this.getKol(); j++){
                Msal.SetElmt(i,j,this.getElmt(i,j));
            }
        }
    }
    
    public boolean isKoefZero(int i){
        boolean koefZero = false;
        int jumlah = 0;
        if (!this.isAllZero(i)){
            for(int j = 1; j <= this.getKol()-1; j++){
                if(this.getElmt(i,j) == 0) jumlah+=1;
            }
        }
        if (jumlah == this.getKol()-1) koefZero = true;
        return koefZero;
        
    }
    
    public boolean isAllZero(int i){
        boolean allzero=true;
        for (int j = 1; j <= this.getKol(); j++){
            if(this.getElmt(i,j) != 0) allzero = false;
        }
        return allzero;
    }
    
    public void tukarBrs(int i1, int i2){
        double temp;
        for (int j = 1; j <= this.getKol(); j++){
            temp = this.getElmt(i1,j);
            SetElmt(i1, j, this.getElmt(i2,j));
            SetElmt(i2, j, temp);
        }
    }
    
     public void eliminasiGauss(){
        int brs = 1;
        int kol = 1;
        int indeksMaks;
        while(brs <= this.getBrs() && kol<=this.getKol()){
            indeksMaks = -1; 
            //Mencari baris yang tidak bernilai 0 dalam suatu kolom
            for(int i = brs; i <= this.getBrs() && indeksMaks == -1; i++){
                if(this.getElmt(i,kol) != 0) indeksMaks = i;
            }

            //Jika tidak ada baris bernilai nol di sebuah kolom, lanjut ke kolom selanjutnya
            if(indeksMaks == -1) kol++;

            //Jika ada akan diproses
            else{
                this.tukarBrs(brs,indeksMaks); //Tukar baris
                double lead = this.getElmt(brs, kol); //Pembagi untuk membuat 1 utama

                //Membagi seluruh kolom pada baris dengan pembuat 1 utama
                for(int j = kol; j <= this.getKol(); j++){
                    this.SetElmt(brs, j, this.getElmt(brs,j)/lead);
                }

                //Mengurangi seluruh kolom di bawah 1 utama pada baris dengan rasio baris lain
                for(int i = brs+1; i <= getBrs(); i++){
                    double rasio = (-1*this.getElmt(i, kol)) / this.getElmt(brs,kol);
                    for (int j = kol; j <= this.getKol(); j++){
                        this.SetElmt(i, j , this.getElmt(i,j) + rasio*this.getElmt(brs,j));
                    }
                }

                //Lanjut ke baris dan pengecekan kolom selajuntnya
                brs++;
                kol++;
                
            }
        }
    }
     
    public void solusiEliminasiGauss(double solusi [][], int[] jumlahSolusi){
        boolean adaSolusi = true;   //Variabel penentu apakah sistem memiliki solusi
        int Brsnol = 0; //Jumlah baris seluruh elemen bernilai 0

        //Mengecek apakah terdapat solusi
        for(int i = 1; i <= this.getBrs(); i++){
            if(this.isKoefZero(i)){
                adaSolusi = false;
            }
            if(this.isAllZero(i)){
                Brsnol++;
            }
        }

        //Jika tidak ada solusi, set nilai jumlahSolusi[0] menjadi 0
        if(!adaSolusi) jumlahSolusi[0] = 0; 

        //Jika ada, akan diproses
        else{
             if(this.getBrs()-Brsnol == this.getKol()-1){
                 jumlahSolusi[0] = 1;
             } //Jika solusi tunggal
             else{
                 jumlahSolusi[0] = 999;
             }  //Jika solusi banyak

             boolean firstPivot = false; //apakah non-zero ditemukan
             int BrsPivot;  //indeks ditemukan elemen bukan 0 pertama pada baris
             int lastPivot = 0;

             //Mengisi array solusi
            for(int i = this.getBrs(); i>=1; i--){
                if(this.isAllZero(i)){
                    continue;
                } //Jika isinya 0 semua, dilewatkan
                
                //Bukan 0, diproses
                else{
                   if(!firstPivot){
                       firstPivot = true;
                       int j = 1;

                       while(j <= this.getKol()-1 && this.getElmt(i,j) == 0){
                           j++;
                       }
                       BrsPivot = j;
                       
                       for (int k = 1; k <= this.getKol()-1; k++){
                           solusi[BrsPivot][k] = 0;
                       }

                       j++;
                       while(j <= this.getKol()-1){
                           if(this.getElmt(i,j) != 0){
                               for (int k = 1; k <= this.getKol()-1; k++){
                                   if (k!=j) solusi[j][k] = 0;
                                   else solusi[j][k] = 1;
                               }
                               solusi[j][this.getKol()] = 0;
                               solusi[BrsPivot][j] = -1*this.getElmt(i,j);
                           }
                           j++;
                       }
                       lastPivot = BrsPivot;
                       solusi[BrsPivot][this.getKol()] = this.getElmt(i, this.getKol());
                   } else{
                        int j = 1;
                        while (j <= this.getKol()-1 && this.getElmt(i,j) == 0) j++;
                        BrsPivot = j;
                        for (int k =1; k <= this.getKol()-1; k++){
                            solusi[BrsPivot][k] = 0;
                        }
                        for(int k = BrsPivot+1; k <= lastPivot-1; k++){
                            for(int l=1; l <= this.getKol()-1; l++){
                                if (l != k) solusi[k] [l] = 0;
                                else solusi[k][l] = 1;
                            }
                            solusi[k][this.getKol()] = 0;
                        }
                        solusi[BrsPivot][this.getKol()] = this.getElmt(i, this.getKol());
                        for (int k = BrsPivot+1; k <= this.getKol()-1; k++){
                            for(int l = 1; l <= this.getKol(); l++){
                                solusi[BrsPivot][l] += -1*this.getElmt(i,k)*solusi[k][l];
                            }
                        }
                        lastPivot = BrsPivot;
                   } 
                }
            }
        } 
    }
    
    public void eliminasiGaussJordan(){
        int brs = 1;
        int kol = 1;

        
        while(brs <= this.getBrs() && kol <= this.getKol()){
            int indeksMaks = -1;
            //Mencari baris yang tidak bernilai 0 dalam suatu kolom
            for(int i = brs; i <= this.getBrs()&& indeksMaks == -1; i++){
                if(this.getElmt(i, kol) != 0) {
                    indeksMaks = i;
                }
            }

            //Jika tidak ada baris bernilai nol di sebuah kolom, lanjut ke kolom selanjutnya
            if(indeksMaks == -1) kol++;

            //Jika ada akan diproses
            else{
                this.tukarBrs(brs, indeksMaks); //Tukar Baris
                double lead = this.getElmt(brs, kol);
                //Membagi seluruh kolom pada baris dengan pembuat 1 utama
                for(int j = kol; j <= this.getKol(); j++){
                    this.SetElmt(brs, j, this.getElmt(brs,j)/lead);
                }
                //Mengurangi seluruh kolom pada baris dengan rasio baris lain
                for(int i = 1; i <= this.getBrs(); i++){
                    if(i != brs){
                        double rasio = (-1*this.getElmt(i, kol)) / this.getElmt(brs,kol);
                        for(int j = kol; j <= this.getKol(); j++){
                            this.SetElmt(i,j,this.getElmt(i,j) + rasio*this.getElmt(brs,j));
                        }
                    }
                }

                //Lanjut ke baris dan pengecekan kolom selajuntnya
                brs++;
                kol++;
            }
        }
    }
    
    public void solusiEliminasiGaussJordan(double solusi [][], int[] jumlahSolusi){
        int brsnol = 0;
        boolean adaSolusi = true;

        //Mengecek apakah terdapat solusi
        for (int i = this.getBrs(); i >= 1; i--){
            if (this.isAllZero(i)) brsnol++;
            if (this.isKoefZero(i)) adaSolusi = false;
        }

        //Jika tidak ada solusi, set nilai jumlahSolusi[0] menjadi 0
        if(!adaSolusi) jumlahSolusi[0] = 0;

        //Jika ada, akan diproses
        else{
            if(this.getBrs() - brsnol == this.getKol() - 1) jumlahSolusi[0] = 1; //Jika solusi tunggal
            else jumlahSolusi[0] = 999; //Jika solusi banyak

            //Mengisi Array solusi
            for (int i = 1; i <= this.getKol()-1; i++){
                for (int j=1;j <= this.getKol(); j++){
                    if(i == j)  solusi[i][j] = 1;   //Isi dengan 1 setiap, sebagai koefisien dari setiap elemen X
                    else solusi[i][j] = 0;  //Isi dengan 0 bukan diagonal
                }
            }
            
            int BrsPivot = 0;
            for(int i = this.getBrs(); i>=1; i--){
                if(this.isAllZero(i)) continue;
                else{
                    int j=1;
                    while(j <= this.getKol()-1 && this.getElmt(i,j) == 0) j++;
                    BrsPivot = j;   //Nilai x-sekian yang akan diproses
                    solusi[BrsPivot][BrsPivot] = 0; //Meng-0-kan elemen diagonal tersebut
                    j++;
                    while(j <= this.getKol()-1){
                        solusi[BrsPivot][j] = -1*this.getElmt(i,j);
                        j++;
                    }
                    solusi[BrsPivot][this.getKol()] = this.getElmt(i,this.getKol()); //Hasil x-sekian

                }
            }

        }
    }
    
     public void tulisSolusi(double[][] solusi){
        int variabel = this.getKol()-1;
        for (int i = 1; i <= variabel; i++){
            System.out.print("x[" + i + "] = ");
            boolean tulisDulu = true;

            //Mengecek solusi banyak dari x-sekian
            for (int j = 1; j <= variabel; j++){
                if(solusi[i][j] != 0){
                    if(tulisDulu){
                        tulisDulu = false;
                        if((solusi[i][j]*10)%10 == 0) System.out.printf("(%.0f)T[%d]", solusi[i][j],j); 
                        else System.out.printf("(%.2f)T[%d]", solusi[i][j],j); 
                    } else {
                        if ((solusi[i][j]*10)%10 == 0) System.out.printf(" + (%.0f)T[%d]", solusi[i][j],j);
                        else System.out.printf(" + (%.2f)T[%d]", solusi[i][j],j);
                    }
                }
            }
            //Jika solusi di kolom ujung tidak 0
            if(solusi[i][variabel+1] != 0){
                if(tulisDulu){ //Jika solusi x-sekian tunggal
                    if ((solusi[i][variabel+1]*10)%10 == 0) System.out.printf("%.0f\n",solusi[i][variabel+1]);
                    else System.out.printf("%.2f\n",solusi[i][variabel+1]);
                }   
                else { //Konstanta x-sekian banyak
                    if ((solusi[i][variabel+1]*10)%10 == 0) System.out.printf(" + (%.0f)%n", solusi[i][variabel+1]);
                    else System.out.printf(" + (%.2f)%n", solusi[i][variabel+1]);
                }
            } else{
                if(tulisDulu) System.out.println("0"); //Jika solusi x-sekian bernilai 0, dengan satu baris hanya berisi 1 elemen
                else System.out.println();
            }
        }
    }
}

