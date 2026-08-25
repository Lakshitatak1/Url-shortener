package com.example.urlShortner;
import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class Url{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, name = "short_key")
    private String shortKey;
    @Column(name = "long_url")
    private String longUrl;

    public void setShortKey(String shortKey)
    {
        this.shortKey = shortKey;
    }

    public void setLongUrl(String longUrl)
    {
        this.longUrl = longUrl;
    }

    public Long getId()
    {
        return id;
    }

    public String getShortKey()
    {
        return shortKey;
    }

    public String getLongUrl()
    {
        return longUrl;
    }
}