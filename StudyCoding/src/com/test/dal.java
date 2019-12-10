package com.test;

import java.lang.*;
import java.io.*;  

public class dal{
    public static void main (String[] args){ 
        int n, arr[][]=new int[5][5];
        int i,j, x=0;
        int c, dx=0,dy=1;

        for(i=0;i<5;i++){
            for(j=0;j<5;j++)arr[i][j]=0;
        }
        i=j=0;
        while(x<5*5){
            arr[i][j]=++x;
            if(i+dx>=5 || j+dy>=5 || i+dx<0 || j+dy<0)
               c=1;
            else if(arr[i+dx][j+dy]!=0)
                c=1;
            else
                c=0;
            if(c==1){
                if(dy==1){dx=1;dy=0;}
                else if(dx==1){dx=0;dy=-1;}
                else if(dy==-1){dx=-1;dy=0;}
                else{ dx=0;dy=1;}
            }
            i+=dx;
            j+=dy;
        }
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}