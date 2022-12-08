package com.example.hanghae4th.domain.dto;

import com.example.hanghae4th.domain.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBodyDto {

    private final StatusEnum status;
    @JsonProperty(value = "msg")
    private final String message;
    private final Object data;

    @Builder
    public ResponseBodyDto(StatusEnum status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}


    //코드 줄이는 용도로 얘 쓸지 말지 고민중
//    public ResponseBodyDto(StatusEnum status, String message){
//        this(status, message, null);
//    }

