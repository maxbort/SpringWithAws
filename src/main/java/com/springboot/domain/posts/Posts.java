package com.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //get메소드 자동 생성
@NoArgsConstructor // 기본 생성자 자동추가해주는 lombok 어노테이션
@Entity // 테이블과 링크될 클래스임을 나타내는 어노테이션 클래스의 카멜케이스이름을 언더스코어 네이밍으로 테이블이름 매칭
public class Posts { //실제 DB의 테이블과 매칭될 클래스 Entity클래스. 실제 쿼리를 날리는 것보단 이 Entity 클래스 수정을 통해 DB작업
    // Setter 메소드가 없는데 Entity클래스에는 Setter를 만들지 않는다. 인스턴스 값들이 변하는 곳이 무분별하게 생겨나는 것을 방지.
    @Id // 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타냄 선언안해도 필드는 모두 칼럼 변경 필요 옵션 시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
