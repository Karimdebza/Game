package com.game.Class;

public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord) {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public String getCommandWord() {
        return commandWord;
    }
}
