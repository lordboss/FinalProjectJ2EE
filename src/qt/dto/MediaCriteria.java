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
public class MediaCriteria implements Serializable {

	private boolean hasMusicPlayer;
	private boolean hasVideoPlayer;
	private boolean hasOfficeApps;
	private boolean hasGame;
	private boolean hasJavaApps;
	private boolean hasTivi;
	private boolean hasVoiceRecoder;
	private boolean hasVideoRecoder;
	private boolean hasFMRadio;

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
	 * @param hasVideoPlayer
	 *            the hasVideoPlayer to set
	 */
	public void setHasVideoPlayer(boolean hasVideoPlayer) {
		this.hasVideoPlayer = hasVideoPlayer;
	}

	/**
	 * @return the hasVideoPlayer
	 */
	public boolean isHasVideoPlayer() {
		return hasVideoPlayer;
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
	 * @param hasGame
	 *            the hasGame to set
	 */
	public void setHasGame(boolean hasGame) {
		this.hasGame = hasGame;
	}

	/**
	 * @return the hasGame
	 */
	public boolean isHasGame() {
		return hasGame;
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
	 * @param hasVoiceRecoder
	 *            the hasVoiceRecoder to set
	 */
	public void setHasVoiceRecoder(boolean hasVoiceRecoder) {
		this.hasVoiceRecoder = hasVoiceRecoder;
	}

	/**
	 * @return the hasVoiceRecoder
	 */
	public boolean isHasVoiceRecoder() {
		return hasVoiceRecoder;
	}

	/**
	 * @param hasVideoRecoder
	 *            the hasVideoRecoder to set
	 */
	public void setHasVideoRecoder(boolean hasVideoRecoder) {
		this.hasVideoRecoder = hasVideoRecoder;
	}

	/**
	 * @return the hasVideoRecoder
	 */
	public boolean isHasVideoRecoder() {
		return hasVideoRecoder;
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

}
