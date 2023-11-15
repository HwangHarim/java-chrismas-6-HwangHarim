# 4주차 과제 명세서 🔥🔥🔥


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
