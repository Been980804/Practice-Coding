import java.util.*;

// Deque를 활용한 Stack 상위버전
// peekLast() : 뒤에 값 가져오기 <-> peekFirst()
// pollLast() : 뒤에 값 삭제 <-> pollFirst()
// addLast() : 뒤에 값 추가 <-> addFirst()
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        // deque 선언
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i = 0 ; i < number.length(); i++){
            char ch = number.charAt(i);
            // 데크가 비어있지 않고 제거해야할 수가 남아있고 데크에 담긴 마지막 수가 현재 수보다 작을경우
            while(!deque.isEmpty() && k > 0 && deque.peekLast() < ch){
                // 삭제 및 제거해야할 수 감소
                deque.pollLast();
                k--;
            }
            
            deque.addLast(ch);
        }
        
        while(k > 0){
            deque.pollLast();
            k--;
        }
        
        for(char c : deque) answer += c;
        return answer;
    }
}

// 힌트 : 스택을 사용해서 앞자리에 큰수가 오게끔
// class Solution {
//     public String solution(String number, int k) {
//         String answer = "";
        
//         // LIFO : Last In First Out
//         Stack<Integer> stack = new Stack<>();
//         // 맨 첫숫자 stack에 넣기
//         stack.add(number.charAt(0) - '0');        
        
//         for(int i = 1; i < number.length(); i++){
//             int num = number.charAt(i) - '0';
                
//             // 스택에 들어가있는 값이랑 이후 값중 큰값을 저장
//             while(!stack.isEmpty() && stack.peek() < num && k > 0){                           
//                 stack.pop();                
//                 k--;
//             }        
//             stack.add(num);
//         }
        
//         // 제거해야할 수가 남았을 때
//         while(k > 0){
//             stack.pop();
//             k--;
//         }          
        
//         while(!stack.isEmpty()) answer += stack.pop();
//         StringBuffer sb = new StringBuffer(answer);
//         answer = sb.reverse().toString();
        
//         return answer;
//     }
// }