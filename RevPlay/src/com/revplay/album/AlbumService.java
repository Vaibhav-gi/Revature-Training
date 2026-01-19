package com.revplay.album;

import java.sql.Date;
import java.util.List;

public class AlbumService {

    private final AlbumDao dao = new AlbumDao();

    public void createAlbum(int artistId, String title, Date releaseDate) {
        try {
            dao.createAlbum(new Album(artistId, title, releaseDate));
            System.out.println("Album created successfully");
        } catch (Exception e) {
            System.out.println("Album creation failed");
        }
    }

    public void viewMyAlbums(int artistId) {
        try {
            List<Album> list = dao.findByArtist(artistId);
            if (list.isEmpty()) {
                System.out.println("No albums found");
                return;
            }
            list.forEach(a ->
                    System.out.println(
                            a.getAlbumId() + " | " +
                                    a.getTitle() + " | " +
                                    a.getReleaseDate()
                    )
            );
        } catch (Exception e) {
            System.out.println("Error fetching albums");
        }
    }

    public void updateAlbum(int albumId, int artistId,
                            String title, Date date) {
        try {
            dao.updateAlbum(albumId, artistId, title, date);
            System.out.println("Album updated");
        } catch (Exception e) {
            System.out.println("Update failed");
        }
    }

    public void deleteAlbum(int albumId, int artistId) {
        try {
            dao.deleteAlbum(albumId, artistId);
            System.out.println("Album deleted");
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }
}
