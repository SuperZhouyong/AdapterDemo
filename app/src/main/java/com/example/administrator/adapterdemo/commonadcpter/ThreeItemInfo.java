package com.example.administrator.adapterdemo.commonadcpter;

import java.util.ArrayList;
import java.util.List;

/**
 * @data 2017/4/12 0012
 * @aurher Administrator
 */

public class ThreeItemInfo {

    private String status = "1";
    private boolean isExpading ;
    private List<ThreeItemInfo> results = new ArrayList<>();


    public boolean getIsExpading(){
        return isExpading ;
    }
    public void setIsExpading(boolean isExpading){
        this.isExpading = isExpading ;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ThreeItemInfo> getResults() {
        return results;
    }

    public void setResults(List<ThreeItemInfo> results) {
        this.results = results;
    }


}
