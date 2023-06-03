package com.fsoft.happflight.dto.nguoi_dung;

public class GoogleLoginDTO {
    private String email;
    private String name;
    private String googleId;

    public GoogleLoginDTO() {

    }

    public GoogleLoginDTO(String email, String name, String googleId) {
        this.email = email;
        this.name = name;
        this.googleId = googleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
