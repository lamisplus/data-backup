package org.lamisplus.modules.data_backup;

import com.foreach.across.config.AcrossApplication;
import com.foreach.across.core.AcrossModule;
import com.foreach.across.core.context.configurer.ComponentScanConfigurer;
import com.foreach.across.modules.hibernate.jpa.AcrossHibernateJpaModule;
import com.foreach.across.modules.web.AcrossWebModule;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@AcrossApplication(
		modules = {
				AcrossHibernateJpaModule.NAME,
				AcrossWebModule.NAME
		}
)
public class Data_Backup extends AcrossModule {

	public static final String NAME = "Data_Backup Module";

	public static void main( String[] args ) {
		SpringApplication.run( Data_Backup.class, args );
	}

	public Data_Backup() {
		super();
		addApplicationContextConfigurer(new ComponentScanConfigurer(getClass().getPackage().getName() + ".config",
						getClass().getPackage().getName() + ".controller",
						getClass().getPackage().getName() + ".service",
						getClass().getPackage().getName() + ".vm",
						"org.springframework.messaging.simp.SimpMessageSendingOperations"));
	}

	@Override
	public String getName() {
		return NAME;
	}
}
