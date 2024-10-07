//-*- coding =utf-8 -*-
//@Time : 2024/10/7
//@Author: 邓闽川
//@File  StudyRecord.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.model;

import cn.deepal.hrmp.backend.enums.StudyStatusEnum;

/**
 * 数据库中存储的学习记录
 */
public class StudyRecord {

    private long id;

    private int month;
    //工号
    private String jobId;
    //所属部门
    private String department;
    //所在领域
    private String area;
    //业务单元
    private String businessUnit;

    private String name;
    //课程名
    private String className;
    //状态:通过 考试失败 请假 旷课
    private int studyStatus;

}
