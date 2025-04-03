// 최단거리 BFS
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new LinkedList<>();
        
        queue.add(begin);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                String nowWord = queue.poll();
                
                if(nowWord.equals(target)){
                    return answer;
                }
                
                for(int j = 0; j < words.length; j++){
                    if(!visited[j] && canChange(nowWord,words[j])){ // 미방문 && 변환가능
                        visited[j] = true;
                        queue.add(words[j]);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    public boolean canChange(String from, String to){
        int diffCount = 0; // 다른 단어 개수
        
        for(int i = 0; i < from.length(); i++){
            if(from.charAt(i) != to.charAt(i)){
                diffCount++;
            }
            
            if(diffCount > 1){
                return false;
            }                        
        }
        return diffCount == 1;
    }
}