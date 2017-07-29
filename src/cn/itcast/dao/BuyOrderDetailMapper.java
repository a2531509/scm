package cn.itcast.dao;

import cn.itcast.entity.BuyOrderDetail;
import java.util.List;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail> {
	
	public int insertList(List<BuyOrderDetail> buyOrderDetail);
}