package Lab3;

import java.util.List;

public class Letter {
    private String arrayLetterS;
    private List<String> arrayLetter;

    private String nameOfLetter;

    public Letter(String nameOfLetter, List<String> arrayLetter) {
        this.nameOfLetter = nameOfLetter;
        this.arrayLetter = arrayLetter;
    }

    public String getNameOfLetter(){
        return nameOfLetter;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item: arrayLetter) {
            stringBuilder.append(item).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<String> getArrayLetter() {
        return arrayLetter;
    }
}
