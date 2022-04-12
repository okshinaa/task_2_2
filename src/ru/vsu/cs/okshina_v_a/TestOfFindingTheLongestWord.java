package ru.vsu.cs.okshina_v_a;

import org.junit.Test;
import java.util.Stack;

public class TestOfFindingTheLongestWord {
    ReadFile read = new ReadFile();

    static <T> boolean compareStacks(Stack<T> a, Stack<T> b) {
        if (a.isEmpty() != b.isEmpty()) return false;
        if (a.isEmpty() && b.isEmpty()) return true;
        T element_a = a.pop();
        T element_b = b.pop();
        try {
            if (((element_a==null) && (element_b!=null)) || (!element_a.equals(element_b)))
                return false;
            return compareStacks(a, b);
        } finally {
            a.push(element_a);
            b.push(element_b);
        }
    }

    @Test
    public void testNumberOne() {
        MyStack<String> testingInput = read.readFileToStack("testSrc/testCase/input1.txt");
        MyStack<String> actualWord = read.getMaxLines(testingInput);
        MyStack<String> correctOutput = read.readFileToStack("testSrc/testResult/output1.txt");

        compareStacks(actualWord, correctOutput);
    }

    @Test
    public void testNumberTwo() {
        MyStack<String> testingInput = read.readFileToStack("testSrc/testCase/input2.txt");
        MyStack<String> actualWord = read.getMaxLines(testingInput);
        MyStack<String> correctOutput = read.readFileToStack("testSrc/testResult/output2.txt");

        compareStacks(actualWord, correctOutput);
    }

    @Test
    public void testNumberThree() {
        MyStack<String> testingInput = read.readFileToStack("testSrc/testCase/input3.txt");
        MyStack<String> actualWord = read.getMaxLines(testingInput);
        MyStack<String> correctOutput = read.readFileToStack("testSrc/testResult/output3.txt");

        compareStacks(actualWord, correctOutput);
    }
}
