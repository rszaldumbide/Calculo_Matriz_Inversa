/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Windows10
 */
public class mInversaClass {
    public int determinanteMatriz(int x[][], int t){
        int det=0;
        int p;
        switch(t){
            case 1:
                det=x[0][0];
                break;
            //Método de Gauss    
            case 2:
                det=((x[0][0]*x[1][1])-(x[1][0]*x[0][1]));
                break;
            case 3:	
                det=((x[0][0])*(x[1][1])*(x[2][2])+(x[1][0])*(x[2][1])*(x[0][2])+(x[2][0])*(x[0][1])*(x[1][2]))-((x[2][0])*(x[1][1])*(x[0][2])+(x[1][0])*(x[0][1])*(x[2][2])+(x[0][0])*(x[2][1])*(x[1][2]));
                break;
            //cofactores.    
            default:				
                for(int j=0;j<x.length;j++){
                    det+=(x[j][0]*adj(x,j,0));
                }
        }
        return det;
    }
    
    public int adj(int x[][], int i, int j){
        int adjunto;
        int tempAdj[][]=new int[x.length-1][x.length-1];
        int m,n;

        for(int k=0;k<tempAdj.length;k++){	
            if(k<i){							
                m=k;
            }
            else{
                m=k+1;
            }
            for(int l=0;l<tempAdj.length;l++){
                if(l<j){
                    n=l;
                }
                else{
                    n=l+1;
                }
                tempAdj[k][l]=x[m][n];
            }
        }
        adjunto=(int)Math.pow(-1,i+j)*determinanteMatriz(tempAdj, tempAdj.length);		
        return adjunto;																	
    }
    
}
