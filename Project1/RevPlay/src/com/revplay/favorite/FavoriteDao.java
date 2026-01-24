package com.revplay.favorite;

import com.revplay.auth.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDao {

    public void add(int userId, int songId) throws SQLException {
        String sql =
                "INSERT INTO user_favorites (user_id, song_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, songId);
            ps.executeUpdate();
        }
    }

    public void remove(int userId, int songId) throws SQLException {
        String sql =
                "DELETE FROM user_favorites WHERE user_id=? AND song_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, songId);
            ps.executeUpdate();
        }
    }

    public List<Integer> findFavorites(int userId) throws SQLException {
        List<Integer> list = new ArrayList<>();
        String sql =
                "SELECT song_id FROM user_favorites WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("song_id"));
            }
        }
        return list;
    }
}
