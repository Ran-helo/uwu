package io.github.ran.uwu.client;

import java.util.Random;

/**
 * This class either contains the best code or the worst code ever written
 * @author Ran
 */
public class Uwuifier {
    public static String uwu(String stringToUwuify) {
        if (stringToUwuify.equals(UwUMod.prevUwuifiedMessage)) stringToUwuify = UwUMod.prevMessage;
        return UwUMod.prevUwuifiedMessage = (UwUMod.prevMessage = stringToUwuify).toLowerCase().replaceAll("r|l","w").replaceAll("n([aeiou])", "ny$1").replaceAll("ove", "uve").replaceAll("uck", "uwq").replaceFirst("i", "i-i").replaceFirst("(?s)(.*)" + "i-i-i", "$1" + "i-i") + ((new Random().nextInt(10)) <= 2 ? " >_<" : ""); // Wanted to put >~< but it doesn't look good in minecraft font rendering
    }

    @SuppressWarnings("unused")
    public static String uwuify(String stringToUwuify) {
        return stringToUwuify.toLowerCase().replaceAll("r|l","w").replaceAll("n([aeiou])", "ny$1").replaceAll("ove", "uve").replaceAll("uck", "uwq").replaceFirst("i", "i-i").replaceFirst("(?s)(.*)" + "i-i-i", "$1" + "i-i") + ((new java.util.Random().nextInt(10)) <= 2 ? " >~<" : "");
    }
}
