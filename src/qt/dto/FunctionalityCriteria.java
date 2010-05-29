/**
 * 
 */
package qt.dto;

import java.io.Serializable;

/**
 * Class chứa các tiêu chí tìm kiếm chuyên sâu theo chức năng
 * 
 * @author tqthe
 * 
 */
@SuppressWarnings("serial")
public class FunctionalityCriteria implements Serializable {

	private boolean hasCamera;
	private boolean hasMusicPlayer;
	private boolean hasFMRadio;
	private boolean hasMemoryCard;
	private boolean hasWifi;
	private boolean has3G;
	private boolean hasBluetooth;
	private boolean hasOfficeApps;
	private boolean hasGPS;
	private boolean hasTouchScreen;
	private boolean hasTivi;
	private boolean hasJavaApps;
	private boolean has2Sim;

	/**
	 * Default constructor
	 */
	public FunctionalityCriteria() {
	}

	/**
	 * @param hasCamera
	 *            the hasCamera to set
	 */
	public void setHasCamera(boolean hasCamera) {
		this.hasCamera = hasCamera;
	}

	/**
	 * @return the hasCamera
	 */
	public boolean isHasCamera() {
		return hasCamera;
	}

	/**
	 * @param hasMusicPlayer
	 *            the hasMusicPlayer to set
	 */
	public void setHasMusicPlayer(boolean hasMusicPlayer) {
		this.hasMusicPlayer = hasMusicPlayer;
	}

	/**
	 * @return the hasMusicPlayer
	 */
	public boolean isHasMusicPlayer() {
		return hasMusicPlayer;
	}

	/**
	 * @param hasFMRadio
	 *            the hasFMRadio to set
	 */
	public void setHasFMRadio(boolean hasFMRadio) {
		this.hasFMRadio = hasFMRadio;
	}

	/**
	 * @return the hasFMRadio
	 */
	public boolean isHasFMRadio() {
		return hasFMRadio;
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
	 * @param hasWifi
	 *            the hasWifi to set
	 */
	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}

	/**
	 * @return the hasWifi
	 */
	public boolean isHasWifi() {
		return hasWifi;
	}

	/**
	 * @param hasBluetooth
	 *            the hasBluetooth to set
	 */
	public void setHasBluetooth(boolean hasBluetooth) {
		this.hasBluetooth = hasBluetooth;
	}

	/**
	 * @return the hasBluetooth
	 */
	public boolean isHasBluetooth() {
		return hasBluetooth;
	}

	/**
	 * @param has3G
	 *            the has3G to set
	 */
	public void setHas3G(boolean has3G) {
		this.has3G = has3G;
	}

	/**
	 * @return the has3G
	 */
	public boolean isHas3G() {
		return has3G;
	}

	/**
	 * @param hasOfficeApps
	 *            the hasOfficeApps to set
	 */
	public void setHasOfficeApps(boolean hasOfficeApps) {
		this.hasOfficeApps = hasOfficeApps;
	}

	/**
	 * @return the hasOfficeApps
	 */
	public boolean isHasOfficeApps() {
		return hasOfficeApps;
	}

	/**
	 * @param hasGPS
	 *            the hasGPS to set
	 */
	public void setHasGPS(boolean hasGPS) {
		this.hasGPS = hasGPS;
	}

	/**
	 * @return the hasGPS
	 */
	public boolean isHasGPS() {
		return hasGPS;
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
	 * @param hasTivi
	 *            the hasTivi to set
	 */
	public void setHasTivi(boolean hasTivi) {
		this.hasTivi = hasTivi;
	}

	/**
	 * @return the hasTivi
	 */
	public boolean isHasTivi() {
		return hasTivi;
	}

	/**
	 * @param hasJavaApps
	 *            the hasJavaApps to set
	 */
	public void setHasJavaApps(boolean hasJavaApps) {
		this.hasJavaApps = hasJavaApps;
	}

	/**
	 * @return the hasJavaApps
	 */
	public boolean isHasJavaApps() {
		return hasJavaApps;
	}

	/**
	 * @param has2Sim
	 *            the has2Sim to set
	 */
	public void setHas2Sim(boolean has2Sim) {
		this.has2Sim = has2Sim;
	}

	/**
	 * @return the has2Sim
	 */
	public boolean isHas2Sim() {
		return has2Sim;
	}
}
