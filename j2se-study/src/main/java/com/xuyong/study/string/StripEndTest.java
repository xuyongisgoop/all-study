package com.xuyong.study.string;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by xuyong on 2018/10/11
 */
public class StripEndTest {

    public static void main(String[] args) {
        System.out.println(transportDistrictCode("310000"));
    }

    private static String transportDistrictCode(String districtCode) {
        if (districtCode.endsWith("0000")) {
            return StringUtils.substring(districtCode,0, districtCode.lastIndexOf("0000")).concat("0100");
        }
        return districtCode;
    }
}
