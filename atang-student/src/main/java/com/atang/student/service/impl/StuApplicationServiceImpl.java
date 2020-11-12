package com.atang.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atang.student.mapper.StuApplicationMapper;
import com.atang.student.domain.StuApplication;
import com.atang.student.service.IStuApplicationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生请假销假Service业务层处理
 * 
 * @author atang
 * @date 2020-11-12
 */
@Service
public class StuApplicationServiceImpl implements IStuApplicationService 
{
    @Autowired
    private StuApplicationMapper stuApplicationMapper;

    /**
     * 查询学生请假销假
     * 
     * @param applyId 学生请假销假ID
     * @return 学生请假销假
     */
    @Override
    public StuApplication selectStuApplicationById(Long applyId)
    {
        return stuApplicationMapper.selectStuApplicationById(applyId);
    }

    /**
     * 查询学生请假销假列表
     * 
     * @param stuApplication 学生请假销假
     * @return 学生请假销假
     */
    @Override
    public List<StuApplication> selectStuApplicationList(StuApplication stuApplication)
    {
        return stuApplicationMapper.selectStuApplicationList(stuApplication);
    }

    /**
     * 新增学生请假销假
     * 
     * @param stuApplication 学生请假销假
     * @return 结果
     */
    @Override
    public int insertStuApplication(StuApplication stuApplication)
    {
        stuApplication.setCreateTime(DateUtils.getNowDate());
        return stuApplicationMapper.insertStuApplication(stuApplication);
    }

    /**
     * 修改学生请假销假
     * 
     * @param stuApplication 学生请假销假
     * @return 结果
     */
    @Override
    public int updateStuApplication(StuApplication stuApplication)
    {
        stuApplication.setUpdateTime(DateUtils.getNowDate());
        return stuApplicationMapper.updateStuApplication(stuApplication);
    }

    /**
     * 删除学生请假销假对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStuApplicationByIds(String ids)
    {
        return stuApplicationMapper.deleteStuApplicationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生请假销假信息
     * 
     * @param applyId 学生请假销假ID
     * @return 结果
     */
    @Override
    public int deleteStuApplicationById(Long applyId)
    {
        return stuApplicationMapper.deleteStuApplicationById(applyId);
    }
}
