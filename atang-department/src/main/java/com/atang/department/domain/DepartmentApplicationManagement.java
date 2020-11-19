package com.atang.department.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 请假销假管理对象 stu_application
 * 
 * @author atang
 * @date 2020-11-19
 */
public class DepartmentApplicationManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假ID */
    private Long applyId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 学生性别（0男 1女 2未知） */
    @Excel(name = "学生性别", readConverterExp = "0=男,1=女,2=未知")
    private String stuSex;

    /** 学生院系 */
    @Excel(name = "学生院系")
    private String stuDept;

    /** 请假事由 */
    @Excel(name = "请假事由")
    private String applyReason;

    /** 离校时间 */
    @Excel(name = "离校时间")
    private String leaveTime;

    /** 返校时间 */
    @Excel(name = "返校时间")
    private String backTime;

    /** 去往何地 */
    @Excel(name = "去往何地")
    private String leaveDestination;

    /** 是否生病 */
    @Excel(name = "是否生病")
    private String sick;

    /** 本人电话 */
    @Excel(name = "本人电话")
    private String phonenumber;

    /** 班导师姓名 */
    @Excel(name = "班导师姓名")
    private String teacherName;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String status;

    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }
    public void setStuId(Long stuId) 
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setStuSex(String stuSex) 
    {
        this.stuSex = stuSex;
    }

    public String getStuSex() 
    {
        return stuSex;
    }
    public void setStuDept(String stuDept) 
    {
        this.stuDept = stuDept;
    }

    public String getStuDept() 
    {
        return stuDept;
    }
    public void setApplyReason(String applyReason) 
    {
        this.applyReason = applyReason;
    }

    public String getApplyReason() 
    {
        return applyReason;
    }
    public void setLeaveTime(String leaveTime) 
    {
        this.leaveTime = leaveTime;
    }

    public String getLeaveTime() 
    {
        return leaveTime;
    }
    public void setBackTime(String backTime) 
    {
        this.backTime = backTime;
    }

    public String getBackTime() 
    {
        return backTime;
    }
    public void setLeaveDestination(String leaveDestination) 
    {
        this.leaveDestination = leaveDestination;
    }

    public String getLeaveDestination() 
    {
        return leaveDestination;
    }
    public void setSick(String sick) 
    {
        this.sick = sick;
    }

    public String getSick() 
    {
        return sick;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applyId", getApplyId())
            .append("stuId", getStuId())
            .append("stuName", getStuName())
            .append("stuSex", getStuSex())
            .append("stuDept", getStuDept())
            .append("applyReason", getApplyReason())
            .append("leaveTime", getLeaveTime())
            .append("backTime", getBackTime())
            .append("leaveDestination", getLeaveDestination())
            .append("sick", getSick())
            .append("phonenumber", getPhonenumber())
            .append("teacherName", getTeacherName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
