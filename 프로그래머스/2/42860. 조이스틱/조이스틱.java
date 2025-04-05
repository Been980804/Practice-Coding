
// 탐욕법인 이유 : ▲/▼ or ◀/▶ 중 더적은 횟수를 선택하는게 핵심!!
class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // step01. 문자 바꾸는 횟수(▲/▼)
        for(int i = 0; i < name.length(); i++){
            // ▲/▼ 두 방법중 비교해서 최소 횟수 채택
            // 'Z' - name.charAt(i) + 1 : +1 이유는 A에서 시작하므로
            int min = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            answer += min;
        }
        
        // step02. 커서 이동(◀/▶)
        // 오른쪽으로만 이동했을 경우
        int move = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++){
            int next = i + 1;
            
            // 연속된 A 끝까지 이동하는 회수 체크
            while(next < name.length() && name.charAt(next) == 'A') next++;
            
            // 앞쪽 처리 -> 뒤쪽 처리할 때 최적의 경로
            // ex) ABAAAB
            move = Math.min(move, i * 2 + name.length() - next);
            // 뒤쪽 처리 -> 앞쪽 처리할 때 최적의 경로
            // ex) ABBAAAAB
            move = Math.min(move, (name.length() - next) * 2 + i);            
        }
        answer += move;
        return answer;
    }
}