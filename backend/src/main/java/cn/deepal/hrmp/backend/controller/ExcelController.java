/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.deepal.hrmp.backend.controller;


import cn.deepal.hrmp.backend.model.excel.Ledger;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {


    //测试接口
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    /**
     * 合并上传文件夹中的Excel
     * @param files
     * @return 合并后的文件
     */
    @PostMapping("/uploadMergeExcels")
    public String uploadMergeExcels(List<MultipartFile> files) throws IOException {
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


        return "hello";
    }
    @GetMapping("/download")
    public void downLoad(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        ArrayList<Ledger> ledgers = new ArrayList<>();
        ledgers.add(new Ledger("1","1","1"));
        EasyExcel.write(response.getOutputStream(), Ledger.class).sheet("模板").doWrite(ledgers);
    }

}
