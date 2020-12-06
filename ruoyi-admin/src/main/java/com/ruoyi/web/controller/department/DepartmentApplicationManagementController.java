package com.ruoyi.web.controller.department;

import java.util.List;

import com.atang.student.domain.StuApplication;
import com.atang.student.service.IStuApplicationService;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.atang.department.domain.DepartmentApplicationManagement;
import com.atang.department.service.IDepartmentApplicationManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 请假销假管理Controller
 * 
 * @author atang
 * @date 2020-11-19
 */
@Controller
@RequestMapping("/department/applicationManagement")
public class DepartmentApplicationManagementController extends BaseController
{
    private String department_prefix = "department/applicationManagement";
    private String student_prefix = "student/application";

    @Autowired
    private IDepartmentApplicationManagementService departmentApplicationManagementService;

    @Autowired
    private IStuApplicationService stuApplicationService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("department:applicationManagement:view")
    @GetMapping()
    public String applicationManagement()
    {
        return department_prefix + "/applicationManagement";
    }

    /**
     * 查询请假销假管理列表
     */
    @RequiresPermissions("department:applicationManagement:list")
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
//            case 100://teacher
//                String deptName = user.getDept().getDeptName();
//                list = stuApplicationService.selectStuApplicationsByDeptName(deptName);
            case 101://departmentAdministrator
                Long deptId = user.getDept().getDeptId();
                list = stuApplicationService.selectStuApplicationsByParentDeptName(deptId, stuApplication);
            default:
                System.out.println("error!");
                break;
        }
        return getDataTable(list);
    }

    /**
     * 导出请假销假管理列表
     */
    @RequiresPermissions("department:applicationManagement:export")
    @Log(title = "请假销假管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DepartmentApplicationManagement departmentApplicationManagement)
    {
        List<DepartmentApplicationManagement> list = departmentApplicationManagementService.selectDepartmentApplicationManagementList(departmentApplicationManagement);
        ExcelUtil<DepartmentApplicationManagement> util = new ExcelUtil<DepartmentApplicationManagement>(DepartmentApplicationManagement.class);
        return util.exportExcel(list, "applicationManagement");
    }

    /**
     * 新增请假销假管理
     */
    @GetMapping("/add")
    public String add()
    {
        return department_prefix + "/add";
    }

    /**
     * 新增保存请假销假管理
     */
    @RequiresPermissions("department:applicationManagement:add")
    @Log(title = "请假销假管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DepartmentApplicationManagement departmentApplicationManagement)
    {
        return toAjax(departmentApplicationManagementService.insertDepartmentApplicationManagement(departmentApplicationManagement));
    }

    /**
     * 修改请假销假管理
     */
    @GetMapping("/edit/{applyId}")
    public String edit(@PathVariable("applyId") Long applyId, ModelMap mmap)
    {
        DepartmentApplicationManagement departmentApplicationManagement = departmentApplicationManagementService.selectDepartmentApplicationManagementById(applyId);
        mmap.put("departmentApplicationManagement", departmentApplicationManagement);
        return department_prefix + "/edit";
    }

    /**
     * 修改保存请假销假管理
     */
    @RequiresPermissions("department:applicationManagement:edit")
    @Log(title = "请假销假管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DepartmentApplicationManagement departmentApplicationManagement)
    {
        return toAjax(departmentApplicationManagementService.updateDepartmentApplicationManagement(departmentApplicationManagement));
    }

    /**
     * 删除请假销假管理
     */
    @RequiresPermissions("department:applicationManagement:remove")
    @Log(title = "请假销假管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(departmentApplicationManagementService.deleteDepartmentApplicationManagementByIds(ids));
    }

    /**
     * 改变学生请假销假状态 +1
     */
    @RequiresPermissions("department:applicationManagement:edit")
    @Log(title = "请假销假管理", businessType = BusinessType.UPDATE)
    @PostMapping( "/addStatus")
    @ResponseBody
    public AjaxResult addStatus(String ids)
    {
        return toAjax(stuApplicationService.addStuApplicationStatusByIds(ids));
    }

    /**
     * 改变学生请假销假状态 ->6
     */
    @RequiresPermissions("department:applicationManagement:edit")
    @Log(title = "请假销假管理", businessType = BusinessType.UPDATE)
    @PostMapping( "/endStatus")
    @ResponseBody
    public AjaxResult endStatus(String ids)
    {
        return toAjax(stuApplicationService.endStuApplicationStatusByIds(ids));
    }
}
