package cn.itcast.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BuyOrderDetail implements Serializable {
	
    @Override
	public String toString() {
		return "BuyOrderDetail [bodId=" + bodId + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsUnit="
				+ goodsUnit + ", goodsType=" + goodsType + ", goodsColor=" + goodsColor + ", bodAmount=" + bodAmount
				+ ", bodBuyPrice=" + bodBuyPrice + ", bodTotalPrice=" + bodTotalPrice + ", boId=" + boId
				+ ", bodImeiList=" + bodImeiList + "]";
	}

	private String bodId;

    private String goodsId;

    private String goodsName;

    private String goodsUnit;

    private String goodsType;

    private String goodsColor;

    private Integer bodAmount;

    private BigDecimal bodBuyPrice;

    private BigDecimal bodTotalPrice;

    private String boId;

    private String bodImeiList;

    public String getBodId() {
        return bodId;
    }

    public void setBodId(String bodId) {
        this.bodId = bodId == null ? null : bodId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor == null ? null : goodsColor.trim();
    }

    public Integer getBodAmount() {
        return bodAmount;
    }

    public void setBodAmount(Integer bodAmount) {
        this.bodAmount = bodAmount;
    }

    public BigDecimal getBodBuyPrice() {
        return bodBuyPrice;
    }

    public void setBodBuyPrice(BigDecimal bodBuyPrice) {
        this.bodBuyPrice = bodBuyPrice;
    }

    public BigDecimal getBodTotalPrice() {
        return bodTotalPrice;
    }

    public void setBodTotalPrice(BigDecimal bodTotalPrice) {
        this.bodTotalPrice = bodTotalPrice;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId == null ? null : boId.trim();
    }

    public String getBodImeiList() {
        return bodImeiList;
    }

    public void setBodImeiList(String bodImeiList) {
        this.bodImeiList = bodImeiList == null ? null : bodImeiList.trim();
    }
}