package ua.lviv.iot;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private String line;
    private List<String> list;
    public String subline;

    public StringProcessor() {

    }

    public StringProcessor(String line, List<String> list) {
        this.line = line;
        this.list = list;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void readInput() {
        System.out.println("Enter your string: ");
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
    }

    public List<String> findMatch() {
        list = new LinkedList<>();
        Pattern pattern = Pattern.compile("[g][i][t][h][u][b][.][c][o][m](\\/\\w*\\/)");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            subline = matcher.group();
            Pattern patternForSubline = Pattern.compile("\\/\\w*\\/");
            Matcher matcherForSubline = patternForSubline.matcher(subline);

            while (matcherForSubline.find()) {
                list.add(matcherForSubline.group());
            }
        }
        return list;
    }

    public void showResults() {
        if (list.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Information of user: " + list);
        }
    }

}