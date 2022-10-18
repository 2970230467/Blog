package com.ruoyi.business.mapper;

import java.util.List;
import com.blog.business.domain.SHomework;

/**
 * 作业Mapper接口
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
public interface SHomeworkMapper
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
     * 删除作业
     *
     * @param id 作业主键
     * @return 结果
     */
    public int deleteSHomeworkById(Long id);

    /**
     * 批量删除作业
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSHomeworkByIds(Long[] ids);
}
