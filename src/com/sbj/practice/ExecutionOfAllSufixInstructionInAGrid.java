package com.sbj.practice;

public class ExecutionOfAllSufixInstructionInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startPos[] = {0,1};
		System.out.println(new ExecutionOfAllSufixInstructionInAGrid().executeInstructions(3, startPos, "RRDDLU"));
	}

	public int[] executeInstructions(int n, int[] startPos, String s) { int noOfExecutedInstructions[] = new int[s.length()];
    
    for(int counter=0;counter < s.length(); counter++){
        int rowsIndex = startPos[0];
        int columnIndex = startPos[1];
        int totalExecution = 0;
        for(int i =counter; i < s.length(); i++){

            switch(s.charAt(i)){
                case 'R':
                    columnIndex++;
                    break;
                case 'L':
                    columnIndex--;
                    break;
                case 'U':
                    rowsIndex--;
                    break;
                case 'D':
                    rowsIndex++;
                    break;
            }
            if(columnIndex >=n || rowsIndex >=n || columnIndex <0 || rowsIndex <0){
                break;
            }else{
                totalExecution++;
            }            
        }
        noOfExecutedInstructions[counter]= totalExecution;
    }
    
    return noOfExecutedInstructions;
}
}
