import java.util.*;

class Solution {
    class Node {
        int nextNode;
        int distance;
        
        public Node(int nextNode, int distance){
            this.nextNode = nextNode;
            this.distance = distance;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 방문여부/거리 저장할 배열
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        // 그래프 생성
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n; i++) graph.add(new ArrayList<>());
        
        // 양방향 그래프
        for(int[] e : edge){
            graph.get(e[0]).add(new Node(e[1],1));
            graph.get(e[1]).add(new Node(e[0],1));
        }
        
        bfs(graph, visited, distance, 1);
        
        int max = 0;
        // 1번노드에서부터의 최대 거리를 max에 저장
        for(int d : distance){
            if(d > max) max = d;
        }
        // 최대거리와 똑같은 거리의 노드 발견시 answer++
        for(int d : distance){
            if(d == max) answer++;
        }
        return answer;
    }
    
    public void bfs(List<List<Node>> graph, boolean[] visited, int[] distance, int start){
        Queue<Integer> queue = new LinkedList<>();
        // 1번 노드부터 시작 , 방문
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            
            // 현재 노드와 연결된 노드들 가져옴
            for(Node next : graph.get(nowNode)){
                // 미방문시
                if(!visited[next.nextNode]){
                    // 방문으로 수정
                    visited[next.nextNode] = true;
                    // 현재까지의 거리와 다음 노드의 거리 +
                    distance[next.nextNode] = next.distance + distance[nowNode];
                    queue.add(next.nextNode);
                }
            }            
        }
    }
}