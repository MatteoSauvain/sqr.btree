import java.util.ArrayList;

public class Node {
    private ArrayList<Element> elementArray;
    private ArrayList<Node> childrenArray;
    private boolean trouve = false;
    private boolean appelEnfant = false;

    public Node (ArrayList<Element> _elementArray, ArrayList<Node> _childrenArray){
        if (_elementArray.size()<=2) {
            this.elementArray = _elementArray;
        }
        if (_childrenArray.size()<=3) {
            this.childrenArray = _childrenArray;
        }
    }


    public boolean hasChildren() {
        boolean res = false;
        if (this.childrenArray.size() == 0){
            res = true;
        }
        return res;
    }

    public ArrayList<Element> getElement() {
        return elementArray;
    }

    public ArrayList<Node> getChildrenArray(){
        return childrenArray;
    }

    public void insertElement(Element toInsert, Node n){
        String keyElementToInsert = toInsert.getKey();
        if (elementArray.size()<3) {
            if (!hasChildren()) {
                if (keyElementToInsert.compareTo(n.elementArray.get(0).getKey()) < 0) {
                    elementArray.add(0, toInsert);
                } else if (keyElementToInsert.compareTo(n.elementArray.get(0).getKey()) == 0) {
                    elementArray.add(0, toInsert);
                } else if (keyElementToInsert.compareTo(n.elementArray.get(0).getKey()) > 0) {
                    if (keyElementToInsert.compareTo(n.elementArray.get(1).getKey()) < 0) {
                        elementArray.add(1, toInsert);
                    }else if (keyElementToInsert.compareTo(n.elementArray.get(1).getKey()) > 0) {
                        elementArray.add(2, toInsert);
                    }
                }
            }
            else { // Si le noeud a des enfants
                searchElement(toInsert, true);
            }
        }
    }

    public void searchElement(Element element, boolean toInsert){
        System.out.println(hasChildren());
        if (hasChildren()){
            for (int i = 0; i<elementArray.size()-1; i++){
                if (!trouve && !appelEnfant) {
                    if (element.getKey().compareTo(this.elementArray.get(i).getKey()) < 0) {
                        appelEnfant = true;
                        if (!hasChildren()){
                            searchElement(this.getChildrenArray().get(0), element, toInsert);
                        }
                        else {
                            System.out.println("La valeur n'est pas comprise dans l'arbre");
                        }
                    } else if (element.getKey().compareTo(this.elementArray.get(i).getKey()) == 0) {
                        trouve = true;
                        if (toInsert){
                            insertElement(element, element.getNodeParent());
                            System.out.println("Élement correctement inséré");
                        }
                        else {
                            System.out.println("Un noeud au moins comprend la valeur clé:" + element.getKey());
                        }

                    } else if (element.getKey().compareTo(this.elementArray.get(i).getKey()) > 0) {
                        appelEnfant = true;
                        if (hasChildren()){
                            if (this.childrenArray.size() <= 2) {
                                searchElement(this.getChildrenArray().get(1), element, toInsert);
                            } else {
                                searchElement(this.getChildrenArray().get(2), element, toInsert);
                            }
                        }
                        else {
                            System.out.println("La valeur n'est pas comprise dans l'arbre");
                        }
                    }
                }
            }
        }
    }

    private void searchElement(Node parent, Element element, boolean toInsert){
            for (int i = 0; i < elementArray.size() - 1; i++) {
                if (!trouve && !appelEnfant) {
                    if (element.getKey().compareTo(this.elementArray.get(i).getKey()) < 0) {
                        appelEnfant = true;
                        if (hasChildren()) {
                            searchElement(this.childrenArray.get(0), element, toInsert);
                        }
                        else {
                            System.out.println("La valeur n'est pas comprise dans l'arbre");
                        }
                    } else if (element.getKey().compareTo(this.elementArray.get(i).getKey()) == 0) {
                        trouve = true;
                        if (toInsert){
                            insertElement(element, element.getNodeParent());
                            System.out.println("Élément correctement inséré");
                        }
                        else{
                            System.out.println("Un noeud au moins comprend la valeur clé:" + element.getKey());
                        }
                    } else if (element.getKey().compareTo(this.elementArray.get(i).getKey()) > 0) {
                        if (hasChildren()) {
                            if (this.childrenArray.size() <= 2) {
                                appelEnfant = true;
                                searchElement(this.childrenArray.get(1), element, toInsert);
                            } else {
                                appelEnfant = true;
                                searchElement(this.childrenArray.get(2), element, toInsert);
                            }
                        } else {
                            System.out.println("La valeur n'est pas comprise dans l'arbre");
                        }
                    }
                }
            }
    }




}
