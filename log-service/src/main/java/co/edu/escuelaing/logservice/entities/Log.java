package co.edu.escuelaing.logservice.entities;

import java.util.Objects;

/**
 * Log class that represents a message with a date entry
 */
public class Log {
    private String message;
    private String eventDate;

    public Log(String message, String eventDate) {
        this.message = message;
        this.eventDate = eventDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(message, log.message) && Objects.equals(eventDate, log.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, eventDate);
    }

    @Override
    public String toString() {
        return "Log{" +
                "message='" + message + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
