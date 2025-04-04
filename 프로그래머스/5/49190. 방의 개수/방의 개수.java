import java.util.*;

class Solution {
    // 0,1,2,3,4,5,6,7 순서
    int[] dx = {0,1,1,1,0,-1,-1,-1};
    int[] dy = {1,1,0,-1,-1,-1,0,1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        // Set을 사용하는 이유 중복 X
        // Node : 중복 방문 방지
        // Egde : 중복된 경로 방지
        HashSet<String> visitedNode = new HashSet<>();
        HashSet<String> visitedEdge = new HashSet<>();
        
        int x = 0, y = 0;
        String start = x + "," + y;
        visitedNode.add(start);
        
        for(int dir : arrows){
            // 대각선 끼리 만나는 경우 0.5,0.5 같은 포인트에서 만날 수 있음 따라서 한번의 이동을 두번의 이동                으로 나눠줌
            for(int step = 0; step < 2; step++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                String now = x + "," + y;
                String next = nx + "," + ny;
                // 양방향을 나눠서 표시해 줌으로써 어떤 경로로 이동하는지 체크
                String edge1 = now + "->" + next;
                String edge2 = next + "->" + now;
                
                // 이미 방문한적이 있는 노드 && 새로운 경로로 방문했을 경우 -> 방이 생성됨 
                if(visitedNode.contains(next) && !visitedEdge.contains(edge1))  answer++;
                
                visitedNode.add(next);
                visitedEdge.add(edge1);
                visitedEdge.add(edge2);
                
                x = nx;
                y = ny;
            }
        }
        return answer;
    }
}