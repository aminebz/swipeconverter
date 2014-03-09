package org.tinovation.swipeconverter;

public class Input {
	
	private Double num;
	private String type,unit;

	public Input(Double number,String type,String unit){
		num = number;
		this.type = type;
		this.unit = unit;
	}
	
	public Double getNumber(){
		return num;
	}
	
	public String getType(){
		return type;
	}
	
	public String getUnit(){
		return unit;
	}

}
