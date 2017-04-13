package com.example.administrator.adapterdemo;

/**
 * @data 2017/3/3 0003
 * @aurher Administrator
 */

public class SelectBean {
    private int CurrentPos ;
    private String CurrentData ;

    public SelectBean(int currentPos, String currentData) {
        CurrentPos = currentPos;
        CurrentData = currentData;
    }

    public int getCurrentPos() {
        return CurrentPos;
    }

    public void setCurrentPos(int currentPos) {
        CurrentPos = currentPos;
    }

    public String getCurrentData() {
        return CurrentData;
    }

    public void setCurrentData(String currentData) {
        CurrentData = currentData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectBean that = (SelectBean) o;

        if (CurrentPos != that.CurrentPos) return false;
        return CurrentData.equals(that.CurrentData);

    }

    @Override
    public int hashCode() {
        int result = CurrentPos;
        result = 31 * result + CurrentData.hashCode();
        return result;
    }
}
