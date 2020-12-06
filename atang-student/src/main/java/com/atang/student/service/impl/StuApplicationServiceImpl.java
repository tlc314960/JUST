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
 * @date 2020-11-14
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
     * 查询学生全部请假销假
     *
     * @param stuId 学生请假销假ID
     * @return 学生请假销假集合
     */
    @Override
    public List<StuApplication> selectStuApplicationsById(Long stuId, StuApplication stuApplication) {
        return stuApplicationMapper.selectStuApplicationsById(stuId, stuApplication);
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

    /**
     * 改变学生请假销假状态 +1
     *
     * @param ids 需要改变的数据ID
     * @return 结果
     */
    @Override
    public int addStuApplicationStatusByIds(String ids) {
        return stuApplicationMapper.addStuApplicationStatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 根据院系查询学生请假销假列表
     *
     * @param deptName 学生请假销假
     * @return 学生请假销假集合
     */
    @Override
    public List<StuApplication> selectStuApplicationsByDeptName(String deptName, StuApplication stuApplication) {
        return stuApplicationMapper.selectStuApplicationsByDeptName(deptName, stuApplication);
    }

    /**
     * 改变学生请假销假状态 ->6
     *
     * @param ids 需要改变的数据ID
     * @return 结果
     */
    @Override
    public int endStuApplicationStatusByIds(String ids) {
        return stuApplicationMapper.endStuApplicationStatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 根据父院系Id查询学生请假销假列表
     *
     * @param deptId 学生请假销假
     * @return 学生请假销假集合
     */
    @Override
    public List<StuApplication> selectStuApplicationsByParentDeptName(Long deptId, StuApplication stuApplication) {
        return stuApplicationMapper.selectStuApplicationsByParentDeptName(deptId, stuApplication);
    }
}
