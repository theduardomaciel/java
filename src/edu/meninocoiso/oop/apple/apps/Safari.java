package edu.meninocoiso.oop.apple.apps;

import edu.meninocoiso.oop.interfaces.WebBrowser;

import java.util.Optional;

public class Safari implements WebBrowser {
    private final String[] tabs;
    private int currentTab;

    public Safari() {
        tabs = new String[10];
        currentTab = 0;
    }

    @Override
    public void openURL(String url) {
        System.out.println("Opening " + url + " in Safari");
        tabs[currentTab] = url;
    }

    @Override
    public void addNewTab(Optional<String> url) {
        if (url.isPresent()) {
            System.out.println("Opening " + url.get() + " in a new tab");
            tabs[++currentTab] = url.get();
        } else {
            System.out.println("Opening a new tab");
            tabs[++currentTab] = "";
        }
    }

    @Override
    public void refresh() {
        System.out.println("Refreshing " + tabs[currentTab]);
    }
}
