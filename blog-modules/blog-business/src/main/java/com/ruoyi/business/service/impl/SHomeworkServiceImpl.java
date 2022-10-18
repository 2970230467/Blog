package com.ruoyi.business.service.impl;

import java.util.List;
import com.blog.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.business.mapper.SHomeworkMapper;
import com.blog.business.domain.SHomework;
import com.blog.business.service.ISHomeworkService;

/**
 * 作业Service业务层处理
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
@Service
public class SHomeworkServiceImpl implements ISHomeworkService
{
    @Autowired
    private SHomeworkMapper sHomeworkMapper;

    /**
     * 查询作业
     *
     * @param id 作业主键
     * @return 作业
     */
    @Override
    public SHomework selectSHomeworkById(Long id)
    {
        return sHomeworkMapper.selectSHomeworkById(id);
    }

    /**
     * 查询作业列表
     *
     * @param sHomework 作业
     * @return 作业
     */
    @Override
    public List<SHomework> selectSHomeworkList(SHomework sHomework)
    {
        return sHomeworkMapper.selectSHomeworkList(sHomework);
    }

    /**
     * 新增作业
     *
     * @param sHomework 作业
     * @return 结果
     */
    @Override
    public int insertSHomework(SHomework sHomework)
    {
        sHomework.setCreateTime(DateUtils.getNowDate());
        return sHomeworkMapper.insertSHomework(sHomework);
    }

    /**
     * 修改作业
     *
     * @param sHomework 作业
     * @return 结果
     */
    @Override
    public int updateSHomework(SHomework sHomework)
    {
        sHomework.setUpdateTime(DateUtils.getNowDate());
        return sHomeworkMapper.updateSHomework(sHomework);
    }

    /**
     * 批量删除作业
     *
     * @param ids 需要删除的作业主键
     * @return 结果
     */
    @Override
    public int deleteSHomeworkByIds(Long[] ids)
    {
        return sHomeworkMapper.deleteSHomeworkByIds(ids);
    }

    /**
     * 删除作业信息
     *
     * @param id 作业主键
     * @return 结果
     */
    @Override
    public int deleteSHomeworkById(Long id)
    {
        return sHomeworkMapper.deleteSHomeworkById(id);
    }
}
