package com.revplay.song;

import com.revplay.auth.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDao {

    // ADD SONG (ARTIST)
    public void addSong(Song song) throws SQLException {
        String sql =
                "INSERT INTO songs (title, genre, duration, artist_id, album_id) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, song.getTitle());
            ps.setString(2, song.getGenre());
            ps.setInt(3, song.getDuration());
            ps.setInt(4, song.getArtistId());

            if (song.getAlbumId() != null)
                ps.setInt(5, song.getAlbumId());
            else
                ps.setNull(5, Types.INTEGER);

            ps.executeUpdate();
        }
    }

    // VIEW SONGS BY ARTIST
    public List<Song> findByArtist(int artistId) throws SQLException {
        List<Song> list = new ArrayList<>();
        String sql = "SELECT * FROM songs WHERE artist_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, artistId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(map(rs));
        }
        return list;
    }

    // SEARCH SONGS (USER)
    public List<Song> search(String keyword) throws SQLException {
        List<Song> list = new ArrayList<>();
        String sql = "SELECT * FROM songs WHERE title LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(map(rs));
        }
        return list;
    }

    // ASSIGN SONG TO ALBUM
    public void assignSongToAlbum(int songId, int albumId, int artistId)
            throws SQLException {

        String sql = """
        UPDATE songs
        SET album_id = ?
        WHERE song_id = ? AND artist_id = ?
    """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, albumId);
            ps.setInt(2, songId);
            ps.setInt(3, artistId);

            ps.executeUpdate();
        }
    }

    // DELETE SONG (ARTIST OWNERSHIP)
    public void deleteSong(int songId, int artistId) throws SQLException {
        String sql =
                "DELETE FROM songs WHERE song_id=? AND artist_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, songId);
            ps.setInt(2, artistId);
            ps.executeUpdate();
        }
    }

    // INCREMENT PLAY COUNT
    public void incrementPlayCount(int songId) throws SQLException {
        String sql =
                "UPDATE songs SET play_count = play_count + 1 WHERE song_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, songId);
            ps.executeUpdate();
        }
    }

    private Song map(ResultSet rs) throws SQLException {
        return new Song(
                rs.getInt("song_id"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getInt("duration"),
                rs.getInt("artist_id"),
                rs.getObject("album_id", Integer.class),
                rs.getInt("play_count")
        );
    }
}
