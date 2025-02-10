import java.util.ArrayList;

public class Graph<U, V>{
    private ArrayList<Edge<U,V>> edgeList = new ArrayList<>();
    private  ArrayList<Vertices<V>> vertextList = new ArrayList<>();

    public Graph(){
        edgeList = new ArrayList<>();
        vertextList = new ArrayList<>();
    }

    public void addVertices(V element){
        Vertices<V> v = new Vertices<>(element);
        vertextList.add(v);
    }

    public void addEdge(U element){
        Edge<U,V> e = new Edge<>(element);
        edgeList.add(e);
    }

    public Vertices<V> opposite(Edge<U,V> edge, Vertices<V> vertex){
        if(edge.getV1() == vertex){
            return edge.getv2();
        }else if(edge.getv2() == vertex){
            return edge.getV1();
        }else{
            throw new IllegalArgumentException("Cannot find the given vertex");
        }
    }
}
