package com.agenda.event.model;

import java.time.LocalDateTime;

public class Event {

    private String id;
    private String title;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(String title, String location, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
