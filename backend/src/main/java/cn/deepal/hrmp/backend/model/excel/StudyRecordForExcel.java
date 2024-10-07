//-*- coding =utf-8 -*-
//@Time : 2024/10/7
//@Author: 邓闽川
//@File  StudyRecordForExcel.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.model.excel;


import cn.deepal.hrmp.backend.enums.StudyStatusEnum;

/**
 * Excel存储的培训记录
 */

public class StudyRecordForExcel {

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
    //签到状态
    private String signStatus;
    //考试状态
    private String testStatus;

}
