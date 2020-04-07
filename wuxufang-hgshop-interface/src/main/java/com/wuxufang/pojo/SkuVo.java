package com.wuxufang.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SkuVo extends Sku {

	private static final long serialVersionUID = 6421745598284906156L;

	private BigDecimal maxPrice;

	private BigDecimal minPrice;

	private int maxStockCount;

	private int minStockCount;

	// 卖点或者标题当中含有的关键词
	private String key;

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxStockCount() {
		return maxStockCount;
	}

	public void setMaxStockCount(int maxStockCount) {
		this.maxStockCount = maxStockCount;
	}

	public int getMinStockCount() {
		return minStockCount;
	}

	public void setMinStockCount(int minStockCount) {
		this.minStockCount = minStockCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "SkuVo [maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", maxStockCount=" + maxStockCount
				+ ", minStockCount=" + minStockCount + ", key=" + key + "]";
	}

}
