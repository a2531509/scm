package cn.itcast.service.impl;



import java.util.UUID;

import org.springframework.stereotype.Service;

import cn.itcast.entity.AccountRecords;
import cn.itcast.entity.BuyOrder;
import cn.itcast.entity.BuyOrderDetail;
import cn.itcast.service.BuyOrderService;

@Service("buyOrderService")
public class BuyOrderServiceImpl extends BaseServiceImpl<BuyOrder> implements BuyOrderService {

	@Override
	public int insertBuyOrder(BuyOrder buyOrder) throws Exception {
		
		int i = 0;
		String boId = ("bo"+UUID.randomUUID().toString().replace("-", ""));
		buyOrder.setBoId(boId);
		
		i = buyOrderMapper.insert(buyOrder);
		
		for(BuyOrderDetail buyOrderDetail:buyOrder.getBuyOrderDetails()){
			buyOrderDetail.setBodId(UUID.randomUUID().toString().replace("-", ""));
			buyOrderDetail.setBoId(boId);
		}
		buyOrderDetailrMapper.insertList(buyOrder.getBuyOrderDetails());
		
		
		AccountRecords accountRecords = new AccountRecords();
		// 生成并设置怅务记录的主键
		accountRecords.setArId(String.valueOf("ar"+UUID.randomUUID().toString().replace("-", "")));
		accountRecords.setArAttn(buyOrder.getBoAttn());
		accountRecords.setArArrears(buyOrder.getBoArrears());
		//bo表示商品采购，可以在参数表中加入相关内容
		accountRecords.setArBusType("bo");
		accountRecords.setArDate(buyOrder.getBoDate());
		//优惠金额：用应付金额减去实付金额再减去欠款
		accountRecords.setArDiscount(buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
		accountRecords.setArOperator(buyOrder.getBoOperator());
		//采购单号
		accountRecords.setArOrderId(buyOrder.getBoId());
		accountRecords.setArPaid(buyOrder.getBoPaid());
		accountRecords.setArPayable(buyOrder.getBoPayable());
		accountRecords.setArRemark(buyOrder.getBoRemark());
		accountRecords.setSupId(buyOrder.getSupId());
		accountRecordsMapper.insert(accountRecords);
		
		return i;

	}



}


