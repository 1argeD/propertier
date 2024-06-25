package com.example.properties;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class RefreshCounter {
    private final Log log = LogFactory.getLog(getClass());
    private final AtomicLong counter = new AtomicLong(0);

    @EventListener
    public void refresh(RefreshScopeRefreshedEvent e) {
        this.log.info("새로고침 횟수 : " + this.counter.incrementAndGet());
    }
}
