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
	private boolean hasVoiceRecorder;
	private boolean hasVideoRecorder;
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
	public boolean getHasMusicPlayer() {
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
	public boolean getHasVideoPlayer() {
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
	public boolean getHasOfficeApps() {
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
	public boolean getHasGame() {
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
	public boolean getHasJavaApps() {
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
	public boolean getHasTivi() {
		return hasTivi;
	}

	/**
	 * @param hasVoiceRecorder
	 *            the hasVoiceRecoder to set
	 */
	public void setHasVoiceRecorder(boolean hasVoiceRecorder) {
		this.hasVoiceRecorder = hasVoiceRecorder;
	}

	/**
	 * @return the hasVoiceRecoder
	 */
	public boolean getHasVoiceRecorder() {
		return hasVoiceRecorder;
	}

	/**
	 * @param hasVideoRecorder
	 *            the hasVideoRecoder to set
	 */
	public void setHasVideoRecorder(boolean hasVideoRecorder) {
		this.hasVideoRecorder = hasVideoRecorder;
	}

	/**
	 * @return the hasVideoRecoder
	 */
	public boolean getHasVideoRecorder() {
		return hasVideoRecorder;
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
	public boolean getHasFMRadio() {
		return hasFMRadio;
	}

}
