package com.example.hanghae4th.domain.businesslogic;

import com.example.hanghae4th.domain.dto.ResponseBodyDto;
import com.example.hanghae4th.domain.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BadResponse extends ResponseBuilding{

    @Autowired
    public BadResponse(){}

    //상태코드 400, status: Bad Request, msg: message 반환
    public ResponseEntity<ResponseBodyDto> respondBadRequest(String message){
        ResponseBodyDto body = buildDto(StatusEnum.BAD_REQUEST, message);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //상태코드 401, status: Unauthorized, msg: message 반환
    public ResponseEntity<ResponseBodyDto> respondUnauthorized(String message){
        ResponseBodyDto body = buildDto(StatusEnum.UNAUTHORIZED, message);
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    //상태코드 403, status: Forbidden, msg: message 반환
    public ResponseEntity<ResponseBodyDto> respondForbidden(String message){
        ResponseBodyDto body = buildDto(StatusEnum.FORBIDDEN, message);
        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }
}
