package com.sbj.practice;
class RomanConversion {
	
	public static void main(String[] args) {
		decode("XL");
	}
    
  public static Integer decode( String roman ) {
    // first convert to Upper case
    String upperCase = roman.toUpperCase();
    int currentCharNumber = 0;
    int lastCharNumber = 0;
    
    // Applying reverse logic to conver into number 
    for(int i = upperCase.length() -1 ; i >=0 ;i -- ){
      char currentChar = upperCase.charAt(i);
      switch(currentChar){
      case 'M':
        currentCharNumber = processCurrentNumber(1000,lastCharNumber ,currentCharNumber);
        lastCharNumber = 1000;
        break;
      case 'D':
        currentCharNumber = processCurrentNumber(500,lastCharNumber ,currentCharNumber);
        lastCharNumber = 500;
        break;
      case 'C':
        currentCharNumber = processCurrentNumber(100,lastCharNumber ,currentCharNumber);
        lastCharNumber = 100;
        break;
      case 'L':
        currentCharNumber = processCurrentNumber(50,lastCharNumber ,currentCharNumber);
        lastCharNumber = 50;
        break;
      case 'X':
        currentCharNumber = processCurrentNumber(10,lastCharNumber ,currentCharNumber);
        lastCharNumber = 10;
        break;
      case 'V':
        currentCharNumber = processCurrentNumber(5,lastCharNumber ,currentCharNumber);
        lastCharNumber = 5;
        break;
      case 'I':
        currentCharNumber = processCurrentNumber(1,lastCharNumber ,currentCharNumber);
        lastCharNumber = 1;
        break;
    }
    }
    return currentCharNumber;
  }
  
   private static Integer processCurrentNumber(Integer number,Integer lastCharNumber, Integer currentCharNumber){
    if(lastCharNumber > number){
      return currentCharNumber - number;
    }else{
      return currentCharNumber + number;
    }
  }
}