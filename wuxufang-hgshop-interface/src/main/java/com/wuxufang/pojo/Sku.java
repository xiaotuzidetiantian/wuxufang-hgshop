package com.wuxufang.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Sku implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String sellPoint;
	private BigDecimal price;
	private Integer stockCount;
	private String barcode;
	private String image;
	private String status;
	private Date createTime;
	private Date updateTime;
	private BigDecimal costPrice;
	private Integer marketPrice;
	private Integer spuId;
	private String cartThumbnail;
	private Spu spu;
	private List<SpecOption> specs;
	
	public Sku() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sku(Integer id, String title, String sellPoint, BigDecimal price, Integer stockCount, String barcode,
			String image, String status, Date createTime, Date updateTime, BigDecimal costPrice, Integer marketPrice,
			Integer spuId, String cartThumbnail, Spu spu, List<SpecOption> specs) {
		super();
		this.id = id;
		this.title = title;
		this.sellPoint = sellPoint;
		this.price = price;
		this.stockCount = stockCount;
		this.barcode = barcode;
		this.image = image;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.costPrice = costPrice;
		this.marketPrice = marketPrice;
		this.spuId = spuId;
		this.cartThumbnail = cartThumbnail;
		this.spu = spu;
		this.specs = specs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Integer marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Integer getSpuId() {
		return spuId;
	}

	public void setSpuId(Integer spuId) {
		this.spuId = spuId;
	}

	public String getCartThumbnail() {
		return cartThumbnail;
	}

	public void setCartThumbnail(String cartThumbnail) {
		this.cartThumbnail = cartThumbnail;
	}

	public Spu getSpu() {
		return spu;
	}

	public void setSpu(Spu spu) {
		this.spu = spu;
	}

	public List<SpecOption> getSpecs() {
		return specs;
	}

	public void setSpecs(List<SpecOption> specs) {
		this.specs = specs;
	}

	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price + ", stockCount="
				+ stockCount + ", barcode=" + barcode + ", image=" + image + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", costPrice=" + costPrice + ", marketPrice="
				+ marketPrice + ", spuId=" + spuId + ", cartThumbnail=" + cartThumbnail + ", spu=" + spu + ", specs="
				+ specs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((cartThumbnail == null) ? 0 : cartThumbnail.hashCode());
		result = prime * result + ((costPrice == null) ? 0 : costPrice.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((marketPrice == null) ? 0 : marketPrice.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((sellPoint == null) ? 0 : sellPoint.hashCode());
		result = prime * result + ((specs == null) ? 0 : specs.hashCode());
		result = prime * result + ((spu == null) ? 0 : spu.hashCode());
		result = prime * result + ((spuId == null) ? 0 : spuId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stockCount == null) ? 0 : stockCount.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (cartThumbnail == null) {
			if (other.cartThumbnail != null)
				return false;
		} else if (!cartThumbnail.equals(other.cartThumbnail))
			return false;
		if (costPrice == null) {
			if (other.costPrice != null)
				return false;
		} else if (!costPrice.equals(other.costPrice))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (marketPrice == null) {
			if (other.marketPrice != null)
				return false;
		} else if (!marketPrice.equals(other.marketPrice))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (sellPoint == null) {
			if (other.sellPoint != null)
				return false;
		} else if (!sellPoint.equals(other.sellPoint))
			return false;
		if (specs == null) {
			if (other.specs != null)
				return false;
		} else if (!specs.equals(other.specs))
			return false;
		if (spu == null) {
			if (other.spu != null)
				return false;
		} else if (!spu.equals(other.spu))
			return false;
		if (spuId == null) {
			if (other.spuId != null)
				return false;
		} else if (!spuId.equals(other.spuId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stockCount == null) {
			if (other.stockCount != null)
				return false;
		} else if (!stockCount.equals(other.stockCount))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}
	
}
