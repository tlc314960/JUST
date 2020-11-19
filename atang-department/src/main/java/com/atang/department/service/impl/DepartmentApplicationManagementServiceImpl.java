package com.atang.department.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atang.department.mapper.DepartmentApplicationManagementMapper;
import com.atang.department.domain.DepartmentApplicationManagement;
import com.atang.department.service.IDepartmentApplicationManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 请假销假管理Service业务层处理
 * 
 * @author atang
 * @date 2020-11-19
 */
@Service
public class DepartmentApplicationManagementServiceImpl implements IDepartmentApplicationManagementService 
{
    @Autowired
    private DepartmentApplicationManagementMapper departmentApplicationManagementMapper;

    /**
     * 查询请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 请假销假管理
     */
    @Override
    public DepartmentApplicationManagement selectDepartmentApplicationManagementById(Long applyId)
    {
        return departmentApplicationManagementMapper.selectDepartmentApplicationManagementById(applyId);
    }

    /**
     * 查询请假销假管理列表
     * 
     * @param departmentApplicationManagement 请假销假管理
     * @return 请假销假管理
     */
    @Override
    public List<DepartmentApplicationManagement> selectDepartmentApplicationManagementList(DepartmentApplicationManagement departmentApplicationManagement)
    {
        return departmentApplicationManagementMapper.selectDepartmentApplicationManagementList(departmentApplicationManagement);
    }

    /**
     * 新增请假销假管理
     * 
     * @param departmentApplicationManagement 请假销假管理
     * @return 结果
     */
    @Override
    public int insertDepartmentApplicationManagement(DepartmentApplicationManagement departmentApplicationManagement)
    {
        departmentApplicationManagement.setCreateTime(DateUtils.getNowDate());
        return departmentApplicationManagementMapper.insertDepartmentApplicationManagement(departmentApplicationManagement);
    }

    /**
     * 修改请假销假管理
     * 
     * @param departmentApplicationManagement 请假销假管理
     * @return 结果
     */
    @Override
    public int updateDepartmentApplicationManagement(DepartmentApplicationManagement departmentApplicationManagement)
    {
        departmentApplicationManagement.setUpdateTime(DateUtils.getNowDate());
        return departmentApplicationManagementMapper.updateDepartmentApplicationManagement(departmentApplicationManagement);
    }

    /**
     * 删除请假销假管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDepartmentApplicationManagementByIds(String ids)
    {
        return departmentApplicationManagementMapper.deleteDepartmentApplicationManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除请假销假管理信息
     * 
     * @param applyId 请假销假管理ID
     * @return 结果
     */
    @Override
    public int deleteDepartmentApplicationManagementById(Long applyId)
    {
        return departmentApplicationManagementMapper.deleteDepartmentApplicationManagementById(applyId);
    }
}
