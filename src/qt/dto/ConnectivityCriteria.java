/**
 * 
 */
package qt.dto;

import java.io.Serializable;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("serial")
public class ConnectivityCriteria implements Serializable {

	private boolean has3G;
	private boolean hasGPS;
	private boolean hasBluetooth;
	private boolean hasWifi;
	private boolean hasGPRS;
	private boolean hasUSB;
	private boolean has2Sim;

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
	 * @param hasGPRS
	 *            the hasGPRS to set
	 */
	public void setHasGPRS(boolean hasGPRS) {
		this.hasGPRS = hasGPRS;
	}

	/**
	 * @return the hasGPRS
	 */
	public boolean isHasGPRS() {
		return hasGPRS;
	}

	/**
	 * @param hasUSB
	 *            the hasUSB to set
	 */
	public void setHasUSB(boolean hasUSB) {
		this.hasUSB = hasUSB;
	}

	/**
	 * @return the hasUSB
	 */
	public boolean isHasUSB() {
		return hasUSB;
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
