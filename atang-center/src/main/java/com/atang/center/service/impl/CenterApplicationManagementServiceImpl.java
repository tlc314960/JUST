package com.atang.center.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atang.center.mapper.CenterApplicationManagementMapper;
import com.atang.center.domain.CenterApplicationManagement;
import com.atang.center.service.ICenterApplicationManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 请假销假管理Service业务层处理
 * 
 * @author atang
 * @date 2020-11-19
 */
@Service
public class CenterApplicationManagementServiceImpl implements ICenterApplicationManagementService 
{
    @Autowired
    private CenterApplicationManagementMapper centerApplicationManagementMapper;

    /**
     * 查询请假销假管理
     * 
     * @param applyId 请假销假管理ID
     * @return 请假销假管理
     */
    @Override
    public CenterApplicationManagement selectCenterApplicationManagementById(Long applyId)
    {
        return centerApplicationManagementMapper.selectCenterApplicationManagementById(applyId);
    }

    /**
     * 查询请假销假管理列表
     * 
     * @param centerApplicationManagement 请假销假管理
     * @return 请假销假管理
     */
    @Override
    public List<CenterApplicationManagement> selectCenterApplicationManagementList(CenterApplicationManagement centerApplicationManagement)
    {
        return centerApplicationManagementMapper.selectCenterApplicationManagementList(centerApplicationManagement);
    }

    /**
     * 新增请假销假管理
     * 
     * @param centerApplicationManagement 请假销假管理
     * @return 结果
     */
    @Override
    public int insertCenterApplicationManagement(CenterApplicationManagement centerApplicationManagement)
    {
        centerApplicationManagement.setCreateTime(DateUtils.getNowDate());
        return centerApplicationManagementMapper.insertCenterApplicationManagement(centerApplicationManagement);
    }

    /**
     * 修改请假销假管理
     * 
     * @param centerApplicationManagement 请假销假管理
     * @return 结果
     */
    @Override
    public int updateCenterApplicationManagement(CenterApplicationManagement centerApplicationManagement)
    {
        centerApplicationManagement.setUpdateTime(DateUtils.getNowDate());
        return centerApplicationManagementMapper.updateCenterApplicationManagement(centerApplicationManagement);
    }

    /**
     * 删除请假销假管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCenterApplicationManagementByIds(String ids)
    {
        return centerApplicationManagementMapper.deleteCenterApplicationManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除请假销假管理信息
     * 
     * @param applyId 请假销假管理ID
     * @return 结果
     */
    @Override
    public int deleteCenterApplicationManagementById(Long applyId)
    {
        return centerApplicationManagementMapper.deleteCenterApplicationManagementById(applyId);
    }
}
