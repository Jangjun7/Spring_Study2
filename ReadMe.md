# 스프링 웹 MVC

## 요청 매핑
- 스프링 5 추가된 애노테이션
  * @GetMapping
  * @PostMapping
  * @PutMapping
  * @PatchMapping
  * @DeleteMapping
--------------------------------
- 스프링4 이전부터 사용된 애노테이션
  * @RequestMapping : method 속성을 설정 X -> 모든 요청 메서드에 매핑 / 공통 URL을 설정할때 주로 사용
* HttpServletRequest
  * String getParameter(String name)

## 스프링 MVC 프레임 워크 동작 방식

* 컨트롤러 빈
  * @Controller
  * Controller 인터페이스 구현체
  * HttpRequestHandler

* 정리
  * DispatcherServlet
  * HandlerMapping
  * HandlerAdapter
  * ViewResolver

## 참고)
* Ant 경로 패턴
* ** : 현재 경로와 하위경로를 모두 포함한 모든 파일
* 예)/upload/**
  - /upload/1.png
  - /upload/sub/2.png

* \* : 