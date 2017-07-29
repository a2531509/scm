package cn.itcast.service;

import cn.itcast.entity.BuyOrder;

public interface BuyOrderService extends BaseService<BuyOrder>{
	
	public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
	
}
