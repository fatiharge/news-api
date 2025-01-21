package com.fatiharge.scheduler;

import com.fatiharge.service.NewsService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

@ApplicationScoped
public class NewsScheduler {

    @Inject
    NewsService newsService;

    @Scheduled(cron = "0 0 12 * * ?")
    void fetchNews() {
        try {
            newsService.fetchDailyNews("us");
            System.out.println("News fetched successfully at " + LocalDateTime.now());
        } catch (Exception e) {
            System.err.println("Failed to fetch news: " + e.getMessage());
        }
    }
}
