package minesweepergame;

import java.awt.Color;
import javax.swing.JButton;

public class MineSweeperImpl {

    int[][] grid;

    public MineSweeperImpl() {
        initiategridMines();
        formMinesweep();
    }

    int clicked(int i, int j) {
        int selected= grid[i][j];
        return selected;
        
    }

    private void initiategridMines() {
        grid = new int[8][8];
        for (int k = 0; k < 12; k++) {
            int i = (int) (Math.random() * (7 - 0) + 0);
            int j = (int) (Math.random() * (7 - 0) + 0);
            grid[i][j] = 9;
        }
        //display();
    }
    private void display(){
        for (int i = 0; i < 8; i++) {
            for(int j=0;j<8;j++){
                System.out.print(grid[i][j]+"  ");
            }
            System.out.println();
        }
         System.out.println();
    }

    public void formMinesweep() {
        int sum=0;
        for (int i = 0; i < 8; i++) {
            for(int j=0;j<8;j++){
                if(grid[i][j]!=9){
                if(i==0 && j==0){
                    if(grid[i+1][j]==9)
                        sum+=1;
                    if(grid[i][j+1]==9)
                        sum+=1;
                    if(grid[i+1][j+1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else if(i==0 && j==7){
                    if(grid[i][j-1]==9)
                        sum+=1;
                    if(grid[i+1][j]==9)
                        sum+=1;
                    if(grid[i+1][j-1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                    
                }
                else if(i==7 && j==0){
                    if(grid[i][j+1]==9)
                        sum+=1;
                    if(grid[i-1][j]==9)
                        sum+=1;
                    if(grid[i-1][j+1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else if(i==7 && j==7){
                    if(grid[i][j-1]==9)
                        sum+=1;
                    if(grid[i-1][j]==9)
                        sum+=1;
                    if(grid[i-1][j-1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else if(i==0){
                    if(grid[i][j-1]==9)
                        sum+=1;
                    if(grid[i][j+1]==9)
                        sum+=1;
                    if(grid[i+1][j-1]==9)
                        sum+=1;
                    if(grid[i+1][j+1]==9)
                        sum+=1;
                    if(grid[i+1][j]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else if(j==0){
                    if(grid[i-1][j]==9)
                        sum+=1;
                    if(grid[i+1][j]==9)
                        sum+=1;
                    if(grid[i-1][j+1]==9)
                        sum+=1;
                    if(grid[i][j+1]==9)
                        sum+=1;
                    if(grid[i+1][j+1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else if(i==7){
                    if(grid[i][j-1]==9)
                        sum+=1;
                    if(grid[i][j+1]==9)
                        sum+=1;
                    if(grid[i-1][j-1]==9)
                        sum+=1;
                    if(grid[i-1][j]==9)
                        sum+=1;
                    if(grid[i-1][j+1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else if(j==7){
                    if(grid[i-1][j]==9)
                        sum+=1;
                    if(grid[i+1][j]==9)
                        sum+=1;
                    if(grid[i-1][j-1]==9)
                        sum+=1;
                    if(grid[i][j-1]==9)
                        sum+=1;
                    if(grid[i+1][j-1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                else{
                    if(grid[i-1][j-1]==9)
                        sum+=1;
                    if(grid[i-1][j]==9)
                        sum+=1;
                    if(grid[i-1][j+1]==9)
                        sum+=1;
                    if(grid[i][j-1]==9)
                        sum+=1;
                    if(grid[i][j+1]==9)
                        sum+=1;
                    if(grid[i+1][j-1]==9)
                        sum+=1;
                    if(grid[i+1][j]==9)
                        sum+=1;
                    if(grid[i+1][j+1]==9)
                        sum+=1;
                    grid[i][j]=sum;
                }
                  sum=0;  
             }
            }
        }
    }


    void gameOver(JButton[][] list) {
        for (int i = 0; i < 8; i++) {
            for(int j=0;j<8;j++){
                if(grid[i][j]==9){
                    list[i][j].setText("X");
                    list[i][j].setBackground(Color.red);
                }
                list[i][j].setEnabled(false);
            }
        }
    }

    void openZeros(JButton[][] list,int i,int j) {
        for (int a = i-1; a<=i+1; a++) {
            for(int b=j-1;b<=j+1;b++){
                if(a<0||b<0||a>7||b>7){
                }
                else{
                    int ans=clicked(a,b);
                    if(ans==0 && list[a][b].isEnabled()==true){
                        list[a][b].setText(Integer.toString(ans));
                        list[a][b].setBackground(Color.yellow);
                        list[a][b].setEnabled(false);
                        openZeros(list, a, b);
                    }else{
                    list[a][b].setText(Integer.toString(ans));
                    list[a][b].setBackground(Color.yellow);
                    list[a][b].setEnabled(false);
                    }
                }
            }
        }
    }

}
