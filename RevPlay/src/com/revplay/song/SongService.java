package com.revplay.song;

import java.util.List;

public class SongService {

    private SongDao dao = new SongDao();

    // ARTIST: UPLOAD
    public void uploadSong(String title, String genre,
                           int duration, int artistId, Integer albumId) {
        try {
            dao.addSong(new Song(title, genre, duration, artistId, albumId));
            System.out.println("Song Uploaded Successfully");
        } catch (Exception e) {
            System.out.println("Upload failed");
//            e.printStackTrace();
        }
    }

    // ARTIST: VIEW OWN SONGS
    public void viewMySongs(int artistId) {
        try {
            List<Song> list = dao.findByArtist(artistId);
            if (list.isEmpty()) {
                System.out.println("No songs uploaded");
                return;
            }
            list.forEach(s ->
                    System.out.println(
                            s.getSongId() + " | " +
                                    s.getTitle() + " | " +
                                    s.getGenre() + " | Plays: " +
                                    s.getPlayCount()
                    )
            );
        } catch (Exception e) {
            System.out.println("Error fetching songs");
        }
    }

    // USER: SEARCH
    public void searchSongs(String keyword) {
        try {
            List<Song> list = dao.search(keyword);
            list.forEach(s ->
                    System.out.println(
                            s.getSongId() + " | " +
                                    s.getTitle() + " | " +
                                    s.getGenre()
                    )
            );
        } catch (Exception e) {
            System.out.println("Search failed");
        }
    }

    // ARTIST: DELETE
    public void deleteSong(int songId, int artistId) {
        try {
            dao.deleteSong(songId, artistId);
            System.out.println("Song deleted");
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }

    // ARTIST: ADD SONG TO ALBUM
    public void addSongToAlbum(int songId, int albumId, int artistId) {
        try {
            dao.assignSongToAlbum(songId, albumId, artistId);
            System.out.println("Song added to album");
        } catch (Exception e) {
            System.out.println("Failed to add song to album");
        }
    }

    // PLAY (USED BY PLAYER MODULE)
    public void playSong(int songId) {
        try {
            dao.incrementPlayCount(songId);
        } catch (Exception e) {
            System.out.println("Play failed");
        }
    }
}
