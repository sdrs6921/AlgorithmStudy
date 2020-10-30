# Minimum Spanning Tree - 별자리 만들기
<img width="1175" alt="스크린샷 2020-10-30 오후 6 57 55" src="https://user-images.githubusercontent.com/42570260/97691557-da750d00-1ae1-11eb-8cc0-a3dfd3d787a2.png">
</br></br>

## 문제 풀이
- 별의 개수 n과 별의 위치 좌표(x, y)가 주어진다.
- n개의 별을 모두 이어서 별자리를 만든다고 할 때, 별자리를 만들 수 있는 최소 비용을 구함.(단, 별자리를 만드는 비용은 별 사이의 거리)

### 1. Kurscal 알고리즘
#### n의 최대 크기가 100이므로 별과 별 사이의 모든 간선과 가중치를 구하여 가중치의 크기를 기준으로 간선 정렬
#### 만약 정점과 정점이 다른 집합일 경우 해당 정점을 잇고 answer에 가중치를 더함
### 2. Union-Find
#### 서로 다른 disjoint를 생성하여 자기 자신이 root를 가리키도록 구현
#### 집합을 합치는 union, 같은 집합인지 여부를 확인하는 find 알고리즘 구현
#### 만약 Parent배열과 u가 같다면 u를 출력하고 아니라면 자신이 연결되어 있는 root를 발견할 때까지 재귀호출하는 getParent 구현
### 3. Point, Edge
#### Point class와 Edge class를 사용하여 좌표, 정점, 가중치를 정보를 저장하고 
