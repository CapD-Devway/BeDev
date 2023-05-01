package dev.com.bedev.api.condition;

import lombok.Data;

//검색 조건 클래스
@Data
public class PostSearchCondition {
    //글제목, 내용, 프로젝트이름, 스택

    private String title;
    private String content;
    private String projectName;
    private String stack;

}
