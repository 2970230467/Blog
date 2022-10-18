package com.ruoyi.business.service;

import java.util.List;
import com.blog.business.domain.SHomework;

/**
 * 作业Service接口
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
public interface ISHomeworkService
{
    /**
     * 查询作业
     *
     * @param id 作业主键
     * @return 作业
     */
    public SHomework selectSHomeworkById(Long id);

    /**
     * 查询作业列表
     *
     * @param sHomework 作业
     * @return 作业集合
     */
    public List<SHomework> selectSHomeworkList(SHomework sHomework);

    /**
     * 新增作业
     *
     * @param sHomework 作业
     * @return 结果
     */
    public int insertSHomework(SHomework sHomework);

    /**
     * 修改作业
     *
     * @param sHomework 作业
     * @return 结果
     */
    public int updateSHomework(SHomework sHomework);

    /**
     * 批量删除作业
     *
     * @param ids 需要删除的作业主键集合
     * @return 结果
     */
    public int deleteSHomeworkByIds(Long[] ids);

    /**
     * 删除作业信息
     *
     * @param id 作业主键
     * @return 结果
     */
    public int deleteSHomeworkById(Long id);
}
