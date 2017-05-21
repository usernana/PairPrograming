public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        
	char[] chars = bowlingCode.toCharArray(); 
        int i = 0;
        int j = -1;
        int sum = 0;
       
        while (i < chars.length) {
    		switch(chars[i]) 

    		{ 
    		
            case '|': 
            	if(i-1 == j) //表示比赛结束
            		return sum;
            	j=i;
            	break; 

    		case 'X': //这一格的分数等于 10 加上接下来两球击倒的瓶数的总和
    			sum += gramScoring(chars[i]);
                if(chars[i+2]!='|'){
                	if(chars[i+3] == '|'){
                		if(chars[i+4] == '|'){
                    		sum += gramScoring(chars[i+2]) + gramScoring(chars[i+5]);
                    	}else{
                    		sum += gramScoring(chars[i+2]) + gramScoring(chars[i+4]);
                    	}
                	}else if(chars[i+3] == '/'){
                		sum += gramScoring(chars[i+3]);
                	}else{
                		sum += gramScoring(chars[i+2]) + gramScoring(chars[i+3]);
                	}
                	
                }else{
                	if(i+4 == chars.length-1){
                		if(chars[i+4] == '/'){
                    		sum += gramScoring(chars[i+4]);
                    	}else{
                    		sum += gramScoring(chars[i+3]) + gramScoring(chars[i+4]);
                    	}
                	}else{
                		sum += gramScoring(chars[i+3]);
                	}
                }
                break; 

    		case '/': //这一格的分数等于 10 加上接下来一个球击倒的瓶数

    			sum = sum - gramScoring(chars[i-1]) + 10;
    			if(chars[i+2]!='|'){
    				sum += gramScoring(chars[i+2]);
    			}else{
    				sum += gramScoring(chars[i+3]);
    			}
    			break; 

    		default: 
    			sum += gramScoring(chars[i]);
    			break; 

    		} 

            i++;

        }
       
        return sum;
    }

   
    private int gramScoring(char c) {//各个字母所代表的分数
    	int score = 0;
    	switch(c) 

		{ 
			case 'X': 
				
				score = 10;
	
			break; 
	
			case '/': 
	
				score = 10;
				
			break; 
			
			case '-': 
	
				score = 0;
	
	    		break; 
	
			default: 
				
				score = Integer.parseInt(String.valueOf(c));
	
			break; 
        }
	
        return score;
    }
    
}
