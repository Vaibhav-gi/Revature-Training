package com.revplay.playlist;

import java.util.List;

public class PlaylistService {

    private final PlaylistDao dao = new PlaylistDao();

    public void createPlaylist(int userId, String name,
                               String desc, boolean isPublic) {
        try {
            dao.create(new Playlist(userId, name, desc, isPublic));
            System.out.println("Playlist created");
        } catch (Exception e) {
            System.out.println("Failed to create playlist");
        }
    }

    public void viewMyPlaylists(int userId) {
        try {
            List<Playlist> list = dao.findByUser(userId);
            if (list.isEmpty()) {
                System.out.println("No playlists found");
                return;
            }
            list.forEach(p ->
                    System.out.println(
                            p.getPlaylistId() + " | " +
                                    p.getName() + " | Public: " +
                                    p.isPublic()
                    )
            );
        } catch (Exception e) {
            System.out.println("Error fetching playlists");
        }
    }

    public void viewPublicPlaylists() {
        try {
            List<Playlist> list = dao.findPublic();
            list.forEach(p ->
                    System.out.println(
                            p.getPlaylistId() + " | " + p.getName()
                    )
            );
        } catch (Exception e) {
            System.out.println("Error fetching public playlists");
        }
    }

    public void updatePlaylist(int playlistId, int userId,
                               String name, String desc, boolean isPublic) {
        try {
            dao.update(new Playlist(
                    playlistId, userId, name, desc, isPublic));
            System.out.println("Playlist updated");
        } catch (Exception e) {
            System.out.println("Update failed");
        }
    }

    public void deletePlaylist(int playlistId, int userId) {
        try {
            dao.delete(playlistId, userId);
            System.out.println("Playlist deleted");
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }
}
