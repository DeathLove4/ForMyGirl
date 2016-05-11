package BeanModel;

import java.util.List;

/**
 * Created by Death丶Love on 2016/5/11.
 */
public class WholeDayModel {
    private String dayTime;
    private List<SingleModel> list;
    private boolean goodnight;
    private String goodnightTime;
    private String goodnightContent;
    private int goodnightPic;

    public WholeDayModel(String dayTime, List<SingleModel> list, boolean goodnight, String goodnightTime,String goodnightContent,int goodnightPic) {
        this.dayTime = dayTime;
        this.list = list;
        this.goodnight = goodnight;
        this.goodnightTime = goodnightTime;
        this.goodnightContent = goodnightContent;
        this.goodnightPic = goodnightPic;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public List<SingleModel> getList() {
        return list;
    }

    public void setList(List<SingleModel> list) {
        this.list = list;
    }

    public boolean isGoodnight() {
        return goodnight;
    }

    public void setGoodnight(boolean goodnight) {
        this.goodnight = goodnight;
    }

    public String getGoodnightContent() {
        return goodnightContent;
    }

    public void setGoodnightContent(String goodnightContent) {
        this.goodnightContent = goodnightContent;
    }

    public int getGoodnightPic() {
        return goodnightPic;
    }

    public void setGoodnightPic(int goodnightPic) {
        this.goodnightPic = goodnightPic;
    }

    public String getGoodnightTime() {
        return goodnightTime;
    }

    public void setGoodnightTime(String goodnightTime) {
        this.goodnightTime = goodnightTime;
    }
}
