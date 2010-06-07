/**
 * 
 */
package qt.dto;

import java.io.Serializable;

/**
 * Class chứa các tiêu chí tìm kiếm cho DienThoai
 * 
 * @author tqthe
 * 
 */
@SuppressWarnings("serial")
public class PhoneCriteria implements Serializable {

	private String name;
	private double minPrice = -1.0;
	private double maxPrice = -1.0;
	private int manufactureId;

	private MediaCriteria mediaCriteria = new MediaCriteria();
	private ConnectivityCriteria connectivityCriteria = new ConnectivityCriteria();

	private int designId = -1;
	private int styleId = -1;
	private int melody = -1;
	private int cameraRange = -1;
	private double minCamera = -1.0;
	private double maxCamera = -1.0;
	private int networkId = -1;
	private int osId = -1;
	private boolean hasTouchScreen;
	private boolean hasMemoryCard;
	private int productStatusId = -1;

	private void setMaxMinCameraBaseOnRange() {
		if (cameraRange == 1) {
			setMinCamera(0.0);
			setMaxCamera(0.3);
		} else if (cameraRange == 2) {
			setMinCamera(0.3);
			setMaxCamera(1.0);
		} else if (cameraRange == 3) {
			setMinCamera(1.0);
			setMaxCamera(2.0);
		} else if (cameraRange == 4) {
			setMinCamera(2.2);
			setMaxCamera(3.2);
		} else if (cameraRange == 5) {
			setMinCamera(3.2);
			setMaxCamera(5.0);
		} else if (cameraRange == 6) {
			setMinCamera(5.0);
			setMaxCamera(Double.MAX_VALUE);
		}
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param minPrice
	 *            the minPrice to set
	 */
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	/**
	 * @return the minPrice
	 */
	public double getMinPrice() {
		return minPrice;
	}

	/**
	 * @param maxPrice
	 *            the maxPrice to set
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	/**
	 * @return the maxPrice
	 */
	public double getMaxPrice() {
		return maxPrice;
	}

	/**
	 * @param manufactureId
	 *            the manufactureId to set
	 */
	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	/**
	 * @return the manufactureId
	 */
	public int getManufactureId() {
		return manufactureId;
	}

	/**
	 * @param mediaCriteria
	 *            the mediaCriteria to set
	 */
	public void setMediaCriteria(MediaCriteria mediaCriteria) {
		this.mediaCriteria = mediaCriteria;
	}

	/**
	 * @return the mediaCriteria
	 */
	public MediaCriteria getMediaCriteria() {
		return mediaCriteria;
	}

	/**
	 * @param connectivityCriteria
	 *            the connectivityCriteria to set
	 */
	public void setConnectivityCriteria(
			ConnectivityCriteria connectivityCriteria) {
		this.connectivityCriteria = connectivityCriteria;
	}

	/**
	 * @return the connectivityCriteria
	 */
	public ConnectivityCriteria getConnectivityCriteria() {
		return connectivityCriteria;
	}

	/**
	 * @param styleId
	 *            the styleId to set
	 */
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	/**
	 * @return the styleId
	 */
	public int getStyleId() {
		return styleId;
	}

	/**
	 * @param melody
	 *            the melody to set
	 */
	public void setMelody(int melody) {
		this.melody = melody;
	}

	/**
	 * @return the melody
	 */
	public int getMelody() {
		return melody;
	}

	/**
	 * @param minCamera
	 *            the minCamera to set
	 */
	public void setMinCamera(double minCamera) {
		this.minCamera = minCamera;
	}

	/**
	 * @return the minCamera
	 */
	public double getMinCamera() {
		return minCamera;
	}

	/**
	 * @param maxCamera
	 *            the maxCamera to set
	 */
	public void setMaxCamera(double maxCamera) {
		this.maxCamera = maxCamera;
	}

	/**
	 * @return the maxCamera
	 */
	public double getMaxCamera() {
		return maxCamera;
	}

	/**
	 * @param networkId
	 *            the networkId to set
	 */
	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}

	/**
	 * @return the networkId
	 */
	public int getNetworkId() {
		return networkId;
	}

	/**
	 * @param osId
	 *            the osId to set
	 */
	public void setOsId(int osId) {
		this.osId = osId;
	}

	/**
	 * @return the osId
	 */
	public int getOsId() {
		return osId;
	}

	/**
	 * @param hasTouchScreen
	 *            the hasTouchScreen to set
	 */
	public void setHasTouchScreen(boolean hasTouchScreen) {
		this.hasTouchScreen = hasTouchScreen;
	}

	/**
	 * @return the hasTouchScreen
	 */
	public boolean isHasTouchScreen() {
		return hasTouchScreen;
	}

	/**
	 * @param hasMemoryCard
	 *            the hasMemoryCard to set
	 */
	public void setHasMemoryCard(boolean hasMemoryCard) {
		this.hasMemoryCard = hasMemoryCard;
	}

	/**
	 * @return the hasMemoryCard
	 */
	public boolean isHasMemoryCard() {
		return hasMemoryCard;
	}

	/**
	 * @param productStatusId
	 *            the productStatusId to set
	 */
	public void setProductStatusId(int productStatusId) {
		this.productStatusId = productStatusId;
	}

	/**
	 * @return the productStatusId
	 */
	public int getProductStatusId() {
		return productStatusId;
	}

	/**
	 * @param designId the designId to set
	 */
	public void setDesignId(int designId) {
		this.designId = designId;
	}

	/**
	 * @return the designId
	 */
	public int getDesignId() {
		return designId;
	}

	/**
	 * @param cameraRange the cameraRange to set
	 */
	public void setCameraRange(int cameraRange) {
		this.cameraRange = cameraRange;
		
		setMaxMinCameraBaseOnRange();
	}

	/**
	 * @return the cameraRange
	 */
	public int getCameraRange() {
		return cameraRange;
	}

}
