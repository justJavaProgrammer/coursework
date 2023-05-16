package edu.odeyalo.college.coursework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionMessage {
    @JsonProperty("timestamp")
    private Long timestamp;
    private String message;
    private String path;
    @JsonProperty("exception_type")
    private String exceptionType;
    @JsonProperty("additional_info")
    private Map<String, Object> additionalInfo;


    public ApiExceptionMessage(String message, String path, String exceptionType) {
        this(message, path, exceptionType, Collections.emptyMap());
    }
    public ApiExceptionMessage(String message, String path, String exceptionType, Map<String, Object> additionalInfo) {
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.path = path;
        this.exceptionType = exceptionType;
        this.additionalInfo = additionalInfo;
    }

    public static ApiExceptionMessage of(String message, String path, String exceptionType, Map<String, Object> additionalInfo) {
        return new ApiExceptionMessage(message, path, exceptionType, additionalInfo);
    }
}
