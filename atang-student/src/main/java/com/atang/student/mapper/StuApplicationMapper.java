package com.atang.student.mapper;

import java.util.List;
import com.atang.student.domain.StuApplication;

/**
 * 学生请假销假Mapper接口
 * 
 * @author atang
 * @date 2020-11-14
 */
public interface StuApplicationMapper 
{
    /**
     * 查询学生请假销假
     * 
     * @param applyId 学生请假销假ID
     * @return 学生请假销假
     */
    public StuApplication selectStuApplicationById(Long applyId);

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
     * 删除学生请假销假
     * 
     * @param applyId 学生请假销假ID
     * @return 结果
     */
    public int deleteStuApplicationById(Long applyId);

    /**
     * 批量删除学生请假销假
     * 
     * @param applyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteStuApplicationByIds(String[] applyIds);

    /**
     * 查询学生全部请假销假
     *
     * @param stuId 学生请假销假ID
     * @return 学生请假销假集合
     */
    List<StuApplication> selectStuApplicationsById(Long stuId);
}
