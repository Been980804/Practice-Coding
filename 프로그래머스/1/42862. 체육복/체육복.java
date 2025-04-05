import java.util.*;

// 탐욕법 : 앞번호 -> 뒷번호 순으로 
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 탐욕법을 위한 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] cloth = new int[n+1];
        
        // 모든학생은 옷을 1벌씩 가지고 있음
        Arrays.fill(cloth,1);
        
        // 잃어버린학생 --
        for(int i = 0; i < lost.length; i++){
            cloth[lost[i]]--;
        }
        
        // 여벌옷 있는 학생 ++
        for(int i = 0; i < reserve.length; i++){
            cloth[reserve[i]]++;
        }
        
        // 1번 학생부터 n번학생까지
        for(int i = 1; i <= n; i++){
            // 옷이 없는 상태면
            if(cloth[i] == 0) {
                // 앞번호 학생이 여벌옷이 있을 경우 (i > 1 이유는 i-1 범위를 위함)
                if(i > 1 && cloth[i-1] == 2){
                    cloth[i-1]--;
                    cloth[i]++;
                // 뒷번호 학생이 여벌옷이 있을 경우 ( i < n 이유는 i+1 범위를 위함)
                } else if(i < n && cloth[i + 1] == 2){
                    cloth[i+1]--;
                    cloth[i]++;
                }
            }
        }
        
        // 옷이 있는 학생 수 check
        for(int i = 1; i <= n ; i++){
            if(cloth[i] >= 1) answer++;
        }
        
        return answer;
    }
}