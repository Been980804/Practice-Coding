import java.util.*;

// 플로이드-워셜 (인덱스 기반 : 배열이 이점) -> 간접적인 관계 유추
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 그래프 생성 및 승패 관계 작성
        boolean[][] graph = new boolean[n+1][n+1];        
        for(int[] result : results){
            // A가 B를 이김
            graph[result[0]][result[1]] = true; 
        }
        
        // 플로이드-워셜을 루프가 k->i->j 순으로 돌아야함
        // 경유지 -> 출발지 -> 도착지
        for(int k = 1; k <= n; k++){
            for(int i = 1 ;i <= n; i++){
                for(int j = 1; j <= n; j++){
                    // i가 k를 이기고 k가 j를 이길경우 i가 j를 이김
                    // 그래프에 저장
                    if(graph[i][k] && graph[k][j])  graph[i][j] = true;
                }
            }
        }
        
        // 1번 선수부터 시작해서
        for(int i = 1; i <= n; i++){
            // 연결관계 수
            int cnt = 0;
            
            // 몇명의 선수와 연결되어있는지 확인
            for(int j = 1; j <= n; j++){
                // 자기자신 pass
                if(i == j) continue;
                // 이겼거나 졌거나는 상관 X
                if(graph[i][j] || graph[j][i]) cnt++;
            }
            
            // 자신 제외하고 모든 연결관계가 있을 경우 -> 자신의 순위를 알 수 있음
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}