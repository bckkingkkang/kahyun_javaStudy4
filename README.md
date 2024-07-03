# kahyun_javaStudy4

## 참조 타입과 참조 변수
- 객체(Object)의 번지를 참조하는 타입, 메모리의 번지를 변수 안에 저장
- 배열, 열거, 클래스, 인터페이스

### 메소드 영역
- JVM이 시작할 때 생성되고모든 스레드가 공유하는 영역   
> 코드에서 사용되는 클래스들을 클래스 로더로 읽어 클래스 별로 정적 필드와 상수, 메소드 코드, 생성자 코드 등을 분류해서 저장

### 힙 영역
- 객체외 배열이 생성되는 영역
- 힙 영역에서 생성된 객체와 배열은 JVM 스택 영역의 변수나 다른 객체의 필드에서 참조한다.
- 참조하는 변수나 필드가 없는 경우 의미없는 객체 -> **Garbage Collector**를 실행시켜 자동으로 제거

### JVM 스택 영역
- JVM 스택은 메소드를 호출할 때마다 프레임을 추가(push)하고 메소드가 종료되면 해당 프레임을 제거(pop)하는 동작을 수행한다.
> 프레임 내부의 로컬 변수 스택에서는 기본 타입 변수와 참조 타입 변수가 추가(push)되거나 제거(pop)된다.
> * 스택 영역에 변수가 생성되는 시점 : 최초로 변수에 값이 저장될 때(초기화)    
> * 스택 영역에서 변수가 제거되는 시점 : 변수는 선언된 블록 안에서만 스택에 존재하고 블록을 벗어나면 제거


## Null과 NullPointerException
- 참조 타입 변수는 힙 영역의 객체를 참조하지 않는다는 뜻으로 null 값을 가질 수 있다.
- null 값도 초기값으로 사용할 수 있기 때문에 null로 초기화된 참조 변수는 스택 영역에 생성된다.
- 참조 타입 변수가 null 값을 가지는지 확인하려면 `==`, `!=` 연산 수행
