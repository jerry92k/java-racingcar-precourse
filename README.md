# 우아한 테크 캠프 - 프리코스(2주차)

## 미션명 : 자동차 경주 게임
<br>

## 프로그램 설명
- n대의 자동차가 m번의 횟수만큼 게임한다.
- 각 게임 결과에 따라 자동차는 위치를 전진 또는 대기한다.
- m번의 게임이 종료된 후 우승 자동차를 선별한다.

<br>
  
## 요구사항

[입력 요구사항]

- 사용자는 경주할 자동차 n 대의 이름을 입력한다.
  - 이름은 5자리 이하여야 한다.
  - 자동차 이름은 한줄로 입력받으며 쉼표(,)를 기준으로 구분한다.
- 사용자는 게임을 시도할 횟수 m을 입력한다.
  - m은 1~2147483647(Integer.MAX_VALUE) 사이 값으로 한다.

[출력 요구사항]

- 매 게임 후 자동차별 위치 출력한다.
  - 각 자동차는 0에서 9 사이의 난수를 생성하여 값이 4 이상일 경우 전진하고, 3 이하일 경우는 전진하지 않는다.
- m번의 게임이 끝난 후 우승 자동차를 출력한다. 우승 자동차가 여러대 일 경우 쉼표(,)로 이름을 구분해 출력한다.

<br>

## 기능 정의

- 자동차 경주 게임 흐름 제어 및 사용자 입출력 처리(RacingCarGameController)

  - 참여 자동차 이름 입력
    - (기능)
      - String으로 자동차 이름을 한줄에 입력받아 (,)를 기준으로 split
    - (예외체크)
      - 입력된 이름이 없는 경우 체크하고 예외시 재입력
  - 게임 총 횟수 m 입력
    - (기능)
      - String으로 입력받은 데이터를 정수로 변환
    - (예외체크)
      - m이 숫자인지 유효성 검증
  - 게임 셋팅
    - 게임 참여 자동차들과 게임 총횟수를 이용하여 게임 셋팅
  - 게임 총횟수만큼 게임을 플레이
    - 각 게임이 끝날때마다 현황 출력
      - 자동차 위치 1은 ( - )로 표현한다.
      - ex) 위치 3인 경우 --- 출력
  - 우승 자동차 출력
    - 게임이 완전히 종료된 후 가장 멀리 도달한 자동차 이름 출력
    - 우승 자동차가 여러대일 경우 (,)로 구분하여 출력

- 자동차 이름(CarNmae)

  - (기능)
    - split한 String 타입 토큰을 자동차 이름 객체로 래핑
  - (예외체크)
    - 이름이 길이가 1~5 사이인지 유효성 검증 후 예외시 재입력

- 자동차 위치(CarPosition)

  - (기능)
    - 자동차의 위치 정보를 관리할 래핑 객체 생성(위치 기본값 0)

- 자동차(RacingCar)

  - (기능)
    - 자동차 이름과 위치를 멤버변수로 가진 자동차 객체를 생성
    - 0~9 사이 난수를 생성하여
      - 난수 생성값이 4 이상일 경우 - 전진(자동차의 위치를 현재위치 +1)
      - 난수 생성값이 3 이하일 경우 - 대기(자동차의 위치 변화 없음)
    - 게임에서는 자동차 이름, 위치에 직접 접근하지 않고 자동차 객체를 통하도록 함

- 자동차 집합(RacingCars)

  - (기능)
    - 레이싱에 참여한 자동차를 리스트 형태 멤버변수로 관리하는 일급 콜렉터 정의
    - 자동차들에게 일괄적인 플레이(난수 생성에 따른 위치 변화) 명령
    - 자동차들의 위치중 가장 먼 거리의 위치 찾기

- 게임의 총 횟수와 시도 횟수

  - (기능)
    - 게임 총횟수(TotalGameTimes) - 횟수 m으로 셋팅 (생성시 총횟수를 셋팅하고 이후 변경 불가)
    - 게임 시도 횟수(TryGameTimes) - 기본값 0
  - (예외체크)
    - m이 1~2147483647(Integer.MAX_VALUE) 사이 값인지 유효성 검증

- 게임 횟수 관리(GameTimesManager)

  - (기능)

    - 게임의 횟수를 관리하는 GameTimesManager 객체 생성
    - TotalGameTimes과 TryGameTimes의 횟수를 비교하여 게임이 끝났는지 판단
    - TryGameTimes 횟수 증가 명령
    - 게임이 끝났는지 판단 -> 게임 총 횟수만큼 시도를 하였는지 체크

  - (예외체크)

    - 게임 총횟수 만큼 플레이를 완료하였는데 또 시도할 경우 예외발생

      => 현재 프로그램 흐름으로는 발생할 일 없음

- 자동차 경주 게임(RacingCarGame)

  - (기능)
    - 게임에 참여하는 자동차들과 게임횟수 매니저를 멤버변수로 사용
    - 다음 게임 플레이
      - 자동차들에게 play 명령을 전달하고, 게임 횟수 매니저에게 시도 횟수를 증가 명령을 전달
    - 참여 자동차들 중 가장 멀리 위치한 자동차 찾기 -> 우승 자동차 추출에 사용