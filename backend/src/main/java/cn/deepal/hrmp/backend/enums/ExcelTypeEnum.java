//-*- coding =utf-8 -*-
//@Time : 2024/9/10
//@Author: 邓闽川
//@File  ExcelTypeEnum.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.enums;

import cn.deepal.hrmp.backend.model.excel.Ledger;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ExcelTypeEnum {
    ONLINE(1, Ledger.class),

    ;

    private final Integer status;
    private final Class clazz;

    private static Map<Integer, ExcelTypeEnum> cache;

    static {
        cache = Arrays.stream(ExcelTypeEnum.values()).collect(Collectors.toMap(ExcelTypeEnum::getStatus, Function.identity()));
    }

    public static ExcelTypeEnum of(Integer type) {
        return cache.get(type);
    }
}

