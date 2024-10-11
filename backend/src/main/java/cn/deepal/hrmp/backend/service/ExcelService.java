//-*- coding =utf-8 -*-
//@Time : 2024/9/10
//@Author: 邓闽川
//@File  ExcelService.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.service;

import cn.deepal.hrmp.backend.model.excel.Ledger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ExcelService {


    List<Ledger> readAndMergeLedgerExcels(List<MultipartFile> files) throws IOException;

    void analyse(List<Ledger> ledgers);

    void loadStudyRecord2DataBase(String fileName);
}
