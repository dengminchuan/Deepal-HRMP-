//-*- coding =utf-8 -*-
//@Time : 2024/9/10
//@Author: 邓闽川
//@File  ExcelServiceImpl.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.service.impl;

import cn.deepal.hrmp.backend.model.StudyRecord;
import cn.deepal.hrmp.backend.model.excel.Ledger;
import cn.deepal.hrmp.backend.model.excel.StudyRecordForExcel;
import cn.deepal.hrmp.backend.service.ExcelService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public List<Ledger> readAndMergeLedgerExcels(List<MultipartFile> files) throws IOException {
        ArrayList<Ledger> ledgers = new ArrayList<>();
        //加载所有excel到arraylist中
        for (MultipartFile file : files) {
            EasyExcel.read(file.getInputStream(), Ledger.class, new ReadListener<Ledger>() {
                @Override
                public void invoke(Ledger ledger, AnalysisContext analysisContext) {
                    ledgers.add(ledger);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    log.info("analysis file:"+file.getName()+"successfully!");
                }
            });

        }
        return ledgers;
    }
    @Override
    public void analyse(List<Ledger> ledgers) {

    }

    @Override
    public void loadStudyRecord2DataBase(String fileName) {

        EasyExcel.read(fileName, StudyRecordForExcel.class, new ReadListener<StudyRecordForExcel>() {
            @Override
            public void invoke(StudyRecordForExcel studyRecordForExcel, AnalysisContext analysisContext) {
                //处理每一条excel数据
                StudyRecord studyRecord=transferExcel2Database(studyRecordForExcel);

            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet("出勤及考试情况").doRead();
    }

    private StudyRecord transferExcel2Database(StudyRecordForExcel studyRecordForExcel) {
        StudyRecord studyRecord = new StudyRecord();
        studyRecord.setMonth(studyRecordForExcel.getMonth());
        studyRecord.setJobId(studyRecordForExcel.getJobId());
        studyRecord.setDepartment(studyRecordForExcel.getDepartment());
        studyRecord.setArea(studyRecordForExcel.getArea());
        studyRecord.setBusinessUnit(studyRecordForExcel.getBusinessUnit());
        studyRecord.setName(studyRecordForExcel.getName());
        studyRecord.setClassName(studyRecordForExcel.getClassName());

        return null;
    }

    public static void main(String[] args) {
        new ExcelServiceImpl().loadStudyRecord2DataBase("C:\\Users\\lv jiang er hao\\Desktop\\深蓝日新课堂学习情况（2024年3月15日前入职的L11以下非管理人员）.xlsx");
    }

}
