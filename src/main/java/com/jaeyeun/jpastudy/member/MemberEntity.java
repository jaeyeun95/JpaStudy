package com.jaeyeun.jpastudy.member;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer idx;

    @Column(name = "id")
    private String id;

    @Column(name = "pwd")
    private String pwd;

    @Builder
    public MemberEntity(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
}
