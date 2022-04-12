package ru.vsu.cs.okshina_v_a;

public class Main {
    private static final String PATH = "input.txt";

    public static void main(String[] args) {
        ReadFile read = new ReadFile();
        MyStack<String> words = read.readFileToStack(PATH);
        System.out.println("All words: " + words + ";");

        MyStack<String> stackTask = read.getMaxLines(words);
        System.out.println("Max length words: " + stackTask + ";");
    }
}