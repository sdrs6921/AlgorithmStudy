# Topological Sort - ACM Craft

<img width="1175" alt="스크린샷 2020-10-29 오후 8 00 22" src="https://user-images.githubusercontent.com/42570260/97559976-72f78880-1a21-11eb-9ffa-cfea2678620b.png">
<img width="1175" alt="스크린샷 2020-10-29 오후 8 00 39" src="https://user-images.githubusercontent.com/42570260/97559959-6f640180-1a21-11eb-9e21-7b0cbcd65faa.png">


## 문제 풀이
- 테스트 케이스, 건물의 개수, 건물 간 건설 규칙, 건설 당 걸리는 시간, 승리하기 위한 건물의 번호가 입력으로 주어짐.
- 건물을 모두 완성하는 데 걸리는 시간을 출력

### 1. 인접 리스트
#### 건물간의 순서를 인접 리스트를 활용하여 구현
### 2. 위상 정렬
#### indegree 배열을 활용하여 이전에 연결된 건물의 개수를 저장
#### result 배열에 건물을 짓는 데 걸리는 시간을 저장해서 출력
