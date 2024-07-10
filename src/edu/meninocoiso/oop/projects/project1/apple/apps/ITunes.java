package edu.meninocoiso.oop.projects.project1.apple.apps;

import edu.meninocoiso.oop.projects.project1.classes.Song;
import edu.meninocoiso.oop.projects.project1.interfaces.MusicPlayer;

public class ITunes implements MusicPlayer {
	private Song currentSong;
	private boolean isPlaying = false;
	
	public void open() {
		System.out.println("Opening iTunes");
	}
	
	// (methods) Music Player
	@Override
	public void play() {
		if (currentSong == null) {
			System.out.println("No song selected");
			return;
		}
		
		if (isPlaying) {
			System.out.println("Resuming " + currentSong.getTitle() + " by " + currentSong.getArtist());
		} else {
			System.out.println("Playing " + currentSong.getTitle() + " by " + currentSong.getArtist());
		}
		
		isPlaying = true;
	}
	
	@Override
	public void pause() {
		if (currentSong == null) {
			System.out.println("No song selected");
			return;
		}
		
		if (isPlaying) {
			System.out.println("Pausing " + currentSong.getTitle() + " by " + currentSong.getArtist());
			isPlaying = false;
		} else {
			System.out.println("Song is already paused");
		}
	}
	
	@Override
	public void selectSong(Song song) {
		currentSong = song;
	}
}
