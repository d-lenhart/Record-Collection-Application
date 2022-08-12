package com.techelevator.model;

public class Collection {

    private int collectionId;
    private String title;
    private boolean isPublic;
    private String notes;

    public int getCollectionId() { return collectionId; }
    public void setCollectionId(int collectionId) { this.collectionId = collectionId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isPublic() { return isPublic; }
    public void setPublic(boolean isPublic) { this.isPublic = isPublic; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
