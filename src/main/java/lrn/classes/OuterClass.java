package lrn.classes;

public class OuterClass {
    String outerField = "Outer field";
    static String staticOuterField = "static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        OuterClass outerObject = new OuterClass();

        System.out.println("Inner Class:");
        System.out.println("------------");
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nstatic nested Class:");
        System.out.println("----------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);
    }
}
