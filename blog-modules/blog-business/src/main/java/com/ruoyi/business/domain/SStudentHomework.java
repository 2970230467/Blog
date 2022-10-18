package com.ruoyi.business.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;

/**
 * 查看作业对象 s_student_homework
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
public class SStudentHomework extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 作业id */
    @Excel(name = "作业id")
    private Long homeworkId;

    /** 作业标题 */
    @Excel(name = "作业标题")
    private String homeworkTitle;

    /** 作业内容 */
    @Excel(name = "作业内容")
    private String homeworkContent;

    /** 作业评分 */
    @Excel(name = "作业评分")
    private BigDecimal homeworkScore;

    /** 批阅时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批阅时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String stuClassName;

    /** 作业表 */
    @Excel(name = "作业表")
    private SHomework SHomework;

    /** 作业表 */
    @Excel(name = "是否批阅")
    private String state;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentId()
    {
        return studentId;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public void setHomeworkId(Long homeworkId)
    {
        this.homeworkId = homeworkId;
    }

    public Long getHomeworkId()
    {
        return homeworkId;
    }
    public void setHomeworkTitle(String homeworkTitle)
    {
        this.homeworkTitle = homeworkTitle;
    }

    public String getHomeworkTitle()
    {
        return homeworkTitle;
    }
    public void setHomeworkContent(String homeworkContent)
    {
        this.homeworkContent = homeworkContent;
    }

    public String getHomeworkContent()
    {
        return homeworkContent;
    }
    public void setHomeworkScore(BigDecimal homeworkScore)
    {
        this.homeworkScore = homeworkScore;
    }

    public BigDecimal getHomeworkScore()
    {
        return homeworkScore;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getStuClassName() {
        return stuClassName;
    }

    public SHomework getSHomework() {return SHomework;}

    public String getState() {
        return state;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName;
    }

    public void setSHomework(SHomework SHomework) {
        this.SHomework = SHomework;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("homeworkId", getHomeworkId())
            .append("homeworkTitle", getHomeworkTitle())
            .append("homeworkContent", getHomeworkContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("homeworkScore", getHomeworkScore())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("stuClassName", getStuClassName())
                .append("state", getState())
                .append("getSHomework", getSHomework())
            .toString();
    }
}
