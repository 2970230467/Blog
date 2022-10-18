package com.ruoyi.business.service.impl;

import java.util.List;
import com.blog.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.business.mapper.SStudentHomeworkMapper;
import com.blog.business.domain.SStudentHomework;
import com.blog.business.service.ISStudentHomeworkService;

/**
 * 查看作业Service业务层处理
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
@Service
public class SStudentHomeworkServiceImpl implements ISStudentHomeworkService
{
    @Autowired
    private SStudentHomeworkMapper sStudentHomeworkMapper;

    /**
     * 查询查看作业
     *
     * @param id 查看作业主键
     * @return 查看作业
     */
    @Override
    public SStudentHomework selectSStudentHomeworkById(Long id)
    {
        return sStudentHomeworkMapper.selectSStudentHomeworkById(id);
    }

    /**
     * 查询查看作业列表
     *
     * @param sStudentHomework 查看作业
     * @return 查看作业
     */
    @Override
    public List<SStudentHomework> selectSStudentHomeworkList(SStudentHomework sStudentHomework)
    {
        return sStudentHomeworkMapper.selectSStudentHomeworkList(sStudentHomework);
    }

    /**
     * 新增查看作业
     *
     * @param sStudentHomework 查看作业
     * @return 结果
     */
    @Override
    public int insertSStudentHomework(SStudentHomework sStudentHomework)
    {
        sStudentHomework.setCreateTime(DateUtils.getNowDate());
        return sStudentHomeworkMapper.insertSStudentHomework(sStudentHomework);
    }

    /**
     * 修改查看作业
     *
     * @param sStudentHomework 查看作业
     * @return 结果
     */
    @Override
    public int updateSStudentHomework(SStudentHomework sStudentHomework)
    {
        sStudentHomework.setUpdateTime(DateUtils.getNowDate());
        return sStudentHomeworkMapper.updateSStudentHomework(sStudentHomework);
    }

    /**
     * 批量删除查看作业
     *
     * @param ids 需要删除的查看作业主键
     * @return 结果
     */
    @Override
    public int deleteSStudentHomeworkByIds(Long[] ids)
    {
        return sStudentHomeworkMapper.deleteSStudentHomeworkByIds(ids);
    }

    /**
     * 删除查看作业信息
     *
     * @param id 查看作业主键
     * @return 结果
     */
    @Override
    public int deleteSStudentHomeworkById(Long id)
    {
        return sStudentHomeworkMapper.deleteSStudentHomeworkById(id);
    }
}
