package Tutorial;

public class Person {
    //fields
    private String name; //name of the person
    private int maximumBooks; //most books the person can check out

    //constructors
    public Person(){
        this.name = "unknown name";
        this.maximumBooks = 3;
    }

    //methods
    public String getName() {

        return this.name;
    }

    public void setName(String anyName){
       this.name = anyName;

    }
    public int getMaximumBooks() {

        return this.maximumBooks;
    }
    public void setMaximumBooks(int maximumBooks) {

        this.maximumBooks = maximumBooks;
    }
    public String toString(){
        return this.getName() + "(" + this.getMaximumBooks() + "books)";
    }


}

