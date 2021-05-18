package com.example.demo.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCodeVO {
    private Integer State;
    private String Msg;
}
