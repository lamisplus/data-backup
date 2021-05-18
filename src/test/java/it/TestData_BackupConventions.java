package it;

import com.foreach.across.core.AcrossModule;
import com.foreach.across.test.AbstractAcrossModuleConventionsTest;
import org.lamisplus.modules.data_backup.Data_Backup;

public class TestData_BackupConventions extends AbstractAcrossModuleConventionsTest
{

	@Override
	protected AcrossModule createModule() {
		return new Data_Backup();
	}
}
