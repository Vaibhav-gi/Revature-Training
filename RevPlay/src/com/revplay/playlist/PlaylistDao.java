package com.revplay.playlist;

import com.revplay.auth.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDao {

    // CREATE PLAYLIST
    public void create(Playlist p) throws SQLException {
        String sql =
                "INSERT INTO playlists (user_id, name, description, is_public) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getUserId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getDescription());
            ps.setBoolean(4, p.isPublic());
            ps.executeUpdate();
        }
    }

    // FIND PLAYLISTS BY USER
    public List<Playlist> findByUser(int userId) throws SQLException {
        List<Playlist> list = new ArrayList<>();
        String sql = "SELECT * FROM playlists WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    // FIND PUBLIC PLAYLISTS
    public List<Playlist> findPublic() throws SQLException {
        List<Playlist> list = new ArrayList<>();
        String sql = "SELECT * FROM playlists WHERE is_public=true";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    // UPDATE PLAYLIST
    public void update(Playlist p) throws SQLException {
        String sql =
                "UPDATE playlists SET name=?, description=?, is_public=? " +
                        "WHERE playlist_id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setBoolean(3, p.isPublic());
            ps.setInt(4, p.getPlaylistId());
            ps.setInt(5, p.getUserId());
            ps.executeUpdate();
        }
    }

    // DELETE PLAYLIST
    public void delete(int playlistId, int userId) throws SQLException {
        String sql =
                "DELETE FROM playlists WHERE playlist_id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, playlistId);
            ps.setInt(2, userId);
            ps.executeUpdate();
        }
    }

    // MAPPER
    private Playlist map(ResultSet rs) throws SQLException {
        return new Playlist(
                rs.getInt("playlist_id"),
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getBoolean("is_public")
        );
    }
}
