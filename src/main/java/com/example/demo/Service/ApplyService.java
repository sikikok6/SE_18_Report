package com.example.demo.Service;

import com.example.demo.Model.ApplyModel;
import com.example.demo.Model.Permission;
import com.example.demo.Response.ApplyVO;

public interface ApplyService {
    public String AddApplication(ApplyModel applyModel);

    public ApplyVO GetApplications();

    public ApplyVO GetMyApply(String Openid);

    public String UploadPermission(Permission permission);
}
