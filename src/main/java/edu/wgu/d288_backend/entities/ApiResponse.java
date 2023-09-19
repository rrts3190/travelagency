package edu.wgu.d288_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
