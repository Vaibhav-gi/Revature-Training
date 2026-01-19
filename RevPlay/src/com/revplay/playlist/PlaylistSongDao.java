package com.revplay.playlist;

import com.revplay.auth.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlaylistSongDao {

    // ADD SONG TO PLAYLIST
    public void addSong(int playlistId, int songId, int userId) throws Exception {

        // Ownership check: playlist must belong to user
        String checkSql =
                "SELECT 1 FROM playlists WHERE playlist_id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(checkSql)) {

            ps.setInt(1, playlistId);
            ps.setInt(2, userId);

            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new RuntimeException("Playlist does not belong to user");
            }
        }

        String sql =
                "INSERT INTO playlist_songs (playlist_id, song_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, playlistId);
            ps.setInt(2, songId);
            ps.executeUpdate();
        }
    }

    // REMOVE SONG FROM PLAYLIST
    public void removeSong(int playlistId, int songId, int userId) throws Exception {

        String sql =
                "DELETE ps FROM playlist_songs ps " +
                        "JOIN playlists p ON ps.playlist_id = p.playlist_id " +
                        "WHERE ps.playlist_id=? AND ps.song_id=? AND p.user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, playlistId);
            ps.setInt(2, songId);
            ps.setInt(3, userId);
            ps.executeUpdate();
        }
    }
}
