package com.revplay.album;

import java.sql.Date;

public class Album {

    private int albumId;
    private int artistId;
    private String title;
    private Date releaseDate;

    // For DB read
    public Album(int albumId, int artistId, String title, Date releaseDate) {
        this.albumId = albumId;
        this.artistId = artistId;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    // For insert
    public Album(int artistId, String title, Date releaseDate) {
        this.artistId = artistId;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public int getAlbumId() { return albumId; }
    public int getArtistId() { return artistId; }
    public String getTitle() { return title; }
    public Date getReleaseDate() { return releaseDate; }
}
