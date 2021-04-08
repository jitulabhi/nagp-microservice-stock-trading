package com.labhi.stockpricepullservice.config;

import java.util.Date;
import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.labhi.stockprice.model.StockCompany;
import com.labhi.stockprice.model.StockPrice;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableBatchProcessing
@EnableScheduling
@Slf4j
public class BatchConfiguration {

	@Autowired
	public SimpleJobLauncher jobLauncher;

	@Autowired
	public Job job;
	
	
	@Bean
	@StepScope
	public MongoItemReader<StockCompany> reader(MongoTemplate mongoTemplate){
    	MongoItemReader<StockCompany> reader = new MongoItemReader<StockCompany>();
    	reader.setTemplate(mongoTemplate);
    	reader.setCollection("stock-company-list");
    	reader.setTargetType(StockCompany.class);
    	 reader.setSort(new HashMap<String, Sort.Direction>() {{
    	      put("_id", Direction.DESC);
    	    }});
        reader.setQuery("{}");
        reader.setSaveState(false);
        return reader;
    
	}

	@Bean
	public Job job(Step readWriteStep, JobBuilderFactory factory) {
		return factory.get("job").incrementer(new RunIdIncrementer()).flow(readWriteStep).end().build();
	}

	@Bean
	public Step readWriteStep(MongoItemReader<StockCompany> reader, Writer writer, StockCompanyToPriceProcessor processor, StepBuilderFactory factory)
			throws Exception {

		return factory.get("readWriteStep").<StockCompany, StockPrice>chunk(1).reader(reader).processor(processor)
				.writer(writer.write()).build();
	}

	@Bean(name = "launcher")
	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}

	@Scheduled(fixedRateString = "${job.execution.interval}", initialDelayString = "${job.execution.delay}")
	public void schedule() {
		log.info("job started {}", new Date());
		try {
			JobParameters param = new JobParametersBuilder().addLong("uniqueness", System.nanoTime()).toJobParameters();
			JobExecution exec = jobLauncher.run(job, param);
			log.info("job finished {}", exec.getStatus());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
