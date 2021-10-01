/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findWord(statement,"no") >= 0)
        {
            response = "Why no? The answer is always yes.";
        }
        else if (findWord(statement,"mother") >= 0
                || findWord(statement,"father") >= 0
                || findWord(statement,"sister") >= 0
                || findWord(statement,"brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement,"cat") >= 0 || findWord(statement,"dog") >= 0){
            response = "Tell me more about your pets.";

    }
        else if (findWord(statement,"Nathan") >= 0){
            response = "Nathan seems like an excellent teacher";
        }
        else if (findWord(statement,"sports") >= 0) {
            response = "Which sport is your favorite?";
        }
        else if (findWord(statement,"Basketball") >= 0) {
            response = "Basketball is the best sport";
        }
        else if (findWord(statement,"Netflix") >= 0) {
            response = "What is your favorite show?";
        }
        else if (findWord(statement, "Pippen") >= 0){
            response = "Pippen is my dog! I love my baby";
        }
        else if (findWord(statement, "Packers") >= 0) {
            response = "The Green Bay Packers are the best team in football";
        }
        else if (findWord(statement, "I want") >= 0){
            transformIWantStatement(statement);
        }
        else if (findWord(statement, "I") >= 0 && findWord(statement, "you") >= 0){
            transformIYouStatement(statement);
        }
        else if (findWord(statement, "you") >= 0 && findWord(statement, "me") >= 0){
            transformYouMeStatement(statement);
        }
        else if (findWord(statement, "I want to") >= 0) {
            transformIWantToStatement(statement);
        }
        else if (findWord(statement, "I like") >= 0){
            transformILikeStatement(statement);
        }
        else if (statement.trim().length() == 0){
            response = "Say something silly";
        }

        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4){
            response = "Why are you like this";
        }
        else if (whichResponse == 5){
            response = "How interesting is that, wow";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        str = str.toLowerCase();
        word = word.toLowerCase();

        int index = str.indexOf(word);
        if (index >= 0) {
            if (index == 0 && str.charAt(index + word.length()) == ' ') {
                return index;
            }
            else if (index + word.length() > str.length() - 1 && str.charAt(index - 1) == ' '){
                return index;
            }
            else if (str.charAt(index - 1) == ' ' && str.charAt(index + word.length()) == ' ') {
                return index;

            }
        }

        return -1;
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
//        if (statement.indexOf("I want ") >= 0){
//
//            int index_word_after = findWord(statement, "I want");
//
//            index_word_after = index_word_after + 6; // plus 6 because from "I" in "I want" to the next space is 6 chars
//
//            String word_after = "";
//
//            while (statement.charAt(index_word_after) != ' ' || statement.indexOf(index_word_after) == statement.length() - 1){
//                word_after = word_after + statement.charAt(index_word_after);
//                index_word_after ++;


        // if (findWord(statement, "I want") >= 0){
        System.out.println("Would you really be happy if you had" + statement.substring(6) + "?");
        return "Would you really be happy if you had" + statement.substring(6) + "?"; //6 because from "I" in "I want" to the next space is 6 chars
        }




    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        statement = statement.toLowerCase();

        if(findWord(statement, "I") >= 0 && findWord(statement, "you") >= 0){
            int index1 = statement.indexOf("I");
            index1 = index1 + 2;
            String something = statement.substring(index1, findWord(statement, "you"));
            System.out.print("Why do you" + something + "me?");
            return "Why do you" + something + "me?";
        }

        return "";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        statement = statement.toLowerCase();

        if (findWord(statement, "I want to") >= 0){
            int indexstart = statement.indexOf("I want to");
            indexstart = indexstart + 10;
            String something = statement.substring(indexstart);
            System.out.print("What would it mean to" + something + "?");
            return "What would it mean to" + something + "?";
        }

        return "";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        if (findWord(statement, "you") >= 0 && findWord(statement, "me") >= 0) {
            int index_y = statement.indexOf("you");
            index_y = index_y + 4;
            String something = statement.substring(index_y, findWord(statement, "me"));
            System.out.print("What makes you think that I " + something + "you?");
            return "What makes you think that I " + something + "you?";

        }
        return "";
    }

    public String transformILikeStatement(String statement){

        if(findWord(statement,"I like") >= 0){
            int index_I_= statement.indexOf("I like");
            index_I_ = index_I_ + 7;
            String something = statement.substring(index_I_);
            System.out.print("What does is mean to like " + something + "?");
            return "What does is mean to like " + something + "?";
        }

        return "";
    }
}
