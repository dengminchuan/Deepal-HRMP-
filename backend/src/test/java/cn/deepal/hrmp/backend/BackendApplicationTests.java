package cn.deepal.hrmp.backend;

import cn.deepal.hrmp.backend.model.excel.Ledger;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    void testEasyExcelRead(){
        String fileName="C:\\Users\\lv jiang er hao\\Desktop\\test\\发闽川\\month8\\8月培训台账-车体工程.xlsx";
        EasyExcel.read(fileName, Ledger.class, new ReadListener<Ledger>() {


            @Override
            public void invoke(Ledger ledger, AnalysisContext analysisContext) {
                System.out.println(ledger);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取excel表完成");
            }
        }).sheet("培训台账（含费用）").headRowNumber(3).doRead();
    }

}
