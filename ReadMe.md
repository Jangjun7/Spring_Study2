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

## 컨트롤러 구현 없는 경로 매핑
* WebMvcConfigurer

## 폼 태그
* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
* <form:form>
  - modelAttribute : 커맨드 객체의 이름(EL식 속성 이름)
  - 커맨드 객체의 이름이 command이면 생략 가능
  - @ModelAttribute

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

* \* : 현재 경로의 모든 파일
  - /upload/*
  - /upload/1.png

* ? : 글자 1개
* 예) /m?00
  - > /m100, /m200

## 커맨드 객체
* getter, setter 형태의 객체

## CSS 및 HTML 태그와 관련된 공통 속성
* cssClass: HTML의 class 속성값

## 모델
* Model
  - .addAttribute(String name, Object value)
  - .addAllAttribute(Map...)
  - > 요청 메서드로 정의 : 주입

## 요청 메서드에 자동 주입
* 커맨드 객체 : 요청 데이터
* Model

      서블릿 기본 객체 : 스프링 컨테이너에 관리 객체 추가 : 요청 메서드의 주입, 의존성 자동 주입(@Autowired)