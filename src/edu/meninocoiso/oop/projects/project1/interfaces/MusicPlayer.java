package edu.meninocoiso.oop.projects.project1.interfaces;

import edu.meninocoiso.oop.projects.project1.classes.Song;

public interface MusicPlayer {
	public void play();
	
	public void pause();
	
	public void selectSong(Song song);
}
