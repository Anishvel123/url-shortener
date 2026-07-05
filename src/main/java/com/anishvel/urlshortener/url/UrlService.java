package com.anishvel.urlshortener.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlShortener createShortUrl(String OriginalUrl) {
        Optional<UrlShortener> exists = urlRepository.findByOriginalUrl(OriginalUrl);
        if (exists.isPresent()) {
            return exists.get();
        }

        UrlShortener url = new UrlShortener();
        url.setOriginalUrl(OriginalUrl);
        String shortCode;
        do {
            shortCode = generateShortCode();
        } while (urlRepository.existsByShortCode(shortCode));
        url.setShortCode(shortCode);

        return urlRepository.save(url);
    }

    public UrlShortener getOriginalUrl(String shortCode) {

        Optional<UrlShortener> exists = urlRepository.findByShortCode(shortCode);
        if (exists.isPresent()) {
            return exists.get();
        }
        throw new RuntimeException("Short URL is not found");
    }

    private String generateShortCode() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 6);
    }
}
