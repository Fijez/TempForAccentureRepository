package m06collection.s.task;

/**
 * Добавление элементов в двухсвязный список
 * Создайте класс StringsLinkedLis в котором обявите поля first и last ( оба поля должны быть объявлены с ключевым словом  private)
 * first last указывают соот-но на первый и последний элемент
 *  Необходимо реализовать метод add который должен создавать новый объект класса Node,в который он поместит переданное значение
 *   по списку можно проходить как с первого элементы до последнего , так и  наоборот ( не забывайте менять менять ссылки рядом стоящих элементов)
 *
 *   Node first( Node last) не должны иметь значение, только указывает на первый( последний ) элемент
 *
 */

class Demo {
    public static void main(String[] args) {
        StringsLinkedLis str = new StringsLinkedLis();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("4");
        str.add("5");
        str.add("6");
        str.add("7");
        str.add("8");
        str.add("9");

        StringsLinkedLis.node nd = str.getFirst();

        System.out.println(nd.getValue());
        nd = nd.getNext();
        System.out.println(nd.getValue());

        nd = nd.getNext();
        System.out.println(nd.getValue());

        nd = nd.getNext();
        System.out.println(nd.getValue());

        nd = nd.getNext();
        System.out.println(nd.getValue());

        nd = nd.getNext();
        System.out.println(nd.getValue());

        nd = nd.getNext();
        System.out.println(nd.getValue());

        System.out.println("-----------------------------------");

        System.out.println(nd.getValue());
        nd = nd.getPrev();
        System.out.println(nd.getValue());
        nd = nd.getPrev();
        System.out.println(nd.getValue());
        nd = nd.getPrev();
        System.out.println(nd.getValue());
        nd = nd.getPrev();
        System.out.println(nd.getValue());
        nd = nd.getPrev();
        System.out.println(nd.getValue());
    }

}


class StringsLinkedLis {


    private node first;
    private node last;

    public void add(String str) {
        node nd = new node(str);
        if (this.first == null) {
            this.first = this.last = nd;
        } else if (this.first == this.last){
            this.last = nd;
            this.last.prev = this.first;
            this.first.next = last;
        } else {
            this.last.next = nd;
            this.last.next.prev = this.last;
            this.last = nd;
        }
    }

    public StringsLinkedLis() {
    }

    public node getFirst() {
        return first;
    }

    public node getLast() {
        return last;
    }

    class node {
        private node next = null;
        private node prev = null;
        private String value = null;

        public node getNext() {
            if(next != null) {
                return next;
            } else {
                throw new NullPointerException();
            }
        }

        public node getPrev() {
            if (prev != null) {
                return prev;
            } else {
                throw new NullPointerException();
            }
        }

        public String getValue() {
            return value;
        }

        public node (String val) {
            value = val;
        }

        public node () {
        }

    }


}


