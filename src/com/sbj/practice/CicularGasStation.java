package com.sbj.practice;

import java.util.Arrays;
import java.util.List;

public class CicularGasStation {
	public static void main(String[] args) {
		//Integer A[] = { 959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209 };
		//Integer B[] = { 862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884 };
		//Integer A[] = {1,2};
		//Integer B[] = {2,1};
		//System.out.println(canCompleteCircuit(Arrays.asList(A), Arrays.asList(B)));
		int a[] = {1,2,3,4,5};
		int b[] = {3,4,5,1,2};
		
		System.out.println(canCompleteCircuit(a,b));

	}

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int minIndex = -1;
        int gasStorage = 0;
        for(int i=0; i<A.size(); i++){
            //minIndex = checkCircularly(A,B, i);
            int length = A.size();
            minIndex = i;
            int j = i;
                do{
                                
                    gasStorage += A.get(j);
                    System.out.println("j="+j+", GasStorage="+gasStorage+", B.get(j)="+B.get(j));
                    if(gasStorage >= B.get(j)) {
                    	// deduct gas required to reach B[j]
                    	gasStorage-=B.get(j);
                    }else{
                        //cannot complete circle
                        minIndex = -1;
                        break;
                    }
                    length--;
                    //traverse circular so reset to 0 when reaches last index
                    if(j == (A.size() -1)){
                        j = 0;
                    }else{
                        j++;
                    }
                }while(length > 0 );
           
            }
            return minIndex;
    }
    
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }
}

