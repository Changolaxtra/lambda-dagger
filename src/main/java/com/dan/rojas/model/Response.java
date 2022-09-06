package com.dan.rojas.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {
    String avatarName;
    String encodedImage;
    String error;
}
