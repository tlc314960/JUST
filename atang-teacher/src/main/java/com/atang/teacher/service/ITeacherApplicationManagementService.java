package com.atang.teacher.service;

import java.util.List;
import com.atang.teacher.domain.TeacherApplicationManagement;

/**
 * 请假销假管理Service接口
 * 
 * @author atang
 * @date 2020-11-17
 */
public interface ITeacherApplicationManagementService 
{
    /**
     * 查询请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 请假销假管理
     */
    public TeacherApplicationManagement selectTeacherApplicationManagementById(Long applyId);

    /**
     * 查询请假销假管理列表
     * 
     * @param teacherApplicationManagement 请假销假管理
     * @return 请假销假管理集合
     */
    public List<TeacherApplicationManagement> selectTeacherApplicationManagementList(TeacherApplicationManagement teacherApplicationManagement);

    /**
     * 新增请假销假管理
     * 
     * @param teacherApplicationManagement 请假销假管理
     * @return 结果
     */
    public int insertTeacherApplicationManagement(TeacherApplicationManagement teacherApplicationManagement);

    /**
     * 修改请假销假管理
     * 
     * @param teacherApplicationManagement 请假销假管理
     * @return 结果
     */
    public int updateTeacherApplicationManagement(TeacherApplicationManagement teacherApplicationManagement);

    /**
     * 批量删除请假销假管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTeacherApplicationManagementByIds(String ids);

    /**
     * 删除请假销假管理信息
     * 
     * @param applyId 请假销假管理ID
     * @return 结果
     */
    public int deleteTeacherApplicationManagementById(Long applyId);
}
