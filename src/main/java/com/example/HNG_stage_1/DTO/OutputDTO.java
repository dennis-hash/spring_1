package com.example.HNG_stage_1.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutputDTO {
    private String slack_name;
    private String current_day;
    private String  utc_time;
    private String track;
    private String github_file_url = "https://github.com/dennis-hash/spring_1/blob/main/src/main/java/com/example/HNG_stage_1/Controller/Api.java";
    private String github_repo_url = "https://github.com/dennis-hash";
    private Integer status_code = 200;

    public OutputDTO(String slack_name, String track, String time, String dayOfWeek ){
        this.slack_name = slack_name;
        this.track = track;
        this.utc_time = time;
        this.current_day = dayOfWeek;
    }
}
