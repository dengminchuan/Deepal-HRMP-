//-*- coding =utf-8 -*-
//@Time : 2024/9/8
//@Author: 邓闽川
//@File  Ledger.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.doubleconverter.DoubleNumberConverter;
import com.alibaba.excel.converters.integer.IntegerNumberConverter;
import lombok.Data;

/**
 * 每月培训台账
 */
@Data
public class Ledger {

    private String id;

    private String month;

    private String trainingType;

    private String trainingName;

    private String trainingId;

    private String department;

    private String participants;

    private String trainingTime;

    private String trainingMethod;

    private String classHour;

    private String trainingLocation;

    private String teacherName;

    private String teacherId;

    private String planNum;

    private String participateNum;

    private String participatePercentage;

    private String satisfaction;

    private String money;

    private String isSignContract;

    private String notes;






}
