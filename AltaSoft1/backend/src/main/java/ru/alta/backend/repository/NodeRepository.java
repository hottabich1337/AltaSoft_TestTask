package ru.alta.backend.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alta.backend.model.Node;

public interface NodeRepository extends MongoRepository<Node, Integer> {

}

