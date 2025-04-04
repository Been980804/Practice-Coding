import java.util.*;

// 각 바위 사이의 최소 거리의 최댓값 -> 최소 거리를 이분탐색의 대상으로
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance;
        
        while(min <= max){
            // 유지하고 싶은 바위 사이의 최소 거리
            int mid = (min + max) / 2;
            int removed = 0, prev = 0;
            
            // 각 돌 사이의 거리를 보며 mid보다 작으면 돌 제거
            for(int rock : rocks){
                if(rock - prev < mid)   removed++;
                else prev = rock;
            }
            
            // 마지막 목적지와도 비교
            if(distance - prev < mid)   removed++;
            
            // mid 거리를 유지하려면 n 이상의 돌을 제거해야하므로 mid 줄이기
            if(removed > n){
                max = mid - 1;
            // 제거한 돌이 n보다 적거나 같을 시 -> mid가 최솟값을 후보지만, 가장 큰 값일지는 모름
            } else{
                answer = mid;
                min = mid + 1;
            }    
                
        }
        return answer;
    }
}