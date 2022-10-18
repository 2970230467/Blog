package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;

/**
 * 作业对象 s_homework
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
public class SHomework extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师id */
    @Excel(name = "教师id")
    private String teacherId;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String teacherName;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String stuClassName;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 作业标题 */
    @Excel(name = "作业标题")
    private String title;

    /** 作业内容 */
    @Excel(name = "作业内容")
    private String content;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态(0开始，1结束) */
    @Excel(name = "状态(0开始，1结束)")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherId()
    {
        return teacherId;
    }
    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName()
    {
        return teacherName;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getCourseName()
    {
        return courseName;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public String getStuClassName() {
        return stuClassName;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherId", getTeacherId())
            .append("teacherName", getTeacherName())
            .append("courseName", getCourseName())
            .append("title", getTitle())
            .append("content", getContent())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("stuClassName", getStuClassName())
            .toString();
    }
}
