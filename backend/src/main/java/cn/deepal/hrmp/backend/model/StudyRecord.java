package cn.deepal.hrmp.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学习记录表
 * @TableName StudyRecord
 */
@TableName(value ="StudyRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyRecord implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 月份
     */
    @TableField(value = "month")
    private Integer month;

    /**
     * 工号
     */
    @TableField(value = "jobId")
    private String jobId;

    /**
     * 所属部门
     */
    @TableField(value = "department")
    private String department;

    /**
     * 所在领域
     */
    @TableField(value = "area")
    private String area;

    /**
     * 业务单元
     */
    @TableField(value = "businessUnit")
    private String businessUnit;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 课程名
     */
    @TableField(value = "className")
    private String className;

    /**
     * 状态: 1-通过, 2-考试失败, 3-请假, 4-旷课
     */
    @TableField(value = "studyStatus")
    private Integer studyStatus;

    /**
     * 逻辑删除字段，1-删除,0-未删除
     */
    @TableField(value = "isDelete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField(value = "createdTime")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updatedTime")
    private Date updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}