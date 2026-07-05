package com.anishvel.urlshortener.url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlShortener, Long> {

    Optional<UrlShortener> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);

    Optional<UrlShortener> findByOriginalUrl(String OriginalUrl);

}
