package org.lamisplus.modules.data_backup.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.base.config.ContextProvider;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
@RequiredArgsConstructor
public class BackupJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        LOG.debug("Running backup job...");
        BackupService backupService = ContextProvider.getBean(BackupService.class);
        backupService.backupPGSQL(false);
        backupService.cleanupBackup();
    }
}
