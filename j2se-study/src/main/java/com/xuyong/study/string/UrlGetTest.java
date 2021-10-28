package com.xuyong.study.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Created by xuyong on 2020/11/8
 */
public class UrlGetTest {
    private String redirectUrl = "[]";

    public static void main(String[] args) {
        UrlGetTest urlGetTest = new UrlGetTest();
        System.out.println("result: " + urlGetTest.getRedirectUrlByType(RedirectUrlTypeEnum.ORDER_URL));
    }

    private String getRedirectUrlByType(RedirectUrlTypeEnum type){
        if(Objects.nonNull(type) && StringUtils.isNotBlank(this.redirectUrl)){
            try {
                JSONArray redirectUrlInfoArray = JSON.parseArray(this.redirectUrl);
                if(Objects.nonNull(redirectUrlInfoArray) && redirectUrlInfoArray.size() > 0){
                    for(int i = 0; i < redirectUrlInfoArray.size(); i++){
                        JSONObject jsonObject = redirectUrlInfoArray.getJSONObject(i);
                        if(jsonObject.getString("urlType").equals(type.name())){
                            return jsonObject.getString("url");
                        }
                    }
                }
            }catch (Exception e){
                return "";
            }
        }

        return "";
    }
}
