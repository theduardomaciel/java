package edu.meninocoiso.syntax.methods;

/**
 * Classe de usuário para testar a classe SmartTv
 *
 * @version 1.0
 * @since 10/06/2024
 */
public class User {
    public static void main(String[] args) {
        SmartTv tv = new SmartTv();

        System.out.println("A TV está ligada? " + tv.isOn);
        System.out.println("Canal atual: " + tv.currentChannel);
        System.out.println("Volume atual: " + tv.currentVolume);

        if (!tv.isOn) {
            boolean newState = tv.toggleTv();
            System.out.println("A TV está ligada? " + newState);
        }

        tv.changeChannel("Globo");

        tv.increaseVolume();
        tv.increaseVolume();
        tv.increaseVolume();

        tv.decreaseVolume();

        tv.toggleTv();
    }
}
