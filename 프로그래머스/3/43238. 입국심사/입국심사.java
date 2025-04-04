import java.util.*;

// 최소시간 -> 시간을 이분탐색 대상으로 봐야함
class Solution {
    public long solution(int n, int[] times) {
        long answer;
        
        // 최소시간 1분
        long min = 1;
        // 최대시간 times 배열에 담긴 시간 중 최대시간 * 사람 수 (즉, 모든 사람이 가장 오래걸리는 심사관한테            심사받음)
        // long 설정이유 시간(1,000,000,000) * 인원(1,000,000,000) int의 범위를 넘어갈 수 있음
        long max = (long) Arrays.stream(times).max().getAsInt() * n;
        // 아무리 못해도 최대시간으로 처리가 가능하게끔
        answer = max;
        
        // min 이 max를 넘어서는 순간 -> 최소 시간을 찾았다는 증거
        while(min <= max){
            long mid = (min + max) / 2;
            
            long cnt = 0;
            
            // mid 시간동안 심사관들이 몇명의 인원을 심사할 수 있는지 카운트
            for(int time : times)   cnt+= mid/time;
            
            // 심사된 인원이 n보다 높으면 여유 있음 -> 시간 줄이기
            if(cnt >= n){
                answer = mid;
                max = mid -1;
            // 부족할시 -> 시간 늘리기
            } else{
                min = mid + 1;
            }
        }
        return answer;
    }
}