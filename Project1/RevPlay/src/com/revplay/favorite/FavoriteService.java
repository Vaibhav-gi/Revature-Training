package com.revplay.favorite;

public class FavoriteService {

    private final FavoriteDao dao = new FavoriteDao();

    public void addFavorite(int userId, int songId) {
        try {
            dao.add(userId, songId);
            System.out.println("Added to favorites");
        } catch (Exception e) {
            System.out.println("Failed to add favorite");
        }
    }

    public void removeFavorite(int userId, int songId) {
        try {
            dao.remove(userId, songId);
            System.out.println("Removed from favorites");
        } catch (Exception e) {
            System.out.println("Failed to remove favorite");
        }
    }

    public void viewFavorites(int userId) {
        try {
            dao.findFavorites(userId)
                    .forEach(id -> System.out.println("Song ID: " + id));
        } catch (Exception e) {
            System.out.println("Error fetching favorites");
        }
    }
}
