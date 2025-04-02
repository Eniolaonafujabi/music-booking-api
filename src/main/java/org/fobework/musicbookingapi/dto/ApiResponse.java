package org.fobework.musicbookingapi.dto;

import lombok.Getter;
import lombok.Setter;


public class ApiResponse {
    private Object data;

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    private boolean success;
}
