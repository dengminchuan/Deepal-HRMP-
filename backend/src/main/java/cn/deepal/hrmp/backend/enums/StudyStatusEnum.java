//-*- coding =utf-8 -*-
//@Time : 2024/10/7
//@Author: 邓闽川
//@File  StudyStatusEnum.java
//@software:IntelliJ IDEA
package cn.deepal.hrmp.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum StudyStatusEnum {
    PASS(1,"通过"),

    TEST_FAILED(2,"考试不合格"),

    ESCAPE(3,"旷课"),

    APOLOGY(4,"请假")
    ;

    private final Integer status;

    private final String desc;


    private static Map<Integer, StudyStatusEnum> cache;

    static {
        cache = Arrays.stream(StudyStatusEnum.values()).collect(Collectors.toMap(StudyStatusEnum::getStatus, Function.identity()));
    }

    public static StudyStatusEnum of(Integer type) {
        return cache.get(type);
    }
}
