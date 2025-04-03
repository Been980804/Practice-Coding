import java.util.Queue;
import java.util.LinkedList;

class Load {
    int x;
    int y;
    
    public Load(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    Queue<Load> queue = new LinkedList<>();
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(0, 0, maps);
        
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps){
        queue.add(new Load(x, y));
        
        while(!queue.isEmpty()){
            Load load = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nowX = load.x + dx[i];
                int nowY = load.y + dy[i];
                
                if(nowX >= 0 && nowY >= 0 && nowX < maps.length && nowY < maps[0].length){
                    if(maps[nowX][nowY] == 1){
                        queue.add(new Load(nowX, nowY));
                        maps[nowX][nowY] = maps[load.x][load.y] + 1;
                    }
                }                
            }
        }
        if(maps[maps.length - 1][maps[0].length - 1] == 0 
           || maps[maps.length - 1][maps[0].length - 1] == 1){
            return -1;
        } else {
            return maps[maps.length - 1][maps[0].length - 1];
        }
    }
}