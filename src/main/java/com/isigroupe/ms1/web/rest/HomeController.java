package com.isigroupe.ms1.web.rest;

import com.isigroupe.ms1.domain.DateHistory;
import com.isigroupe.ms1.repository.DateHistoryRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final DateHistoryRepository dateHistoryRepository;

    public HomeController(DateHistoryRepository dateHistoryRepository) {
        this.dateHistoryRepository = dateHistoryRepository;
    }

    @GetMapping("/home/ms1")
    public String getHome() {
        return "Hello World MS1!";
    }

    @GetMapping("/services/calendar/dayfinder")
    public Map<String, String> getDayOfWeek(@RequestParam String date) {
        // Format attendu : jj-MM-aaaa
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDate = LocalDate.parse(date, formatter);
        String dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH);

        // Save to database
        DateHistory dateHistory = new DateHistory(localDate.toString(), dayOfWeek);
        dateHistoryRepository.save(dateHistory);

        Map<String, String> response = new HashMap<>();
        response.put("date", localDate.toString()); // format aaaa-MM-jj
        response.put("dayOfWeek", dayOfWeek); // en anglais

        return response;
    }

    @GetMapping("/calendar/historique/all")
    public List<DateHistory> getHistory() {
        return dateHistoryRepository.findAll();
    }
}
