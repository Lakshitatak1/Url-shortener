package com.example.urlShortner;
import org.springframework.stereotype.Component;
import java.util.Random;
@Component
public class ShortKeyGenerator {
    public String generate()
    {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++)
        {
            int ind = random.nextInt(62);
            s.append(characters.charAt(ind));
        }
        return s.toString();
    }
}