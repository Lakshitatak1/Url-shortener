package com.example.urlShortner;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/url")
public class UrlController {
    UrlService urlService;

    public UrlController(UrlService urlService)
    {
        this.urlService = urlService;
    }

    @PostMapping
    public CreateUrlResponse createShortUrl(@RequestBody CreateUrlRequest request)
    {
        Url url = urlService.createShortUrl(request.getUrl());
        String redirectUrl = "http://localhost:8080/api/url/" + url.getShortKey();
        return new CreateUrlResponse(redirectUrl);
    }
    @GetMapping("/{shortKey}")
    public ResponseEntity<?> getLongUrl(@PathVariable String shortKey) {
        return urlService.findUrl(shortKey)
            .map(url -> ResponseEntity
                    .status(HttpStatus.FOUND)
                    .header("Location", url.getLongUrl())
                    .build())
            .orElse(ResponseEntity.notFound().build());
}
}