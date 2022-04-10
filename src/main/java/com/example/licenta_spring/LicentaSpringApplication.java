package com.example.licenta_spring;

import com.example.licenta_spring.domains.User;
import com.example.licenta_spring.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class LicentaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicentaSpringApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserRepository repository, MongoTemplate mongoTemplate){
//        return args -> {
//            User user = new User(
//                    "stefancolt",
//                    "coltstefan",
//                    "password",
//                    "Stefan",
//                    "Colt"
//                    );
//
//            //usingMongoTemplayeAndQuery(repository, mongoTemplate, user);
//            repository.findUserByEmail("stefancolt")
//                    .ifPresentOrElse(s->{
//                        System.out.println(s);
//                    }, () -> {
//                        System.out.println("Inserting students");
//                        repository.insert(user);
//                    });
//        };
//    }

    private void usingMongoTemplayeAndQuery(UserRepository repository, MongoTemplate mongoTemplate, User user) throws IllegalAccessException {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is("stefancolt@gmail.com"));
        List<User> users = mongoTemplate.find(query,User.class);

        if(users.size() > 1){
            throw new IllegalAccessException(
                    "found many students"
            );
        }
        if(users.isEmpty()) {
            System.out.println("Inserting students");
            repository.insert(user);
        }
        else {
            System.out.println("Student already exists");
        }
        ;
    }


}
