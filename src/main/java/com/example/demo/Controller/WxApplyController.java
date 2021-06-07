package com.example.demo.Controller;

import com.example.demo.Model.AllApplyInfo;
import com.example.demo.Model.Permission;
import com.example.demo.Response.ApplyVO;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Service.ApplyService;
import com.example.demo.Model.ApplyModel;
import javax.annotation.Resource;
@RestController
public class WxApplyController {
    @Resource
    ApplyService applyService;

    @PostMapping("/LeaveUpdate")
    public JSONObject LeaveUpdate(@RequestBody ApplyModel leaveModel) {
        JSONObject ret = new JSONObject();
        try {
            String msg  = applyService.AddApplication(leaveModel);
            System.out.println(leaveModel.toString());
            ret.put("success", true);
            ret.put("exc", "");
        }
        catch (Exception e) {
            ret.put("success", false);
            e.printStackTrace();
            ret.put("exc", e.getMessage());
        }

        return ret;
    }




    @PostMapping("/UploadPermission")
    public JSONObject UploadPermission(@RequestBody Permission permission){

        JSONObject jsonObject = new JSONObject();
        try {
            String msg = applyService.UploadPermission(permission);
            jsonObject.put("success", true);
            jsonObject.put("exc", msg);
        }
        catch (Exception e) {
            jsonObject.put("success", false);
            e.printStackTrace();
            jsonObject.put("exc", e.getMessage());
        }
        return jsonObject;
    }


    @GetMapping("/GetApproval")
    public ApplyVO GetAllApplyInfos(){
        return applyService.GetApplications();
    }

    @GetMapping("GetApproval/Mine")
    public ApplyVO GetMyApply(@RequestParam("Openid") String Openid){
        System.out.println(Openid);
        return applyService.GetMyApply(Openid);
    }



}
