# 스프링 웹 MVC
1. 세션
2. 인터셉터

HandlerInterceptor 인터페이스

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

## 날짜 값 변환
@DateTimeFormat
  - pattern
  - 에러코드 : typeMisMatch

## @PathVariable : 경로 변수

## 익셉션 처리
@ExceptionHandler
  * 요청 메서드의 주입 가능한 객체
  1) 발생한 예외 객체
  2) Model
  3) HttpServletRequest
  4) HttpServletResponse
  5) HttpSession

@ControllerAdvice

## 스프링 파일 업로드(MultipartFile)
  - multipart
  - 설정
        
        web.xml
        <multipart-config>
          <max-file-size>20971520</max-file-size> <!-- 1MB * 20 -->
          <max-request-size>41943040</max-request-size> <!-- 40MB -->
        </multipart-config>
  - 1kb -> 1024 byte
  - 1mb -> 1024 kb
  - 1024 * 1024 * 20
## MultipartFile

## 프로필과 프로퍼티 파일
  - @Profile
    - 설정 관련 빈을 분리
    - spring.profiles.activity=프로필명
  - PropertySourcesPlaceholderConfigurer
    - static 메서드로 정의
    - @Bean
  - @Value
    - @Value("${설정이름}")
  - spring.profiles.active : properties 파일 방식의 설정

---------------------------------

# JSON 응답과 요청 처리
* JSON이란?
  - JSON(JavaScript Object Notation) : 자바스크립트 객체 표기법
  - ("이름1":"값1","이름2":"값2"...)
* Jackson 의존 설정
  - jackson-databind
  - jackson-datatype-jsr310
    - JSR310 : Data & TimeAPI (java.time. 패키지)

* @RestController
1) 스프링5에서 추가
2) 기존 컨트롤러와 다른점, 반환값이 객체
   * \> getter 호출 \> JSON 출력
3) 문자열 반환 \> 문자열 출력
4) 반환값(void) \> 응답 바디 X

* @ResponseBody
1) 스프링4까지는 자주 사용된 애노테이션
2) 일반컨트롤러(@Controller)에서 JSON 요청과 응답을 처리

* @JsonIgnore
  - JSON 변환 베제
* @JsonFormat
  - 날짜의 형식화
  - pattern
* RequestBody
  - 요청 데이터를 JSON 형식으로 인식할수 있도록 알려주는 애노테이션
  - Content-Type : application/json
* 참고) ARC - AdvancedRestClient
* ResponseEntity
  - 응답 상태 코드 + 응답 바디에 대한 상세한 통제
1) status(...) : 응답 상태 코드
2) body(...) : 바디에 출력 코드
3) build() : 바디 출력 X

* @ExceptionHandler


## 타임리프(Thymeleaf)
* 설정

        thymeleaf-spring6
        thymeleaf - java8time // JDK8Date & TIME API -> #temporals : 형식화
        thymeleaf layout : 레이아웃 기능
* 특징
  - Natural Template
