package Java_Core.String;

/**
 * Created by Splayd on 10.12.2016.
 */
public class StringBuilderOperations {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        int startOfSubstrIncl = 3;
        int endOfSubstrExcl = 5;
        int indexOffSet = 4;
        int charIndex = 5;

        builder.append("New ending"); //add
        builder.delete(startOfSubstrIncl, endOfSubstrExcl); //replace from to
        builder.insert(indexOffSet, "some sub string"); //inser
        builder.replace(startOfSubstrIncl, endOfSubstrExcl, "replace"); //replace
        builder.setCharAt(charIndex, 'a'); //replace char

        String builderString = builder.toString(); //convert to string
        System.out.println(builderString);

    }
}
