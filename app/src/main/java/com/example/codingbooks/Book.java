package com.example.codingbooks;

public class Book {

    private String booktitle;
    private int coverimage;
    private String link;

    public Book(String booktitle, int coverimage, String link) {
        this.booktitle = booktitle;
        this.coverimage = coverimage;
        this.link = link;
    }

    public String getLink() {

        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(int coverimage) {
        this.coverimage = coverimage;
    }
}
