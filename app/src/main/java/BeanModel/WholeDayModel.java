package BeanModel;

import java.util.List;

/**
 * Created by Death丶Love on 2016/5/11.
 */
public class WholeDayModel {
    private String dayTime;
    private List<SingleModel> list;

    public WholeDayModel(String dayTime, List<SingleModel> list) {
        this.dayTime = dayTime;
        this.list = list;
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
}
