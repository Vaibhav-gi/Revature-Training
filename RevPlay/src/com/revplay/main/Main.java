package com.revplay.main;

import com.revplay.album.AlbumService;
import com.revplay.auth.AuthService;
import com.revplay.auth.User;
import com.revplay.artist.ArtistService;
import com.revplay.song.SongService;
import com.revplay.playlist.PlaylistSongService;
import com.revplay.playlist.PlaylistService;
import com.revplay.favorite.FavoriteService;
import com.revplay.history.HistoryService;
import com.revplay.player.PlayerService;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final AuthService authService = new AuthService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== REVPLAY ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> registerFlow();
                case 2 -> loginFlow();
                case 3 -> {
                    System.out.println("Bye");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // ================= REGISTER =================
    private static void registerFlow() {

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Role (USER / ARTIST): ");
        String role = sc.nextLine().toUpperCase();

        System.out.print("Security Question: ");
        String question = sc.nextLine();

        System.out.print("Security Answer: ");
        String answer = sc.nextLine();

        authService.register(email, password, role, question, answer);
    }

    // ================= LOGIN =================
    private static void loginFlow() {

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = authService.login(email, password);

        if (user != null) {
            if (user.getRole().equals("ARTIST")) {
                artistMenu(user);
            } else {
                userMenu(user);
            }
            return;
        }

        // Only comes here if login failed
        while (true) {
            System.out.println("\nLogin failed. Choose an option:");
            System.out.println("1. Try Login Again");
            System.out.println("2. Forgot Password");
            System.out.println("3. Back to Main Menu");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    loginFlow();   // retry login
                    return;
                }
                case 2 -> {
                    forgotPasswordFlow();
                    return;
                }
                case 3 -> {
                    return;        // back to main menu
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void forgotPasswordFlow() {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Security Answer: ");
        String answer = sc.nextLine();

        System.out.print("Enter New Password: ");
        String newPassword = sc.nextLine();

        authService.forgotPassword(email, answer, newPassword);
    }

    // ================= ARTIST MENU =================
    private static void artistMenu(User user) {

        ArtistService artistService = new ArtistService();
        SongService songService = new SongService();
        AlbumService albumService = new AlbumService();

        while (true) {
            System.out.println("\n=== ARTIST MENU ===");
            System.out.println("1. Create Artist Profile");
            System.out.println("2. View Artist Profile");
            System.out.println("3. Update Artist Profile");
            System.out.println("4. Upload Song");
            System.out.println("5. View My Songs");
            System.out.println("6. Delete Song");
            System.out.println("7. Logout");
            System.out.println("8. Create Album");
            System.out.println("9. View My Albums");
            System.out.println("10. Add Song to Album");
            System.out.println("11. Delete Album");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Bio: ");
                    String bio = sc.nextLine();

                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Social Links: ");
                    String links = sc.nextLine();

                    artistService.createProfile(
                            user.getUserId(), bio, genre, links);
                }

                case 2 -> artistService.viewProfile(user.getUserId());

                case 3 -> {
                    System.out.print("New Bio: ");
                    String bio = sc.nextLine();

                    System.out.print("New Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("New Social Links: ");
                    String links = sc.nextLine();

                    artistService.updateProfile(
                            user.getUserId(), bio, genre, links);
                }

                case 4 -> {
                    System.out.print("Song Title: ");
                    String title = sc.nextLine();

                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Duration (seconds): ");
                    int duration = sc.nextInt();
                    sc.nextLine();

                    songService.uploadSong(
                            title, genre, duration,
                            user.getUserId(), null
                    );
                }

                case 5 -> songService.viewMySongs(user.getUserId());

                case 6 -> {
                    System.out.print("Song ID to delete: ");
                    int songId = sc.nextInt();
                    sc.nextLine();

                    songService.deleteSong(songId, user.getUserId());
                }

                case 7 -> {
                    System.out.println("Logged out");
                    return;
                }
                case 8 -> {
                    System.out.print("Album Title: ");
                    String title = sc.nextLine();

                    System.out.print("Release Date (YYYY-MM-DD): ");
                    String dateStr = sc.nextLine();

                    java.sql.Date releaseDate = null;
                    if (!dateStr.isBlank()) {
                        releaseDate = java.sql.Date.valueOf(dateStr);
                    }

                    albumService.createAlbum(
                            user.getUserId(),
                            title,
                            releaseDate
                    );
                }


                case 9 -> albumService.viewMyAlbums(user.getUserId());

                case 10 -> {
                    System.out.print("Song ID: ");
                    int songId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Album ID: ");
                    int albumId = sc.nextInt();
                    sc.nextLine();

                    songService.addSongToAlbum(songId, albumId, user.getUserId());
                }

                case 11 -> {
                    System.out.print("Album ID: ");
                    int albumId = sc.nextInt();
                    sc.nextLine();

                    albumService.deleteAlbum(albumId, user.getUserId());
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    // ================= USER MENU =================
    private static void userMenu(User user) {

        SongService songService = new SongService();
        PlaylistService playlistService = new PlaylistService();
        PlaylistSongService playlistSongService = new PlaylistSongService();
        FavoriteService favoriteService = new FavoriteService();
        HistoryService historyService = new HistoryService();
        PlayerService playerService = new PlayerService();

        while (true) {
            System.out.println("\n=== USER MENU ===");
            System.out.println("1. Search Songs");
            System.out.println("2. Play Song");
            System.out.println("3. Create Playlist");
            System.out.println("4. View My Playlists");
            System.out.println("5. View Public Playlists");
            System.out.println("6. Delete Playlist");
            System.out.println("7. Logout");
            System.out.println("8. Add Song to Playlist");
            System.out.println("9. Remove Song from Playlist");
            System.out.println("10. Add Favorite");
            System.out.println("11. Remove Favorite");
            System.out.println("12. View Favorites");
            System.out.println("13. View Listening History");
            System.out.println("14. Pause Song");
            System.out.println("15. Resume Song");
            System.out.println("16. Skip Song");
            System.out.println("17. Toggle Repeat");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Keyword: ");
                    String keyword = sc.nextLine();
                    songService.searchSongs(keyword);
                }

                case 2 -> {
                    System.out.print("Song ID: ");
                    int songId = sc.nextInt();
                    sc.nextLine();
                    songService.playSong(songId);
                    historyService.recordPlay(user.getUserId(), songId);
//                    System.out.println("Playing song...");
                    playerService.play(songId);
                }

                case 3 -> {
                    System.out.print("Playlist Name: ");
                    String name = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Public? (true/false): ");
                    boolean isPublic = sc.nextBoolean();
                    sc.nextLine();

                    playlistService.createPlaylist(
                            user.getUserId(), name, desc, isPublic);
                }

                case 4 -> playlistService.viewMyPlaylists(user.getUserId());

                case 5 -> playlistService.viewPublicPlaylists();

                case 6 -> {
                    System.out.print("Playlist ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    playlistService.deletePlaylist(pid, user.getUserId());
                }

                case 7 -> {
                    System.out.println("Logged out");
                    return;
                }

                case 8 -> {
                    System.out.print("Playlist ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Song ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    playlistSongService.addSongToPlaylist(
                            pid, sid, user.getUserId()
                    );
                }

                case 9 -> {
                    System.out.print("Playlist ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Song ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    playlistSongService.removeSongFromPlaylist(
                            pid, sid, user.getUserId()
                    );
                }
                case 10 -> {
                    System.out.print("Song ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    favoriteService.addFavorite(user.getUserId(), sid);
                }

                case 11 -> {
                    System.out.print("Song ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    favoriteService.removeFavorite(user.getUserId(), sid);
                }

                case 12 -> favoriteService.viewFavorites(user.getUserId());

                case 13 -> historyService.viewHistory(user.getUserId());

                case 14 -> playerService.pause();

                case 15 -> playerService.resume();

                case 16 -> {
                    System.out.print("Next Song ID: ");
                    int nextId = sc.nextInt();
                    sc.nextLine();

                    songService.playSong(nextId);
                    historyService.recordPlay(user.getUserId(), nextId);
                    playerService.skip(nextId);
                }

                case 17 -> playerService.toggleRepeat();

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
