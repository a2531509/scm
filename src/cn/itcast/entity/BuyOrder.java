package cn.itcast.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BuyOrder implements Serializable {
	
	private List<BuyOrderDetail> buyOrderDetails;
	
    private String boId;

    private Integer supId;

    private String shId;

    private Date boDate;

    private BigDecimal boPayable;

    private BigDecimal boPaid;

    private BigDecimal boArrears;

    private String boOriginal;

    private String boRemark;

    private String boAttn;

    private Integer boOperator;

    
    
    
    @Override
	public String toString() {
		return "BuyOrder [buyOrderDetails=" + buyOrderDetails + ", boId=" + boId + ", supId=" + supId + ", shId=" + shId
				+ ", boDate=" + boDate + ", boPayable=" + boPayable + ", boPaid=" + boPaid + ", boArrears=" + boArrears
				+ ", boOriginal=" + boOriginal + ", boRemark=" + boRemark + ", boAttn=" + boAttn + ", boOperator="
				+ boOperator + "]";
	}

	public List<BuyOrderDetail> getBuyOrderDetails() {
		return buyOrderDetails;
	}

	public void setBuyOrderDetails(List<BuyOrderDetail> buyOrderDetails) {
		this.buyOrderDetails = buyOrderDetails;
	}

	public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId == null ? null : boId.trim();
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId == null ? null : shId.trim();
    }

    public Date getBoDate() {
        return boDate;
    }

    public void setBoDate(Date boDate) {
        this.boDate = boDate;
    }

    public BigDecimal getBoPayable() {
        return boPayable;
    }

    public void setBoPayable(BigDecimal boPayable) {
        this.boPayable = boPayable;
    }

    public BigDecimal getBoPaid() {
        return boPaid;
    }

    public void setBoPaid(BigDecimal boPaid) {
        this.boPaid = boPaid;
    }

    public BigDecimal getBoArrears() {
        return boArrears;
    }

    public void setBoArrears(BigDecimal boArrears) {
        this.boArrears = boArrears;
    }

    public String getBoOriginal() {
        return boOriginal;
    }

    public void setBoOriginal(String boOriginal) {
        this.boOriginal = boOriginal == null ? null : boOriginal.trim();
    }

    public String getBoRemark() {
        return boRemark;
    }

    public void setBoRemark(String boRemark) {
        this.boRemark = boRemark == null ? null : boRemark.trim();
    }

    public String getBoAttn() {
        return boAttn;
    }

    public void setBoAttn(String boAttn) {
        this.boAttn = boAttn == null ? null : boAttn.trim();
    }

    public Integer getBoOperator() {
        return boOperator;
    }

    public void setBoOperator(Integer boOperator) {
        this.boOperator = boOperator;
    }
}