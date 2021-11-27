package com.media4all.desafio;

import com.media4all.desafio.component.ScheduledTasks;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesafioApplicationTests {

	@Autowired
	private ScheduledTasks tasks;

	@Test
	void contextLoads() {
		assertThat(tasks).isNotNull();
	}

}
