# LinkedList_Stack 에디터
<img width="1174" alt="스크린샷 2020-10-20 오후 8 46 09" src="https://user-images.githubusercontent.com/42570260/96581833-61bdc600-1315-11eb-8df3-bf50d739fc80.png">
</br></br>

## 문제 풀이
- 입력으로 문자열이 주어지고 각 명령어 마다 문자열 처리 수행
- "L" : 커서를 왼쪽으로 이동(만약 맨 왼쪽이라면 무시)
- "D" : 커서를 오른쪽으로 이동(만약 멘 오른쪽이라면 무시)
- "B" : 커서 기준으로 왼쪽 문자 삭제
- "P $" : 커서 기준으로 오른쪽에 문자 추가

### 1. String Builder 사용
#### 들어오는 명령어를 cursor위치 변수와 StringBuilder Class를 활용하여 문자열 처리
#### StingBuilder 중간에 삽입 삭제하게 되면 발생하는 오버헤드로 인해 시간 초과 발생

### 2. LinkedList 사용
#### 삽입, 삭제 시간 감소를 위해 들어오는 명령어에 따라 cursor 위치 변수와 LinkedList 사용
#### 이것 또한 시간 초과 발생

### 3. Stack 사용
#### 커서를 기준으로 왼쪽 스택과 오른 쪽 스택으로 나눔
#### 만약 커서를 옮길 경우 커서의 이동 방향과 함께 왼쪽 혹은 오른쪽 스택으로 옮김
#### 삭제는 왼쪽 스택에서 pop
#### 추가는 왼쪽 스택에 push
#### StringBuilder Class를 활용하여 왼쪽 스택에서 pop()한 문자를 0번에 삽입하고, 오른쪽 스택에서 pop한 문자를 뒤에 삽입
#### StringBuilder Class에서 0번 위치에 계속 삽입하는 과정에서 시간초과 발생
#### 그렇다면 왼쪽 스택을 전부 오른쪽으로 밀어넣은 후 String builder Class에서 append() 해서 성공!

<img width="1174" alt="스크린샷 2020-10-20 오후 8 46 31" src="https://user-images.githubusercontent.com/42570260/96581820-5ec2d580-1315-11eb-9b0d-5493b5ec57a0.png">
