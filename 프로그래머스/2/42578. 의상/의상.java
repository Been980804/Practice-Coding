import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        // 옷 타입별로 개수 파악
        // map.getOrDefault(key, default_value) -> key값이 존재하면 그에대한 value를 get
        //                                      -> 존재하지 않으면 0 
        for(int i = 0 ; i < clothes.length; i++){
            String clothes_type = clothes[i][1];            
            map.put(clothes_type, map.getOrDefault(clothes_type, 0) + 1);
        }
        
        for(int i : map.values()){
            // 안 입을 경우 포함
            answer *= (i + 1); 
        }
        
        //  최소 한개는 입어야함
        answer -= 1;    
        return answer;
    }
}