package com.all.in.one.allinOne.error.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {

    private ErrorLevel level;
    private String path;
    private String message;

}