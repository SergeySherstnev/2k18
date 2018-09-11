package com.tsystems.test;

public class TstArray {
    int rowCnt;
    int[][] arrayTst;

    TstArray (int Rows) {
        this.rowCnt = Rows;

        arrayTst = new int[Rows][Rows];
        for (int j=0; j<arrayTst.length ; j++) {
            for (int k = 0; k < arrayTst[j].length; k++) {
                arrayTst[j][k] = (int) (Math.random() * 100);
            }
        }
    }

    public String getDiag () {
        String strDiag = new String();
        for (int j=0; j<arrayTst.length ; j++) {
            strDiag += String.valueOf(arrayTst[j][j]);
            strDiag += " ";
        }
        return strDiag;
    }
}
