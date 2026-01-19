package com.revplay.artist;

public class ArtistService {

    private ArtistDao artistDao = new ArtistDao();

    // CREATE PROFILE
    public void createProfile(int userId,
                              String bio,
                              String genre,
                              String socialLinks) {

        try {
            if (artistDao.findByUserId(userId) != null) {
                System.out.println("Artist profile already exists");
                return;
            }

            Artist artist = new Artist(userId, bio, genre, socialLinks);
            artistDao.createProfile(artist);

            System.out.println("Artist profile created");

        } catch (Exception e) {
            System.out.println("Failed to create artist profile");
        }
    }

    // VIEW PROFILE
    public void viewProfile(int userId) {
        try {
            Artist artist = artistDao.findByUserId(userId);

            if (artist == null) {
                System.out.println("Artist profile not found");
                return;
            }

            System.out.println("Bio: " + artist.getBio());
            System.out.println("Genre: " + artist.getGenre());
            System.out.println("Social Links: " + artist.getSocialLinks());

        } catch (Exception e) {
            System.out.println("Error fetching artist profile");
        }
    }

    // UPDATE PROFILE
    public void updateProfile(int userId,
                              String bio,
                              String genre,
                              String socialLinks) {

        try {
            Artist artist = new Artist(userId, bio, genre, socialLinks);
            artistDao.updateProfile(artist);

            System.out.println("Artist profile updated");

        } catch (Exception e) {
            System.out.println("Failed to update artist profile");
        }
    }
}
