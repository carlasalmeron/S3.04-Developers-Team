package com.agenda.event.model;

import java.time.LocalDateTime;

public class Event {

    private int id;
    private String title;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Event(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.location = builder.location;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public static class Builder {

        private int id;
        private String title;
        private String location;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Event build() {

            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("The title cannot be empty");
            }
            if (startTime == null || endTime == null) {
                throw new IllegalArgumentException("Dates are needed");
            }
            if (endTime.isBefore(startTime)) {
                throw new IllegalArgumentException("Finish date cannot be before end date.");
            }

            return new Event(this);
        }
    }
}
