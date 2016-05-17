package BeanModel;


/**
 * Created by Death丶Love on 2016/5/11.
 */
public class SingleModel {
    private String happenedTime;
    private boolean isGoodNight;//用于标记是否是晚安
    private boolean promise; //用于标记是否是承诺
    private String content;
    private int[] picList;


    public SingleModel(String happenedTime, boolean isGoodNight, boolean promise, String content, int[] picList) {
        this.happenedTime = happenedTime;
        this.isGoodNight = isGoodNight;
        this.promise = promise;
        this.content = content;
        this.picList = picList;
    }

    public String getHappenedTime() {
        return happenedTime;
    }

    public void setHappenedTime(String happenedTime) {
        this.happenedTime = happenedTime;
    }

    public boolean isGoodNight() {
        return isGoodNight;
    }

    public void setGoodNight(boolean goodNight) {
        isGoodNight = goodNight;
    }

    public boolean isPromise() {
        return promise;
    }

    public void setPromise(boolean promise) {
        this.promise = promise;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int[] getPicList() {
        return picList;
    }

    public void setPicList(int[] picList) {
        this.picList = picList;
    }
}
