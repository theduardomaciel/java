package edu.meninocoiso.oop;

import edu.meninocoiso.oop.interfaces.NavigationBar;

public abstract class MobileDevice implements NavigationBar {
    private final String model;
    private final String manufacturer;
    private final int storage;

    public MobileDevice(String model, String manufacturer, int storage) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.storage = storage;
    }

    protected void turnOn() {
        System.out.println("Turning on device " + model + " (" + storage + " GB) by " + manufacturer);
    }

    protected void turnOff() {
        System.out.println("Turning off device " + model + " (" + storage + " GB) by " + manufacturer);
    }

    protected void startVoiceMail() {
        System.out.println("Starting voice mail");
    }

    protected abstract void call(String phoneNumber);
    protected abstract void answerCall();
}
