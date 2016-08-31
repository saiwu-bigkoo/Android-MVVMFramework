package com.bigkoo.mvvmframeworkdemo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sai on 16/6/4.
 */
public class Ticket implements Serializable{

    /**
     * productId : 923010086
     * spotName : 蓝水河漂流
     * spotAliasName : ["蓝水河"]
     */

    private String productId;
    private String spotName;
    private String imageUrl;
    private String price;
    private String detailInfo;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }
}
