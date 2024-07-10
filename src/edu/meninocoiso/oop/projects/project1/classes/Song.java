package edu.meninocoiso.oop.projects.project1.classes;

import edu.meninocoiso.oop.projects.project1.enums.Genre;

public class Song {
	private final String id;
	private final String title;
	private final String artist;
	private final String album;
	private final Genre genre;
	private final Float duration;
	private final String path;
	
	public Song(String id, String title, String artist, String album, Genre genre, Float duration, String path) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.duration = duration;
		this.path = path;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public Float getDuration() {
		return duration;
	}
	
	public String getPath() {
		return path;
	}
	
	public String toString() {
		return title + " by " + artist + " from " + album + " (" + genre + ")";
	}
	
	public String getDetails() {
		return "Title: " + title + "\nArtist: " + artist + "\nAlbum: " + album + "\nGenre: " + genre + "\nDuration: " + duration + " seconds";
	}
	
	public String durationToString() {
		int minutes = (int) (duration / 60);
		int seconds = (int) (duration % 60);
		return minutes + "m " + seconds + "s";
	}
}
