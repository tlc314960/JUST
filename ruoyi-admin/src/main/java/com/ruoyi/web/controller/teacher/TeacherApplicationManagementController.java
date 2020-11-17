package com.ruoyi.web.controller.teacher;

import com.atang.student.domain.StuApplication;
import com.atang.student.service.IStuApplicationService;
import com.atang.teacher.domain.TeacherApplicationManagement;
import com.atang.teacher.service.ITeacherApplicationManagementService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请假销假管理Controller
 * 
 * @author atang
 * @date 2020-11-17
 */
@Controller
@RequestMapping("/teacher/applicationManagement")
public class TeacherApplicationManagementController extends BaseController
{
    private String teacher_prefix = "teacher/applicationManagement";
    private String student_prefix = "student/application";

    @Autowired
    private ITeacherApplicationManagementService teacherApplicationManagementService;

    @Autowired
    private IStuApplicationService stuApplicationService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("teacher:applicationManagement:view")
    @GetMapping()
    public String applicationManagement()
    {
        return teacher_prefix + "/applicationManagement";
    }

    /**
     * 查询请假销假管理列表
     */
    @RequiresPermissions("teacher:applicationManagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StuApplication stuApplication)
    {
        startPage();
        SysUser user = ShiroUtils.getSysUser();
        Long userId = user.getUserId();
        int roleId = userService.selectUserRoleByUserId(userId).remove(0).getRoleId().intValue();
        List<StuApplication> list = null;
        switch (roleId){
            case 1://admin
                list = stuApplicationService.selectStuApplicationList(stuApplication);
                break;
//            case 2://student
//                list = stuApplicationService.selectStuApplicationsById(userId);
//                break;
            case 100://teacher
                String deptName = user.getDept().getDeptName();
                list = stuApplicationService.selectStuApplicationsByDeptName(deptName);
            default:
                System.out.println("error!");
                break;
        }
        return getDataTable(list);
//        startPage();
//        List<TeacherApplicationManagement> list = teacherApplicationManagementService.selectTeacherApplicationManagementList(teacherApplicationManagement);
//        return getDataTable(list);
    }

    /**
     * 导出请假销假管理列表
     */
    @RequiresPermissions("teacher:applicationManagement:export")
    @Log(title = "请假销假管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeacherApplicationManagement teacherApplicationManagement)
    {
        List<TeacherApplicationManagement> list = teacherApplicationManagementService.selectTeacherApplicationManagementList(teacherApplicationManagement);
        ExcelUtil<TeacherApplicationManagement> util = new ExcelUtil<TeacherApplicationManagement>(TeacherApplicationManagement.class);
        return util.exportExcel(list, "applicationManagement");
    }

    /**
     * 新增请假销假管理
     */
    @GetMapping("/add")
    public String add()
    {
        return teacher_prefix + "/add";
    }

    /**
     * 新增保存请假销假管理
     */
    @RequiresPermissions("teacher:applicationManagement:add")
    @Log(title = "请假销假管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TeacherApplicationManagement teacherApplicationManagement)
    {
        return toAjax(teacherApplicationManagementService.insertTeacherApplicationManagement(teacherApplicationManagement));
    }

    /**
     * 修改请假销假管理
     */
    @GetMapping("/edit/{applyId}")
    public String edit(@PathVariable("applyId") Long applyId, ModelMap mmap)
    {
        TeacherApplicationManagement teacherApplicationManagement = teacherApplicationManagementService.selectTeacherApplicationManagementById(applyId);
        mmap.put("teacherApplicationManagement", teacherApplicationManagement);
        return teacher_prefix + "/edit";
    }

    /**
     * 修改保存请假销假管理
     */
    @RequiresPermissions("teacher:applicationManagement:edit")
    @Log(title = "请假销假管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TeacherApplicationManagement teacherApplicationManagement)
    {
        return toAjax(teacherApplicationManagementService.updateTeacherApplicationManagement(teacherApplicationManagement));
    }

    /**
     * 删除请假销假管理
     */
    @RequiresPermissions("teacher:applicationManagement:remove")
    @Log(title = "请假销假管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teacherApplicationManagementService.deleteTeacherApplicationManagementByIds(ids));
    }
}
