# Level 1 방학 블랙잭 미션 재구현

# 목표

1. README 상세 작성
    - 페어 중간에 LMS를 다시 보게 되는 경우가 많았는데 그러지 않아도 될 정도로 작성해보기
    - 한번 구현으로써 도메인을 파악하기 보다 구현 전에 도메인 파악을 하게 만들기 위해
2. TDD
3. 다형성 최대로 사용해보기

# 기능 목록

## View

---

- [x] 참여할 사람의 이름을 입력한다.
    - [x] 1 ~ 6 명의 참가자를 받을 수 있다.
    - [x] , 를 기준으로 참가자의 이름을 구분한다.
- [x] 참가자들의 배팅 금액을 입력받는다.
    - [x] 배팅 금액은 1000단위여야 한다.

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
20000
```

---

- [x] 게임 준비 상태를 출력한다.
    - [x] 딜러의 시작 중 첫카드 1장을 출력한다.
        - [x] 딜러의 이름은 `딜러` 로 고정한다.
    - [x] 참가자의 이름과 시작 카드 2장을 출력한다.

``` 
딜러와 pobi, jason에게 2장을 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드
```

---

- [x] 모든 참가자에게 카드 지급 여부 문구를 출력한다. ( y, n )
    - [x] 현재 참가자의 이름과 보유 카드 전체를 출력한다.
- [x] 딜러에게 카드를 지급한 문구를 출력한다.

```
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
pobi카드: 2하트, 8스페이드, A클로버
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

딜러는 16이하라 한장의 카드를 더 받았습니다.
```

---

- [x] 모든 카드와 점수를 출력한다.
    - [x] 딜러의 모든 카드와 점수를 출력한다.
    - [x] 참가자의 모든 카드와 점수를 출력한다.
- [x] 게임의 최종 승패를 출력한다.
    - [x] 딜러는 승, 패, 무 순서로 횟수와 함께 출력한다.
        - [x] 승, 패, 무의 횟수가 0일 경우 출력을 생략한다.
    - [x] 참가자는 승, 패, 무 중 1개를 출력한다.

```
딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```

---

- [x] 딜러와 모든 참가자의 최종 수익을 출력한다.
    - [x] 이름과 최종 수익을 출력한다.

```     
## 최종 수익
딜러: 10000
pobi: 10000 
jason: -20000
```

## Model

### 덱

- [x] 총 52개의 카드를 가진다.
    - [x] 카드는 끝수, 문양, 점수를 가진다.
        - [x] 끝수 ( 점수 ) ( 13개 )
            - A (1)
            - 2 (2)
            - 3 (3)
            - 4 (4)
            - 5 (5)
            - 6 (6)
            - 7 (7)
            - 8 (8)
            - 9 (9)
            - 10 (10)
            - J (10)
            - Q (10)
            - K (10)
        - [x] 문양 ( 4개 )
            - SPADE
            - CLOVER
            - DIAMOND
            - HEART
    - [x] 끝수 A는 10점의 보너스 점수를 더 받을 수 있다.

### 딜러

- [x] 이름은 `딜러` 이다.
- [x] 카드 지급 여부를 결정할 수 없다.
    - [x] 총 점수가 16보다 클 떄까지 카드를 더 받는다.

### 참가자

- [x] 이름이 있다.
- [x] 카드 지급 여부를 결정할 수 있다.
- [x] 게임에 원하는 만큼의 돈을 배팅할 수 있다.

### 게임

- [x] 참가한 순서대로 게임을 진행한다.
- [x] 카드를 지급한다.

### 게임 상태

- [x] 점수가 21점이 넘으면 BUST
- [x] 점수가 21점이고 카드가 2장이면 BLACKJACK
- [x] 나머지는 HIT

### 배팅 금액

- [x] 1000원 이상으로 배팅할 수 있다.
- [x] 1000원 단위로 배팅할 수 있다.

### 수익

- [x] 이겼을 때는 배팅 금액의 1배
    - [x] 블랙잭으로 이길시 1.5배
- [x] 비겼을 때는 0원
- [x] 졌을 때는 배팅 금액의 -1배

### 점수

- [x] 점수가 11이하 일 때만 ACE 점수 보너스가 적용된다.
