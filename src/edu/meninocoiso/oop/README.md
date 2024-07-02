# Projeto: Programação Orientada a Objetos (POO/OOP)

## 📚 Sobre
Este projeto inclui um exemplo de como a programação orientada a objetos (POO) pode ser implementada em Java.  

## 📋 Diagrama de Classes

```mermaid
classDiagram
    class NavigationBar {
        +goBack() void
        +goToHome() void
        +openActivityCenter() void
    }

    class MobileDevice {
        #turnOn() void
        #turnOff() void
        #call(String phoneNumber) void
        #answerCall() void
        #startVoiceMail() void
    }

    class MusicPlayer {
        +play() void
        +pause() void
        +selectSong(String songId) void
    }

        class WebBrowser {
        +showPage(String url) void
        +addNewTab() void
        +refreshCurrentPage() void
    }

    class iTunes {

    }

    class Safari {
        
    }

    class iPhone {
    }

    iTunes --> MusicPlayer
    Safari --> WebBrowser

    MobileDevice --> iPhone
    MobileDevice --> NavigationBar   

    iPhone --> iTunes
    iPhone --> Safari

```