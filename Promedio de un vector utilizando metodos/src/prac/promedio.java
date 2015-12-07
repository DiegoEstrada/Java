/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac;

/**
 *
 * @author Diego EG
 */
public class promedio {
    public void prom (int ar[])
    {
        int c,r=0;
        for (c=0;c<ar.length;c++)
        {
            r+=ar[c];
        }
        System.out.println("el promedio es "+r/ar.length);
    }
}
