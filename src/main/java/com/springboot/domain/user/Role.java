package com.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final로 선언된 모든 필드나 @NonNull 어노테이션이 붙은 필드에 대한 생성자를 자동으로 생성
                        // 즉, 반드시 초기화가 필요한 필드들만을 포함하는 생성자를 만듬
                        // NoArgsConstructor 어노테이션은 파라미터가 없는 기본 생성자를 자동으로 생성.
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER","일반 사용자");
    // 스프링 시큐리티에서는 권한 코드에 항상 ROLE_ 이 앞에 있어야 한다.
    private final String key;
    private final String title;
}