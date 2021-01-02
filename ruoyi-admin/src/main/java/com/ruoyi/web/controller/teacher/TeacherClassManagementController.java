package com.ruoyi.web.controller.teacher;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.List;

/**
 * 班级管理Controller
 *
 * @author atang
 * @date 2020-12-25
 */
@Controller
@RequestMapping("/teacher/classManagement")
public class TeacherClassManagementController extends BaseController {
    private String prefix = "teacher/classManagement";
    private String sysPrefix = "system/user";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        SysUser user = ShiroUtils.getSysUser();
        Long deptId = user.getDeptId();
//        System.out.println(1);
//        System.out.println(deptId);
        List<SysUser> list = userService.selectUserListByDeptId(deptId);
        return getDataTable(list);
    }
}
