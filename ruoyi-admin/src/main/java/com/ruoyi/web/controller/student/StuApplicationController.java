package com.ruoyi.web.controller.student;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.service.ISysRoleService;
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
import com.atang.student.domain.StuApplication;
import com.atang.student.service.IStuApplicationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.sound.midi.Soundbank;

/**
 * 学生请假销假Controller
 * 
 * @author atang
 * @date 2020-11-14
 */
@Controller
@RequestMapping("/student/application")
public class StuApplicationController extends BaseController
{
    private String prefix = "student/application";

    @Autowired
    private IStuApplicationService stuApplicationService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @RequiresPermissions("student:application:view")
    @GetMapping()
    public String application()
    {
        return prefix + "/application";
    }

    /**
     * 查询学生请假销假列表
     */
    @RequiresPermissions("student:application:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StuApplication stuApplication)
    {
        startPage();
        SysUser user = ShiroUtils.getSysUser();
        Long userId = user.getUserId();
        int roleId = userService.selectUserRoleByUserId(userId).remove(0).getRoleId().intValue();
//        int roleId = user.getRoleId().intValue();
        List<StuApplication> list = null;

        switch (roleId){
            case 1://admin
                list = stuApplicationService.selectStuApplicationList(stuApplication);
                break;
            case 2://student
//                list = stuApplicationService.selectStuApplicationsById(userId);
                list = stuApplicationService.selectStuApplicationsById(userId, stuApplication);
                break;
//            case 100://teacher
//                String deptName = user.getDept().getDeptName();
//                list = stuApplicationService.selectStuApplicationsByDeptName(deptName);
            default:
                System.out.println("error!");
                break;
        }
        return getDataTable(list);
    }

    /**
     * 导出学生请假销假列表
     */
    @RequiresPermissions("student:application:export")
    @Log(title = "学生请假销假", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StuApplication stuApplication)
    {
        List<StuApplication> list = stuApplicationService.selectStuApplicationList(stuApplication);
        ExcelUtil<StuApplication> util = new ExcelUtil<StuApplication>(StuApplication.class);
        return util.exportExcel(list, "application");
    }

    /**
     * 新增学生请假销假
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        SysUser user = ShiroUtils.getSysUser();
        if(!user.getLoginName().equals("admin")){

        }
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/add";
    }

    /**
     * 新增保存学生请假销假
     */
    @RequiresPermissions("student:application:add")
    @Log(title = "学生请假销假", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StuApplication stuApplication)
    {
        return toAjax(stuApplicationService.insertStuApplication(stuApplication));
    }

    /**
     * 修改学生请假销假
     */
    @GetMapping("/edit/{applyId}")
    public String edit(@PathVariable("applyId") Long applyId, ModelMap mmap)
    {
        StuApplication stuApplication = stuApplicationService.selectStuApplicationById(applyId);
        mmap.put("stuApplication", stuApplication);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生请假销假
     */
    @RequiresPermissions("student:application:edit")
    @Log(title = "学生请假销假", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StuApplication stuApplication)
    {
        return toAjax(stuApplicationService.updateStuApplication(stuApplication));
    }

    /**
     * 删除学生请假销假
     */
    @RequiresPermissions("student:application:remove")
    @Log(title = "学生请假销假", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stuApplicationService.deleteStuApplicationByIds(ids));
    }

    /**
     * 改变学生请假销假状态 +1
     */
    @RequiresPermissions("student:application:edit")
    @Log(title = "学生请假销假", businessType = BusinessType.UPDATE)
    @PostMapping( "/addStatus")
    @ResponseBody
    public AjaxResult addStatus(String ids)
    {
        return toAjax(stuApplicationService.addStuApplicationStatusByIds(ids));
    }


    @RequiresPermissions("student:application:detail")
    @GetMapping("/detail/{applyId}")
    public String detail(@PathVariable("applyId") Long applyId, ModelMap mmap)
    {
        mmap.put("stuApplication", stuApplicationService.selectStuApplicationById(applyId));
        return prefix + "/detail";
    }
}
