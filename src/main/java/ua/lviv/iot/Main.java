package ua.lviv.iot;

public class Main {

    public static void main(String[] args) {
        StringProcessor stringProcessor = new StringProcessor();
        stringProcessor.readInput();
        stringProcessor.findMatch();
        stringProcessor.showResults();
    }
}
