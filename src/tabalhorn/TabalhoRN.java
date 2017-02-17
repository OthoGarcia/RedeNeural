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
        double [][]w={{-0.5,0.5,-0.3},{-0.5,-0.2,0.75},{0.5,-0.2,-0.75}};
        int [][]d= {{0,1,0,0},{0,0,1,0},{0,1,1,0}};
        int[] ordem ={0,0,0};        
        int result, result2, result3;
        boolean[] continua = {true, true,true};
        boolean[] achou = {false, false,false};
        boolean fim = true;
        Perceptron p1= new Perceptron(0.05);
        Perceptron p2=new Perceptron(0.07);
        Perceptron p3=new Perceptron(0.07);
        for (int j = 0; (j < 1000) && ( fim ); j++) {
            continua[0] = false;
            continua[1] = false;
            continua[2] = false;
            fim = false;
            for (int i = 0; i < x[0].length; i++) {
                result = p1.calcula(x[0][i], x[1][i], w[0]);
                result2 = p2.calcula(x[0][i], x[1][i], w[1]);
                result3 = p3.calcula(result, result2, w[2]);
                
                System.out.println("Epoca: "+j+" (" +result + 
                            "  ," + result2 + 
                            ")  ="+result3  +
                            "  w1="+ w[2][0] +
                             "  w2=" + w[2][1] +
                              "  w0=" + w[2][2]);
                
               
                //ajustar pesos p1
               if(achou[0]==false){
                    if((result==1) && (d[0][i]==0)){
                        w[0][ordem[0]]=p1.ajustarPesos(false,w[0][ordem[0]]); //Deve diminuir os pesos
                        ordem[0]++;
                        continua[0] = true;
                    }else if ((result==0)&&(d[0][i]==1)){
                        w[0][ordem[0]]=p1.ajustarPesos(true,w[0][ordem[0]]); //Deve aumentar os pesos
                        ordem[0]++;                
                        continua[0] = true;
                    }
                    if (ordem[0]>=w[0].length){
                        ordem[0]=0;
                    }
               }
               if(achou[1]==false){
                    if((result2==1) && (d[1][i]==0)){
                        w[1][ordem[1]]=p2.ajustarPesos(false,w[1][ordem[1]]); //Deve diminuir os pesos
                        ordem[1]++;
                        continua[1] = true;
                    }else if ((result2==0)&&(d[1][i]==1)){
                        w[1][ordem[1]]=p2.ajustarPesos(true,w[1][ordem[1]]); //Deve aumentar os pesos
                        ordem[1]++;                
                        continua[1] = true;
                    }
                    if (ordem[1]>=w[1].length){
                        ordem[1]=0;
                    }
               }
               if(achou[2]==false){
                    if((result3==1) && (d[2][i]==0)){
                        w[2][ordem[2]]=p2.ajustarPesos(false,w[2][ordem[2]]); //Deve diminuir os pesos
                        ordem[2]++;
                        continua[2] = true;
                    }else if ((result3==0)&&(d[2][i]==1)){
                        w[2][ordem[2]]=p2.ajustarPesos(true,w[2][ordem[2]]); //Deve aumentar os pesos
                        ordem[2]++;                
                        continua[2] = true;
                    }
                    if (ordem[2]>=w[2].length){
                        ordem[2]=0;
                    }
               }
            }
            System.out.println("_________________________");
            for (int i = 0; i < achou.length; i++) {
                if(continua[i] == true){
                    fim = true;
                }
                if(continua[i] == false){
                    achou[i] = true;
                }
            }
            
        }
        
                
        /*(∼A∧B)*/
        /*
        Perceptron p1=new Perceptron(x,w,d,0.05,0,10000);
        p1.treinar();
        
        System.out.println("________________Neuronio 2____________________");
        
        int [][]x2 = {{0,0,1,1},{0,1,0,1}};
        double []w2={-0.5,-0.2,0.75};
        int []d2= {0,0,1,0};
        
        /*(A∧∼B)*/
        /*
        Perceptron p2=new Perceptron(x2,w2,d2,0.07,0,10000);
        p2.treinar();
        */
    }
    
}
