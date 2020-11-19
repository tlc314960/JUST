package com.atang.department.mapper;

import java.util.List;
import com.atang.department.domain.DepartmentApplicationManagement;

/**
 * 请假销假管理Mapper接口
 * 
 * @author atang
 * @date 2020-11-19
 */
public interface DepartmentApplicationManagementMapper 
{
    /**
     * 查询请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 请假销假管理
     */
    public DepartmentApplicationManagement selectDepartmentApplicationManagementById(Long applyId);

    /**
     * 查询请假销假管理列表
     * 
     * @param departmentApplicationManagement 请假销假管理
     * @return 请假销假管理集合
     */
    public List<DepartmentApplicationManagement> selectDepartmentApplicationManagementList(DepartmentApplicationManagement departmentApplicationManagement);

    /**
     * 新增请假销假管理
     * 
     * @param departmentApplicationManagement 请假销假管理
     * @return 结果
     */
    public int insertDepartmentApplicationManagement(DepartmentApplicationManagement departmentApplicationManagement);

    /**
     * 修改请假销假管理
     * 
     * @param departmentApplicationManagement 请假销假管理
     * @return 结果
     */
    public int updateDepartmentApplicationManagement(DepartmentApplicationManagement departmentApplicationManagement);

    /**
     * 删除请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 结果
     */
    public int deleteDepartmentApplicationManagementById(Long applyId);

    /**
     * 批量删除请假销假管理
     * 
     * @param applyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDepartmentApplicationManagementByIds(String[] applyIds);
}
