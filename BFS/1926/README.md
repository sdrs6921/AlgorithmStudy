#BFS - 그림 문제
<img width="1197" alt="스크린샷 2020-10-10 오후 8 03 30" src="https://user-images.githubusercontent.com/42570260/95653437-bef69200-0b33-11eb-8711-86f8c7888df6.png">

## 문제 풀이

 - 2중 for문을 활용하여 반복문을 돌면서 그림이 시작되는 곳을 찾아서 BFS를 이용하여 넓이를 구하는 방식으로 문제 해결
 - 2중 넓이를 구했던 곳을 다시 한 번 더 방문하여 이중으로 넓이를 구하는 것을 방지하기 위해 visited 배열을 만들어서 이를 확인
 - Output : 그림의 개수와 그림의 최대 넓이