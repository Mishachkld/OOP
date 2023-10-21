package Lab3;

public class Letter {
    private String arrayLetter;
    private String nameOfLetter;

    public Letter(String nameOfLetter, String arrayLetter) {
        this.nameOfLetter = nameOfLetter;
        this.arrayLetter = arrayLetter;
    }

    public String getNameOfLetter(){
        return nameOfLetter;
    }

    public String getArrayLetter(){
        return arrayLetter;
    }

    @Override
    public String toString() {
        return nameOfLetter + ":\n" + arrayLetter + "\n";
    }
}
