public class DeviceMeasurement{
	
	private String deviceCategory;
	private String deviceName;
	private Float measurementValue, lowerRange, upperRange;

//	public DeviceMeasurement(String deviceCategory, String deviceName, Float measurementValue){
//		this.deviceCategory = deviceCategory;
//		this.deviceName = deviceName;
//		this.measurementValue = measurementValue;
//	}

	public DeviceMeasurement(String deviceCategory, String deviceName, Float measurementValue, Float lowerRange, Float upperRange){
		this.deviceCategory = deviceCategory;
		this.deviceName = deviceName;
		this.measurementValue = measurementValue;
		this.lowerRange = lowerRange;
		this.upperRange = upperRange;
	}
	
	public boolean isSafeRange() {
		return lowerRange <= measurementValue && measurementValue <= upperRange;
	}

	public String getDeviceCategory(){
		return deviceCategory;
	}

	public String getDeviceName(){
		return deviceName;
	}

	public Float getmeasurementValue(){
		return measurementValue;
	}
	
	public Float getLowerRange() {
		return lowerRange;
	}
	
	public Float getUpperRange() {
		return upperRange;
	}
}