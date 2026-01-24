package com.revplay.history;

import com.revplay.auth.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {

    public void record(int userId, int songId) throws SQLException {
        String sql =
                "INSERT INTO listening_history (user_id, song_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, songId);
            ps.executeUpdate();
        }
    }

    public List<Integer> getHistory(int userId) throws SQLException {
        List<Integer> list = new ArrayList<>();
        String sql =
                "SELECT song_id FROM listening_history WHERE user_id=? ORDER BY played_at DESC";

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
