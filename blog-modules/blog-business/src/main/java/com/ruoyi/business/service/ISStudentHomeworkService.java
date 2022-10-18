package com.ruoyi.business.service;

import java.util.List;
import com.blog.business.domain.SStudentHomework;

/**
 * 查看作业Service接口
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
public interface ISStudentHomeworkService
{
    /**
     * 查询查看作业
     *
     * @param id 查看作业主键
     * @return 查看作业
     */
    public SStudentHomework selectSStudentHomeworkById(Long id);

    /**
     * 查询查看作业列表
     *
     * @param sStudentHomework 查看作业
     * @return 查看作业集合
     */
    public List<SStudentHomework> selectSStudentHomeworkList(SStudentHomework sStudentHomework);

    /**
     * 新增查看作业
     *
     * @param sStudentHomework 查看作业
     * @return 结果
     */
    public int insertSStudentHomework(SStudentHomework sStudentHomework);

    /**
     * 修改查看作业
     *
     * @param sStudentHomework 查看作业
     * @return 结果
     */
    public int updateSStudentHomework(SStudentHomework sStudentHomework);

    /**
     * 批量删除查看作业
     *
     * @param ids 需要删除的查看作业主键集合
     * @return 结果
     */
    public int deleteSStudentHomeworkByIds(Long[] ids);

    /**
     * 删除查看作业信息
     *
     * @param id 查看作业主键
     * @return 结果
     */
    public int deleteSStudentHomeworkById(Long id);
}
