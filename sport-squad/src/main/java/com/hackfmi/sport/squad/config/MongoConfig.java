//package com.hackfmi.sport.squad.config;
//
//import java.net.UnknownHostException;
//import java.util.List;
//
//import com.hackfmi.sport.squad.Application;
//import com.mongodb.Mongo;
//
//import com.mongodb.WriteConcern;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.core.convert.CustomConversions;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//
//@Configuration
////@ComponentScan(basePackageClasses = Application.class)
//@EnableMongoRepositories
//class MongoConfig extends AbstractMongoConfiguration{
//
//    @Override
//    protected String getDatabaseName() {
//        return "sport-squad";
//    }
//
//    @Override
//    public Mongo mongo() throws Exception {
//        Mongo mongo = new Mongo();
//        return mongo;
//    }
//
//    @Override
//    protected String getMappingBasePackage() {
//        return "com.hackfmi.sport.squad.**";
//    }
//
////    @Override
////    protected String getMappingBasePackage() {
////        return "com.hackfmi.sport.squad";
////    }
//
////    @Autowired
////    private List<Converter<?, ?>> converters;
////
////    @Override
////    public CustomConversions customConversions() {
////        return new CustomConversions(converters);
////    }
//
//    /*@Bean
//    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
//        return new SimpleMongoDbFactory(new Mongo(), "sport-squad");
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws UnknownHostException {
//        MongoTemplate template = new MongoTemplate(mongoDbFactory(), mongoConverter());
//        return template;
//    }
//
//    @Bean
//    public MongoTypeMapper mongoTypeMapper() {
//        return new DefaultMongoTypeMapper(null);
//    }
//
//    @Bean
//    public MongoMappingContext mongoMappingContext() {
//        return new MongoMappingContext();
//    }
//
//    @Bean
//    public MappingMongoConverter mongoConverter() throws UnknownHostException {
//        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), mongoMappingContext());
//        converter.setTypeMapper(mongoTypeMapper());
//        return converter;
//    }*/
//}
