package org.example;

public class DeckDto {
    private boolean success;
    private String deck_id;
    private int remaining;
    private boolean shuffle;

    public boolean isSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public int getRemaining() {
        return remaining;
    }

    public boolean isShuffle() {
        return shuffle;
    }
}
