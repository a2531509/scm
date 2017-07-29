package cn.itcast.entity;

public class SysParam {
    private Long sysParamId;

    private String sysParamField;

    private String sysParamValue;

    private String sysParamText;

    private String sysParamType;

    public Long getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getSysParamField() {
        return sysParamField;
    }

    public void setSysParamField(String sysParamField) {
        this.sysParamField = sysParamField == null ? null : sysParamField.trim();
    }

    public String getSysParamValue() {
        return sysParamValue;
    }

    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue == null ? null : sysParamValue.trim();
    }

    public String getSysParamText() {
        return sysParamText;
    }

    public void setSysParamText(String sysParamText) {
        this.sysParamText = sysParamText == null ? null : sysParamText.trim();
    }

    public String getSysParamType() {
        return sysParamType;
    }

    public void setSysParamType(String sysParamType) {
        this.sysParamType = sysParamType == null ? null : sysParamType.trim();
    }

	@Override
	public String toString() {
		return "SysParam [sysParamId=" + sysParamId + ", sysParamField=" + sysParamField + ", sysParamValue="
				+ sysParamValue + ", sysParamText=" + sysParamText + ", sysParamType=" + sysParamType + "]";
	}
    
    
}