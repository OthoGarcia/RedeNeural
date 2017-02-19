/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabalhorn;

/**
 *
 * @author Ogarcia
 */
public class TabalhoRN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][]x = {{0,0,1,1},{0,1,0,1}};
        double []w={-0.5,0.5,-0.3};
        int []d= {0,1,0,0};
        
        /*(∼A∧B)*/
        Perceptron p1=new Perceptron(x,w,d,0.05,0,10000);
        p1.treinar();
        
        System.out.println("________________Neuronio 2____________________");
        
        int [][]x2 = {{0,0,1,1},{0,1,0,1}};
        double []w2={-0.5,-0.2,0.75};
        int []d2= {0,0,1,0};
        
        /*(A∧∼B)*/
        Perceptron p2=new Perceptron(x2,w2,d2,0.07,0,10000);
        p2.treinar();
    }
    
}
