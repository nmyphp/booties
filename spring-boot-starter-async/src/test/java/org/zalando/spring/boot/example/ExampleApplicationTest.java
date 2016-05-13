/**
 * Copyright (C) 2015 Zalando SE (http://tech.zalando.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.spring.boot.example;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zalando.spring.boot.example.job.ExampleJob;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ExampleApplication.class })
@WebIntegrationTest(randomPort = true)
public class ExampleApplicationTest {

    @Autowired
    private ExampleJob job;

    @Autowired
    // @Qualifier("taskExecutor")
    private ThreadPoolTaskExecutor executor;

    @Test
    public void startUp() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        job.run();
        TimeUnit.SECONDS.sleep(2);
        job.run();
        TimeUnit.SECONDS.sleep(2);
    }
}
