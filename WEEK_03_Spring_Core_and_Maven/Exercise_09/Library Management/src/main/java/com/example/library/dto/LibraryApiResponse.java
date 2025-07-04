package com.example.library.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryApiResponse {
    private int status;
    private String message;
    private Object data;

    public static LibraryApiResponse success(Object data) {
        return new LibraryApiResponse(200, "Success", data);
    }

    public static LibraryApiResponse success(String message, Object data) {
        return new LibraryApiResponse(200, message, data);
    }

    public static LibraryApiResponse error(int status, String message) {
        return new LibraryApiResponse(status, message, null);
    }

    public static LibraryApiResponse notFound(String message) {
        return new LibraryApiResponse(404, message, null);
    }

    public static LibraryApiResponse created(Object data) {
        return new LibraryApiResponse(201, "Created successfully", data);
    }
}
