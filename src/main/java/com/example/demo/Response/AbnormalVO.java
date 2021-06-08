package com.example.demo.Response;

import com.example.demo.Model.Abnormal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AbnormalVO {
    private String msg = "";
    private Abnormal abnormal;
}
