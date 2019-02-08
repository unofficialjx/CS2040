public class Student {
    static int indexOfLastStudent = 0;
    String name;
    int index;


    public Student(String name) {
        this.name = name;
        this.index = indexOfLastStudent;
        indexOfLastStudent++;
    }


    @Override
    public String toString() {
        return "(" + name + ", " + index + ")";
    }
}
