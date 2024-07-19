package org.example.imagedrag.example01.nested;

public class Button {
    // 중첩 인터페이스
    static interface OnClickListener {
        void onClick();
    }

    // 인터페이스 타입 필드
    OnClickListener listener;

    // 매개 변수의 다형성
    void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    // 구현 객체의 onClick() 메소드 호출
    void touch() {
        listener.onClick();
    }
}
