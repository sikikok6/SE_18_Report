package com.example.demo.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageVO {

    private Integer status = -2;

    private String code = "";

    private String msg = "";
}
