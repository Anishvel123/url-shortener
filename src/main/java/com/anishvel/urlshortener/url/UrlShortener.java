package com.anishvel.urlshortener.url;

import jakarta.persistence.*;

@Entity
@Table
public class UrlShortener {
    @Id
    @SequenceGenerator(
            name = "url_sequence",
            sequenceName = "url_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "url_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String originalUrl;
    @Column(nullable = false, unique = true)
    private String shortCode;

    public UrlShortener() {
    }

    public UrlShortener(Long id, String OriginalUrl, String ShortCode) {
        this.id = id;
        this.originalUrl = OriginalUrl;
        this.shortCode = ShortCode;
    }

    public UrlShortener(String OriginalUrl, String ShortCode) {
        this.originalUrl = OriginalUrl;
        this.shortCode = ShortCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public String toString() {
        return "UrlShortener{" +
                "id=" + id +
                ", OriginalUrl='" + originalUrl + '\'' +
                ", ShortCode='" + shortCode + '\'' +
                '}';
    }
}
