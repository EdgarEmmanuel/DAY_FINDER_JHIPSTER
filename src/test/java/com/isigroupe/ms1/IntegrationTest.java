package com.isigroupe.ms1;

import com.isigroupe.ms1.config.AsyncSyncConfiguration;
import com.isigroupe.ms1.config.EmbeddedSQL;
import com.isigroupe.ms1.config.JacksonConfiguration;
import com.isigroupe.ms1.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { Ms1App.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedSQL
public @interface IntegrationTest {
}
