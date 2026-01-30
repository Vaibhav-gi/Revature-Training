package com.revplay.player;

public class PlayerService {

    private Integer currentSongId;
    private PlayerState state = PlayerState.STOPPED;
    private boolean repeat = false;

    public void play(int songId) {
        currentSongId = songId;
        state = PlayerState.PLAYING;
        System.out.println("▶ Now playing song ID: " + songId);
    }

    public void pause() {
        if (state == PlayerState.PLAYING) {
            state = PlayerState.PAUSED;
            System.out.println("⏸ Song paused");
        } else {
            System.out.println("No song is playing");
        }
    }

    public void resume() {
        if (state == PlayerState.PAUSED) {
            state = PlayerState.PLAYING;
            System.out.println("▶ Song resumed");
        } else {
            System.out.println("Nothing to resume");
        }
    }

    public void skip(int nextSongId) {
        currentSongId = nextSongId;
        state = PlayerState.PLAYING;
        System.out.println("⏭ Skipped to song ID: " + nextSongId);
    }

    public void toggleRepeat() {
        repeat = !repeat;
        System.out.println("🔁 Repeat is " + (repeat ? "ON" : "OFF"));
    }
}
