package com.sbj.practice;

public class FindLongestPalindrom {

	public static void main(String[] args) {
		System.out.println((new FindLongestPalindrom()).longestPalindrome("\"jsfpmgkuxqnmtruslzgyvexhqjoamvyuyedhybqqcjhhhgmwqudgldvspgugibdsqfhucpfcqzriqqusvspgbqhgkswlzdkytyqphexemwxpduxplkquvgvhefsxubjluopighxbpscekijrqjhcgmqcuoczwbvueuviyfokdoqqsckjdorsettkkpiyyxxdsfczyhkyxlvrmhvflqbvlrukqcplbxnyokdxvhubsisxrodolmpmkdczavqlsnrggffagoddaldlcexwvozjxxdjtfjrfciwpacpbajcpmgfpefngqfbzehaaqyfvthtrbhkzrzqmzdcgrkezpqgbqjembeqaziuubbvdfpfyqanilcjggkudsyigiqgrcmauyugyhepvduudvpehyguyuamcrgqigiysdukggjclinaqyfpfdvbbuuizaqebmejqbgqpzekrgcdzmqzrzkhbrthtvfyqaahezbfqgnfepfgmpcjabpcapwicfrjftjdxxjzovwxecldladdogaffggrnslqvazcdkmpmlodorxsisbuhvxdkoynxblpcqkurlvbqlfvhmrvlxykhyzcfsdxxyyipkkttesrodjkcsqqodkofyivueuvbwzcoucqmgchjqrjikecspbxhgipouljbuxsfehvgvuqklpxudpxwmexehpqytykdzlwskghqbgpsvsuqqirzqcfpcuhfqsdbigugpsvdlgduqwmghhhjcqqbyhdeyuyvmaojqhxevygzlsurtmnqxukgmpfsj\""));

	}
	
	public String longestPalindrome(String s) {
		if(s.length() == 1) {
			return s;
		}
		String longestPalindrom = "";
		String stringToProcess = new String(s);
		// bbababaaa
		for( int i =0 ; i < s.length() ;i ++) {

			for (int j = i; j < s.length(); j++) {
				stringToProcess = s.substring(i, j+1);
				//System.out.println("processedString:"+stringToProcess);
				if(stringToProcess.equals(new StringBuilder(stringToProcess).reverse().toString()) 
						&& stringToProcess.length() > longestPalindrom.length()) {
					System.out.println("potentialPalindromString:"+stringToProcess);
					longestPalindrom = stringToProcess;
				}
			}
		}

		return longestPalindrom;
	}
	

}
