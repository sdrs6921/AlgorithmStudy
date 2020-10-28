# Topological Sort - 음악프로그램

<img width="1175" alt="스크린샷 2020-10-28 오후 6 11 15" src="https://user-images.githubusercontent.com/42570260/97415903-1b85e980-1949-11eb-96a4-b2958e3bcb75.png">
<img width="1175" alt="스크린샷 2020-10-28 오후 6 11 36" src="https://user-images.githubusercontent.com/42570260/97415906-1cb71680-1949-11eb-8fa6-af1977755afe.png">
</br></br>

## 문제 풀이
- 가수의 수, PD의 수, PD마다 원하는 가수의 순서가 입력 값으로 주어진다.
- 모든 PD가 원하는 순서를 만족하는 가수의 순서를 출력. 순서를 구하는 것이 불가능 할 경우 0을 출력

### 1. 인접 리스트
#### PD마다 원하는 순서를 바탕으로 가수의 순서 관계를 인접 리스트에 저장
### 2. Indegree 배열
#### 가수마다 이전에 출현해야 할 가수의 수를 담을 배열 생성
### 3. 위상 정렬
#### 위상 정렬을 통해 얻은 가수의 순서를 ArrayList에 담고 만약 ArrayList의 수가 N과 같지 않다면 0을 출력
