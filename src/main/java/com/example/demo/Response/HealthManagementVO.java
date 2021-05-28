package com.example.demo.Response;


import com.example.demo.Model.AllInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HealthManagementVO {
    private List<AllInfo> all;
    private Integer status = -2;
    private String code = "";
    private String msg = "";
}
