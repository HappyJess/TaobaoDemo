/*
*CampaignRecommendEx.java
*Created on 2015/10/4 上午12:12 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package name.iiii.taobaodemo.bean;

import java.io.Serializable;

/**
 * Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
 * http://www.cniao5.com
 */
public class HomeCampaign implements Serializable {


    private Long id;
    private String title;
    private int cpOne;
    private int cpTwo;
    private int cpThree;

    public HomeCampaign() {
    }

    public HomeCampaign(Long id, String title, int cpOne, int cpTwo, int cpThree) {
        this.id = id;
        this.title = title;
        this.cpOne = cpOne;
        this.cpTwo = cpTwo;
        this.cpThree = cpThree;
    }

    public int getCpOne() {
        return cpOne;
    }

    public void setCpOne(int cpOne) {
        this.cpOne = cpOne;
    }

    public int getCpTwo() {
        return cpTwo;
    }

    public void setCpTwo(int cpTwo) {
        this.cpTwo = cpTwo;
    }

    public int getCpThree() {
        return cpThree;
    }

    public void setCpThree(int cpThree) {
        this.cpThree = cpThree;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
