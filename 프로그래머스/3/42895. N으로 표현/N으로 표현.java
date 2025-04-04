import java.util.*;


// i는 숫자 사용 횟수
// 통에 집어넣는 개념
// 최솟값 8 -> 8개의 통을 만듬 (List<HashSet<Integer>>)
class Solution {
    public int solution(int N, int number) {        
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i < 9; i++)
            list.add(new HashSet<>());
        
        // 숫자 하나가지고 만들 수 있는 수는 자기 자신밖에 없음
        list.get(1).add(N);
        if(number == N) return 1;
        
        // 1번 통 채웠으니 2번 통부터
        for(int i = 2; i < 9; i++){
            HashSet<Integer> total = list.get(i);
            
            // 2번째 통 -> 1번 통 두개를 (+,-,*,/)
            // 3번째 통 -> 2번째 통에 담겨있는 것들에 1번째 통을 (+,-,*,/) 해주면 됨
            // 4번째 통 -> 3번째 ~~ (동일)
            for(int j = 1; j < i; j++){
                HashSet<Integer> set1 = list.get(j);
                HashSet<Integer> set2 = list.get(i-j);
                
                for(int a : set1){
                    for(int b : set2){
                        total.add(a+b);
                        total.add(a-b);
                        total.add(a*b);
                        
                        if(a != 0 && b != 0)
                            total.add(a/b);
                    }
                }
                
                // ex) i = 3, N = 8 일경우 888 도 만들어서 통에 넣어줘야함
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            // 해당 통에 number와 동일한 값이 있으면 해당 통 번호(i) 가 최소값
            if(total.contains(number)) return i;
        }        
        return -1;
    }
}