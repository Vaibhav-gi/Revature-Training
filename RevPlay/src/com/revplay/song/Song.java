package com.revplay.song;

public class Song {

    private int songId;
    private String title;
    private String genre;
    private int duration;     // seconds
    private int artistId;
    private Integer albumId;
    private int playCount;

    // For DB read
    public Song(int songId, String title, String genre,
                int duration, int artistId,
                Integer albumId, int playCount) {
        this.songId = songId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.artistId = artistId;
        this.albumId = albumId;
        this.playCount = playCount;
    }

    // For insert
    public Song(String title, String genre,
                int duration, int artistId, Integer albumId) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.artistId = artistId;
        this.albumId = albumId;
    }

    public int getSongId() { return songId; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public int getArtistId() { return artistId; }
    public Integer getAlbumId() { return albumId; }
    public int getPlayCount() { return playCount; }
}
