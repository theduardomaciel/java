package edu.meninocoiso.oop.apple;

import edu.meninocoiso.oop.MobileDevice;
import edu.meninocoiso.oop.apple.apps.ITunes;
import edu.meninocoiso.oop.apple.apps.Safari;
import edu.meninocoiso.oop.classes.Song;
import edu.meninocoiso.oop.enums.Genre;

import java.util.Random;
import java.util.Timer;

public class IPhone extends MobileDevice {
    // O iPhone, assim como outros dispositivos móveis, possui características pessoais
    // como modelo, fabricante e capacidade de armazenamento
    private IPhone(String model, String manufacturer, int storage) {
        // O método "super" é utilizado para chamar o construtor da superclasse (MobileDevice)
        super(model, manufacturer, storage);
    }

    // (methods) Navigation Bar
    @Override
    public void back() {
        System.out.println("Going back");
    }

    @Override
    public void goToHome() {
        System.out.println("Going to home screen");
    }

    @Override
    public void openActivityCenter() {
        System.out.println("Opening activity center");
    }

    // (methods) Mobile Device
    // Suponhamos que o método call() possui uma chance de cair na caixa postal de 25% (25 em 100)
    private final int errorChance = new Random().nextInt(100);

    public void call(String phoneNumber) {
        if (errorChance < 25) {
            // Se o número de erro for menor que 25, a chamada cai na caixa postal
            startVoiceMail();
        } else {
            System.out.println("Calling " + phoneNumber);
        }
    }

    public void answerCall() {
        System.out.println("Answering call");
    }

    // Além disso, possui dois aplicativos: um navegador web (Safari) e um reprodutor de música (iTunes)
    // Os aplicativos são classes que implementam interfaces
    // O Safari é um navegador web que implementa a interface WebBrowser
    // O iTunes é um reprodutor de música que implementa a interface MusicPlayer

    private final Safari safari = new Safari();
    private final ITunes iTunes = new ITunes();

    public static void main(String[] args) {
        IPhone iPhone = new IPhone(
            "iPhone 12",
            "Apple",
            128
        );

        iPhone.turnOn();

        // O usuário primeiramente realiza uma ligação
        iPhone.call("123456789");

        // O usuário pode abrir o reprodutor de música
        iPhone.iTunes.open();

        // Em um cenário real, o usuário selecionaria uma música por meio do aplicativo de música,
        // mas para fins de exemplo, vamos selecionar uma música diretamente
        iPhone.iTunes.selectSong(new Song(
            "1",
            "CHIHIRO",
            "Billie Eilish",
            "HIT ME HARD AND SOFT",
            Genre.POP,
            301.8f,
            "path/to/song"
        ));

        // O usuário pode então reproduzir a música
        iPhone.iTunes.play();

        // Suponhamos que após 5 segundos ouvindo música o usuário decida abrir o navegador web
        Timer t = new java.util.Timer();

        // Criamos um temporizador para simular o tempo de reprodução da música
        t.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        iPhone.iTunes.pause();
                        iPhone.goToHome();
                        iPhone.safari.openURL("https://www.google.com");

                        // Por fim, o usuário pode desligar o dispositivo
                        iPhone.turnOff();

                        t.cancel();
                    }
                },
                5000
        );
    }
}
