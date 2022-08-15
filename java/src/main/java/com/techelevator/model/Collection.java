package com.techelevator.model;

public class Collection {

    private int collectionId;
    private String title;
    private boolean publicFlag;
    private String notes;

    public int getCollectionId() { return collectionId; }
    public void setCollectionId(int collectionId) { this.collectionId = collectionId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public boolean isPublicFlag() {
        return publicFlag;
    }

    public void setPublicFlag(boolean publicFlag) {
        this.publicFlag = publicFlag;
    }
}
