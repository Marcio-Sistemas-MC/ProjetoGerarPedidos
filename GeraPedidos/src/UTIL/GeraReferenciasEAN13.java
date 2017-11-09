/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.util.Random;

/**
 *
 * @author
 */
public class GeraReferenciasEAN13 {

    private char[] codigo = {'7', '8', '9', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
    private int MIN = 1;
    private int MAX = 1000000;
    

    public String gerarReferenciaEAN13() {
        String cods = String.valueOf(numRandom());
        for (int i = cods.length() - 1, j = 12; i >= 0; i--, j--) {
            codigo[j] = cods.charAt(i);
        }
        return String.valueOf(codigo);
    }
    
    private int numRandom() {
        Random rand = new Random();
        int randomNum = rand.nextInt((MAX - MIN) + 1) + MIN;
        return  randomNum;
    }
    
  /*  public static void main(String[] args) {
        System.out.println(new GeraReferenciasEAN13().gerarReferenciaEAN13());
    }*/

}
