import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        //Arraylist des éléments du noeud racine
        ArrayList<Element> rootElementList = new ArrayList<Element>();
        ArrayList<Node> rootChildrenList = new ArrayList<Node>();
        Integer[] elementValuesArray = new Integer[] {1,2,3};
        Element rootFirstElement = new Element("2", elementValuesArray);
        rootElementList.add(rootFirstElement);

        //Enfant 1
        Integer[] childOneValuesArray = new Integer[] {1,2,3};

        //On remplit l'enfant 1 avec les éléments qui le composent
        ArrayList<Element> firstChildElementList = new ArrayList<>();
        Element childOneElement = new Element("1", childOneValuesArray);
        firstChildElementList.add(childOneElement);

        //L'enfant 1 n'a pas d'enfants
        ArrayList<Node> firstChildChildrenList = new ArrayList<>();

        Node firstChild = new Node(firstChildElementList, firstChildChildrenList);

        //On remplit la liste des enfants du noeud racines
        rootChildrenList.add(firstChild);


        //Enfant 2
        Integer[] childTwoValuesArray = new Integer[] {1,2,3};

        //On remplit l'enfant 1 avec les éléments qui le composent
        ArrayList<Element> secondChildElementList = new ArrayList<>();
        Element childTwoElement = new Element("3", childTwoValuesArray);
        firstChildElementList.add(childTwoElement);

        //L'enfant 1 n'a pas d'enfants
        ArrayList<Node> secondChildChildrenList = new ArrayList<>();

        Node secondChild = new Node(secondChildElementList, secondChildChildrenList);

        //On remplit la liste des enfants du noeud racine
        rootChildrenList.add(secondChild);
        //On crée le noeud principal
        Node root = new Node(rootElementList, rootChildrenList);

        Integer[] valuesElementToSearch = new Integer[]{1,2,3};
        Element toSearch = new Element("2", valuesElementToSearch);
        System.out.println(root.getChildrenArray().size());
        root.searchElement(toSearch, false);

    }
}
