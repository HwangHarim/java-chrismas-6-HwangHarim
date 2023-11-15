# [4주차] 과제 명세서 🔥🔥🔥


1. MVC 패턴을 기반으로 아키텍처 구성  
2. view 와 controller service 과 데이털를 이동 할 때 Dto를 사용하여 요소만을 이동 시킴


## ⚒️ 설계 구조
- controller
  - ChristmasController


- Service
  - ChristmasService


- Domain
  - discount
    - chrisMasCountDownDiscount
    - SpecialDiscount
    - weekDiscountType
  - event
    - EventFactory
    - EventHandler
    - GiftEvent
  - menu
    - FoodCategory
    - Menu
    - OrderMenu
  - RoleType
    - Badge
  - ReservationDay
  

- Dto
  - request
    - orderMenuRequest
    - ReservationRequest
  - response
    - BadgeResponse
    - DiscountedTotalAmountResponse
    - DiscountResponse
    - GiftResponse
    - OrderMenuResponse
    - TotalAmountResponse
    - TotalDiscountAmountResponse


- filter
    - BlankInputFilter

- resolver
  - ControllerAndView -> controller의 리턴 값을 outView 에 연결하는 역할

- view
    - inputView
    - outputView


- run
  - RunApplication

- converter
  - convert 

- error
  - exception
    - orderMenuInputException
    - ReservationDayInputException
  - ErrorMessage

---

# 📌 요구사항

- 할인 일정
  - 크리스마스 카운트나운 혜택(12.1 ~ 12.25) 1000 + ((N-1)일)*100;
  - 평일 할인 (일~목) -> 디저트 메뉴 1개당 2023원
  - 주말 할인 (금,토) -> 메인메뉴 1개당 2023원
  - 특별 할인 총주문액 1000원 할인(특정 날짜)
  - 증정 이벤트  12만원 이상 구매시 샴페인 증정

- 할인 등급 배지
  - 산타 - 2만원 이상
  - 트리 - 1만원 이상
  - 별 - 5천원 이상

- 입력 처리 오류시 오류 출력 및 다시 실행

- 입력 예외처리
  - 날짜입력
    - 1~31 이내의 수
    - 빈값 X
  
  - 주문
    - 중복 X
    - 빈값 X
    - 주문 개수 20개 이하
---