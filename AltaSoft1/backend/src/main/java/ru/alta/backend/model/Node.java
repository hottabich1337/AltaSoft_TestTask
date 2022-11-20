package ru.alta.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Node {
    @Id
    private String nodeId;
    private String value;
    private Node parent;
    private List<Node> children = new ArrayList<>();


    public void addChild(Node child){
        children.add(child);
    }
}
