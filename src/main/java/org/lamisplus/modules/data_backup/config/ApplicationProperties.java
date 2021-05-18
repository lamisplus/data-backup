package org.lamisplus.modules.data_backup.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ApplicationProperties {
    private String databaseDir;
    private String tempDir = System.getProperty("user.dir");
    private String serverUrl;
}
