package com.example.urlShortner;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service 
public class UrlService {
    private UrlRepository urlRepo;
    private ShortKeyGenerator shortKeyGen;

    public UrlService(UrlRepository urlRepo, ShortKeyGenerator shortKeyGen)
    {
        this.urlRepo = urlRepo;
        this.shortKeyGen = shortKeyGen;
    }

    public Url createShortUrl(String longUrl)
    {
        String key = shortKeyGen.generate();
        while(urlRepo.findByShortKey(key).isPresent())
        {
            key = shortKeyGen.generate();
        }

        Url url = new Url();
        url.setShortKey(key);
        url.setLongUrl(longUrl);
        return urlRepo.save(url);
    }

    public Optional<Url> findUrl(String shortKey) {
        return urlRepo.findByShortKey(shortKey);
    }
}