package com.atang.teacher.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atang.teacher.mapper.TeacherApplicationManagementMapper;
import com.atang.teacher.domain.TeacherApplicationManagement;
import com.atang.teacher.service.ITeacherApplicationManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 请假销假管理Service业务层处理
 * 
 * @author atang
 * @date 2020-11-17
 */
@Service
public class TeacherApplicationManagementServiceImpl implements ITeacherApplicationManagementService 
{
    @Autowired
    private TeacherApplicationManagementMapper teacherApplicationManagementMapper;

    /**
     * 查询请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 请假销假管理
     */
    @Override
    public TeacherApplicationManagement selectTeacherApplicationManagementById(Long applyId)
    {
        return teacherApplicationManagementMapper.selectTeacherApplicationManagementById(applyId);
    }

    /**
     * 查询请假销假管理列表
     * 
     * @param teacherApplicationManagement 请假销假管理
     * @return 请假销假管理
     */
    @Override
    public List<TeacherApplicationManagement> selectTeacherApplicationManagementList(TeacherApplicationManagement teacherApplicationManagement)
    {
        return teacherApplicationManagementMapper.selectTeacherApplicationManagementList(teacherApplicationManagement);
    }

    /**
     * 新增请假销假管理
     * 
     * @param teacherApplicationManagement 请假销假管理
     * @return 结果
     */
    @Override
    public int insertTeacherApplicationManagement(TeacherApplicationManagement teacherApplicationManagement)
    {
        teacherApplicationManagement.setCreateTime(DateUtils.getNowDate());
        return teacherApplicationManagementMapper.insertTeacherApplicationManagement(teacherApplicationManagement);
    }

    /**
     * 修改请假销假管理
     * 
     * @param teacherApplicationManagement 请假销假管理
     * @return 结果
     */
    @Override
    public int updateTeacherApplicationManagement(TeacherApplicationManagement teacherApplicationManagement)
    {
        teacherApplicationManagement.setUpdateTime(DateUtils.getNowDate());
        return teacherApplicationManagementMapper.updateTeacherApplicationManagement(teacherApplicationManagement);
    }

    /**
     * 删除请假销假管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTeacherApplicationManagementByIds(String ids)
    {
        return teacherApplicationManagementMapper.deleteTeacherApplicationManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除请假销假管理信息
     * 
     * @param applyId 请假销假管理ID
     * @return 结果
     */
    @Override
    public int deleteTeacherApplicationManagementById(Long applyId)
    {
        return teacherApplicationManagementMapper.deleteTeacherApplicationManagementById(applyId);
    }
}
