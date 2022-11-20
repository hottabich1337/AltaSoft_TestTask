package ru.alta.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alta.backend.model.Node;
import ru.alta.backend.repository.NodeRepository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class NodeService {
    private Node rootNode = new Node();
    private Map<String,Node> nodeMap = new TreeMap<>();
    @Autowired
    private NodeRepository nodeRepository ;

    public void add(Node node){
        rootNode.addChild(node);
    }

    public void save(){
        nodeRepository.save(rootNode);
    }
    public void remove(Node node){
        Node removeNode = nodeMap.get(node.getNodeId());
        Node parentNode = removeNode.getParent();
        parentNode.getChildren().remove(removeNode);
        nodeMap.remove(removeNode.getNodeId());
    }
    public void moveUp(Node node){
        Node parentNode = node.getParent();
        if (parentNode!=rootNode){
            parentNode.getChildren().remove(node);
            Node superParentNode =  parentNode.getParent();
            superParentNode.addChild(node);
        }

    }

    public void moveDown(Node currentNode){
        Node node = nodeMap.get(currentNode.getNodeId());
        Node parentNode = node.getParent();
        List<Node> parentList ;
        if (parentNode!=rootNode){
            Node grandParentNode = parentNode.getParent();
            parentList = grandParentNode.getChildren();
            if (parentList.indexOf(parentNode)!=parentList.size()-1){
                parentList.get(parentList.indexOf(parentNode)+1).addChild(node);
            }else {
                grandParentNode.addChild(node);
            }
        }else {
            parentList = rootNode.getChildren();
            if (parentList.indexOf(parentNode)!=parentList.size()-1){
                parentList.get(parentList.indexOf(parentNode)+1).addChild(node);
            }else {
                rootNode.addChild(node);
            }
        }
    }

    public void moveTo(Node movableNode,Node moveto){
        Node node = nodeMap.get(movableNode.getNodeId());
        Node targetNode = nodeMap.get(moveto.getNodeId());
        targetNode.addChild(node);
        Node parent = node.getParent();
        parent.getChildren().remove(node);
    }
}
