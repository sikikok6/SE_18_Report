package com.example.demo.Response;

import com.example.demo.Model.BasicInfo_Front;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@AllArgsConstructor
public class LoginVO {
    private Integer status = -2;

    private String code = "";

    private String msg = "";

    private BasicInfo_Front basicInfo_front;




}
