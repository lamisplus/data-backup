package it;

import com.foreach.across.config.AcrossContextConfigurer;
import com.foreach.across.core.AcrossContext;
import com.foreach.across.test.AcrossTestConfiguration;
import com.foreach.across.test.AcrossWebAppConfiguration;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import io.zonky.test.db.postgres.junit5.SingleInstancePostgresExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lamisplus.modules.data_backup.Data_Backup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({SpringExtension.class, SingleInstancePostgresExtension.class})
@DirtiesContext
@ContextConfiguration
@AcrossWebAppConfiguration
@AutoConfigureEmbeddedDatabase(beanName = "acrossDataSource")
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class
})
@Slf4j
public class TestData_Backup {
    @Autowired
    AcrossContext acrossContext;

    @Test
    public void should_initialize_module() {
        assertNotNull(acrossContext.getModule(Data_Backup.NAME));
    }

    @Configuration
    @AcrossTestConfiguration//(modules = Data_Backup.NAME)
    @PropertySource(value = "classpath:across-test.properties")
    static class Config implements AcrossContextConfigurer {

        @Override
        public void configure(AcrossContext context) {
            context.addModule(new Data_Backup());
        }
    }
}
