package com.sbj.practice;

public class SurroundedRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = {{'X','X','X','X'},
					  {'X','O','O','X'},
					  {'X','X','O','X'},
					  {'X','O','X','X'}};
		
		new SurroundedRegion().solve(board);
		for(int i = 0;i<board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		System.out.print(board[i][j] +" ");
        	}
        	System.out.println();
        }

	}
	
	public void solve(char[][] board) {
        if(board==null || board.length==1) {
        	return;
        }
        
        for(int i = 0;i<board.length; i++) {
        		for(int j = 0; j < board[i].length; j++) {
        			if(i ==0 || i == board.length -1 || j ==0 || j == board[i].length -1) {
        				if(board[i][j] == 'O') {
        					flipChars(board,i,j);
        				}
        			}
        		}
        }
        
        for(int i = 0;i<board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		if(board[i][j] =='Z') {
        			board[i][j] ='O';
        		}else if(board[i][j] =='O') {
        			board[i][j] ='X';
        		}
        	}
        }
        
    }

	
	
	private void flipChars(char[][] board, int i, int j) {
		if(i < 0 || j<0 || i >=board.length || j >= board[i].length || board[i][j]=='X' || board[i][j]=='Z') {
			return;
		}
		board[i][j] = 'Z';
		flipChars(board, i+1, j);
		flipChars(board, i-1, j);
		flipChars(board, i, j+1);
		flipChars(board, i, j-1);
	}
}
