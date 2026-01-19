package com.revplay.playlist;

public class Playlist {

    private int playlistId;
    private int userId;
    private String name;
    private String description;
    private boolean isPublic;

    public Playlist(int playlistId, int userId,
                    String name, String description, boolean isPublic) {
        this.playlistId = playlistId;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
    }

    public Playlist(int userId, String name,
                    String description, boolean isPublic) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
    }

    public int getPlaylistId() { return playlistId; }
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isPublic() { return isPublic; }
}
