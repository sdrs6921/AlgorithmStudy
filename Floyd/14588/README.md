# BFS - Line Friends (Small)
<img width="1161" alt="스크린샷 2020-11-04 오후 4 43 27" src="https://user-images.githubusercontent.com/42570260/98083620-fc91d500-1ebd-11eb-9eb3-e9d85ea9cf76.png">
<img width="1161" alt="스크린샷 2020-11-04 오후 4 43 13" src="https://user-images.githubusercontent.com/42570260/98083633-00255c00-1ebe-11eb-8110-c6953c66f6a1.png">
</br></br>

## 문제 풀이
- 입력으로 선분의 수, 각각의 선분의 왼쪽, 오른쪽 좌표와 질문의 수와 두 친구 사이의 거리를 알고 싶은 두 개의 선분이 입력으로 주어진다.
- 질문을 받은 두 개의 선분의 친구 사이의 거리를 출력한다. 만약 친구 관계가 단절되었다면 -1을 출력


### Floyd
#### 오른쪽 좌표와, 왼쪽 좌표를 담을 수 있는 객체를 생성하여 선분의 수 만큼 배열에 담음
#### 반복문을 돌려 선분 간에 친구라면 1, 아니면 0을 할당
#### dist 이차원 배열을 통해 친구 거리를 구한다.
#### 점화식 dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
