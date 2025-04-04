// 더해 내려가면서 가장 큰 수를 찾음
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 0,0 (즉, 7에) 1,0 / 1,1 을 더해가며 아래 칸으로 갈 때 마다 숫자를 더해줌
        for(int i = 1 ; i < triangle.length; i++){
            for(int j = 0 ; j < triangle[i].length; j++){
                
                // 가장 왼쪽일 경우 (i,0)
                // 바로 위로 가야함 ∵ i-1
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                // 가장 오른쪽일 경우 (i,i)
                    // 바로 위, 왼쪽 한칸 ∵ i-1, j-1 
                } else if(j == i){
                    triangle[i][j] += triangle[i-1][j-1];
                // 중앙값일 경우 위의 두값중 큰값을 더해줘야함
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j],triangle[i-1][j-1]);
                }
                // answer에 지속적으로 최대값을 비교해서 저장
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}