public class Edge <T, U>{
    private T edge;
    private Vertices<U> v1;
    private Vertices<U> v2;

    public Edge(T edge){
        this.edge = edge;
        v1 = null;
        v2 = null;
    }

    public T getEdge(){
        return edge;
    }

    public Vertices<U> getV1(){
        return v1;
    }

    public Vertices<U> getv2(){
        return v2;
    }

    public void setVertices(Vertices<U> v1, Vertices<U> v2){
        this.v1 = v1;
        this.v2 = v2;
    }

}
