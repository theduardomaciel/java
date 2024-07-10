package edu.meninocoiso.oop.projects.project1.interfaces;

import java.util.Optional;

public interface WebBrowser {
	public void openURL(String url);
	
	public void addNewTab(Optional<String> url);
	
	public void refresh();
}
