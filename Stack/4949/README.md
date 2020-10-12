# Stack - 균형 잡힌 세상
<img width="1176" alt="스크린샷 2020-10-12 오후 8 35 26" src="https://user-images.githubusercontent.com/42570260/95742122-7ae9c580-0cca-11eb-8b48-058d19c58f54.png">
</br></br>

## 문제 풀이
### 주어진 문자열에 소괄호와 대괄호의 개수가 같으며,  소괄호는 소괄호끼리 묶여 있고 대괄호는 대괄호와 매칭되도록 구현
- 스택을 활용하여 ‘(‘와 ‘[‘가 들어올 경우 push
- ‘]’와 ‘)’가 들어왔을 경우 스택이 비어있는지, 스택의 탑이 다른 괄호와 매칭되는 지를 비교
- ‘.’이 들어올 때까지 반복