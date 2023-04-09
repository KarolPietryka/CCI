package task.graph.structure;

import data.structure.LinkedList;
import data.structure.Queue;
import kotlin.Unit;
import task.graph.structure.graph.Graph;
import task.graph.structure.graph.Node;

import java.util.*;
import java.util.stream.Collectors;

//You are given a list of projects and a list of dependencies (which is a list of pairs of
//projects, where the second project is dependent on the first project). All of a project's dependencies
//must be built before the project is. Find a build order that will allow the projects to be built. If there
//is no valid build order, return an error.
public class BuildOrderJ {

    public LinkedList<String> getOrder(List<String> projects, Map<String, String> depList) {
        GraphExt graph = new GraphExt();
        LinkedList<String> result = new LinkedList<>();
        String rootSymbol = depList.keySet().stream().findFirst().get();

        for(Map.Entry<String, String> entry : depList.entrySet()){
            Node keyNode = Optional.ofNullable(graph.get(entry.getKey())).orElse(graph.add(entry.getKey()));
            Node depNode = Optional.ofNullable(graph.get(entry.getValue())).orElse(graph.add(entry.getValue()));
            keyNode.addLink(depNode);
            if(rootSymbol.equals(depNode.getSymbol())){ rootSymbol = entry.getKey(); }
            projects.remove(entry.getKey());
            projects.remove(entry.getValue());
        }
        Node root = graph.get(new Node(rootSymbol));
        Queue<Node> graphQueue = new Queue<>(root);
        while (graphQueue.peek() != null){
            Node current = graphQueue.pop();
            result.add(current.getSymbol());
            current.getLinkedNodes().forEach(item ->  graphQueue.push(item));
        }

        projects.forEach(it -> {
                    graph.add(new Node(it));
                    result.add(it);
                }
        );
        return result;
    }
    private class GraphExt extends Graph{
        public Node add(String symbol){
            Node newNode = new Node(symbol);
            add(newNode);
            return newNode;
        }
    }

}
