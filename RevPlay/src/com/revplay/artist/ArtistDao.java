package com.revplay.artist;

import com.revplay.auth.DBConnection;

import java.sql.*;

public class ArtistDao {

    // CREATE PROFILE
    public void createProfile(Artist artist) throws SQLException {

        String sql =
                "INSERT INTO artists (user_id, bio, genre, social_links) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, artist.getUserId());
            ps.setString(2, artist.getBio());
            ps.setString(3, artist.getGenre());
            ps.setString(4, artist.getSocialLinks());

            ps.executeUpdate();
        }
    }

    // GET PROFILE BY USER ID
    public Artist findByUserId(int userId) throws SQLException {

        String sql = "SELECT * FROM artists WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Artist(
                        rs.getInt("artist_id"),
                        rs.getInt("user_id"),
                        rs.getString("bio"),
                        rs.getString("genre"),
                        rs.getString("social_links")
                );
            }
            return null;
        }
    }

    // UPDATE PROFILE
    public void updateProfile(Artist artist) throws SQLException {

        String sql =
                "UPDATE artists SET bio=?, genre=?, social_links=? WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, artist.getBio());
            ps.setString(2, artist.getGenre());
            ps.setString(3, artist.getSocialLinks());
            ps.setInt(4, artist.getUserId());

            ps.executeUpdate();
        }
    }
}
