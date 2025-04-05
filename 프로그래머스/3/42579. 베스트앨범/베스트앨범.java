import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        
        // 장르별 총 재생횟수
        Map<String, Integer> totalPlays = new HashMap<>();
        // 장르별 각 곡 고유번호별 재생횟수
        Map<String, Map<Integer, Integer>> music = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            // 장르별 총 재생 횟수 저장 (존재하면 누적, 없으면 0에서 시작)
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            // 장르별 고유번호-재생횟수 저장용 Map이 없으면 생성
            music.putIfAbsent(genres[i], new HashMap<>());
            // 해당 장르에 고유번호와 재생 횟수 저장
            music.get(genres[i]).put(i, plays[i]);
        }
        
        // 장르 리스트 생성 (총 재생 수 기준으로 정렬하기 위해)
        List<String> genreList = new ArrayList<>(totalPlays.keySet());
        // 장르별 총 재생 수를 기준으로 내림차순 정렬 (value값 정렬)
        Collections.sort(genreList, (s1, s2) 
                         -> totalPlays.get(s2).compareTo(totalPlays.get(s1)));
        
        // 각 장르별로 재생 횟수가 높은 곡부터 정렬
        for(String str : genreList) {
            Map<Integer, Integer> map = music.get(str);             // 고유번호 - 재생횟수 맵
            List<Integer> numList = new ArrayList<>(map.keySet());  // 고유번호 리스트
            
            // 재생 횟수 기준으로 고유번호 정렬 (내림차순)
            Collections.sort(numList, (s1, s2) 
                             -> map.get(s2).compareTo(map.get(s1)));
            
            // 가장 많이 재생된 곡 최대 2개 선택
            answerList.add(numList.get(0));
            if(numList.size() > 1) answerList.add(numList.get(1));
        }
        
        // 리스트를 배열로 변환해서 반환
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}