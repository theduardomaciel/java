package edu.meninocoiso.basic.syntax.methods;

/**
 * Classe para representar uma SmartTv
 *
 * @version 1.0
 * @since 10/06/2024
 **/
public class SmartTv {
	
	boolean isOn = false;
	String currentChannel = "Record";
	int currentVolume = 10;
	
	/**
	 * Aumenta o volume da TV
	 */
	public void increaseVolume() {
		currentVolume++;
		System.out.println("Volume aumentado para " + currentVolume);
	}
	
	/**
	 * Diminui o volume da TV
	 */
	public void decreaseVolume() {
		currentVolume--;
		System.out.println("Volume diminuído para " + currentVolume);
	}
	
	/**
	 * Liga ou desliga a TV
	 */
	public boolean toggleTv() {
		isOn = !isOn;
		return isOn;
	}
	
	/**
	 * Altera o canal da TV
	 *
	 * @param channel Canal para o qual a TV deve ser alterada
	 */
	public void changeChannel(String channel) {
		currentChannel = channel;
		System.out.println("Canal alterado para " + currentChannel);
	}
}
