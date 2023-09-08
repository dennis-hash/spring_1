package com.example.HNG_stage_1.Controller;

import com.example.HNG_stage_1.DTO.OutputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class Api {
    @GetMapping
    public ResponseEntity<?> getDetails(@RequestParam("slack_name") String slack_name, @RequestParam("track") String track){

        OffsetDateTime utcTime = OffsetDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String utcTimeString = utcTime.format(formatter);

        String dayOfWeek = utcTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
        return new ResponseEntity<>(new OutputDTO(slack_name, track, utcTime.format(formatter), dayOfWeek), HttpStatus.OK);
    }
}
