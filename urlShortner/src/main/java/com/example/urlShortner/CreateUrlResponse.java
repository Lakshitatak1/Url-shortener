package com.example.urlShortner;

public class CreateUrlResponse{
    private String redirectUrl;

    public CreateUrlResponse(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    public String getRedirectUrl() {
        return redirectUrl;
    }
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}