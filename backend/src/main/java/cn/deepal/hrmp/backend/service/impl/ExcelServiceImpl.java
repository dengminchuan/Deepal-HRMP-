//-*- coding =utf-8 -*-
//@Time : 2024/9/10
//@Author: 邓闽川
//@File  ExcelServiceImpl.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.service.impl;

import cn.deepal.hrmp.backend.model.excel.Ledger;
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
    //todo:分析合并后的数据,输出新的excel表
    @Override
    public void analyse(List<Ledger> ledgers) {

    }
}
