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
package example;

import static org.zalando.stups.junit.postgres.MavenProjectLayout.projectBaseDir;

import java.util.concurrent.TimeUnit;

import org.junit.ClassRule;
import org.junit.Test;
import org.zalando.stups.junit.postgres.PostgreSqlRule;

/**
 * 
 * @author jbellmann
 *
 */
public class DirectoryLayoutRuleTest {

    @ClassRule
    public static final PostgreSqlRule postgres = new PostgreSqlRule.Builder().withPort(5435)
            .addScriptLocation(projectBaseDir(DirectoryLayoutRuleTest.class) + "/dbscripts").build();

    @Test
    public void runTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }
}
