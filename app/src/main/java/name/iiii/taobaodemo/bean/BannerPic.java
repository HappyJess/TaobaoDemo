package name.iiii.taobaodemo.bean;

import cn.bmob.v3.BmobObject;

/**
 * 作者：李忠峰 on 2016/1/15 08:43<br/>
 * 邮箱：i@iiii.name
 */
public class BannerPic extends BmobObject {
    private String imgUrl;
    private Integer kindId;
    private String textStr;
    private String redirectUrl;



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getTextStr() {
        return textStr;
    }

    public void setTextStr(String textStr) {
        this.textStr = textStr;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
