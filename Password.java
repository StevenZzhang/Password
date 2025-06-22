import java.util.*;
public class Password {
    private String username;
    private String password;
    public Password(String username, String password) {
        this.username = username;
        boolean retry = checkpassword(password);
        if (!retry) {
            System.out.println("Please reset the password with the changePassword function.");
        }
        this.password = passwordScrambler(password);
    }
    public Boolean correctPassword(String passwordattempt) {
        if (this.password.equals(passwordScrambler(passwordattempt))) {
            return true;
        }
        else
            return false;
    }
    public void changePassword(String newpassword) {
        this.password = passwordScrambler(newpassword);
    }
    public String passwordScrambler(String password) {
        String newpassword = "";
        ArrayList<String> changeONE = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            changeONE.add(binaryfinder(password.substring(i, i + 1)) + "P");
        }
        for (int i = 0; i < changeONE.size(); i++) {
            newpassword += changeONE.get(i);
        }
        int count = 0;
        String temp = "0";
        ArrayList<Integer> changeTWO = new ArrayList<>();
        for (int i = 0; i < newpassword.length(); i++) {
            if (newpassword.substring(i, i + 1).equals(temp)) {
                count++;
            }
            else if (newpassword.substring(i, i + 1).equals("P")) {
                changeTWO.add(0);
            }
            else {
                temp = newpassword.substring(i, i + 1);
                changeTWO.add((count));
                count = 1;
            }
        }
        newpassword = "";
        for (int i = 0; i < changeTWO.size(); i++) {
            newpassword += changeTWO.get(i);
        }
        String tempPassword = "";
        for (int i = newpassword.length(); i > 0; i--) {
            tempPassword += newpassword.substring(i - 1, i);
        }
        newpassword = tempPassword;
        return newpassword;
    }
    public boolean checkpassword(String password) {
        boolean upper = false;
        boolean lower = false;
        boolean special = false;
        boolean number = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i + 1).equals("A") || password.substring(i, i + 1).equals("B") || password.substring(i, i + 1).equals("C") || password.substring(i, i + 1).equals("D") || password.substring(i, i + 1).equals("E") || password.substring(i, i + 1).equals("F") || password.substring(i, i + 1).equals("G") || password.substring(i, i + 1).equals("H") || password.substring(i, i + 1).equals("I") || password.substring(i, i + 1).equals("J") || password.substring(i, i + 1).equals("K") || password.substring(i, i + 1).equals("L") || password.substring(i, i + 1).equals("M") || password.substring(i, i + 1).equals("N") || password.substring(i, i + 1).equals("O") || password.substring(i, i + 1).equals("P") || password.substring(i, i + 1).equals("Q") || password.substring(i, i + 1).equals("R") || password.substring(i, i + 1).equals("S") || password.substring(i, i + 1).equals("T") || password.substring(i, i + 1).equals("U") || password.substring(i, i + 1).equals("V") || password.substring(i, i + 1).equals("W") || password.substring(i, i + 1).equals("X") || password.substring(i, i + 1).equals("Y") || password.substring(i, i + 1).equals("Z")) {
                upper = true;
            }
            if (password.substring(i, i + 1).equals("a") || password.substring(i, i + 1).equals("b") || password.substring(i, i + 1).equals("c") || password.substring(i, i + 1).equals("d") || password.substring(i, i + 1).equals("e") || password.substring(i, i + 1).equals("f") || password.substring(i, i + 1).equals("g") || password.substring(i, i + 1).equals("h") || password.substring(i, i + 1).equals("i") || password.substring(i, i + 1).equals("j") || password.substring(i, i + 1).equals("k") || password.substring(i, i + 1).equals("l") || password.substring(i, i + 1).equals("m") || password.substring(i, i + 1).equals("n") || password.substring(i, i + 1).equals("o") || password.substring(i, i + 1).equals("p") || password.substring(i, i + 1).equals("q") || password.substring(i, i + 1).equals("r") || password.substring(i, i + 1).equals("s") || password.substring(i, i + 1).equals("t") || password.substring(i, i + 1).equals("u") || password.substring(i, i + 1).equals("v") || password.substring(i, i + 1).equals("w") || password.substring(i, i + 1).equals("x") || password.substring(i, i + 1).equals("y") || password.substring(i, i + 1).equals("z")) {
                lower = true;
            }
            if (password.substring(i, i + 1).equals("!") || password.substring(i, i + 1).equals("\"") || password.substring(i, i + 1).equals("#") || password.substring(i, i + 1).equals("%") || password.substring(i, i + 1).equals("&") || password.substring(i, i + 1).equals("'") || password.substring(i, i + 1).equals("?") || password.substring(i, i + 1).equals(")") || password.substring(i, i + 1).equals("*") || password.substring(i, i + 1).equals("+") || password.substring(i, i + 1).equals(",") || password.substring(i, i + 1).equals("-") || password.substring(i, i + 1).equals(".") || password.substring(i, i + 1).equals("/") || password.substring(i, i + 1).equals("_") || password.substring(i, i + 1).equals("@") || password.substring(i, i + 1).equals("?")) {
                special = true;
            }
            if (password.substring(i, i + 1).equals("1") || password.substring(i, i + 1).equals("2") || password.substring(i, i + 1).equals("3") || password.substring(i, i + 1).equals("4") || password.substring(i, i + 1).equals("5") || password.substring(i, i + 1).equals("6") || password.substring(i, i + 1).equals("7") || password.substring(i, i + 1).equals("8") || password.substring(i, i + 1).equals("9") || password.substring(i, i + 1).equals("0")) {
                number = true;
            }
        }
        if (upper && lower && special && number && password.length() >= 10) {
            return true;
        }
        else {
            return false;
        }
    }
    public String binaryfinder(String substring) {
        String newstring = "";
        if (substring.equals("a")) {
            newstring = "01100001";
        }
        if (substring.equals("A")) {
            newstring = "01000001";
        }
        if (substring.equals("b")) {
            newstring = "01100010";
        }
        if (substring.equals("B")) {
            newstring = "01000010";
        }
        if (substring.equals("c")) {
            newstring = "01100011";
        }
        if (substring.equals("C")) {
            newstring = "01000011";
        }
        if (substring.equals("d")) {
            newstring = "01100100";
        }
        if (substring.equals("D")) {
            newstring = "01000100";
        }
        if (substring.equals("e")) {
            newstring = "01100101";
        }
        if (substring.equals("E")) {
            newstring = "01000101";
        }
        if (substring.equals("f")) {
            newstring = "01100110";
        }
        if (substring.equals("F")) {
            newstring = "01000110";
        }
        if (substring.equals("g")) {
            newstring = "01100111";
        }
        if (substring.equals("G")) {
            newstring = "01000111";
        }
        if (substring.equals("h")) {
            newstring = "01101000";
        }
        if (substring.equals("H")) {
            newstring = "01001000";
        }
        if (substring.equals("i")) {
            newstring = "01101001";
        }
        if (substring.equals("I")) {
            newstring = "01001001";
        }
        if (substring.equals("j")) {
            newstring = "01101010";
        }
        if (substring.equals("J")) {
            newstring = "01001010";
        }
        if (substring.equals("k")) {
            newstring = "01101011";
        }
        if (substring.equals("K")) {
            newstring = "01001011";
        }
        if (substring.equals("l")) {
            newstring = "01101100";
        }
        if (substring.equals("L")) {
            newstring = "01001100";
        }
        if (substring.equals("m")) {
            newstring = "01101101";
        }
        if (substring.equals("M")) {
            newstring = "01001101";
        }
        if (substring.equals("n")) {
            newstring = "01101110";
        }
        if (substring.equals("N")) {
            newstring = "01001110";
        }
        if (substring.equals("o")) {
            newstring = "01101111";
        }
        if (substring.equals("O")) {
            newstring = "01001111";
        }
        if (substring.equals("p")) {
            newstring = "01110000";
        }
        if (substring.equals("P")) {
            newstring = "01010000";
        }
        if (substring.equals("q")) {
            newstring = "01110001";
        }
        if (substring.equals("Q")) {
            newstring = "01010001";
        }
        if (substring.equals("r")) {
            newstring = "01110010";
        }
        if (substring.equals("R")) {
            newstring = "01010010";
        }
        if (substring.equals("s")) {
            newstring = "01110011";
        }
        if (substring.equals("S")) {
            newstring = "01010011";
        }
        if (substring.equals("t")) {
            newstring = "01110100";
        }
        if (substring.equals("T")) {
            newstring = "01010100";
        }
        if (substring.equals("u")) {
            newstring = "01110101";
        }
        if (substring.equals("U")) {
            newstring = "01010101";
        }
        if (substring.equals("v")) {
            newstring = "01110110";
        }
        if (substring.equals("V")) {
            newstring = "01110110";
        }
        if (substring.equals("w")) {
            newstring = "01110111";
        }
        if (substring.equals("W")) {
            newstring = "01010111";
        }
        if (substring.equals("x")) {
            newstring = "01111000";
        }
        if (substring.equals("X")) {
            newstring = "01011000";
        }
        if (substring.equals("y")) {
            newstring = "01111001";
        }
        if (substring.equals("Y")) {
            newstring = "01011001";
        }
        if (substring.equals("z")) {
            newstring = "01111010";
        }
        if (substring.equals("Z")) {
            newstring = "01011010";
        }
        if (substring.equals("1")) {
            newstring = "00110001";
        }
        if (substring.equals("2")) {
            newstring = "00110010";
        }
        if (substring.equals("3")) {
            newstring = "00110011";
        }
        if (substring.equals("4")) {
            newstring = "00110100";
        }
        if (substring.equals("5")) {
            newstring = "00110101";
        }
        if (substring.equals("6")) {
            newstring = "00110110";
        }
        if (substring.equals("7")) {
            newstring = "00110111";
        }
        if (substring.equals("8")) {
            newstring = "00111000";
        }
        if (substring.equals("9")) {
            newstring = "00111001";
        }
        if (substring.equals("0")) {
            newstring = "00110000";
        }
        if (substring.equals("?")) {
            newstring = "00111111";
        }
        if (substring.equals("@")) {
            newstring = "01000000";
        }
        if (substring.equals("_")) {
            newstring = "01011111";
        }
        if (substring.equals("/")) {
            newstring = "00101111";
        }
        if (substring.equals(".")) {
            newstring = "00101110";
        }
        if (substring.equals("-")) {
            newstring = "00101101";
        }
        if (substring.equals(",")) {
            newstring = "00101100";
        }
        if (substring.equals("+")) {
            newstring = "00101011";
        }
        if (substring.equals("*")) {
            newstring = "00101010";
        }
        if (substring.equals(")")) {
            newstring = "00101001";
        }
        if (substring.equals("?")) {
            newstring = "00101000";
        }
        if (substring.equals("'")) {
            newstring = "00100111";
        }
        if (substring.equals("&")) {
            newstring = "00100110";
        }
        if (substring.equals("%")) {
            newstring = "00100101";
        }
        if (substring.equals("$")) {
            newstring = "00100100";
        }
        if (substring.equals("#")) {
            newstring = "00100011";
        }
        if (substring.equals("\"")) {
            newstring = "00100010";
        }
        if (substring.equals("!")) {
            newstring = "00100001";
        }
        return newstring;
    }
}