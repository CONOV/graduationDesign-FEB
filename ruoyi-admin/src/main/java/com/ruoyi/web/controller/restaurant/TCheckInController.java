package com.ruoyi.web.controller.restaurant;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TAttendancesheet;
import com.ruoyi.system.service.ITCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant/checkin")
public class TCheckInController extends BaseController {

    @Autowired
    private ITCheckInService itCheckInService;

    @PreAuthorize("@ss.hasAnyPermi('restaurant:checkin:add')")
    @Log(title = "打卡管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody TAttendancesheet tAttendancesheet) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",itCheckInService.add(tAttendancesheet));
        return ajax;
    }

}