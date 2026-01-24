package com.revplay.album;

import com.revplay.auth.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {

    // CREATE ALBUM
    public void createAlbum(Album album) throws SQLException {
        String sql = """
            INSERT INTO albums (artist_id, title, release_date)
            VALUES (?, ?, ?)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, album.getArtistId());
            ps.setString(2, album.getTitle());

            if (album.getReleaseDate() != null)
                ps.setDate(3, album.getReleaseDate());
            else
                ps.setNull(3, Types.DATE);

            ps.executeUpdate();
        }
    }

    // VIEW ALBUMS BY ARTIST
    public List<Album> findByArtist(int artistId) throws SQLException {
        List<Album> list = new ArrayList<>();
        String sql = "SELECT * FROM albums WHERE artist_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, artistId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    // UPDATE ALBUM
    public void updateAlbum(int albumId, int artistId,
                            String newTitle, Date newDate)
            throws SQLException {

        String sql = """
            UPDATE albums
            SET title=?, release_date=?
            WHERE album_id=? AND artist_id=?
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newTitle);
            ps.setDate(2, newDate);
            ps.setInt(3, albumId);
            ps.setInt(4, artistId);
            ps.executeUpdate();
        }
    }

    // DELETE ALBUM
    public void deleteAlbum(int albumId, int artistId)
            throws SQLException {

        String sql =
                "DELETE FROM albums WHERE album_id=? AND artist_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, albumId);
            ps.setInt(2, artistId);
            ps.executeUpdate();
        }
    }

    private Album map(ResultSet rs) throws SQLException {
        return new Album(
                rs.getInt("album_id"),
                rs.getInt("artist_id"),
                rs.getString("title"),
                rs.getDate("release_date")
        );
    }
}
