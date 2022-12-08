package com.example.hanghae4th.domain.businesslogic;

import com.example.hanghae4th.domain.dto.ResponseBodyDto;
import com.example.hanghae4th.domain.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SuccessResponse extends ResponseBuilding{

    @Autowired
    public SuccessResponse(){}

    //data 만 반환
    public ResponseEntity<ResponseBodyDto> respondData(Object data){
        ResponseBodyDto body = buildDto(null, null, data);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    //상태코드 200, status: OK, msg: success 반환
    public ResponseEntity<ResponseBodyDto> respondOK(){
        ResponseBodyDto body = buildDto(StatusEnum.OK);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    //상태코드 200, status: OK, msg: success, data: data 반환
    public ResponseEntity<ResponseBodyDto> respondOK(Object data){
        ResponseBodyDto body = buildDto(StatusEnum.OK, data);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    //상태코드 200, status: OK, msg: success, 헤더에 headers 반환
    public ResponseEntity<ResponseBodyDto> respondHeaders(HttpHeaders headers){
        ResponseBodyDto body = buildDto(StatusEnum.OK);
        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }

    //상태코드 201, status: Created, msg: success 반환
    public ResponseEntity<ResponseBodyDto> respondCreated(){
        ResponseBodyDto body = buildDto(StatusEnum.CREATED);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}
