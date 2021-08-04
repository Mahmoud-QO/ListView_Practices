package com.example.listviewpractices;

public class Item
{
    private int imageID;
    private String day;
    private String description;

    Item(String day, String description, int imageID){
        this.day = day; this.description = description; this.imageID = imageID;
    }

    public int getImageID()
    {
        return imageID;
    }
    public void setImageID(int imageID)
    {
        this.imageID = imageID;
    }

    public String getDay()
    {
        return day;
    }
    public void setDay(String day)
    {
        this.day = day;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
}
