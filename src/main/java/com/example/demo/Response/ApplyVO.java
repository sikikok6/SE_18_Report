package com.example.demo.Response;
import com.example.demo.Model.AllApplyInfo;
import com.example.demo.Model.ApplyModel;
import com.example.demo.Model.BasicInfo_Front;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder

public class ApplyVO {
    private Integer status = -2;
    private String code = "";
    private String msg = "";
    private List<AllApplyInfo> allApplyInfos;

}
