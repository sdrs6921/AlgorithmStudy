# DP - RGB 거리
![스크린샷 2020-10-11 오후 6 48 47](https://user-images.githubusercontent.com/42570260/95675459-689c5880-0bf2-11eb-80ba-dcea4f67f9be.png)

</br></br>
## 문제 풀이
### 집을 빨강, 초록, 파랑 중 하나를 이용하여 최소 비용을 사용하여 색을 칠해야 함
### 집을 찰하는 규칙
- 1번 집의 색은 2번 집과 겹치면 안됨
- N -1 번째 색은 N번째 집의 색과 겹치면 안됨
- i 번쨰 색은 i - 1번쨰 색과 i + 1번째 색과 겹치면 안됨
### 집의 개수와 각 집에 소요되는 페인트의 R,G,B 값의 비용이 주어짐 
</br></br>
### 점화식
#### dp[N][3] 배열 
#### dp[N][1]  =  빨강색, dp[N][2] = 초록색, dp[N][3] = 파란색으로 칠했을 때의 최소 비용
#### K번째에서 빨간색으로 칠한다면 K-1번째의 초록색과 파란색 중에서 최소 비용과 현재 빨간색으로 칠했을 때의 비용으로 배열에 값을 할당하면 현재 집을 빨간색으로 칠했을 때의 최소 비용을 구할 수 있다.
#### DP[k][1] = 비용[K][1] + min(DP[k-1][2], DP[k-1][3])