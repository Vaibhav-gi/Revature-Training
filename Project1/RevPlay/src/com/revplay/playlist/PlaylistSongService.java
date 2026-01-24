package com.revplay.playlist;

public class PlaylistSongService {

    private final PlaylistSongDao dao = new PlaylistSongDao();

    public void addSongToPlaylist(int playlistId, int songId, int userId) {
        try {
            dao.addSong(playlistId, songId, userId);
            System.out.println("Song added to playlist");
        } catch (Exception e) {
            System.out.println("Failed to add song to playlist");
//            e.printStackTrace();
        }
    }

    public void removeSongFromPlaylist(int playlistId, int songId, int userId) {
        try {
            dao.removeSong(playlistId, songId, userId);
            System.out.println("Song removed from playlist");
        } catch (Exception e) {
            System.out.println("Failed to remove song");
        }
    }
}
