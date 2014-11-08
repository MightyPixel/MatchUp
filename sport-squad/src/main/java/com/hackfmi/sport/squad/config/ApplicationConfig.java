package com.hackfmi.sport.squad.config;

import static org.springframework.context.annotation.ComponentScan.Filter;

import com.mongodb.Mongo;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;

import com.hackfmi.sport.squad.Application;

@Configuration
@EnableMongoRepositories(basePackages = "com.hackfmi.sport.squad.repository")
@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
class ApplicationConfig  extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "sport-squad";
    }

    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo();
        return mongo;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.hackfmi.sport.squad.domain";
    }

	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/persistence.properties"));
		return ppc;
	}
	
}