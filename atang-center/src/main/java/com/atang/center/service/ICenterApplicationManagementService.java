package com.atang.center.service;

import java.util.List;
import com.atang.center.domain.CenterApplicationManagement;

/**
 * 请假销假管理Service接口
 * 
 * @author atang
 * @date 2020-11-19
 */
public interface ICenterApplicationManagementService 
{
    /**
     * 查询请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 请假销假管理
     */
    public CenterApplicationManagement selectCenterApplicationManagementById(Long applyId);

    /**
     * 查询请假销假管理列表
     * 
     * @param centerApplicationManagement 请假销假管理
     * @return 请假销假管理集合
     */
    public List<CenterApplicationManagement> selectCenterApplicationManagementList(CenterApplicationManagement centerApplicationManagement);

    /**
     * 新增请假销假管理
     * 
     * @param centerApplicationManagement 请假销假管理
     * @return 结果
     */
    public int insertCenterApplicationManagement(CenterApplicationManagement centerApplicationManagement);

    /**
     * 修改请假销假管理
     * 
     * @param centerApplicationManagement 请假销假管理
     * @return 结果
     */
    public int updateCenterApplicationManagement(CenterApplicationManagement centerApplicationManagement);

    /**
     * 批量删除请假销假管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCenterApplicationManagementByIds(String ids);

    /**
     * 删除请假销假管理信息
     * 
     * @param applyId 请假销假管理ID
     * @return 结果
     */
    public int deleteCenterApplicationManagementById(Long applyId);
}
