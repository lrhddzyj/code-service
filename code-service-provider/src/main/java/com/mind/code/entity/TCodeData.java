package com.mind.code.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lrh on 2015/12/30.
 */
@Document(collection = "t_code_data")
public class TCodeData {

    public TCodeData(String codeData) {
        this.codeData = codeData;
    }

    @Id
    private String codeData;


    public String getCodeData() {
        return codeData;
    }

    public void setCodeData(String codeData) {
        this.codeData = codeData;
    }

}
