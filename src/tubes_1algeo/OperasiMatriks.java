package tubes_1algeo;

public class OperasiMatriks extends MATRIKS{
    
    public static MATRIKS tambah(MATRIKS m1, MATRIKS m2) {
        /*m1 ditambah m2*/
        MATRIKS m_hasil = new MATRIKS();
        m_hasil.makeMATRIKS(m1.getBrs(), m1.getKol());
        
        for(int i = 0; i < m1.getBrs(); i++) {
            for(int j = 0; j < m1.getKol(); j++) {
                m_hasil.matriks[i][j] = m1.getElmt(i, j) + m2.getElmt(i, j);
            }
        }
        
        return m_hasil;
    }
    
    public static MATRIKS kurang(MATRIKS m1, MATRIKS m2) {
        /*m1 dikurang m2*/
        MATRIKS m_hasil = new MATRIKS();
        m_hasil.makeMATRIKS(m1.getBrs(), m1.getKol());
        
        for(int i = 0; i < m1.getBrs(); i++) {
            for(int j = 0; j < m1.getKol(); j++) {
                m_hasil.matriks[i][j] = m1.getElmt(i, j) - m2.getElmt(i, j);
            }
        }
        
        return m_hasil;
    }
    
    public static MATRIKS kaliMatriks(MATRIKS m1, MATRIKS m2){
        /*m1 dikali m2*/
        MATRIKS M=new MATRIKS();
        M.makeMATRIKS(m1.baris, m2.kolom);
        for (int i=0;i<M.baris; i++){
            for (int j=0;j<M.kolom;j++){
                for (int k=0;k<m1.kolom;k++){
                    M.matriks[i][j]+=m1.matriks[i][k]*m2.matriks[k][j];
                }
            }
        }
        return M;
    }
}
