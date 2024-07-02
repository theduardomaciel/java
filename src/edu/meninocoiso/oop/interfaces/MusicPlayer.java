package edu.meninocoiso.oop.interfaces;

import edu.meninocoiso.oop.classes.Song;

public interface MusicPlayer {
    public void play();
    public void pause();
    public void selectSong(Song song);
}
