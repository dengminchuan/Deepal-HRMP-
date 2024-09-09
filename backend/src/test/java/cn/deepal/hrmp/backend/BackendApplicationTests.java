package cn.deepal.hrmp.backend;

import cn.deepal.hrmp.backend.model.excel.Ledger;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@Slf4j
@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    void testEasyExcelRead(){
        String fileName1="C:\\Users\\lv jiang er hao\\Desktop\\test\\发闽川\\month8\\8月培训台账-车体工程.xlsx";
        //总台账,需要写回
        ArrayList<Ledger> ledgers = new ArrayList<>();
        EasyExcel.read(fileName1, Ledger.class, new ReadListener<Ledger>() {
            @Override
            public void invoke(Ledger ledger, AnalysisContext analysisContext) {
                ledgers.add(ledger);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取excel表1完成");
            }
        }).sheet("培训台账（含费用）").headRowNumber(3).doRead();
        String fileName2="C:\\Users\\lv jiang er hao\\Desktop\\test\\发闽川\\month8\\控制集成中心培训台账-202408.xlsx";
        EasyExcel.read(fileName2, Ledger.class, new ReadListener<Ledger>() {
            @Override
            public void invoke(Ledger ledger, AnalysisContext analysisContext) {
                ledgers.add(ledger);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取excel表2完成");
            }
        }).sheet("培训台账（含费用）").headRowNumber(3).doRead();
        String writeFileName="C:\\Users\\lv jiang er hao\\Desktop\\test\\发闽川\\month8\\测试写excel.xlsx";
        EasyExcel.write(writeFileName,Ledger.class)
                .sheet("测试write")
                .doWrite(ledgers);


    }

}
