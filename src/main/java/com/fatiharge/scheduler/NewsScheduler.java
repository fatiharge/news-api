package com.fatiharge.scheduler;

import com.fatiharge.service.NewsService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;

@ApplicationScoped
public class NewsScheduler {
    private static final Logger LOG = Logger.getLogger(NewsScheduler.class);
    @Inject
    NewsService newsService;

    @Scheduled(cron = "0 0 12 * * ?")
    void fetchNews() {
        try {
            newsService.fetchDailyNews("us");
            LOG.info("News fetched successfully at " + LocalDateTime.now());
        } catch (Exception e) {
            LOG.error("Failed to fetch news: " + e.getMessage(), e);
        }
    }
}
