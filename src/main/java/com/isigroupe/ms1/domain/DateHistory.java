package com.isigroupe.ms1.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "date_history")
public class DateHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_date")
    private String inputDate;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    // Constructors
    public DateHistory() {}

    public DateHistory(String inputDate, String dayOfWeek) {
        this.inputDate = inputDate;
        this.dayOfWeek = dayOfWeek;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
