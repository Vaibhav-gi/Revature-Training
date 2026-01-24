package com.revplay.history;

public class HistoryService {

    private final HistoryDao dao = new HistoryDao();

    public void recordPlay(int userId, int songId) {
        try {
            dao.record(userId, songId);
        } catch (Exception e) {
            System.out.println("Failed to record history");
        }
    }

    public void viewHistory(int userId) {
        try {
            dao.getHistory(userId)
                    .forEach(id -> System.out.println("Song ID: " + id));
        } catch (Exception e) {
            System.out.println("Error fetching history");
        }
    }
}
