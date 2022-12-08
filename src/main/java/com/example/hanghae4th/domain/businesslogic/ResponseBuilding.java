package com.example.hanghae4th.domain.businesslogic;


import com.example.hanghae4th.domain.dto.ResponseBodyDto;
import com.example.hanghae4th.domain.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilding {

    @Autowired
    public ResponseBuilding() {
    }

    //기본 빌드
    protected ResponseBodyDto buildDto(StatusEnum status, String message, Object data) {
        return ResponseBodyDto.builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    //buildDto(상태코드, 메세지) => 데이터는 null
    protected ResponseBodyDto buildDto(StatusEnum status, String message) {
        return buildDto(status, message, null);
    }

    //buildDto(상태코드, 데이터) => 메세지는 success
    protected ResponseBodyDto buildDto(StatusEnum status, Object data) {
        return buildDto(status, "success", data);
    }

    //buildDto(상태코드) => 메세지는 success, 데이터는 null
    protected ResponseBodyDto buildDto(StatusEnum status) {
        return buildDto(status, "success", null);
    }
}
