package com.media4all.desafio;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.media4all.desafio.component.ScheduledTasks;

@SpringBootTest
public class ScheduledTasksTest {

    @SpyBean
    ScheduledTasks tasks;

    @Test
    public void sendLog() {
        await().atMost(Duration.FIVE_SECONDS).untilAsserted(() -> {
            verify(tasks, atLeast(2)).sendLog();
        });
    }
}
