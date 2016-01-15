package name.iiii.taobaodemo.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/1/13.
 */

public class HotGoods  extends BmobObject implements Serializable {
    private Integer id;
    private String title;
    private Double price;
    private int cpOne;

    public HotGoods(int id, String title, Double price, int cpOne) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.cpOne = cpOne;
    }

    public HotGoods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCpOne() {
        return cpOne;
    }

    public void setCpOne(int cpOne) {
        this.cpOne = cpOne;
    }
}
