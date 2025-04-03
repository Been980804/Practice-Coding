class Solution {    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];     // 해당 컴퓨터 방문여부 체크
        
        // 미방문으로 초기화
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                answer++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][] computers){
        visited[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                dfs(i, visited, computers);
            }
        }
    }
}