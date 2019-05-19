package com.ap.datamodel;

public class ProductData 
{
	private String productName;
	private String quantity;
	private String size;
	private String color;
	
	public String getProductName()
	{
		return productName;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public String getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity (String quantity)
	{
		this.quantity = quantity;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public void setSize (String size)
	{
		this.size = size;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor (String color)
	{
		this.color = color;
	}
	
	
	
	@Override
	//method name called hashCode
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		/*if color is an empty value, then don't do anything. If it does have a value, then do 
		 * the multiplication hashCode in java means that it will return a whole integer and 
		 * not a decimal value.
		 * 
		 * 
		Sargil: when hashcode invokes on the same object more than once during execution, it should 
		 consistently return the same value without additional value/object
		*/		 
		result = prime * result + ((color == null)? 0 : color.hashCode());
		result = prime * result + ((productName == null)? 0 : productName.hashCode());
		result = prime * result + ((quantity == null)? 0 : quantity.hashCode());
		result = prime * result + ((size == null)? 0 : size.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		if (this == obj)
			return true;
		
		if (this == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		//4 different data types but you're performing 1 actions. So it falls under 1 method
		ProductData other = (ProductData) obj;
		if (color == null)
		{
			if (other.color != null)
				return false;
		}
		
			else if (!color.equals(other.color))
				return false;
		
		if (productName == null)
		{
			if(other.productName != null)
				return false;
		}
		
			else if (!productName.equals(other.productName))
				return false;
		
		
		if (quantity == null)
		{
			if (other.quantity != null)
				return false;
		}
		
		else if (!quantity.equals(other.quantity))
			return false;
		
		
		if (size == null)
		{
			if (other.size != null)
				return false;
		}
		
		else if (!size.equals(other.size))
			return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "ProductData[productName=" + productName + ", quantity=" + quantity + ", "
				+ "size=" + size + ", color="+ color + "]";
		
		     //"ProductData[productName=" + productName + ", quantity=" + quantity + ",
		     //    size=" + size + ", color="+ color + "]"
	}
}














