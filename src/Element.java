public class Element {
    private String key;
    private Integer[] values;
    private Node nodeParent;

    public Element(String _key, Integer[] _values){
        this.key = _key;
        this.values = _values;

    }

    public Node getNodeParent(){
        return nodeParent;
    }

    public String getKey(){
        return key;
    }
    public void setKey(String _key){
        this.key = _key;
    }

    public Integer[] getValues(){
        return values;
    }


}
