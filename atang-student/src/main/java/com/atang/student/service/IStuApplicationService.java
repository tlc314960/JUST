package com.atang.student.service;

import java.util.List;
import com.atang.student.domain.StuApplication;

/**
 * 学生请假销假Service接口
 * 
 * @author atang
 * @date 2020-11-14
 */
public interface IStuApplicationService 
{
    /**
     * 查询学生请假销假
     * 
     * @param applyId 学生请假销假ID
     * @return 学生请假销假
     */
    public StuApplication selectStuApplicationById(Long applyId);

    /**
     * 查询学生全部请假销假
     *
     * @param stuId 学生请假销假ID
     * @return 学生请假销假集合
     */
    public List<StuApplication> selectStuApplicationsById(Long stuId);

    /**
     * 查询学生请假销假列表
     * 
     * @param stuApplication 学生请假销假
     * @return 学生请假销假集合
     */
    public List<StuApplication> selectStuApplicationList(StuApplication stuApplication);

    /**
     * 新增学生请假销假
     * 
     * @param stuApplication 学生请假销假
     * @return 结果
     */
    public int insertStuApplication(StuApplication stuApplication);

    /**
     * 修改学生请假销假
     * 
     * @param stuApplication 学生请假销假
     * @return 结果
     */
    public int updateStuApplication(StuApplication stuApplication);

    /**
     * 批量删除学生请假销假
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStuApplicationByIds(String ids);

    /**
     * 删除学生请假销假信息
     * 
     * @param applyId 学生请假销假ID
     * @return 结果
     */
    public int deleteStuApplicationById(Long applyId);

    /**
     * 改变学生请假销假状态 +1
     *
     * @param ids 需要改变的数据ID
     * @return 结果
     */
    public int addStuApplicationStatusByIds(String ids);
}
